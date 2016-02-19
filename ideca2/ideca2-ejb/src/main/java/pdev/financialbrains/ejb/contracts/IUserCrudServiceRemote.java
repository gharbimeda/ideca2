package pdev.financialbrains.ejb.contracts;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.User;


@Remote
public interface IUserCrudServiceRemote {
	User authentification (String login , String password);
}