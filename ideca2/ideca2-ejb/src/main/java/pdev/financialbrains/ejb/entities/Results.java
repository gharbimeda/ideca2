package pdev.financialbrains.ejb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name="results")
@XmlAccessorType(XmlAccessType.FIELD)
public class Results implements Serializable{
	
	@XmlElement(name="quote")
	public List<Quote> quotes = new ArrayList<Quote>();
	
	
	@XmlElement(name="rate")
	public List<Rate> rates = new ArrayList<Rate>();
    public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	private static final long serialVersionUID = 1L;
    
    public void add(Quote quote) {
		quotes.add(quote);
	}  
    
	public Results() {
	}
	
	


	
	public List<Quote> getQuotes() {
		return quotes;
	}
	
	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
	

	
	
	
	

	
	


	
	
	

	
}
