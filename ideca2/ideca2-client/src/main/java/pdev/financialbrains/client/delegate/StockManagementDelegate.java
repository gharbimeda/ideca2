package pdev.financialbrains.client.delegate;

import java.util.List;

import pdev.financialbrains.client.locator.ServiceLocator;
import pdev.financialbrains.ejb.contracts.IStockCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Stock;

public class StockManagementDelegate {

	final String JNDINAME = "/ideca2-ejb/StockCrudServices!pdev.financialbrains.ejb.contracts.IStockCrudServicesRemote";
	IStockCrudServicesRemote proxy = (IStockCrudServicesRemote) ServiceLocator.getInstance().getProxy(JNDINAME);
	public static StockManagementDelegate instance;

	private StockManagementDelegate() {
	}

	public static StockManagementDelegate getInstance() {
		if (instance == null) {
			return new StockManagementDelegate();
		}
		return instance;
	}

	public void doCreate(Stock stock) {
		proxy.create(stock);
	}

	public void doUpdate(Stock stock) {
		proxy.update(stock);
	}

	public void doDelete(Stock stock) {
		proxy.delete(stock);
	}

	public Stock doReadById(Integer id) {
		return proxy.readById(id);
	}

	public List<Stock> doReadByCompanyName(String companyName) {
		return proxy.readByCompanyName(companyName);
	}

	public List<Stock> doReadAll() {
		return proxy.readAll();
	}

}
