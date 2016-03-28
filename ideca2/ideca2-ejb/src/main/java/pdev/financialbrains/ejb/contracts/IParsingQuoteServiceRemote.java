package pdev.financialbrains.ejb.contracts;

import java.io.IOException;

import javax.ejb.Remote;


@Remote
public interface IParsingQuoteServiceRemote {
	
	 void initializeQuotes(String ticker) throws IOException;
	

}
