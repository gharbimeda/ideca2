package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.Message;

@Local
public interface IMessageCrudServicesLocal {

	void create(Message message);

	void delete(Message message);

	void update(Message message);

	public List<Message> readById(Integer idMessage);

	public void deleteById(Message message);

	List<Message> readAll();

	public Message findByIdUser(int id);
	
	List<Message> readByUserDestId(Integer id);
}
