package pdev.financialbrains.client.boot;
/**
 * MARIEM
 */

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import pdev.financialbrains.ejb.contracts.IParsingQuoteServiceRemote;
import pdev.financialbrains.ejb.entities.Quote;


public class Test {
	public static void main(String[] args) throws NamingException, IOException {
	Context ctx = new InitialContext();
	IParsingQuoteServiceRemote proxy = (IParsingQuoteServiceRemote) ctx.lookup("/ideca2-ejb/ParsingQuoteService!pdev.financialbrains.ejb.contracts.IParsingQuoteServiceRemote");
		//Client c1 = new Client(1, "Moussa", "ELHADJ");
	//Client c2 = new Client(2, "Jilani", "BEN BARKA");
		//proxy.ajouterClient(c2);
	//Quote q = new Quote();
	Quote mstock = new Quote();
	//mstock.setId(1);
//	mstock.setAsk(2.5);
	//mstock.setChange("cc");
	//mstock.setName("AZERTY");
	//mstock.setOpen(5.6);
	//mstock.setVolume(2);
//	mstock.setBid(8.6);
	//mstock.setPreviousClose(6.3);
	//change, name, open, previousClose, symbol, volume) va
	//mstock.setSymbol("AAPL");
	//sproxy.initializeQuotes("AAPL");
	//proxy.addQuote(mstock);
	//System.out.println(proxy.initializeQuotes2("AAPL"));
	}

}
