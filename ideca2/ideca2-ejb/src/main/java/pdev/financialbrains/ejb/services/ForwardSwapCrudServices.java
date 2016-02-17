package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pdev.financialbrains.ejb.contracts.IForwardSwapCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IForwardSwapCrudServicesRemote;
import pdev.financialbrains.ejb.entities.ForwardSwap;

@Stateless
public class ForwardSwapCrudServices implements IForwardSwapCrudServicesLocal, IForwardSwapCrudServicesRemote {

	@PersistenceContext(unitName="data")
	private EntityManager entityManager;

	public ForwardSwapCrudServices() {
	}

	@Override
	public void create(ForwardSwap forwardSwap) {
		entityManager.persist(forwardSwap);
	}

	@Override
	public void delete(ForwardSwap forwardSwap) {
		entityManager.remove(entityManager.find(ForwardSwap.class, forwardSwap.getId()));
	}

	@Override
	public void update(ForwardSwap forwardSwap) {
		entityManager.merge(forwardSwap);
	}

	@Override
	public ForwardSwap readById(Integer id) {
		return entityManager.find(ForwardSwap.class, id);
	}

	@Override
	public List<ForwardSwap> readAll() {
		return entityManager.createQuery("select f from ForwardSwap f ", ForwardSwap.class).getResultList();
	}

}
