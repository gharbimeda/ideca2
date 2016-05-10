package pdev.financialbrains.managedBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import pdev.financialbrains.ejb.contracts.IComplaintsCrudServicesLocal;
import pdev.financialbrains.ejb.entities.Complaint;
import pdev.financialbrains.ejb.entities.Trader;

@ManagedBean(name = "mbcomplaintBean")
@ViewScoped
public class ComplaintBean {

	@EJB
	private IComplaintsCrudServicesLocal complaintsCrudServicesLocal;
	private Complaint complaint;
	@ManagedProperty("#{identityBean}")
	private IdentityBean identityBean;
	private Trader trader;

	public IComplaintsCrudServicesLocal getComplaintsCrudServicesLocal() {
		return complaintsCrudServicesLocal;
	}

	public void setComplaintsCrudServicesLocal(IComplaintsCrudServicesLocal complaintsCrudServicesLocal) {
		this.complaintsCrudServicesLocal = complaintsCrudServicesLocal;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	@PostConstruct
	public void init() {
		complaint = new Complaint();
		trader = new Trader();
		trader = (Trader) identityBean.getUtilisateur();
	}

	public String doAdd() {
		complaint.setUser(trader);
		complaintsCrudServicesLocal.send(complaint);
		init();
		return null;
	}

	public String doUpdate() {
		complaintsCrudServicesLocal.update(complaint);
		init();
		return null;
	}

}
