package pdev.financialbrains.ejb.contracts;

import java.io.IOException;
import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.Quote;

@Remote
public interface IParsingQuoteServiceRemote {

	void initializeQuotes(String ticker) throws IOException;
	public List initializeQuotes2(String ticker) throws IOException;


}
