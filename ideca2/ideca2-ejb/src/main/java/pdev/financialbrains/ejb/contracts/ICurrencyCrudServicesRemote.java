package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.Currency;

@Remote
public interface ICurrencyCrudServicesRemote {

	void create(Currency currency);

	void delete(Currency currency);

	void update(Currency currency);

	Currency readById(Integer id);

	List<Currency> readBySymbol(String symbol);

	List<Currency> readAll();
}
