package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.User;

@Local
public interface IUserCrudServiceLocal {
	
<<<<<<< HEAD
	User authentification(String login, String password);

	List<User> readAll(Integer id);

	List<User> read();
=======
	List<User> readAllButOne(Integer id);
	
	User readById(Integer id);
>>>>>>> refs/remotes/origin/master

	List<User> readAll(Integer id);
	
	User readByLogin(String login);
}