package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.Generic;

@Local
public interface IGenericCrudServiceLocal {

	void create(Generic generic);

	void delete(Generic generic);

	void update(Generic generic);

	Generic readById(Integer id);

	List<Generic> readAll();
	
	Integer readLastId();
}
