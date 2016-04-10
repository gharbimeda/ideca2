package pdev.financialbrains.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pdev.financialbrains.ejb.entities.User;

@ManagedBean
@SessionScoped
public class IdentityBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private User utilisateur;
	private String role;

	public IdentityBean() {
	}

	public Boolean hasRole(String r) {
		Boolean response = false;
		if (role.equals(r))
			response = true;
		return response;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "IdentityBean [utilisateur=" + utilisateur + ", role=" + role + ", getUtilisateur()=" + getUtilisateur()
				+ ", getRole()=" + getRole() + "]";
	}
	

}
