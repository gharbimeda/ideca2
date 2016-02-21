package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pdev.financialbrains.ejb.contracts.IMessageCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IMessageCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Message;
import pdev.financialbrains.ejb.entities.Stock;

/**
 * Session Bean implementation class MessageCrudServices
 */
@Stateless
@LocalBean
public class MessageCrudServices implements IMessageCrudServicesLocal, IMessageCrudServicesRemote {

	/**
	 * Default constructor.
	 */

	@PersistenceContext(unitName = "data")
	private EntityManager entityManager;

	public MessageCrudServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Message message) {
		entityManager.persist(message);

	}@Override
	public void deleteById(Message message) {
		entityManager.remove(entityManager.find(Message.class, message.getId()));
		
	}

	@Override
	public void delete(Message message) {
		entityManager.remove(entityManager.find(Message.class, message.getId()));

	}

	@Override
	public void update(Message message) {
		entityManager.merge(message);

	}

	@Override
	public List<Message> readById(Integer idMessage) {
		// return entityManager.find(Message.class, idMessage);
		// return entityManager.createQuery("select m from Message m where
		// m.userDest=:idMessage",Message.class).getResultList();
		String jpql = "select m from Message m where m.userSource.id=:idMessage";
		Query query = entityManager.createQuery(jpql, Message.class);
		query.setParameter("idMessage",idMessage);
		return 
				query.getResultList();

	}

	@Override
	public List<Message> readAll() {
		return entityManager.createQuery("select m from Message m", Message.class).getResultList();

	}

	@Override
	public Message findByIdUser(int id) {
		String jpql = "select c from Message c where user.idUser =:id ";

		Query query = entityManager.createQuery(jpql);

		query.setParameter("id", id);
		return (Message) query.getSingleResult();
	}

}
