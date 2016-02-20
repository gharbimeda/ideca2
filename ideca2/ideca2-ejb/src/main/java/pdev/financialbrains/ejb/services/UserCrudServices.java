package pdev.financialbrains.ejb.services;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pdev.financialbrains.ejb.contracts.IUserCrudServiceLocal;
import pdev.financialbrains.ejb.contracts.IUserCrudServiceRemote;
import pdev.financialbrains.ejb.entities.User;
@Stateful
public class UserCrudServices  implements IUserCrudServiceLocal, IUserCrudServiceRemote{
	
	
	@PersistenceContext(unitName="data")

	private EntityManager entityManager;
	
	

	public UserCrudServices() {
		super();
	}



	@Override
	public User authentification(String login, String password) {
		User user = null;
		Query query = entityManager
				.createQuery("select u from User u where u.login=:l and u.password=:p");
		query.setParameter("l",login).setParameter("p",password);
		try {
			user= (User) query.getSingleResult();
			return user;
		} catch (Exception exception) {
			return null;
		}}


}
