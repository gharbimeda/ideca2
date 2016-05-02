package pdev.financialbrains.managedBeans;

import java.io.Serializable;

import pdev.financialbrains.managedBeans.EmailSender;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="a")
@RequestScoped
public class MailBean implements Serializable {
	
	private String header ; 
	private String name ; 
	private String mailAddress ;
	
	
	
	
	public String send(){
		
		System.out.println("bbbb");
		 String[] to = { mailAddress };
		 System.out.println(""+mailAddress);
 String Email_Body = "Congratulations you have been added as a trader  in the Ideca2.0 Trading System here is your private Information : "
		+ "\n"
		+ "Login : " 
		 
		+header 
		+ "\n"
		+ "Password :"
		+name
		+  "Welcome To Ideca :)";
			if (EmailSender.sendEmail("create.money.differently@gmail.com", "98238622",
					Email_Body, to)) {
				System.out.println("email sent successfully");
				
			} else {
				System.out.println("some error occured");
			}
			return "Account.jsf?faces-redirect=true";
		}
	    
	
	
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	} 
	
	
	
	

}
