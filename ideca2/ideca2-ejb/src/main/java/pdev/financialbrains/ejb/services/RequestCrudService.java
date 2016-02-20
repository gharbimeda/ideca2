package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pdev.financialbrains.ejb.contracts.IRequestCrudServiceRemote;
import pdev.financialbrains.ejb.entities.Request;

@Stateless
@LocalBean
public class RequestCrudService implements IRequestCrudServiceRemote {

	@PersistenceContext(unitName = "data")
	private EntityManager entityManager;

	public RequestCrudService() {
	}

	@Override
	public void create(Request request) {
		entityManager.persist(request);
	}

	@Override
	public void update(Request request) {
		entityManager.merge(request);
	}

	@Override
	public void delete(Request request) {
		entityManager.remove(entityManager.find(Request.class, request.getId()));
	}

	@Override
	public List<Request> readAll() {
		return entityManager.createQuery("select a from Request a", Request.class).getResultList();
	}

	@Override
	public Request read(Integer id) {
		return entityManager.find(Request.class, id);
	}

}
