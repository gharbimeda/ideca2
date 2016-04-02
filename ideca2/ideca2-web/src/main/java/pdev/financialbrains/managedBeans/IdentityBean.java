package pdev.financialbrains.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pdev.financialbrains.ejb.entities.BackOfficeUser;
import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.entities.User;

@ManagedBean(name= "identity")
@SessionScoped
public class IdentityBean {

	private User userIdentify;

	public IdentityBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User getUserIdentify() {
		return userIdentify;
	}


	public void setUserIdentify(User userIdentify) {
		this.userIdentify = userIdentify;
	}


	public Boolean hasRole(String role){
		Boolean res = false;
		switch (role){
		case "trader" :
			res = userIdentify instanceof Trader;
			break;
		case "backoffuser":
			res = userIdentify instanceof BackOfficeUser;
			break;
	}
	return res;
	}
}
