package pdev.financialbrains.managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.entities.CapFloor;
import pdev.financialbrains.ejb.entities.CashInstrument;
import pdev.financialbrains.ejb.entities.DerivativeInstrument;
import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.entities.TradePK;
import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.services.TradeCrudServices;
import pdev.financialbrains.util.Util;

@ManagedBean( name="capbean")
@ViewScoped
public class CapBean {

	
	@ManagedProperty("#{identity.userIdentify}")
	private Trader trader;
	
	@EJB
	private TradeCrudServices tradeServices;
	
	private CapFloor c = new CapFloor();

	private Integer nbDays;
	private Float risk;
	private Float yield;
	private Integer putCall;
	
	private int i=10;
	
	private List<Trade> trades;
	private List<Trade> caps;
	



	@PostConstruct
	public void init() {
	    
	   caps = remplir(); 
	}
	
public List<Trade> remplir(){
	trades = tradeServices.readPutAccepted();
	List<Trade> caps = new ArrayList<Trade>();
	for (Trade t : trades){
    	if (t.getName().equalsIgnoreCase("cap") || t.getName().equalsIgnoreCase("floor")){
    		caps.add(t);
    	}
    }
	return caps;
	
}
	
	public Integer doNbDays(Integer tenor){
		if (tenor == 3) return 90;
		if (tenor == 6) return 180;
		if (tenor == 12) return 360;
		return 0;
	}

	public void doPricing(){
		
	}
	
	public void doBookTrade(){
		Trade t = new Trade();
		TradePK pk = new TradePK();
		pk.setId(i);
		i++;
		pk.setIdUser(1);
		t.setPk(pk);
		t.setFi(c);
		t.setTrader(trader);
		t.setPutcall(putCall);
		t.setStatus(2);
		t.setName(c.getCapFloorString());
		t.setValue(c.getNotionalAmount());
		tradeServices.create(t);
	}
	
	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public CapFloor getC() {
		return c;
	}

	public void setC(CapFloor c) {
		this.c = c;
	}

	public Integer getNbDays() {
		return nbDays;
	}

	public void setNbDays(Integer nbDays) {
		this.nbDays = nbDays;
	}

	public Float getRisk() {
		return risk;
	}

	public void setRisk(Float risk) {
		this.risk = risk;
	}

	public Float getYield() {
		return yield;
	}

	public void setYield(Float yield) {
		this.yield = yield;
	}

	public Integer getPutCall() {
		return putCall;
	}

	public void setPutCall(Integer putCall) {
		this.putCall = putCall;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}

	public List<Trade> getCaps() {
		return caps;
	}

	public void setCaps(List<Trade> caps) {
		this.caps = caps;
	}
	
	
	
	
}
