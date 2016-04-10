package pdev.financialbrains.managedBeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import pdev.financialbrains.ejb.contracts.IMessageCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.ITradeCrudServiceLocal;
import pdev.financialbrains.ejb.entities.Message;
import pdev.financialbrains.ejb.entities.Trade;

@ManagedBean
@ViewScoped
public class SettlementBean {

	@EJB
	private ITradeCrudServiceLocal tradeLocal;
	@EJB
	private IMessageCrudServicesLocal messageLocal;
	private Trade trade;
	private List<Trade> trades;
	private Integer tradeSettled;
	private Integer tradeUnsettled;
	private Message message;
	@ManagedProperty("#{identityBean}")
	private IdentityBean identityBean;
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

	public Integer getTradeSettled() {
		return tradeSettled;
	}

	public void setTradeSettled(Integer tradeSettled) {
		this.tradeSettled = tradeSettled;
	}

	public Integer getTradeUnsettled() {
		return tradeUnsettled;
	}

	public void setTradeUnsettled(Integer tradeUnsettled) {
		this.tradeUnsettled = tradeUnsettled;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	@PostConstruct
	public void init() {
		trades = tradeLocal.readPending();
		trade = new Trade();
		tradeSettled = tradeLocal.readAccepted();
		tradeUnsettled = tradeLocal.readRefused();
		message = new Message();

	}

	public String doSettle(Trade trade) {
		tradeLocal.settle(trade);
		message.setTexte("Votre Trade a ete accepté !");
		message.setUserSource(identityBean.getUtilisateur());
		message.setUserDest(trade.getTrader());
		message.setDate(new Date());
		messageLocal.create(message);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity.");        
        RequestContext.getCurrentInstance().showMessageInDialog(message);
		init();
		return null;		
	}

	public String doDecline(Trade trade) {
		tradeLocal.decline(trade);
		message.setTexte("Votre Trade a ete décliné !");
		message.setUserSource(identityBean.getUtilisateur());
		message.setUserDest(trade.getTrader());
		message.setDate(new Date());
		messageLocal.create(message);
		init();
		return null;
	}

	public String doShowForm() {
		showForm = showForm ? false : true;
		return null;
	}
}
