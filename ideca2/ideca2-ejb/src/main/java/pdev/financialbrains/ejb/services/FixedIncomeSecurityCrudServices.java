package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pdev.financialbrains.ejb.contracts.IFixedIncomeSecurityLocal;
import pdev.financialbrains.ejb.contracts.IFixedIncomeSecurityRemote;
import pdev.financialbrains.ejb.entities.FixedIncomeSecuritie;
import pdev.financialbrains.ejb.entities.Message;

/**
 * Session Bean implementation class FixedIncomeSecurityCrudServices
 */
@Stateless
@LocalBean
public class FixedIncomeSecurityCrudServices implements IFixedIncomeSecurityRemote,IFixedIncomeSecurityLocal{

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="data")
	private EntityManager entityManager;
    public FixedIncomeSecurityCrudServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void create(FixedIncomeSecuritie f) {
		entityManager.persist(f);
		
	}

	@Override
	public void delete(FixedIncomeSecuritie f) {
		entityManager.remove(entityManager.find(FixedIncomeSecuritie.class, f.getId()));
		
	}

	@Override
	public void update(FixedIncomeSecuritie f) {
		entityManager.merge(f);
		
	}

	@Override
	public FixedIncomeSecuritie readById(Integer id) {
		return entityManager.find(FixedIncomeSecuritie.class, id);
	}

	

	@Override
	public List<FixedIncomeSecuritie> readAll() {
		return entityManager.createQuery("select m from FixedIncomeSecuritie m",FixedIncomeSecuritie.class).getResultList();
	}

	@Override
	public Double priceZeroCouponBond(Float faceValue, Integer timeMaturity, Float currentYield) {
		// TODO Auto-generated method stub
		Double  Price;
		return Price = faceValue/(Math.pow(1+currentYield, timeMaturity));
	}

}
