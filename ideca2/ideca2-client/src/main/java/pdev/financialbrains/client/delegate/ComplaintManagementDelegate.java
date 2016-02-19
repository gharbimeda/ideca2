package pdev.financialbrains.client.delegate;

import java.util.List;

import pdev.financialbrains.client.locator.ServiceLocator;
import pdev.financialbrains.ejb.contracts.IArticleCrudServicesRemote;
import pdev.financialbrains.ejb.contracts.IComplaintsCrudServicesRemote;
import pdev.financialbrains.ejb.contracts.IMessageCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Complaint;
import pdev.financialbrains.ejb.entities.Message;



public class ComplaintManagementDelegate {
	
	
	final static String JNDINAME="/ideca2-ejb/ComplaintsCrudServices!pdev.financialbrains.ejb.contracts.IComplaintsCrudServicesRemote";
	static IComplaintsCrudServicesRemote proxy = (IComplaintsCrudServicesRemote) ServiceLocator.getInstance().getProxy(JNDINAME);
	public static ComplaintManagementDelegate instance;
	
private ComplaintManagementDelegate () {}

public static ComplaintManagementDelegate getInstance() {
	if ( instance == null ) {
		
		return new ComplaintManagementDelegate();
		
		
		
	}
	
	return instance;
}

	public  void doSend(Complaint complaint){
		proxy.send(complaint);
	}

	public static void doDelete(Complaint complaint){
		proxy.delete(complaint);
	}

	
	public static  Complaint doRead (Integer id){
		return proxy.read(id);
	}
	
	
	public static List<Complaint> doReadAll (){
		return proxy.readAll();
	}
	

}