package pdev.financialbrains.client.boot;


import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import pdev.financialbrains.ejb.contracts.IParsingQuoteServiceRemote;


public class Test {
	public static void main(String[] args) throws NamingException {
	Context ctx = new InitialContext();
	IParsingQuoteServiceRemote proxy = (IParsingQuoteServiceRemote) ctx.lookup("ideca2-ear/ideca2-ejb/ParsingQuoteService!pdev.financialbrains.ejb.contracts.IParsingQuoteServiceRemote");
		//Client c1 = new Client(1, "Moussa", "ELHADJ");
	//Client c2 = new Client(2, "Jilani", "BEN BARKA");
		//proxy.ajouterClient(c2);
	//Quote q = new Quote();
	try {
		proxy.initializeQuotes("AAPL");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
