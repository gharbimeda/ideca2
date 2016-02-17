package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.Stock;

@Remote
public interface IStockCrudServicesRemote {

	void create(Stock stock);

	void delete(Stock stock);

	void update(Stock stock);

	Stock readById(Integer id);

	List<Stock> readByCompanyName(String companyName);

	List<Stock> readAll();
}
