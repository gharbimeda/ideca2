package pdev.financialbrains.ejb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="quote")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Quote   implements Serializable {
	
	
	private String open;
	private String previousClose;
	private String name;
	private String ask;
	private String bid;
	private String symbol;
	private String volume;
	private String change;
	private String date ;
	private String rate;
	private String time ;
	
	
	
    private static final long serialVersionUID = 1L;
    
        
	public Quote() {
		super();
	}

	public String getName() {
		return name;
	}


	@XmlElement(name="Name")
	public void setName(String name) {
		this.name = name;
	}

	public String getAsk() {
		return ask;
	}
	@XmlElement(name="Ask")
	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getDate() {
		return date;
	}
	@XmlElement(name="Date")
	public void setDate(String date) {
		this.date = date;
	}

	public String getRate() {
		return rate;
	}
	@XmlElement(name="Rate")
	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTime() {
		return time;
	}
	@XmlElement(name="Time")
	public void setTime(String time) {
		this.time = time;
	}

	public String getBid() {
		return bid;
	}

	@XmlElement(name="Bid")
	public void setBid(String bid) {
		this.bid = bid;
	}


	public String getVolume() {
		return volume;
	}

	@XmlElement(name="Volume")
	public void setVolume(String volume) {
		this.volume = volume;
	}


	public String getChange() {
		return change;
	}

	@XmlElement(name="Change")
	public void setChange(String change) {
		this.change = change;
	}
	
	@Override
	public String toString() {
		StringBuilder sbr = new StringBuilder();
		
//		sbr.append("Name: " + name + " \n")
//		.append("Rate: " + ask + " \n")
//		.append("Date: " + bid + " \n")
		sbr.append("Change: " + change + " \n")
		.append("Volume : " + volume + " \n");
		
		return sbr.toString();
	}


	public String getSymbol() {
		return symbol;
	}

	@XmlElement(name="Symbol")
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public String getOpen() {
		return open;
	}

	@XmlElement(name="Open")
	public void setOpen(String open) {
		this.open = open;
	}


	public String getPreviousClose() {
		return previousClose;
	}

	@XmlElement(name="PreviousClose")
	public void setPreviousClose(String  previousClose) {
		this.previousClose = previousClose;
	}


	public Quote(String symbol) {
		super();
		this.symbol = symbol;
	}
	

}
