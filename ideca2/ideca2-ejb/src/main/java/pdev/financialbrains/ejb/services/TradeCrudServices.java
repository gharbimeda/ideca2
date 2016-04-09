package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pdev.financialbrains.ejb.contracts.ITradeCrudServiceLocal;
import pdev.financialbrains.ejb.contracts.ITradeCrudServiceRemote;
import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.entities.User;

@Stateless
@LocalBean
public class TradeCrudServices implements ITradeCrudServiceLocal, ITradeCrudServiceRemote {

	@PersistenceContext(unitName = "data")
	private EntityManager entityManager;

	@Override
	public void create(Trade trade) {
		entityManager.persist(trade);
	}

	@Override
	public void delete(Trade trade) {
		entityManager.remove(entityManager.find(Trade.class, trade.getPk()));
	}

	@Override
	public void update(Trade trade) {
		entityManager.merge(trade);
	}

	@Override
	public Trade readById(Integer id) {
		return entityManager.find(Trade.class, id);
	}

	@Override
	public List<Trade> readAll() {
		return entityManager.createQuery("select t from Trade t", Trade.class).getResultList();
	}

	@Override
	public List<Trade> readCanApp() {
		Query query = entityManager.createQuery("select t from Trade t where t.status=:x OR t.status=:y");
		query.setParameter("x", 0);
		query.setParameter("y", 1);
		return query.getResultList();
	}

	@Override
	public List<Trade> readPending() {
		Query query = entityManager.createQuery("select t from Trade t where t.status=:x");
		query.setParameter("x", 2);
		return query.getResultList();
	}

	@Override
	public Integer readAccepted() {
		Query query = entityManager.createQuery("select t from Trade t where t.status=:x");
		query.setParameter("x", 1);
		return query.getResultList().size();
	}

	@Override
	public Integer readRefused() {
		Query query = entityManager.createQuery("select t from Trade t where t.status=:x");
		query.setParameter("x", 0);
		return query.getResultList().size();
	}
	
	public List<Trade> readPutAccepted() {
		Query query = entityManager.createQuery("select t from Trade t where t.status=:x and t.putcall=:y");
		query.setParameter("x", 1);
		query.setParameter("y", 0);
		return query.getResultList();
	}
	
	public List<Trade> readCFPutAccepted() {
		Query query = entityManager.createQuery("select t from Trade t where t.status=:x and t.putcall=:y and name=:z or name=:a");
		query.setParameter("x", 1);
		query.setParameter("y", 0);
		query.setParameter("z", "CAP");
		query.setParameter("a", "FLOOR");
		return query.getResultList();
	}
	
	public List<Trade> readTradesByUser(User u){
		Query query = entityManager.createQuery("select t from Trade t where t.trader=:u", Trade.class);
		query.setParameter("u", u);
		return query.getResultList();
	}

}
