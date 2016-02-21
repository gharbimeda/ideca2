package pdev.financialbrains.client.boot;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Random;

import pdev.financialbrains.ejb.contracts.IFxoptionCrudServicesRemote;

public class TestFx {
	public static void main(String[] args) throws NamingException  {
		Context context = new InitialContext(); 
		IFxoptionCrudServicesRemote proxy =(IFxoptionCrudServicesRemote) context.lookup("/ideca2-ejb/FxoptionCrudServices!pdev.financialbrains.ejb.contracts.IFxoptionCrudServicesRemote");
		//proxy.Pricing("call", 12, 2, 3, 2, 1.2f, 1f);
		 /*Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(100);
		 System.out.println(randomInt);
		System.out.println(proxy.N(1.3));
		Double price;
		price=proxy.Pricing("", 12, 2, 3, 2, 1.2f, 1f);
		if (price==null)
		{
			price =Math.random() ;
		}*/
		
		//System.out.println(price);
		System.out.println("price");
		System.out.println(proxy.Pricing("Put", 12, 2, 3, 2, 1.2f, 1f));
		//proxy.Pricing("call", 10, 3, 4, 2, 1.2, 1.2);
	}
}
