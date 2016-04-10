package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.Complaint;
@Local
public interface IComplaintsCrudServicesLocal {

	
	void send (Complaint complaint );
	void delete (Complaint complaint );
	void delete (int id);
	Complaint read(int id);
	List<Complaint> readAll();
	void update(Complaint complaint);
	


}
