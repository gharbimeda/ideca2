package pdev.financialbrains.managedBeans;

//import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.http.HttpServletRequest;
import pdev.financialbrains.ejb.contracts.IComplaintsCrudServicesLocal;
import pdev.financialbrains.ejb.entities.Complaint;
//import pdev.financialbrains.ejb.entities.User;
@ManagedBean(name="mbcomplaintBean")
@ViewScoped
public class ComplaintBean {

	@EJB
	private IComplaintsCrudServicesLocal complaintsCrudServicesLocal ;
	private Complaint complaint;
	//private ServletRequest request;

	//@ManagedProperty(value="#{param['id']}")
	//private String QueryParam;
	//private User user;
	

	
	/*public String getQueryParam() {
		return QueryParam;
	}
	public void setQueryParam(String queryParam) {
		QueryParam = queryParam;
	}*/
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

	
	/*public void GetUserId(ServletRequest request) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		LoginBean loginBean=(LoginBean) req.getSession().getAttribute("loginBean");
		user.setIdUser(loginBean.getIdConnected());
		complaint.setUser(user);
		
     }*/
	@PostConstruct
	public void init(){
		 complaint=new Complaint();
		
	 }
	

	public String doAdd() {
		
		complaintsCrudServicesLocal.send(complaint);
		init();
		return null;
	}
	public String doUpdate()
	{
		complaintsCrudServicesLocal.update(complaint);
		init();
		return null;
	}


	/*	public void construtComplaint(){
	
	User user= new User() ;
	Integer IdUser =Integer.parseInt(this.QueryParam);
	user.setIdUser(IdUser);
	
	complaint.setUser(user);
	
}*/
	}
