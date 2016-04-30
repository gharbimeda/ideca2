package pdev.financialbrains.managedBeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.IComplaintsCrudServicesLocal;
import pdev.financialbrains.ejb.entities.Complaint;

@ManagedBean
@ViewScoped
public class ClaimsBean {

	@EJB
	private IComplaintsCrudServicesLocal claimLocal;
	private String object;
	private String text;
	private Date date;
	private String user;
	private List<Complaint> claims;

	public IComplaintsCrudServicesLocal getClaimLocal() {
		return claimLocal;
	}

	public void setClaimLocal(IComplaintsCrudServicesLocal claimLocal) {
		this.claimLocal = claimLocal;
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

	@PostConstruct
	public void init() {
		claims = claimLocal.readAll();
		object = new String();
		text = new String();
		date = new Date();
		user = new String();
	}

	public String doReply() {
		return null;
	}

}
