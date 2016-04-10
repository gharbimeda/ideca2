package pdev.financialbrains.managedBeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import pdev.financialbrains.ejb.entities.BackOfficeUser;
import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.entities.User;
import pdev.financialbrains.ejb.services.UserCrudServices;

@ManagedBean(name = "access")
@RequestScoped
public class AccessBean {

	@EJB
	private UserCrudServices authan;

	@ManagedProperty("#{identityBean}")
	private IdentityBean identityBean;

	private String login;
	private String password;

	public AccessBean() {
		// TODO Auto-generated constructor stub
	}

	public String doLogin() {
		String navigateTo = null;
		User found = authan.authentification(login, password);

		// Util.userConnect = authan.authentification(login, password);
		if (found != null) {
			if (found instanceof Trader) {
				Trader foundTrader = (Trader) authan.authentification(login, password);
				identityBean.setUtilisateur(foundTrader);
				identityBean.setRole("trader");
				navigateTo = "/pages/trader/home?faces-redirect=true";
			} else if (found instanceof BackOfficeUser) {
				BackOfficeUser foundBackOffUser = (BackOfficeUser) authan.authentification(login, password);
				identityBean.setUtilisateur(foundBackOffUser);
				identityBean.setRole("backoffuser");
				navigateTo = "/pages/back/backHome?faces-redirect=true";
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "NON AUTORISE", null

			));
		}
		return navigateTo;
	}

	public String doLogout() {
		String navigateTo = null;
		navigateTo = "/pages/public/login?faces-redirect=true";
		return navigateTo;
	}

	public UserCrudServices getAuthan() {
		return authan;
	}

	public void setAuthan(UserCrudServices authan) {
		this.authan = authan;
	}

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
