package pdev.financialbrains.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pdev.financialbrains.ejb.entities.BackOfficeUser;
import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.entities.User;

@ManagedBean(eager = true, name = "identity")
@SessionScoped
public class IdentityBean implements Serializable {

	private static final long serialVersionUID = 1L;
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

	public Boolean hasRole(String role) {
		Boolean res = false;
		switch (role) {
		case "trader":
			res = userIdentify instanceof Trader;
			break;
		case "backoffuser":
			res = userIdentify instanceof BackOfficeUser;
			break;
		}
		return res;
	}

	@Override
	public String toString() {
		return "IdentityBean [userIdentify=" + userIdentify + "]";
	}

}
