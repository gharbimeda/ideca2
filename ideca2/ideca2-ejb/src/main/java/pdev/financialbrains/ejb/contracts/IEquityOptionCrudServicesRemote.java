package pdev.financialbrains.ejb.contracts;

import javax.ejb.Remote;

@Remote
public interface IEquityOptionCrudServicesRemote {
	
	public double BlackScholes(char CallPutFlag, double S, double X, double T, double r, double v);
	public double CND(double X);

}
