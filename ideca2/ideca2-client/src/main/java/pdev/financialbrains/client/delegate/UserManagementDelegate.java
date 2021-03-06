package pdev.financialbrains.client.delegate;

import java.util.List;

import pdev.financialbrains.client.locator.ServiceLocator;
import pdev.financialbrains.ejb.contracts.IComplaintsCrudServicesRemote;
import pdev.financialbrains.ejb.contracts.IUserCrudServiceRemote;
import pdev.financialbrains.ejb.entities.Message;
import pdev.financialbrains.ejb.entities.User;
import pdev.financialbrains.ejb.services.UserCrudServices;

public class UserManagementDelegate {

	public static IUserCrudServiceRemote remote;
	public static final String jndi = "/ideca2-ejb/UserCrudServices!pdev.financialbrains.ejb.contracts.IUserCrudServiceRemote";

	private static IUserCrudServiceRemote getProxy() {
		return (IUserCrudServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static User doAuthentification(String login, String password) {
		return getProxy().authentification(login, password);

	}

	public static List<User> doRead(Integer id) {
		return getProxy().readAll(id);
	}

	public static List<User> doReadAll() {
		return getProxy().read();
	}

}