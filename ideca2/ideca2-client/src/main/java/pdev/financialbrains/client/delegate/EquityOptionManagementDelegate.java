package pdev.financialbrains.client.delegate;

import pdev.financialbrains.client.locator.ServiceLocator;

import pdev.financialbrains.ejb.contracts.IEquityOptionCrudServicesRemote;

public class EquityOptionManagementDelegate {
	
	
	private static IEquityOptionCrudServicesRemote remote;
	 private static final String jndi="/ideca2-ejb/EquityOptionCrudService!pdev.financialbrains.ejb.contracts.IEquityOptionCrudServicesRemote";

	public static IEquityOptionCrudServicesRemote getProxy(){
			return (IEquityOptionCrudServicesRemote) ServiceLocator.getInstance().getProxy(jndi);		

}
	
	public static double doBlackScholes(char CallPutFlag, double S, double X, double T, double r, double v){
		return getProxy().BlackScholes(CallPutFlag, S, X, T, r, v);
		
		
		
	}
	
	public static double doCND(double X){
		return getProxy().CND(X);
		
		
		
	}
	
}