package pdev.financialbrains.client.boot;

import pdev.financialbrains.client.delegate.BondManagementDelegate;
import pdev.financialbrains.client.delegate.CurrencyManagementDelegate;
import pdev.financialbrains.client.delegate.StockManagementDelegate;
import pdev.financialbrains.client.delegate.TradeManagementDelegate;
import pdev.financialbrains.ejb.entities.Bond;
import pdev.financialbrains.ejb.entities.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import pdev.financialbrains.ejb.contracts.IStockCrudServicesRemote;

import pdev.financialbrains.ejb.entities.Stock;
import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.entities.TradePK;

public class Main {

	public static void main(String[] args) throws Exception {
//		Currency currency = new Currency();
//		// currency.setId(1);
//		currency.setSymbol("EUR");
//		CurrencyManagementDelegate.getInstance().doCreate(currency);
//
//		Currency currency2 = new Currency();
//		// currency2.setId(9);
//		currency2.setSymbol("DNT");
//		CurrencyManagementDelegate.getInstance().doCreate(currency2);
//
//		Bond bond = new Bond();
//		// bond.setId(10);
//		bond.setCurrentPrice(2500f);
//		BondManagementDelegate.getInstance().doCreate(bond);
//
//		Bond bond2 = new Bond();
//		// bond2.setId(11);
//		bond2.setCurrentPrice(5200f);
//		BondManagementDelegate.getInstance().doCreate(bond2);
//
//		Stock stock = new Stock();
//		// stock.setId(2);
//		stock.setCompanyName("Delice");
//		StockManagementDelegate.getInstance().doCreate(stock);
//
//		Stock stock2 = new Stock();
//		// stock2.setId(3);
//		stock2.setCompanyName("Nestle");
//		StockManagementDelegate.getInstance().doCreate(stock2);

	/*	Trade trade = new Trade();
		TradePK pk = new TradePK(); 
		pk.setId(1);
//		pk.setIdUser(1);
		trade.setName("waiting !");
		//trade.setValue(25d);
		trade.setStatus(2);
		TradeManagementDelegate.getInstance().doCreate(trade);

		Trade trade2 = new Trade();
		trade2.setName("En Attente .....");
		//trade2.setValue(20d);
		trade2.setStatus(2);
		TradeManagementDelegate.getInstance().doCreate(trade2);

		Trade trade3 = new Trade();
		trade3.setName("Still Waiting !!");
		//trade3.setValue(82d);
		trade3.setStatus(2);
		TradeManagementDelegate.getInstance().doCreate(trade3);

		// System.out.println(TradeManagementDelegate.getInstance().doReadAll());
		// System.out.println(TradeManagementDelegate.getInstance().doReadCanApp());
		//System.out.println(TradeManagementDelegate.getInstance().doReadPending());*/

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
		// String nextLine;
		// URL url = null;
		// URLConnection urlConn = null;
		// InputStreamReader inStream = null;
		// BufferedReader buff = null;
		// try{
		// // Create the URL obect that points
		// // at the default file index.html
		// url = new URL("http://finance.yahoo.com" );
		// urlConn = url.openConnection();
		// inStream = new InputStreamReader(
		// urlConn.getInputStream());
		// buff= new BufferedReader(inStream);
		//
		// // Read and print the lines from index.html
		// while (true){
		// nextLine =buff.readLine();
		// if (nextLine !=null){
		// System.out.println(nextLine);
		// }
		// else{
		// break;
		// }
		// }
		// } catch(MalformedURLException e){
		// System.out.println("Please check the URL:" +
		// e.toString() );
		// } catch(IOException e1){
		// System.out.println("Can't read from the Internet: "+
		// e1.toString() );
		// }
		// }
	}
}
