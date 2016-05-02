package pdev.financialbrains.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.ITradeCrudServiceLocal;
import pdev.financialbrains.ejb.entities.CapFloor;
import pdev.financialbrains.ejb.entities.ForwardSwap;
import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.entities.User;
import pdev.financialbrains.ejb.services.UserCrudServices;
import pdev.financialbrains.util.Util;

@ManagedBean(name = "tradeBean")
@ViewScoped
public class TradeBean {

	@EJB
	ITradeCrudServiceLocal services;

	private List<Trade> trades;

	private Trade trade;
	
	private ForwardSwap forwardSwap = new ForwardSwap();

	private Boolean show, showCap=false,showSwap=false;
	
	

	@PostConstruct
	public void init() {
		trades = services.readPending();
	}

	public void doShow() {
		if(trade!=null){
			if(trade.getName().equalsIgnoreCase("cap")||trade.getName().equalsIgnoreCase("floor")){
				trade.setFi((CapFloor)trade.getFi());
				showCap=true;
			}
			if(trade.getName().equalsIgnoreCase("forwardSwap")){
				forwardSwap = (ForwardSwap) trade.getFi();
				showSwap=true;
			}
		}
		
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

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public Boolean getShowCap() {
		return showCap;
	}

	public void setShowCap(Boolean showCap) {
		this.showCap = showCap;
	}

	public Boolean getShowSwap() {
		return showSwap;
	}

	public void setShowSwap(Boolean showSwap) {
		this.showSwap = showSwap;
	}

	public ForwardSwap getForwardSwap() {
		return forwardSwap;
	}

	public void setForwardSwap(ForwardSwap forwardSwap) {
		this.forwardSwap = forwardSwap;
	}

}
