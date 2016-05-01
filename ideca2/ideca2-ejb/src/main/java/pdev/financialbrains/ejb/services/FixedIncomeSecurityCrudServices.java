package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pdev.financialbrains.ejb.contracts.IFixedIncomeSecurityLocal;
import pdev.financialbrains.ejb.contracts.IFixedIncomeSecurityRemote;
import pdev.financialbrains.ejb.entities.Bond;
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
	public Float priceZeroCouponBond(Float faceValue, Float timeMaturity, Float currentYield) {
		// TODO Auto-generated method stub
		Float  Price;
		return Price = (float) (faceValue/(Math.pow(1+currentYield, timeMaturity)));
	}

	@Override
	public Float priceTreasuryBond(Float faceValue, Float timeMaturity, Float currentYield, Integer frequency,
			Float couponRate) {
		Float Price ; 
		return Price = (float) (couponRate*(faceValue/frequency)*
				(1-(Math.pow(1+currentYield, (1/frequency)-1))+
						faceValue/Math.pow(1+currentYield, timeMaturity)));
	}

	public Float dopricTreasuryBond(FixedIncomeSecuritie fx)
	{Float Price;
		return Price = (float) (fx.getCouponRate()*(fx.getFaceValue()/fx.getCouponFreq())*(1-Math.pow(1+fx.getCurrentPrice(),(1/fx.getCouponFreq()-1)))+
	fx.getFaceValue()/Math.pow(1+fx.getCurrentYield(),fx.getTimeMaturity()));
		
	}
	@Override
	public Float priceCorpBond(Float faceValue, Float timeMaturity, Float currentYield, Integer frequency,
			Float couponRate, Integer months) {
		Float Price;
		
		return Price = (float) ((couponRate*(faceValue/frequency))*(1-(1+Math.pow(Math.pow(1+currentYield,(1/frequency)-1), 0-(timeMaturity*frequency))))+faceValue/Math.pow(1+currentYield,(timeMaturity+months)/12)+((faceValue*couponRate)/(frequency/Math.pow(1+currentYield,months/12))));
	}
	@Override
	public Boolean delete2(FixedIncomeSecuritie f) {
		try {
			entityManager.remove(entityManager.find(FixedIncomeSecuritie.class, f.getId()));
			return true;
		} catch (Exception e) {
			System.err.println("Couldn't find the Fixed IncomeSecurity!");
		}
		return false;
	}

	@Override
	public Boolean update2(FixedIncomeSecuritie f) {
		try {
			entityManager.merge(f);
			return true;
		} catch (Exception e) {
			System.err.println("The Fixed Income Security update is not set.");
		}
		return false;
	}



	@Override
	public Boolean add(FixedIncomeSecuritie f) {
		// TODO Auto-generated method stub
		return null;
	}





}
