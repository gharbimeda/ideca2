package pdev.financialbrains.client.delegate;

import java.util.List;

import pdev.financialbrains.client.utils.ServiceLocator;
import pdev.financialbrains.ejb.contracts.ITradeCrudServiceRemote;
import pdev.financialbrains.ejb.entities.Trade;

public class TradeManagementDelegate {

	final String JNDINAME = "/ideca2-ejb/TradeCrudServices!pdev.financialbrains.ejb.contracts.ITradeCrudServiceRemote";
	ITradeCrudServiceRemote proxy = (ITradeCrudServiceRemote) ServiceLocator.getInstance().getProxy(JNDINAME);
	public static TradeManagementDelegate instance;

	private TradeManagementDelegate() {
	}

	public static TradeManagementDelegate getInstance() {
		if (instance == null)
			return new TradeManagementDelegate();
		return instance;
	}

	public void doCreate(Trade trade) {
		proxy.create(trade);
	}

	public void doDelete(Trade trade) {
		proxy.delete(trade);
	}

	public void doUpdate(Trade trade) {
		proxy.update(trade);
	}

	public Trade doReadById(Integer id) {
		return proxy.readById(id);
	}

	public List<Trade> doReadAll() {
		return proxy.readAll();
	}

	public List<Trade> doReadCanApp() {
		return proxy.readCanApp();
	}

	public List<Trade> doReadPending() {
		return proxy.readPending();
	}
}
