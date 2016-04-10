package pdev.financialbrains.client.boot;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.criteria.CriteriaBuilder.In;

import java.util.Random;

import pdev.financialbrains.ejb.contracts.IFxoptionCrudServicesRemote;
import pdev.financialbrains.ejb.entities.ForeignExchangeOption;

public class TestFx {
	public static void main(String[] args) throws NamingException  {
		Context context = new InitialContext(); 
		IFxoptionCrudServicesRemote proxy =(IFxoptionCrudServicesRemote) context.lookup("/ideca2-ejb/FxoptionCrudServices!pdev.financialbrains.ejb.contracts.IFxoptionCrudServicesRemote");
	ForeignExchangeOption fxoption=new ForeignExchangeOption();
	fxoption.setCallPut(0);
	fxoption.setCurrentPrice(12f);	
	fxoption.setDomesticRiskFree(2);
	fxoption.setMaturityDate(2);
	fxoption.setStrikePrice(14f);
	fxoption.setVolatilite(1f);
	fxoption.setRiskFree(2);
	
	
	
	
	
	proxy.create(fxoption);
	}
}
