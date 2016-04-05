package pdev.financialbrains.managedBeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.IMessageCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IUserCrudServiceLocal;
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
	@ManagedProperty("#{identity}")
	private Trader traderConnected;
	private String text;
	private Trader traderDest;
	private Message message;
	private Date date;
	private List<User> traders;
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

	public Trader getTraderConnected() {
		return traderConnected;
	}

	public void setTraderConnected(Trader traderConnected) {
		this.traderConnected = traderConnected;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Trader getTraderDest() {
		return traderDest;
	}

	public void setTraderDest(Trader traderDest) {
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

	public String doShowForm(){
		showForm = showForm ? false : true;
		return null; 
	}
	
	@PostConstruct
	public void init(){
		text = new String();
		traderDest = new Trader();
		message = new Message();
		date = new Date();
		System.out.println(traderConnected);
//		traders =  userLocal.readAllButOne(traderConnected);
	}
	
	public String doSend(){
		message.setUserSource(traderConnected);
		message.setUserDest(traderDest);
		message.setTexte(text);
		message.setDate(date);
		messageLocal.create(message);
		return null;
	}

}
