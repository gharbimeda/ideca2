package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pdev.financialbrains.ejb.contracts.ICapFloorServiceLocal;
import pdev.financialbrains.ejb.contracts.ICapFloorServiceRemote;
import pdev.financialbrains.ejb.entities.CapFloor;

@Stateless
@LocalBean
public class CapFloorCrudService implements ICapFloorServiceLocal, ICapFloorServiceRemote {

	@PersistenceContext(unitName = "data")
	private EntityManager entityManager;

	@Override
	public void create(CapFloor capFloor) {
		entityManager.persist(capFloor);

	}

	@Override
	public void update(CapFloor capFloor) {
		entityManager.merge(capFloor);
	}

	@Override
	public void delete(CapFloor capFloor) {
		entityManager.remove(entityManager.merge(capFloor));
	}

	@Override
	public CapFloor read(Integer id) {
		return entityManager.find(CapFloor.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CapFloor> readAll() {
		Query query = entityManager.createQuery("SELECT c from t_capfloor c");
		return query.getResultList();
	}

}
