package pdev.financialbrains.ejb.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pdev.financialbrains.ejb.entities.DerivativeInstrument;

@Stateless
@LocalBean
public class derivativesCrudService {

	@PersistenceContext(unitName="data")
	private EntityManager em;
	
	public void createDervivativesInstrument(DerivativeInstrument d){
		em.persist(d);
	}
}
