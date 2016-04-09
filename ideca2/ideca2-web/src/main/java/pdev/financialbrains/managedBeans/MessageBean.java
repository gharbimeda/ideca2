package pdev.financialbrains.managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.IMessageCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IUserCrudServiceLocal;
import pdev.financialbrains.ejb.entities.BackOfficeUser;
import pdev.financialbrains.ejb.entities.Message;
import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.entities.User;

@ManagedBean
@ViewScoped
public class MessageBean {

	@EJB
	private IUserCrudServiceLocal userLocal;
	@EJB
	private IMessageCrudServicesLocal messageLocal;
	@ManagedProperty(value = "#{identity}")
	private IdentityBean identityBean;
	private String text;
	private String traderDest;
	private Message message;
	private Date date;
	private List<User> traders;
	private List<String> tradersNames;
	private List<Message> messages;
	private Trader trader;
	private BackOfficeUser back;
	private Boolean showForm = false;

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(Boolean showForm) {
		this.showForm = showForm;
	}

	public IUserCrudServiceLocal getUserLocal() {
		return userLocal;
	}

	public void setUserLocal(IUserCrudServiceLocal userLocal) {
		this.userLocal = userLocal;
	}

	public IMessageCrudServicesLocal getMessageLocal() {
		return messageLocal;
	}

	public void setMessageLocal(IMessageCrudServicesLocal messageLocal) {
		this.messageLocal = messageLocal;
	}

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTraderDest() {
		return traderDest;
	}

	public void setTraderDest(String traderDest) {
		this.traderDest = traderDest;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<User> getTraders() {
		return traders;
	}

	public void setTraders(List<User> traders) {
		this.traders = traders;
	}

	public List<String> getTradersNames() {
		return tradersNames;
	}

	public void setTradersNames(List<String> tradersNames) {
		this.tradersNames = tradersNames;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public BackOfficeUser getBack() {
		return back;
	}

	public void setBack(BackOfficeUser back) {
		this.back = back;
	}

	public String doShowForm() {
		showForm = showForm ? false : true;
		return null;
	}

	@PostConstruct
	public void init() {
		text = new String();
		traderDest = new String();
		message = new Message();
		date = new Date();
		tradersNames = new ArrayList<String>();
		if (identityBean.hasRole("trader")) {
			trader = new Trader();
			trader = (Trader) identityBean.getUserIdentify();
		} else if (identityBean.hasRole("backoffuser")) {
			back = new BackOfficeUser();
			back = (BackOfficeUser) identityBean.getUserIdentify();
		}

		traders = userLocal.readAll(1);
		for (int i = 0; i < traders.size(); i++) {
			tradersNames.add(i, traders.get(i).getLogin());
		}
		messages = messageLocal.readByUserDestId(2);
		System.out.println(identityBean);

	}

	public String doSend() {
		message.setUserSource(userLocal.readById(1));
		message.setUserDest(userLocal.readByLogin(traderDest));
		message.setTexte(text);
		message.setDate(date);
		messageLocal.create(message);
		init();
		return null;
	}

}
