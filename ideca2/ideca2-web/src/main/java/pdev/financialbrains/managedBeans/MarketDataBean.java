package pdev.financialbrains.managedBeans;
/*
 * Mariem
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.IParsingQuoteServiceLocal;
import pdev.financialbrains.ejb.contracts.IParsingQuoteServiceRemote;
import pdev.financialbrains.ejb.entities.Quote;

@ManagedBean(name = "mdBean")
@ViewScoped
public class MarketDataBean {
	@EJB
	private IParsingQuoteServiceLocal quoteLocal;
	
	private List<Quote> quotes = new ArrayList<>();
	private List<Quote> quotess = new ArrayList<>();
	private List<Quote> quotesss = new ArrayList<>();
	private Quote quote = new Quote();

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public List<Quote> getQuotess() {
		return quotess;
	}

	public void setQuotess(List<Quote> quotess) {
		this.quotess = quotess;
	}

	public List<Quote> getQuotesss() {
		return quotesss;
	}

	public void setQuotesss(List<Quote> quotesss) {
		this.quotesss = quotesss;
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
	
		try {//quoteLocal.initializeQuotes("AAPL");
			//quotes = quoteLocal.initializeQuotes2("AAPL");
			quotes = quoteLocal.initializeQuotes2("AAPL");
		 quotess = quoteLocal.initializeQuotes2("YHOO");
		 quotesss = quoteLocal.initializeQuotes2("GOOG");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
