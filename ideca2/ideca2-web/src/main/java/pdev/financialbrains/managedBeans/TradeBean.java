package pdev.financialbrains.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.ITradeCrudServiceLocal;
import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.entities.User;
import pdev.financialbrains.util.Util;

@ManagedBean(name = "tradeBean")
@ViewScoped
public class TradeBean {

	@EJB
	ITradeCrudServiceLocal services;

	private List<Trade> trades;

	private List<Trade> trades1;

	@PostConstruct
	public void init() {
	    trades = services.readPending();
	    trades1= services.readTradesByUser(Util.userConnect);
	}
	

	public void doAccept(Trade trade){
		trade.setStatus(1);
		services.update(trade);
		trades = services.readPending();
	}
	
	public void doDecline(Trade trade){
		trade.setStatus(0);
		services.update(trade);
		trades = services.readPending();
	}
	
	public List<Trade> getTrades() {
		return trades;
	}


	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}


	public List<Trade> getTrades1() {
		return trades1;
	}


	public void setTrades1(List<Trade> trades1) {
		this.trades1 = trades1;
	}
	
	
}
