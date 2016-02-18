package pdev.financialbrains.client.delegate;

import java.util.List;

import pdev.financialbrains.client.utils.ServiceLocator;
import pdev.financialbrains.ejb.contracts.IBondCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Bond;

public class BondManagementDelegate {
	final String JNDINAME = "/ideca2-ejb/BondCrudServices!pdev.financialbrains.ejb.contracts.IBondCrudServicesRemote";
	IBondCrudServicesRemote proxy = (IBondCrudServicesRemote) ServiceLocator.getInstance().getProxy(JNDINAME);
	public static BondManagementDelegate instance;

	private BondManagementDelegate() {
	}

	public static BondManagementDelegate getInstance() {
		if (instance == null) {
			return new BondManagementDelegate();
		}
		return instance;
	}

	public void doCreate(Bond bond) {
		proxy.create(bond);
	}

	public void doDelete(Bond bond) {
		proxy.delete(bond);
	}

	public void doUpdate(Bond bond) {
		proxy.update(bond);
	}

	public Bond doReadById(Integer id) {
		return proxy.readById(id);
	}

	public List<Bond> doReadBySteppedCoupon(Integer steppedCoupon) {
		return proxy.readBySteppedCoupon(steppedCoupon);
	}

	public List<Bond> doReadAll() {
		return proxy.readAll();
	}

}
