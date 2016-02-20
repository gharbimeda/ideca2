package pdev.financialbrains.ejb.contracts;

import javax.ejb.Remote;

@Remote
public interface IEquityOptionCrudServicesRemote {
	
	public Double BlackScholes(String CallPutFlag, Double S, Double X, Double T, Double r, Double v);
	public Double CND(Double X);

}
