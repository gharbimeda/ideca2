package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.Trade;

@Remote
public interface ITradeCrudServiceRemote {

	void create(Trade trade);

	void delete(Trade trade);

	void update(Trade trade);

	Trade readById(Integer id);

	List<Trade> readAll();

	List<Trade> readCanApp();

	List<Trade> readPending();

	Integer readAccepted();

	Integer readRefused();
}
