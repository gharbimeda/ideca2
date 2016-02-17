package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.Currency;

@Local
public interface ICurrencyCrudServicesLocal {

	void create(Currency currency);

	void delete(Currency currency);

	void update(Currency currency);

	Currency readById(Integer id);

	List<Currency> readBySymbol(String symbol);

	List<Currency> readAll();
}
