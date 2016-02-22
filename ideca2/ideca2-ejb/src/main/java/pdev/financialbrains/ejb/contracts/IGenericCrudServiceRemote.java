package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.Generic;

@Remote
public interface IGenericCrudServiceRemote {

	void create(Generic generic);
	
	void delete(Generic generic);
	
	void update(Generic generic);
	
	Generic readById(Integer id);
	
	List<Generic> readAll();
	
	Integer readLastId();
}
