package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pdev.financialbrains.ejb.contracts.IGenericCrudServiceLocal;
import pdev.financialbrains.ejb.contracts.IGenericCrudServiceRemote;
import pdev.financialbrains.ejb.entities.Generic;
import pdev.financialbrains.ejb.entities.Stock;

@Stateless
public class GenericCrudServices implements IGenericCrudServiceLocal, IGenericCrudServiceRemote {

	@PersistenceContext(unitName = "data")
	private EntityManager entityManager;

	public GenericCrudServices() {
	}

	@Override
	public void create(Generic generic) {
		entityManager.persist(generic);
	}

	@Override
	public void delete(Generic generic) {
		entityManager.remove(entityManager.find(Generic.class, generic.getId()));
	}

	@Override
	public void update(Generic generic) {
		entityManager.merge(generic);
	}

	@Override
	public Generic readById(Integer id) {
		return entityManager.find(Generic.class, id);
	}

	@Override
	public List<Generic> readAll() {
		return entityManager.createQuery("select g from Generic g", Generic.class).getResultList();
	}

}
