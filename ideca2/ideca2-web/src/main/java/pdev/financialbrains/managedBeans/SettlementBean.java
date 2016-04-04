package pdev.financialbrains.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.ITradeCrudServiceLocal;
import pdev.financialbrains.ejb.entities.Trade;

@ManagedBean
@ViewScoped
public class SettlementBean {

	@EJB
	private ITradeCrudServiceLocal tradeLocal;
	private Trade trade;
	private List<Trade> trades;
	private boolean showForm = false;

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public ITradeCrudServiceLocal getTradeLocal() {
		return tradeLocal;
	}

	public void setTradeLocal(ITradeCrudServiceLocal tradeLocal) {
		this.tradeLocal = tradeLocal;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}

	@PostConstruct
	public void init() {
		trades = tradeLocal.readPending();
		trade = new Trade();
		
	}

	public String doSettle(Trade trade ) {
		tradeLocal.settle(trade);
		init();
		return null;
	}
	
	public String doDecline(){
		tradeLocal.decline(trade);
		init();
		return null; 
	}

	public String doShowForm() {
		showForm = showForm ? false : true;
		return null;
	}
}
