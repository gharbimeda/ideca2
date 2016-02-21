package pdev.financialbrains.client.boot;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import pdev.financialbrains.ejb.contracts.IAccountCrudServicesRemote;
import pdev.financialbrains.ejb.entities.User;

public class TestAccount {
	
	public static void main(String[] args) throws NamingException  {

		Context context = new InitialContext();
		IAccountCrudServicesRemote proxy = (IAccountCrudServicesRemote) context
				.lookup("/ideca2-ejb/AccountCrudServices!pdev.financialbrains.ejb.contracts.IAccountCrudServicesRemote");
		User user = new User("11", "password");
		proxy.create(user);
			//AccountManagementDelegate accountManagementDelegate=new AccountManagementDelegate();
		
			
		}
}
