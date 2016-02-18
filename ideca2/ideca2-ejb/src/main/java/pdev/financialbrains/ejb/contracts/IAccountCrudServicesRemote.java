package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.User;

@Remote
public interface IAccountCrudServicesRemote {
	void create (User user) ;
	void update(User user);
	void delete(User user );
	User read(Integer IdUser);
	List<User> readAll() ;
}
