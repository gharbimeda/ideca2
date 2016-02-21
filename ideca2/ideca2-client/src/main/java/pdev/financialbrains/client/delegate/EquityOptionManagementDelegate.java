package pdev.financialbrains.client.delegate;

import pdev.financialbrains.client.locator.ServiceLocator;

import pdev.financialbrains.ejb.contracts.IEquityOptionCrudServicesRemote;

public class EquityOptionManagementDelegate {

	private static IEquityOptionCrudServicesRemote remote;
	private static final String jndi = "/ideca2-ejb/EquityOptionCrudService!pdev.financialbrains.ejb.contracts.IEquityOptionCrudServicesRemote";

	public static IEquityOptionCrudServicesRemote getProxy() {
		return (IEquityOptionCrudServicesRemote) ServiceLocator.getInstance().getProxy(jndi);

	}

	public static Double doBlackScholes(String CallPutFlag, Double S, Double X, Double T, Double r, Double v) {
		return getProxy().BlackScholes(CallPutFlag, S, X, T, r, v);

	}

	public static Double doCND(Double X) {

		return getProxy().CND(X);

	}

}