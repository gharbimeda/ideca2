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

	
	/**
	 * add a cap or a floor
	 */
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
		Query query = entityManager.createQuery("SELECT c from CapFloor c", CapFloor.class);
		return query.getResultList();
	}

	/**
	 * method used for the normal distribution 
	 */
	@Override
	public Double CNDF(double x) {
		int neg = (x < 0d) ? 1 : 0;
		if (neg == 1)
			x *= -1d;

		double k = (1d / (1d + 0.2316419 * x));
		double y = ((((1.330274429 * k - 1.821255978) * k + 1.781477937) * k - 0.356563782) * k + 0.319381530) * k;
		y = 1.0 - 0.398942280401 * Math.exp(-0.5 * x * x) * y;

		return (1d - neg) * y + neg * (1d - y);
	}
	
	/**
	 * return number of days according to a tenor
	 */

	@Override
	public Integer nDays(Integer tenor) {
		if (tenor == 3) {
			return 90;
		}
		if (tenor == 6) {
			return 180;
		}
		if (tenor == 12) {
			return 360;
		}
		return 0;
	}

	/**
	 * return the european option
	 */
	@Override
	public double europeanOption(boolean operationType, boolean cF, float s, float k, double r, float q, float v,
			float t) {
		double d1 = 0;
		double d2 = 0;
		double euroOption = 0;

		d1 = Math.log(s / k) + ((r - q + 0.5 * Math.pow(v, 2)) * t / (v * Math.sqrt(t)));
		d2 = Math.log(s / k) + ((r - q - 0.5 * Math.pow(v, 2)) * t / (v * Math.sqrt(t)));

		double nd1 = CNDF(d1);
		double nd2 = CNDF(d2);
		double nnd1 = CNDF(-d1);
		double nnd2 = CNDF(-d2);
		System.out.println(nd1 + "  " + "   " + nd2 + "  " + nnd1 + "    " + "  " + nnd2);
		if (operationType == true) {
			euroOption = s * Math.exp(-q * t) * nnd1 - k * Math.exp(-r * t) * nnd2;
		} else

			euroOption = s * Math.exp(-q * t) * nnd1 + k * Math.exp(-r * t) * nnd2;
		return euroOption;
	}

	
	@Override
	public double calculD1(Double cap_floor, float s, float rfr, Double maturity, Double volatility) {
		Double result = (Math.log(cap_floor/s)+(rfr + 0.8 /2)*maturity)/(volatility * Math.sqrt(maturity));
		return result;
	}

	@Override
	public double pricingCapFloor(Double amount, String cap_floor, Integer nDays, Integer period, Integer daysYear, Double f_rate,
			Double strike, Double vol, Double maturity, Double rfr) {
		Double a = (amount*nDays*period/daysYear)/(1+f_rate*nDays*period/daysYear);
		Double b,c,result=0.0;
		if (cap_floor.equals("cap")){
			b=CNDF(((Math.log(f_rate/strike)+(0.5 * Math.pow(vol, 2)*maturity))/(vol*Math.sqrt(maturity)))-(vol*Math.sqrt(maturity)));
			c=CNDF((Math.log(f_rate/strike)+(0.5*Math.pow(vol, 2)*maturity))/(vol*Math.sqrt(maturity)));
			result= a * Math.exp((-rfr * maturity)*((f_rate*c)-(strike*b)));
			return result;
		}
		if (cap_floor.equals("floor")){
			b=CNDF((-(Math.log(f_rate/strike)+(0.5 * Math.pow(vol, 2)*maturity))/(vol*Math.sqrt(maturity)))-(vol*Math.sqrt(maturity)));
			c=CNDF(-(Math.log(f_rate/strike)+(0.5*Math.pow(vol, 2)*maturity))/(vol*Math.sqrt(maturity)));
			result= a * Math.exp((-rfr * maturity)*((f_rate*c)-(strike*b)));
			return result;
		}
		return result;
	}
	

}
