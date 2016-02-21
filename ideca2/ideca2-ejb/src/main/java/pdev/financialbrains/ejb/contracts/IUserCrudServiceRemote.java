package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.Message;
import pdev.financialbrains.ejb.entities.User;

@Remote
public interface IUserCrudServiceRemote {
	User authentification(String login, String password);

	List<User> readAll(Integer id);

	List<User> read();
}