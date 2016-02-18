package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.Stock;

@Local
public interface IStockCrudServicesLocal {

	void create(Stock stock);

	void delete(Stock stock);

	void update(Stock stock);

	Stock readById(Integer id);

	List<Stock> readByCompanyName(String companyName);

	List<Stock> readAll();
}
