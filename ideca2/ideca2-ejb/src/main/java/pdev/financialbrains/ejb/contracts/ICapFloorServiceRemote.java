package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.CapFloor;

@Remote
public interface ICapFloorServiceRemote {

	void create(CapFloor capFloor);

	void update(CapFloor capFloor);

	void delete(CapFloor capFloor);

	CapFloor read(Integer id);

	List<CapFloor> readAll();

	Double CNDF(double x);

	Integer nDays(Integer tenor);

	double europeanOption(boolean operationType, boolean cF, float s, float k, double r, float q, float v, float t);

	double calculD1(Double cap_floor, float s, float rfr, Double maturity, Double volatility);
	
	double pricingCapFloor(Double amount,String cap_floor, Integer nDays, Integer period, Integer daysYear, Double f_rate, Double strike, Double vol, Double maturity, Double rfr);
	
	
}
