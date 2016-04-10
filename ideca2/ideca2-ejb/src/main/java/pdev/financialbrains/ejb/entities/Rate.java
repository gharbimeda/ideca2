package pdev.financialbrains.ejb.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rate")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Rate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Rate [name=" + name + ", ask=" + ask + ", bid=" + bid
				+ ", rate=" + rate + ", date=" + date + ", time=" + time + "]";
	}
	private Integer id;
	
	private String name;
	private String ask;
	private String bid;
	private String rate;
	private String date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getBid() {
		return bid;
	}
	@XmlElement(name="Bid")
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getRate() {
		return rate;
	}
	@XmlElement(name="Rate")
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getDate() {
		return date;
	}
	@XmlElement(name="Date")
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	@XmlElement(name="Time")
	public void setTime(String time) {
		this.time = time;
	}
	private String time;
	
	
	
}
