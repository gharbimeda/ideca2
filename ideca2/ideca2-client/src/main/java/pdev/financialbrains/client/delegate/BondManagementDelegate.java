package pdev.financialbrains.client.delegate;

import java.util.Date;
import java.util.List;

import pdev.financialbrains.client.locator.ServiceLocator;
import pdev.financialbrains.ejb.contracts.IArticleCrudServicesRemote;
import pdev.financialbrains.ejb.contracts.IBondCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Article;
import pdev.financialbrains.ejb.entities.Bond;
import pdev.financialbrains.ejb.entities.Message;

public class BondManagementDelegate {
	private static IBondCrudServicesRemote remote;
	private static final String jndi="/ideca2-ejb/BondCrudServices!pdev.financialbrains.ejb.contracts.IBondCrudServicesRemote";
	
	public static BondManagementDelegate instance;

	private BondManagementDelegate() {
	}

	public static BondManagementDelegate getInstance() {
		if (instance == null) {
			return new BondManagementDelegate();
		}
		return instance;
	}
	
	private static IBondCrudServicesRemote getProxy(){
		return (IBondCrudServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public static void doCreate(Bond bond){
		getProxy().create(bond);
	}

	public static void doDelete(Bond bond){
		getProxy().delete(bond);
	}

	public static void doUpdate(Bond bond){
		getProxy().update(bond);
	}

	public List<Bond> readBySteppedCoupon(Integer steppedCoupon) {
		return getProxy().readBySteppedCoupon(steppedCoupon);
	}
	public static List<Bond> doRead (){
		return getProxy().readAll();
	}
	public static Bond doRead (Integer id){
		return getProxy().readById(id);
	}

}
