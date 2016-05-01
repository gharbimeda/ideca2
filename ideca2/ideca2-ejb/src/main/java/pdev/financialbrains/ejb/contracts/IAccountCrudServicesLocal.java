package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.entities.User;

@Local
public interface IAccountCrudServicesLocal {
	
	void create (User user) ;
	void create (Trader trader);
	void update(User user);
	void delete(User user );
	void deleteTrader(Trader trader );
	void delete(Integer id);
	User read(Integer IdUser);
	List<User> readAll() ;
	List<Trader> readAlll() ;
	 void updateTrader(Trader trader);
	
	Boolean activateAccount(Trader trader);
	Boolean desactivateAccount(Trader trader);

}
