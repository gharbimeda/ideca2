package pdev.financialbrains.ejb.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import pdev.financialbrains.ejb.contracts.IEquityOptionCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IEquityOptionCrudServicesRemote;


@Stateless
@LocalBean
public class EquityOptionCrudService implements IEquityOptionCrudServicesLocal , IEquityOptionCrudServicesRemote {

	@Override
	public double BlackScholes(char CallPutFlag, double S, double X, double T, double r, double v) {
		double d1, d2;

		d1=(Math.log(S/X)+(r+v*v/2)*T)/(v*Math.sqrt(T));
		d2=d1-v*Math.sqrt(T);

		if (CallPutFlag=='1')
		{
			System.out.println("call"+CallPutFlag);
		return S*CND(d1)-X*Math.exp(-r*T)*CND(d2);
		}
		else
		{
		return X*Math.exp(-r*T)*CND(-d2)-S*CND(-d1);
		}
	}

	@Override
	public double CND(double X) {
		double L, K, w ;
		double a1 = 0.31938153, a2 = -0.356563782, a3 = 1.781477937, a4 = -1.821255978, a5 = 1.330274429;

		L = Math.abs(X);
		System.out.println("l est"+L);
		K = 1.0 / (1.0 + 0.2316419 * L);
		System.out.println("k est "+K);
		w = 1.0 - 1.0 / Math.sqrt(2.0 * Math.PI) * Math.exp(-L *L / 2) * (a1 * K + a2 * K *K + a3 
		* Math.pow(K,3) + a4 * Math.pow(K,4) + a5 * Math.pow(K,5));
		

		if (X < 0.0) 
		{
			System.out.println(" x est negative");
		w= 1.0 - w;
		}
		System.out.println(" x est +");
		return w; 
	}

}
