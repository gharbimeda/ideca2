package pdev.financialbrains.client.delegate;

import java.util.Date;
import java.util.List;

import pdev.financialbrains.client.locator.ServiceLocator;
import pdev.financialbrains.ejb.contracts.IMessageCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Bond;
import pdev.financialbrains.ejb.entities.Message;

public class MessageManagementDelegate {

	private static IMessageCrudServicesRemote remote;
	private static final String jndi="/ideca2-ejb/MessageCrudServices!pdev.financialbrains.ejb.contracts.IMessageCrudServicesRemote";
	public static MessageManagementDelegate instance;
	
	
	private MessageManagementDelegate() {
	}

	public static MessageManagementDelegate getInstance() {
		if (instance == null) {
			return new MessageManagementDelegate();
		}
		return instance;
	}
	
	private static IMessageCrudServicesRemote getProxy(){
		return (IMessageCrudServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public static void doCreate(Message Message){
		getProxy().create(Message);
	} 

	public static void doDeleteById(Message Message){
		getProxy().deleteById(Message);
	}
	public static void doDelete(Message Message){
		getProxy().delete(Message);
	}

	public static void doUpdate(Message Message){
		getProxy().update(Message);
	}

	public static List<Message> doRead (Integer id){
		return getProxy().readById(id);
	}
	
	
	public static List<Message> doRead (){
		return getProxy().readAll();
	}
	
}
