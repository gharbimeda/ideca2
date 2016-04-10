package pdev.financialbrains.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.ITradeCrudServiceLocal;
import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.entities.User;
import pdev.financialbrains.ejb.services.UserCrudServices;
import pdev.financialbrains.util.Util;

@ManagedBean(name = "tradeBean")
@RequestScoped
public class TradeBean {

	@EJB
	ITradeCrudServiceLocal services;

	private List<Trade> trades;
	
	
	
	private Boolean show;

	@PostConstruct
	public void init() {
		trades = services.readPending();
	}

	public String doShow(){
		show=true;
		return null;
	}
	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public String doAccept(Trade t) {
		t.setStatus(1);
		services.update(t);
		return "trades?faces-redirect=true";
	}

	public void doDecline(Trade t) {
		t.setStatus(0);
		services.update(t);
		trades = services.readPending();
	}	

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}



}
