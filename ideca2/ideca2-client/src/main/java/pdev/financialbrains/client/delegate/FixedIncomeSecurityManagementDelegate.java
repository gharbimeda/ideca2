package pdev.financialbrains.client.delegate;

import java.util.List;

import pdev.financialbrains.client.locator.ServiceLocator;
import pdev.financialbrains.ejb.contracts.IFixedIncomeSecurityLocal;
import pdev.financialbrains.ejb.contracts.IFixedIncomeSecurityRemote;
import pdev.financialbrains.ejb.contracts.IMessageCrudServicesRemote;
import pdev.financialbrains.ejb.entities.FixedIncomeSecuritie;
import pdev.financialbrains.ejb.entities.Message;

public class FixedIncomeSecurityManagementDelegate {
	//ideca2-ear/ideca2-ejb/FixedIncomeSecurityCrudServices!pdev.financialbrains.ejb.contracts.IFixedIncomeSecurityRemote
	private static IFixedIncomeSecurityLocal remote;
	private static final String jndi="ideca2-ear/ideca2-ejb/FixedIncomeSecurityCrudServices!pdev.financialbrains.ejb.contracts.IFixedIncomeSecurityRemote";
	public static FixedIncomeSecurityManagementDelegate instance;
	
	
	private FixedIncomeSecurityManagementDelegate() {
	}

	public static FixedIncomeSecurityManagementDelegate getInstance() {
		if (instance == null) {
			return new FixedIncomeSecurityManagementDelegate();
		}
		return instance;
	}
	
	private static IFixedIncomeSecurityRemote getProxy(){
		return (IFixedIncomeSecurityRemote ) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public static void doCreate(FixedIncomeSecuritie f){
		getProxy().create(f);
	} 

	public static void doDelete(FixedIncomeSecuritie f){
		getProxy().delete(f);
	}

	public static void doUpdate(FixedIncomeSecuritie f){
		getProxy().update(f);
	}

	public static FixedIncomeSecuritie doRead (Integer id){
		return getProxy().readById(id);
	}
	
	
	public static List<FixedIncomeSecuritie> doRead (){
		return getProxy().readAll();
	}
	public static Double doPriceZeroCouponBond(Float faceValue,Integer timeMaturity, Float currentYield)
	{
		return getProxy().priceZeroCouponBond(faceValue, timeMaturity, currentYield);
	}
	public static Double doPriceTtreasuryBond(Float faceValue,Integer timeMaturity, Float currentYield,Integer frequency,Float couponRate)
	{
		return getProxy().priceTreasuryBond(faceValue, timeMaturity, currentYield, frequency, couponRate);
	}
	public static Double doPriceCorpBond(Float faceValue,Integer timeMaturity, Float currentYield,Integer frequency,Float couponRate,Integer months)
	{
		return getProxy().priceCorpBond(faceValue, timeMaturity, currentYield, frequency, couponRate, months);

	}
}
