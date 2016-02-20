package pdev.financialbrains.client.delegate;

import java.util.List;

import pdev.financialbrains.client.utils.ServiceLocator;
import pdev.financialbrains.ejb.contracts.IGenericCrudServiceRemote;
import pdev.financialbrains.ejb.entities.Generic;

public class GenericManagementDelegate {

	final String JNDINAME = "/ideca2-ejb/GenericCrudServices!pdev.financialbrains.ejb.contracts.IGenericCrudServiceRemote";
	IGenericCrudServiceRemote proxy = (IGenericCrudServiceRemote) ServiceLocator.getInstance().getProxy(JNDINAME);
	public static GenericManagementDelegate instance;

	public GenericManagementDelegate() {
	}

	public static GenericManagementDelegate getInstance() {
		if (instance == null)
			return new GenericManagementDelegate();
		return instance;
	}

	public void doCreate(Generic generic) {
		proxy.create(generic);
	}

	public void doUpdate(Generic generic) {
		proxy.update(generic);
	}

	public void doDelete(Generic generic) {
		proxy.delete(generic);
	}

	public Generic doReadById(Integer id) {
		return proxy.readById(id);
	}

	public List<Generic> doReadAll() {
		return proxy.readAll();
	}
}
