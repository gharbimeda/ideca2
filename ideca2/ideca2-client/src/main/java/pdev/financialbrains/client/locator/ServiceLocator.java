package pdev.financialbrains.client.locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ServiceLocator {

	private static ServiceLocator instance;
	private static Context context;
	
	private Map<String , Object> cache;
	
	private ServiceLocator() {
		cache = new HashMap<String,Object>();
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public Object getProxy(String jndi) {
		Object proxy = null;
		proxy= cache.get(jndi);
		if(proxy!= null){
			return proxy;
		}else {
			try {
				proxy=context.lookup(jndi);
				cache.put(jndi, proxy);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		
			return proxy;
		}
	}
	public static ServiceLocator getInstance(){
		if(instance == null)
			instance = new ServiceLocator();
		return instance;//retourne une seule instance
	}
}
