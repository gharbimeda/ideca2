package pdev.financialbrains.client.boot;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import pdev.financialbrains.ejb.contracts.IStockCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Stock;

public class Main {

	public static void main(String[] args) {
		try{
			Context context = new InitialContext(); 
			IStockCrudServicesRemote proxy = (IStockCrudServicesRemote) context.lookup("/ideca2-ejb/StockCrudServices!pdev.financialbrains.ejb.contracts.IStockCrudServicesRemote");
			
			Stock stock = new Stock(); 
			
//			stock.setId(1);	
//			stock1.setCompanyName("Toshiba");
//			proxy.create(stock1);
			
//			stock.setCompanyName("Toshiba");		
//			proxy.update(stock1);
			
//			proxy.delete(stock);
			
			stock = proxy.readById(2);
			
			System.out.print(stock);
			
		} catch(NamingException e){
			e.printStackTrace();
		}
	}
}
