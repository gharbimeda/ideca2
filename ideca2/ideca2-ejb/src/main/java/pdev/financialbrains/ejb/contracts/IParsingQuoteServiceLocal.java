package pdev.financialbrains.ejb.contracts;

import java.io.IOException;
import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.Quote;
import pdev.financialbrains.ejb.entities.Rate;

@Local
public interface IParsingQuoteServiceLocal {

	void initializeQuotes(String ticker) throws IOException;
	public List<Quote> initializeQuotes2(String ticker) throws IOException;

	public List<Quote> initializeQuotes3(String ticker) throws IOException;
    public List<Rate> initializeQuotes4(String ticker) throws IOException;
	public Quote parseQuote(String ticker) throws IOException ;
	public List<Quote> initializeQuotes5() throws IOException ;
    public void Timer() throws IOException;
	
}
