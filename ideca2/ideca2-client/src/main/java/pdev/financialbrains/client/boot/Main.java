package pdev.financialbrains.client.boot;

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

	public static void main(String[] args) throws Exception {
		//try{
		//	Context context = new InitialContext(); 
			//IStockCrudServicesRemote proxy = (IStockCrudServicesRemote) context.lookup("/ideca2-ejb/StockCrudServices!pdev.financialbrains.ejb.contracts.IStockCrudServicesRemote");
			
			//Stock stock = new Stock(); 
			
//			stock.setId(1);	
//			stock1.setCompanyName("Toshiba");
//			proxy.create(stock1);
			
//			stock.setCompanyName("Toshiba");		
//			proxy.update(stock1);
			
//			proxy.delete(stock);
			
		/*	stock = proxy.readById(2);
			
			System.out.print(stock);
			
		} catch(NamingException e){
			e.printStackTrace();
		}
	}*/
		/*String uri =
			    "https://feeds.finance.yahoo.com/rss/2.0/headline?s=yhoo&region=US&lang=en-US";
			URL url = new URL(uri);
			HttpURLConnection connection =
			    (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/xml");

			JAXBContext jc = JAXBContext.newInstance(User.class);
			InputStream xml = connection.getInputStream();
		User customer =
			    (User) jc.createUnmarshaller().unmarshal(xml);

			connection.disconnect();*/
}}
