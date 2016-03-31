package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pdev.financialbrains.ejb.contracts.ICurrencyCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.ICurrencyCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Currency;
import pdev.financialbrains.ejb.entities.Stock;

@Stateless
public class CurrencyCrudServices implements ICurrencyCrudServicesRemote, ICurrencyCrudServicesLocal {

	@PersistenceContext(unitName="md")
	private EntityManager entityManager;

	public CurrencyCrudServices() {
	}

	@Override
	public void create(Currency currency) {
		entityManager.persist(currency);
	}

	@Override
	public void delete(Currency currency) {
		entityManager.remove(entityManager.find(Currency.class, currency.getId()));
	}

	@Override
	public void update(Currency currency) {
		entityManager.merge(currency);
	}

	@Override
	public Currency readById(Integer id) {
		return entityManager.find(Currency.class, id);
	}

	@Override
	public List<Currency> readBySymbol(String symbol) {
		Query query = entityManager.createQuery("select c from Currency c where c.symbol=:x");
		query.setParameter("x", symbol);
		return query.getResultList();
	}

	@Override
	public List<Currency> readAll() {
		return entityManager.createQuery("select c from Currency c", Currency.class).getResultList();
	}
	@Override
	public Boolean delete2(Currency b) {
		try {
			entityManager.remove(entityManager.find(Currency.class, b.getId()));
			return true;
		} catch (Exception e) {
			System.err.println("Couldn't find the Currency!");
		}
		return false;
	}

	@Override
	public Boolean update2(Currency b) {
		try {
			entityManager.merge(b);
			return true;
		} catch (Exception e) {
			System.err.println("The Currency update is not set.");
		}
		return false;
	}



	@Override
	public Boolean add(Currency b) {
		// TODO Auto-generated method stub
		return null;
	}

}
