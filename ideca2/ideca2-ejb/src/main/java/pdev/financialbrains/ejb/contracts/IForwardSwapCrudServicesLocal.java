package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.ForwardSwap;

@Local
public interface IForwardSwapCrudServicesLocal {

	void create(ForwardSwap forwardSwap);

	void delete(ForwardSwap forwardSwap);

	void update(ForwardSwap forwardSwap);

	ForwardSwap readById(Integer id);

	List<ForwardSwap> readAll();
	
	Double priceForwardSwap(Float strikeRate, Float rate, Float notional, Float period, Float expiryTime, Float volatility);
}
