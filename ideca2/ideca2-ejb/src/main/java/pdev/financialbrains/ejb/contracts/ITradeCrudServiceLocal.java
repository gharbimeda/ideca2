package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.entities.User;

@Local
public interface ITradeCrudServiceLocal {

	void create(Trade trade);

	void delete(Trade trade);

	void update(Trade trade);

	Trade readById(Integer id);

	List<Trade> readAll();

	List<Trade> readCanApp();

	List<Trade> readPending();

	Integer readAccepted();
	
	Integer readRefused();
	
	void settle(Trade trade);
	
	void decline(Trade trade);

	List<Trade> readTradesByUser(User u);

}
