package pdev.financialbrains.managedBeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.IComplaintsCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IMessageCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IUserCrudServiceLocal;
import pdev.financialbrains.ejb.entities.Complaint;
import pdev.financialbrains.ejb.entities.Message;
import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.entities.User;

@ManagedBean
@ViewScoped
public class ClaimsBean {

	@EJB
	private IComplaintsCrudServicesLocal claimLocal;
	@EJB
	private IMessageCrudServicesLocal messageLocal;
	private String object;
	private String text;
	private Date date;
	private String user;
	private List<Complaint> claims;
	private IUserCrudServiceLocal userLocal;
	private Message message;
	@ManagedProperty("#{identityBean}")
	private IdentityBean identityBean;
	private User admin;
	private String response; 

	public IComplaintsCrudServicesLocal getClaimLocal() {
		return claimLocal;
	}

	public void setClaimLocal(IComplaintsCrudServicesLocal claimLocal) {
		this.claimLocal = claimLocal;
	}

	public IMessageCrudServicesLocal getMessageLocal() {
		return messageLocal;
	}

	public void setMessageLocal(IMessageCrudServicesLocal messageLocal) {
		this.messageLocal = messageLocal;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Complaint> getClaims() {
		return claims;
	}

	public void setClaims(List<Complaint> claims) {
		this.claims = claims;
	}

	public IUserCrudServiceLocal getUserLocal() {
		return userLocal;
	}

	public void setUserLocal(IUserCrudServiceLocal userLocal) {
		this.userLocal = userLocal;
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

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@PostConstruct
	public void init() {
		claims = claimLocal.readAll();
		message = new Message();
		object = new String();
		text = new String();
		date = new Date();
		user = new String();
		admin = new User();
		admin = (User) identityBean.getUtilisateur();
		response = new String();
		
	}

	public String doReply(Trader trader,String rep) {
		message.setUserSource(admin);
		message.setUserDest(trader);
		message.setTexte(rep);
		message.setDate(new Date());
		messageLocal.create(message);
		init();
		return null;
	}

}
