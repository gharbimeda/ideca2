package pdev.financialbrains.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import pdev.financialbrains.ejb.entities.Request;
import pdev.financialbrains.ejb.services.RequestCrudService;

@ManagedBean
@RequestScoped

public class RequestBean{
	@EJB
	private RequestCrudService reqlocal;
	private List<Request> requests = new ArrayList<>();
	private Request request = new Request();
	String nav = "";
	
	
	public List<Request> getRequests() {
		return requests;
	}
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public String doAdd() {
		reqlocal.create(request);
		System.out.println("Im inside ADD************++++++*");
		nav =  "/pages/public/Requestt?faces-redirect=true" ;
		return nav ; 
	}
}

