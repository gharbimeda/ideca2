package pdev.financialbrains.client.delegate;

import java.util.List;

import pdev.financialbrains.client.locator.ServiceLocator;
import pdev.financialbrains.ejb.contracts.ICapFloorServiceRemote;
import pdev.financialbrains.ejb.entities.CapFloor;

public class CapFloorManagementDelegate {

	private static ICapFloorServiceRemote remote;
	private static final String JNDI = "/ideca2-ejb/CapFloorCrudService!pdev.financialbrains.ejb.contracts.ICapFloorServiceRemote";
	
	private static ICapFloorServiceRemote getProxy(){
	    return (ICapFloorServiceRemote) ServiceLocator.getInstance().getProxy(JNDI);	
	}
	
	public static void doCreate(CapFloor capFloor){
		getProxy().create(capFloor);
	}

	public static void doUpdate(CapFloor capFloor){
		getProxy().update(capFloor);
	}

	public static void doDelete(CapFloor capFloor){
		getProxy().delete(capFloor);
	}

	public static CapFloor doRead(Integer id){
		return getProxy().read(id);
	}

	public static List<CapFloor> doReadAll(){
		return getProxy().readAll();
	}
}
