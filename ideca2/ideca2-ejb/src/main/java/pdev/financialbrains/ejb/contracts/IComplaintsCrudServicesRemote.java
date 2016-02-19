package pdev.financialbrains.ejb.contracts;



import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.Complaint;

@Remote
public interface IComplaintsCrudServicesRemote {
	
	
	void send (Complaint complaint );

	void delete (Complaint complaint );
	void delete (int id);
	
	
	Complaint read(int id);
	List<Complaint> readAll();



}