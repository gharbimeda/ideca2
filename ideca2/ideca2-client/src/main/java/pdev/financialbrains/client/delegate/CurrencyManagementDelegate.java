package pdev.financialbrains.client.delegate;

import java.util.List;

import pdev.financialbrains.client.locator.ServiceLocator;
import pdev.financialbrains.ejb.contracts.ICurrencyCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Currency;

public class CurrencyManagementDelegate {

	final String JNDINAME = "/ideca2-ejb/CurrencyCrudServices!pdev.financialbrains.ejb.contracts.ICurrencyCrudServicesRemote";
	ICurrencyCrudServicesRemote proxy = (ICurrencyCrudServicesRemote) ServiceLocator.getInstance().getProxy(JNDINAME);
	public static CurrencyManagementDelegate instance;

	private CurrencyManagementDelegate() {
	}

	public static CurrencyManagementDelegate getInstance() {
		if (instance == null) {
			return new CurrencyManagementDelegate();
		}
		return instance;
	}

	public void doCreate(Currency currency) {
		proxy.create(currency);
	}

	public void doUpdate(Currency currency) {
		proxy.update(currency);
	}

	public void doDelete(Currency currency) {
		proxy.delete(currency);
	}

	public Currency doReadById(Integer id) {
		proxy.readById(id);
	}

	public List<Currency> doReadBySymbol(String symbol) {
		proxy.readBySymbol(symbol);
	}

	public List<Currency> doReadAll() {
		proxy.readAll();
	}

}
