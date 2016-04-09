package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pdev.financialbrains.ejb.contracts.IUserCrudServiceLocal;
import pdev.financialbrains.ejb.contracts.IUserCrudServiceRemote;
import pdev.financialbrains.ejb.entities.User;

@Stateless
@LocalBean
public class UserCrudServices implements IUserCrudServiceLocal, IUserCrudServiceRemote {

	@PersistenceContext(unitName = "data")

	private EntityManager entityManager;

	public UserCrudServices() {
		super();
	}

	@Override
	public User authentification(String login, String password) {
		User user = null;
		Query query = entityManager.createQuery("select u from User u where u.login=:l and u.password=:p");
		query.setParameter("l", login).setParameter("p", password);
		try {
			user = (User) query.getSingleResult();
			return user;
		} catch (Exception exception) {
			return null;
		}
	}

	@Override
	public List<User> readAll(Integer id) {
		String jpql = "select u from User u where u.IdUser != :idMessage";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("idMessage", id);
		return query.getResultList();

	}

	@Override
	public List<User> read() {
		return entityManager.createQuery("select u from User u", User.class).getResultList();

	}

	public User readOneUser(Integer id) {
		Query query = entityManager.createQuery("select u from User u where id= :id", User.class);
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}

	@Override
	public List<User> readAllButOne(Integer id) {
		Query query = entityManager.createQuery("select u from User u where u.IdUser!=:id", User.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public User readById(Integer id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public User readByLogin(String login) {
		Query query = entityManager.createQuery("select u from User u where u.login =:login");
		query.setParameter("login", login);
		return (User) query.getSingleResult();
	}

}
