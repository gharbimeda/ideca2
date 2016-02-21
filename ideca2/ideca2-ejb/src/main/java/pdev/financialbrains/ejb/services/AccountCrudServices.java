package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pdev.financialbrains.ejb.contracts.IAccountCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IAccountCrudServicesRemote;
import pdev.financialbrains.ejb.entities.User;

@Stateless
@LocalBean
public class AccountCrudServices implements IAccountCrudServicesRemote,IAccountCrudServicesLocal{

	@PersistenceContext(unitName="data")
	private EntityManager entityManger;
	
	public AccountCrudServices() {
	
	}
	
	@Override
	public void create(User user) {
		
		entityManger.persist(user);
		
	}

	@Override
	public void update(User user) {
		
		entityManger.merge(user);
	}

	@Override
	public void delete(User user) {
		entityManger.remove(entityManger.find(User.class, user.getIdUser()));
		
	}

	@Override
	public User read(Integer IdUser) {
		
		return entityManger.find(User.class, IdUser);
	}
	
	@Override
	public List<User> readAll() {
		return entityManger.createQuery("select c from User c  ",User.class).getResultList();
		

	}

	@Override
	public void delete(Integer id) {
		entityManger.remove(entityManger.find(User.class, id));
		
	}
}
