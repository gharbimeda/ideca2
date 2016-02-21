package pdev.financialbrains.client.boot;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.criteria.CriteriaBuilder.In;

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
		Double price;
		Double n1 ,n2 ;
		//String currentSpotPrice="14";
		Integer fRisk=2;
		Integer time=3;
		Float strikePrice=14f;
		Integer dRisk=1;
		Float volatilite=1.2f;
		double d1=(Math.log(14 / strikePrice)+(dRisk-fRisk+volatilite*volatilite*0.5)*time )/(volatilite*Math.sqrt(time ));
		double d2=d1-volatilite*Math.sqrt(time );
		n1=proxy.N(d1);
		n2=proxy.N(d2);
		price=14*Math.exp(-fRisk*time)*n1-strikePrice*Math.exp(-dRisk *time)*n2;
		
		System.out.println("price");
		System.out.println(price);
		
		//System.out.println(proxy.Pricing("Put", 12, 2, 3, 2, 1.2f, 1f));
		//proxy.Pricing("call", 10, 3, 4, 2, 1.2, 1.2);
	}
}
