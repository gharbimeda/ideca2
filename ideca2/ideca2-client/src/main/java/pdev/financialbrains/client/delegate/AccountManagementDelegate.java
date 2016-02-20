package pdev.financialbrains.client.delegate;


import java.util.List;

import pdev.financialbrains.client.locator.ServiceLocator;
import pdev.financialbrains.ejb.contracts.IAccountCrudServicesRemote;
import pdev.financialbrains.ejb.entities.User;

public class AccountManagementDelegate {
	
	private static IAccountCrudServicesRemote remote;
	 private static final String jndi="/ideca2-ejb/AccountCrudServices!pdev.financialbrains.ejb.contracts.IAccountCrudServicesRemote";

	public static IAccountCrudServicesRemote getProxy(){
			return (IAccountCrudServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
		}
		
		public static void doCreate(User user){
			getProxy().create(user);
		}

		public static void doDelete(User user){
			getProxy().delete(user);
		}

		public static void doUpdate(User user){
			getProxy().update(user);
		}

		public static User doRead (Integer id){
			return getProxy().read(id);
		}
		
		public static List<User> doRead (){
			return getProxy().readAll();
		}

		public static IAccountCrudServicesRemote getRemote() {
			return remote;
		}

		public static void setRemote(IAccountCrudServicesRemote remote) {
			AccountManagementDelegate.remote = remote;
		}

		/*private final String JNDINAME = "/ideca2-ejb/AccountCrudServices!pdev.financialbrains.ejb.contracts.IAccountCrudServicesRemote";
			
		private IAccountCrudServicesRemote proxy = (IAccountCrudServicesRemote) ServiceLocator.getInstance().getProxy(JNDINAME);
			
		public static AccountManagementDelegate instance;
		
		public AccountManagementDelegate() {
			
		}
			
		
			
		public static AccountManagementDelegate getInstance() {
		
				if (instance == null) {
		
					return new AccountManagementDelegate();
		
				}
		
				return instance;
			}
		
		
		public void create(User user) {
		
				proxy.create(user);
			}
		
			
		public void update(User user) {
				proxy.update(user);
			}
		
		
		
			
		public void delete(User user) {
				proxy.delete(user);
			}
		
			
		public User read(Integer id) {
				return proxy.read(id);
		}
		
		public static List<User> doRead (){
			return proxy.readAll();
		}
		*/
		
				
		}
