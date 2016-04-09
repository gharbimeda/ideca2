package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.User;

@Local
public interface IUserCrudServiceLocal {
	
	List<User> readAllButOne(Integer id);
	
	User readById(Integer id);

	List<User> readAll(Integer id);
	
	User readByLogin(String login);
}