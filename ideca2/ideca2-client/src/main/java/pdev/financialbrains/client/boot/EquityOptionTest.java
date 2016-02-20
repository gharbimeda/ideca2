package pdev.financialbrains.client.boot;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import pdev.financialbrains.client.delegate.EquityOptionManagementDelegate;
import pdev.financialbrains.ejb.contracts.ICapFloorServiceRemote;
import pdev.financialbrains.ejb.contracts.IEquityOptionCrudServicesRemote;
import pdev.financialbrains.ejb.services.EquityOptionCrudService;

public class EquityOptionTest {
	
	
	
	public static void main(String[] args) throws NamingException {
		try {
			Context context = new InitialContext();
		
			IEquityOptionCrudServicesRemote  proxy  = (IEquityOptionCrudServicesRemote) context.lookup("/ideca2-ejb/EquityOptionCrudService!pdev.financialbrains.ejb.contracts.IEquityOptionCrudServicesRemote");
			
			
			System.out.println(EquityOptionManagementDelegate.doCND(-20));
			System.out.println(EquityOptionManagementDelegate.doBlackScholes('1', 50, 60, 10, 0.5, 0.2));
			
			
		} catch (NamingException  e) {
			e.printStackTrace();
		}
	

		
		
}}
