package pdev.financialbrains.client.delegate;

import java.util.List;

import pdev.financialbrains.client.utils.ServiceLocator;

import pdev.financialbrains.ejb.contracts.IFxoptionCrudServicesRemote;

import pdev.financialbrains.ejb.entities.ForeignExchangeOption;

public class FxManagementDelegate {

	
	final String JNDINAME = "/ideca2-ejb/FxoptionCrudServices!pdev.financialbrains.ejb.contracts.IFxoptionCrudServicesRemote";
	IFxoptionCrudServicesRemote proxy = (IFxoptionCrudServicesRemote) ServiceLocator.getInstance().getProxy(JNDINAME);

	public static FxManagementDelegate instance;

	public FxManagementDelegate() {
		
	}
	public static FxManagementDelegate getInstance() {
		if (instance == null) {
			return new FxManagementDelegate();
		}
		return instance;
	}

	public void doCreate(ForeignExchangeOption fx) {
		proxy.create(fx);
	}

	public void doDelete(ForeignExchangeOption fx) {
		proxy.delete(fx);
	}

	public void doUpdate(ForeignExchangeOption fx) {
		proxy.update(fx);
	}

	public ForeignExchangeOption doReadById(Integer id) {
		return proxy.read(id);
	}

	public List<ForeignExchangeOption> doReadAll() {
		return proxy.readAll();
	}
	
	public Double Price(Integer callPut , Integer currentSpotPrice, Integer dRisk,Integer fRisk,Integer time,Float strikePrice,Float volatilite) {
		return proxy.Pricing(callPut, currentSpotPrice, dRisk, fRisk, time, strikePrice, volatilite);
		
	}

}
