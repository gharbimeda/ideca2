package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.User;

@Local
public interface IUserCrudServiceLocal {
	
	User authentification(String login, String password);

	List<User> readAll(Integer id);

	List<User> read();

}