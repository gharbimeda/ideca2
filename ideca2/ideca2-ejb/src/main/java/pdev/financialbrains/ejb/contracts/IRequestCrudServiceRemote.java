package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.Request;

@Remote
public interface IRequestCrudServiceRemote {

	void create(Request request);
	
	void update(Request request);
	
	void delete(Request request);
	
	List<Request> readAll ();
	
	Request read (Integer id);
}
