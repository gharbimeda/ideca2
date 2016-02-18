package pdev.financialbrains.client.boot;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import pdev.financialbrains.client.delegate.BondManagementDelegate;
import pdev.financialbrains.ejb.contracts.IBondCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Bond;
import pdev.financialbrains.ejb.entities.CashInstrument;
import pdev.financialbrains.ejb.entities.FinancialInstrument;

public class TestBond {


	
	public static void main(String[] args) throws NamingException {

		//try {
		//	Context context = new InitialContext();
		//	IBondCrudServicesRemote proxy = (IBondCrudServicesRemote) context
				//	.lookup("/ideca2-ejb/BondCrudServices!pdev.financialbrains.ejb.contracts.IBondCrudServicesRemote");

			//Bond b = new Bond(1, 250.5f, 8.255f, "marioum", "mimi");
			//BondManagementDelegate bondManagementDelegate = new BondManagementDelegate();
			// Bond b = new Bond();
			// b.setId("1");
			// b.setCoupon("coupon");
			// proxy.create(b);
		
			// proxy.update(b);
			// proxy.delete(b);
		
			//System.out.println(proxy.readAll());
			// System.out.println(proxy.readById(1));
			// proxy.delete(b);
			//BondManagementDelegate.doDelete(b2);
	//	} catch (NamingException e) {
		//	e.printStackTrace();
		//}
		//Bond b = new Bond();
		//BondManagementDelegate.getInstance().docreate(b);
	}
}
