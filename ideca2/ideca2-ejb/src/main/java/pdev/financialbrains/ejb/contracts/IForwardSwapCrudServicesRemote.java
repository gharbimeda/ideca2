package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.ForwardSwap;

@Remote
public interface IForwardSwapCrudServicesRemote {

	void create(ForwardSwap forwardSwap);

	void delete(ForwardSwap forwardSwap);

	void update(ForwardSwap forwardSwap);

	ForwardSwap readById(Integer id);

	List<ForwardSwap> readAll();
	
	Double priceForwardSwap(Float strikeRate, Float rate, Float notional, Float period, Float expiryTime, Float volatility);
}
