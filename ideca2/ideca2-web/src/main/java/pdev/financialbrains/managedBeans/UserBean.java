package pdev.financialbrains.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.container.Suspended;

import pdev.financialbrains.ejb.contracts.IAccountCrudServicesLocal;

import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.entities.User;

@ManagedBean
@RequestScoped
public class UserBean  implements Serializable{
	@EJB
	private IAccountCrudServicesLocal aclo;
	private List<User> users = new ArrayList<>();
	private User user = new User();
	private List<Trader> traders = new ArrayList<>();
	private Trader trader = new Trader();
	private Boolean etat;
	
	
	
	 @PostConstruct
		public void init(){
			
			traders = 	aclo.readAlll();	
			
			System.out.println("aaaaaaaaaa**");
		}
	
	public List<Trader> getTraders() {
		return traders;
	}
	public void setTraders(List<Trader> traders) {
		this.traders = traders;
	}
	public Trader getTrader() {
		return trader;
	}
	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String doAdd() {
		trader.setLimite(100000.0);
		aclo.create(trader);
		
		
		System.out.println("Im");
		
		return null;
		
		
		
		
	}
	public String doAccept(Trader trader) {
		trader.setStatus(1);
		aclo.updateTrader(trader);
		return "/pages/admin/home?faces-redirect=true";
	}

	public String  doDecline(Trader trader) {
		trader.setStatus(0);
		aclo.updateTrader(trader);
		return "/pages/admin/home?faces-redirect=true";
	}	
	
	public String doDelete(Trader trade) {
		aclo.deleteTrader(trade);
		return "trades?faces-redirect=true";
	}
	

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	
	
}
