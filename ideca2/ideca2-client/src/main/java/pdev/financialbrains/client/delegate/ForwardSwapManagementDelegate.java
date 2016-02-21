package pdev.financialbrains.client.delegate;

import java.util.List;

import pdev.financialbrains.client.utils.ServiceLocator;
import pdev.financialbrains.ejb.contracts.IForwardSwapCrudServicesRemote;
import pdev.financialbrains.ejb.entities.ForwardSwap;

public class ForwardSwapManagementDelegate {

	final String JNDINAME = "/ideca2-ejb/ForwardSwapCrudServices!pdev.financialbrains.ejb.contracts.IForwardSwapCrudServicesRemote";
	IForwardSwapCrudServicesRemote proxy = (IForwardSwapCrudServicesRemote) ServiceLocator.getInstance()
			.getProxy(JNDINAME);
	public static ForwardSwapManagementDelegate instance;

	private ForwardSwapManagementDelegate() {
	}

	public static ForwardSwapManagementDelegate getInstance() {
		if (instance == null)
			return new ForwardSwapManagementDelegate();
		return instance;
	}

	public void doCreate(ForwardSwap forwardSwap) {
		proxy.create(forwardSwap);
	}

	public void doUpdate(ForwardSwap forwardSwap) {
		proxy.update(forwardSwap);
	}

	public void doDelete(ForwardSwap forwardSwap) {
		proxy.delete(forwardSwap);
	}

	public ForwardSwap doReadById(Integer id) {
		return proxy.readById(id);
	}

	public List<ForwardSwap> doReadAll() {
		return proxy.readAll();
	}

	public Double dopriceForwardSwap(Float strikeRate, Float rate, Float notional, Float period, Float expiryTime,
			Float volatility) {
		return proxy.priceForwardSwap(strikeRate, rate, notional, period, expiryTime, volatility);
	}
}
