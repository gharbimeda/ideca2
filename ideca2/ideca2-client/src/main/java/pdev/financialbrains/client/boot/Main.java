package pdev.financialbrains.client.boot;

import pdev.financialbrains.client.delegate.BondManagementDelegate;
import pdev.financialbrains.client.delegate.CurrencyManagementDelegate;
import pdev.financialbrains.client.delegate.StockManagementDelegate;
import pdev.financialbrains.ejb.entities.Bond;
import pdev.financialbrains.ejb.entities.Currency;
import pdev.financialbrains.ejb.entities.Stock;

public class Main {

	public static void main(String[] args) {
		Currency currency = new Currency();
		currency.setId(1);
		currency.setSymbol("EUR");
		CurrencyManagementDelegate.getInstance().doCreate(currency);
		
		Currency currency2 = new Currency();
		currency2.setId(9);
		currency2.setSymbol("DNT");
		CurrencyManagementDelegate.getInstance().doCreate(currency2);
		
		Bond bond = new Bond();
		bond.setId(10);
		bond.setCurrentPrice(2500f);
		BondManagementDelegate.getInstance().doCreate(bond);
		
		Bond bond2 = new Bond();
		bond2.setId(11);
		bond2.setCurrentPrice(5200f);
		BondManagementDelegate.getInstance().doCreate(bond2);

		 Stock stock = new Stock();
		 stock.setId(2);
		 stock.setCompanyName("Delice");
		 StockManagementDelegate.getInstance().doCreate(stock);
		
		 Stock stock2 = new Stock();
		 stock2.setId(3);
		 stock2.setCompanyName("Nestle");
		 StockManagementDelegate.getInstance().doCreate(stock2);

	}
}
