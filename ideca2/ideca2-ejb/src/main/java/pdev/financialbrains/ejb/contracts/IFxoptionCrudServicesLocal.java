package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.ForeignExchangeOption;

@Local
public interface IFxoptionCrudServicesLocal {
	void create(ForeignExchangeOption fxoption);
	void update(ForeignExchangeOption fxoption);
	void delete(ForeignExchangeOption fxoption);
	ForeignExchangeOption read(Integer id);
	List<ForeignExchangeOption> readAll();
	Double Pricing(Integer callPut , Integer currentSpotPrice, Integer dRisk,Integer fRisk,Integer time,Float strikePrice,Float volatilite);
	 double N(double z);
}
