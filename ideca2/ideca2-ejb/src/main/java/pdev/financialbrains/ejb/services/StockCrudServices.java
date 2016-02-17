package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pdev.financialbrains.ejb.contracts.IStockCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IStockCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Stock;

@Stateless
public class StockCrudServices implements IStockCrudServicesLocal, IStockCrudServicesRemote {

	@PersistenceContext(unitName="md")
	private EntityManager entityManager;

	public StockCrudServices() {
	}

	@Override
	public void create(Stock stock) {
		entityManager.persist(stock);
	}

	@Override
	public void delete(Stock stock) {
		entityManager.remove(entityManager.find(Stock.class, stock.getId()));
	}

	@Override
	public void update(Stock stock) {
		entityManager.merge(stock);
	}

	@Override
	public Stock readById(Integer id) {
		return entityManager.find(Stock.class, id);
	}

	@Override
	public List<Stock> readByCompanyName(String companyName) {
		Query query = entityManager.createQuery("select s from Stock s where s.companyName=:x");
		query.setParameter("x", companyName);
		return query.getResultList();
	}

	@Override
	public List<Stock> readAll() {
		return entityManager.createQuery("select s from Stock s", Stock.class).getResultList();
	}

}
