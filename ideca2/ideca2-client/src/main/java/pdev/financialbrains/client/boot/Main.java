package pdev.financialbrains.client.boot;

import pdev.financialbrains.client.delegate.BondManagementDelegate;
import pdev.financialbrains.client.delegate.CurrencyManagementDelegate;
import pdev.financialbrains.client.delegate.StockManagementDelegate;
import pdev.financialbrains.ejb.entities.Bond;
import pdev.financialbrains.ejb.entities.Currency;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import pdev.financialbrains.ejb.contracts.IStockCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Stock;
import pdev.financialbrains.ejb.entities.User;

public class Main {
	

		
		
		}

	public static void main(String[] args) throws Exception {
		Currency currency = new Currency();
//		currency.setId(1);
		currency.setSymbol("EUR");
		CurrencyManagementDelegate.getInstance().doCreate(currency);

		Currency currency2 = new Currency();
//		currency2.setId(9);
		currency2.setSymbol("DNT");
		CurrencyManagementDelegate.getInstance().doCreate(currency2);

		Bond bond = new Bond();
//		bond.setId(10);
		bond.setCurrentPrice(2500f);
		BondManagementDelegate.getInstance().doCreate(bond);

		Bond bond2 = new Bond();
//		bond2.setId(11);
		bond2.setCurrentPrice(5200f);
		BondManagementDelegate.getInstance().doCreate(bond2);

		Stock stock = new Stock();
//		stock.setId(2);
		stock.setCompanyName("Delice");
		StockManagementDelegate.getInstance().doCreate(stock);

		Stock stock2 = new Stock();
//		stock2.setId(3);
		stock2.setCompanyName("Nestle");
		StockManagementDelegate.getInstance().doCreate(stock2);
		/*
		 * String uri =
		 * "https://feeds.finance.yahoo.com/rss/2.0/headline?s=yhoo&region=US&lang=en-US";
		 * URL url = new URL(uri); HttpURLConnection connection =
		 * (HttpURLConnection) url.openConnection();
		 * connection.setRequestMethod("GET");
		 * connection.setRequestProperty("Accept", "application/xml");
		 * 
		 * JAXBContext jc = JAXBContext.newInstance(User.class); InputStream xml
		 * = connection.getInputStream(); User customer = (User)
		 * jc.createUnmarshaller().unmarshal(xml);
		 * 
		 * connection.disconnect();
		 */
	}
