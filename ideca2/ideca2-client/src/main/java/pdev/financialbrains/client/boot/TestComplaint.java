package pdev.financialbrains.client.boot;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import pdev.financialbrains.client.delegate.ComplaintManagementDelegate;
import pdev.financialbrains.ejb.contracts.IComplaintsCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Complaint;

public class TestComplaint {
	

	public static void main(String[] args) throws NamingException {

		try {
			Context context = new InitialContext();
			IComplaintsCrudServicesRemote proxy = (IComplaintsCrudServicesRemote) context
					.lookup("/ideca2-ejb/ComplaintsCrudServices!pdev.financialbrains.ejb.contracts.IComplaintsCrudServicesRemote");
			Complaint b = new Complaint();
			//Message m = new Message(1,"azerty");
			//m.setTexte("mariem");;
			//MessageManagementDelegate.getInstance().doCreate(m);
		//	System.out.println(MessageManagementDelegate.getInstance().doRead(1));
		//	MessageManagementDelegate.getInstance().doUpdate(m);
			//b=ComplaintManagementDelegate.doRead(1);
			b.setObject("rererer");
			b.setText("hello");
			b.setDate(new Date());
			b.setId(2);
			//System.out.println(	ComplaintManagementDelegate.getInstance().doSend());
			ComplaintManagementDelegate.getInstance().doSend(b);
			
			//System.out.println(ComplaintManagementDelegate.getInstance().doReadAll());
			//ComplaintManagementDelegate.doDelete(b);
			
			
			//b.setObject("ammiijjhh");
			//b.setText("oppopo");
			
			//proxy.delete(2);

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
}