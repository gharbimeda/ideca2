package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pdev.financialbrains.ejb.contracts.IBondCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IBondCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Bond;
import pdev.financialbrains.ejb.entities.Message;

/**
 * Session Bean implementation class BondCrudServices
 */
@Stateless
@LocalBean
public class BondCrudServices implements IBondCrudServicesRemote, IBondCrudServicesLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext(unitName="md")
	private EntityManager entityManager;

	public BondCrudServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Bond b) {
		entityManager.persist(b);

	}

	@Override
	public void delete(Bond b) {
		entityManager.remove(entityManager.find(Bond.class, b.getId()));


	}

	@Override
	public void update(Bond b) {
		entityManager.merge(b);

	}

	@Override
	public Bond readById(Integer id) {
		return entityManager.find(Bond.class, id);

	}

	@Override
	public List<Bond> readBySteppedCoupon(Integer steppedCoupon) {
		Query query = entityManager.createQuery("select b from Bond b where b.steppedCoupon=:a");
		query.setParameter("a", steppedCoupon);
		return (List<Bond>) query.getResultList();
	}

	@Override
	public List<Bond> readAll() {
		//return entityManager.createQuery("select b from Bond b", Bond.class).getResultList();
		return entityManager.createQuery("select m from Bond m", Bond.class).getResultList();

	}

}
