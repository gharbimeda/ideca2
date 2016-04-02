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
import pdev.financialbrains.ejb.entities.Rate;

@ManagedBean(name = "mdBean")
@ViewScoped
public class MarketDataBean {
	@EJB
	private IParsingQuoteServiceLocal quoteLocal;

	private List<Quote> quotes = new ArrayList<>();
	private List<Quote> quotess = new ArrayList<>();
	private List<Quote> quotesss = new ArrayList<>();
	private List<Quote> quotessss = new ArrayList<>();
	private List<Quote> quotes1 = new ArrayList<>();
	private List<Quote> quotes2 = new ArrayList<>();
	private List<Quote> quotes3 = new ArrayList<>();
	private List<Quote> quotes4 = new ArrayList<>();
	private List<Rate> rates = new ArrayList<>();
	private List<Rate> ratess = new ArrayList<>();
	private Rate rate = new Rate();
	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public List<Rate> getRatess() {
		return ratess;
	}

	public void setRatess(List<Rate> ratess) {
		this.ratess = ratess;
	}

	private List<Quote> cur = new ArrayList<>();

	public List<Quote> getCur() {
		return cur;
	}

	public void setCur(List<Quote> cur) {
		this.cur = cur;
	}

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

	public IParsingQuoteServiceLocal getQuoteLocal() {
		return quoteLocal;
	}

	public void setQuoteLocal(IParsingQuoteServiceLocal quoteLocal) {
		this.quoteLocal = quoteLocal;
	}

	public List<Quote> getQuotessss() {
		return quotessss;
	}

	public void setQuotessss(List<Quote> quotessss) {
		this.quotessss = quotessss;
	}

	public List<Quote> getQuotes1() {
		return quotes1;
	}

	public void setQuotes1(List<Quote> quotes1) {
		this.quotes1 = quotes1;
	}

	public List<Quote> getQuotes2() {
		return quotes2;
	}

	public void setQuotes2(List<Quote> quotes2) {
		this.quotes2 = quotes2;
	}

	public List<Quote> getQuotes3() {
		return quotes3;
	}

	public void setQuotes3(List<Quote> quotes3) {
		this.quotes3 = quotes3;
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {

		try {
			quotes = quoteLocal.initializeQuotes2("AAPL");
			quotess = quoteLocal.initializeQuotes2("YHOO");
			quotesss = quoteLocal.initializeQuotes2("GOOG");
			quotessss = quoteLocal.initializeQuotes2("MSFT");
			quotes1 = quoteLocal.initializeQuotes2("NFLX");
			quotes2 = quoteLocal.initializeQuotes2("INTC");//
			quotes3 = quoteLocal.initializeQuotes2("SGF");
			quotes4 = quoteLocal.initializeQuotes2("FB");
           rates = quoteLocal.initializeQuotes4("USDEUR");
           ratess = quoteLocal.initializeQuotes4("USDJPY");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Quote> getQuotes4() {
		return quotes4;
	}

	public void setQuotes4(List<Quote> quotes4) {
		this.quotes4 = quotes4;
	}
}
