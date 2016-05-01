package pdev.financialbrains.ejb.services;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pdev.financialbrains.ejb.contracts.IMDBondCrudServiceLocal;
import pdev.financialbrains.ejb.entities.MdBond;
/*
 * Mariem
 */

@Stateless
@LocalBean


public class MDBondCrduServices  implements IMDBondCrudServiceLocal{
	@PersistenceContext(unitName="md")
	private EntityManager em;
	
	
	@Override
	public void add(MdBond mbond) {
java.util.Date date2 = new java.util.Date();
		
		java.sql.Date sqlDate1 = new java.sql.Date(date2.getTime());
		mbond.setDataB(sqlDate1);
		em.persist(mbond);
		
	}

	@Override
	public void remove(MdBond mbond) {
		em.remove(em.merge(mbond));
		
	}

	@Override
	public List<MdBond> readAll() {
		
		
		String jpql = "select b from MdBond b  ";
				
				Query query =em.createQuery(jpql);
				
				
				return query.getResultList();
	}

}
