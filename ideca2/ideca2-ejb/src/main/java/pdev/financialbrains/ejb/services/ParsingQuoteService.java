package pdev.financialbrains.ejb.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import pdev.financialbrains.ejb.contracts.IParsingQuoteServiceLocal;
import pdev.financialbrains.ejb.contracts.IParsingQuoteServiceRemote;
import pdev.financialbrains.ejb.entities.Query;
import pdev.financialbrains.ejb.entities.Quote;
import pdev.financialbrains.ejb.entities.Rate;
import pdev.financialbrains.ejb.entities.Stock;

/**
 * @author MariemR
 *
 */
@Stateless
@LocalBean
public class ParsingQuoteService implements IParsingQuoteServiceRemote,
		IParsingQuoteServiceLocal {

	@PersistenceContext(unitName = "md")
	private EntityManager em;

	public ParsingQuoteService() {

	}
 
	public List<Quote> initializeQuotes2(String ticker) throws IOException {
		List<Quote> quotes = new ArrayList<>();

		String fileDir = "D:/yahooQuotes.xml";
		String request = "http://query.yahooapis.com/v1/public/yql?q=select%20%2a%20from%20yahoo.finance.quotes%20where%20symbol%20in%20%28%22"
				+ ticker
				+ "%22%29&env=store://datatables.org/alltableswithkeys";
		String result = performRequest(request);

		PrintWriter pr = new PrintWriter(fileDir);
		try {
			pr.write(result);
		} finally {
			pr.close();

			Query query = new Query();

			try {
				File f = new File(fileDir);
				JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
				Unmarshaller unm = jaxbContext.createUnmarshaller();
				query = (Query) unm.unmarshal(f);

				for (Quote quote : query.results.quotes) {
					
					quotes.add(quote);

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return quotes;
	}
	 @Override
		public List<Quote> initializeQuotes3(String ticker) throws IOException {
			List<Quote> quotes = new ArrayList<>();

			String fileDir = "D:/yahooQuotes2.xml";
			String request = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%3D%22"+ticker+
					"%22&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
			String result = performRequest(request);

			PrintWriter pr = new PrintWriter(fileDir);
			try {
				pr.write(result);
			} finally {
				pr.close();

				Query query = new Query();

				try {
					File f = new File(fileDir);
					JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
					Unmarshaller unm = jaxbContext.createUnmarshaller();
					query = (Query) unm.unmarshal(f);

					for (Quote quote : query.results.quotes) {
						
						quotes.add(quote);

					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			return quotes;
		}

	private static String performRequest(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		StringBuilder sb = new StringBuilder();

		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					http.getInputStream()));
			char[] buf = new char[1000000];

			int r = 0;
			do {
				if ((r = br.read(buf)) > 0)
					sb.append(new String(buf, 0, r));
			} while (r > 0);
		} finally {
			http.disconnect();
		}

		return sb.toString();
	}

	@Override
	public void initializeQuotes(String ticker) throws IOException {

		String fileDir = "D:/yahooQuotes.xml";
		String request = "http://query.yahooapis.com/v1/public/yql?q=select%20%2a%20from%20yahoo.finance.quotes%20where%20symbol%20in%20%28%22"
				+ ticker
				+ "%22%29&env=store://datatables.org/alltableswithkeys";
		String result = performRequest(request);

		PrintWriter pr = new PrintWriter(fileDir);
		try {
			pr.write(result);
		} finally {
			pr.close();

			Query query = new Query();

			try {
				File f = new File(fileDir);
				JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
				Unmarshaller unm = jaxbContext.createUnmarshaller();
				query = (Query) unm.unmarshal(f);

				for (Quote quote : query.results.quotes) {
					System.out.println("Ticker :" + quote.getSymbol());
					System.out.println("Company Name :" + quote.getName());
					System.out.println("Ask :" + quote.getAsk());
					System.out.println("Bid :" + quote.getBid());
					System.out.println("Previous Close :"
							+ quote.getPreviousClose());
					System.out.println("Open :" + quote.getOpen());
					System.out.println("Change :" + quote.getChange());
					System.out.println("Volume :" + quote.getVolume());

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public List<Rate> initializeQuotes4(String ticker) throws IOException {
		List<Rate> rates = new ArrayList<>();

    	String fileDir = "D:/yahooCurrencies.xml";
	       String request = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%3D%22"+ticker+
	    		   "%22&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
       String result = performRequest(request);
		
       PrintWriter pr = new PrintWriter(fileDir);
       try {
       	pr.write(result);
       } finally{
       	pr.close();
       
       	Query query = new Query();
       
       	try {
       		File f = new File(fileDir);
       		JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
				Unmarshaller unm = jaxbContext.createUnmarshaller();
				query = (Query) unm.unmarshal(f);
				
				for (Rate rate : query.results.rates) {
					System.out.println("Rate :"+rate.getRate());
					System.out.println("Name :"+rate.getName());
					System.out.println("Date:"+rate.getDate());
					System.out.println("Time :"+rate.getTime());
					System.out.println("As :"+rate.getAsk());
					System.out.println("Bid :"+rate.getBid());
					rates = query.results.getRates();
		        }
				
				
       	}catch(Exception ex) {
       		ex.printStackTrace();
       	}
        
       }
       return rates;
       
      
	
	}


}
