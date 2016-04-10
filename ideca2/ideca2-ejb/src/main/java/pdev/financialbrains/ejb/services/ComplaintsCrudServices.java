package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pdev.financialbrains.ejb.contracts.IComplaintsCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IComplaintsCrudServicesRemote;

import pdev.financialbrains.ejb.entities.Complaint;


@Stateless
public class ComplaintsCrudServices implements IComplaintsCrudServicesRemote, IComplaintsCrudServicesLocal{

	
	@PersistenceContext(unitName="data")
	private EntityManager entityManager;
    public ComplaintsCrudServices() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void send(Complaint complaint) {
		entityManager.persist(complaint);
	}
	@Override
	public void delete(Complaint complaint) {
		entityManager.remove(entityManager.merge(complaint));
		
	}
	@Override
	public void delete(int id) {
		entityManager.remove(entityManager.find(Complaint.class, id));
		
	}
	@Override
	public Complaint read(int id) {
		return entityManager.find(Complaint.class, id);
	}

	public List<Complaint> readAll() {
		return entityManager.createQuery("select m from Complaint m",Complaint.class).getResultList();

	}
	public Complaint findByIdUser(int id) {
		String jpql ="select c from Complaint c where user.idUser =:id " ;
				
				
		        Query query = entityManager.createQuery(jpql);
			
		        query.setParameter( "id", id );
		    return (Complaint) query.getSingleResult();
			}
	@Override
	public void update(Complaint complaint) {
		entityManager.merge(complaint);
		
	}
}
