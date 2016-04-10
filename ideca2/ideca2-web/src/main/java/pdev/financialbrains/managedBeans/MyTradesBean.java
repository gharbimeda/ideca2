package pdev.financialbrains.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pdev.financialbrains.ejb.contracts.ITradeCrudServiceLocal;
import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.entities.User;
import pdev.financialbrains.ejb.services.UserCrudServices;

@ManagedBean(name = "mtradeBean")
@RequestScoped
public class MyTradesBean {
	
	@ManagedProperty("#{identity.userIdentify}")
	private Trader trader;
	
	@EJB
	ITradeCrudServiceLocal services;
	
	@EJB
	UserCrudServices userCrudServices;
	
	private List<Trade> trades;
	
	@PostConstruct
	public void init() {
	    trades =services.readTradesByUser(userCrudServices.readOneUser(1));
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}
	
	public String doDelete(Trade trade) {
		services.delete(trade);
		return "trades?faces-redirect=true";
	}
	

}
