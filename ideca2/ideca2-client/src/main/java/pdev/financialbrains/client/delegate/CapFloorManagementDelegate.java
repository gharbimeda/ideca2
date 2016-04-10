package pdev.financialbrains.client.delegate;

import java.util.List;

import pdev.financialbrains.client.locator.ServiceLocator;
import pdev.financialbrains.ejb.contracts.ICapFloorServiceRemote;
import pdev.financialbrains.ejb.entities.CapFloor;

public class CapFloorManagementDelegate {

	private static ICapFloorServiceRemote remote;
	private static final String JNDI = "/ideca2-ejb/CapFloorCrudService!pdev.financialbrains.ejb.contracts.ICapFloorServiceRemote";
	
	private static ICapFloorServiceRemote getProxy(){
	    return (ICapFloorServiceRemote) ServiceLocator.getInstance().getProxy(JNDI);	
	}
	
	public static void doCreate(CapFloor capFloor){
		getProxy().create(capFloor);
	}

	public static void doUpdate(CapFloor capFloor){
		getProxy().update(capFloor);
	}

	public static void doDelete(CapFloor capFloor){
		getProxy().delete(capFloor);
	}

	public static CapFloor doRead(Integer id){
		return getProxy().read(id);
	}

	public static List<CapFloor> doReadAll(){
		return getProxy().readAll();
	}
	
	public static Double CNDF(double x){
		return getProxy().CNDF(x);
	}

	public static Integer nDays(Integer tenor){
		return getProxy().nDays(tenor);
	}

	public static double europeanOption(boolean operationType, boolean cF, float s, float k, double r, float q, float v, float t){
		return getProxy().europeanOption(operationType, cF, s, k, r, q, v, t);
	}

	public static double calculD1(Double cap_floor, float s, float rfr, Double maturity, Double volatility){
		return getProxy().calculD1(cap_floor,s,rfr,maturity,volatility);
	}
	public static double pricingCapFloor(Double amount, String cap_floor, Integer nDays, Integer period, Integer daysYear, Double f_rate,
			Double strike, Double vol, Double maturity, Double rfr) {
		//return getProxy().pricingCapFloor(amount, cap_floor, nDays, period, daysYear, f_rate, strike, vol, maturity, rfr);
		return 0;
	}
}
