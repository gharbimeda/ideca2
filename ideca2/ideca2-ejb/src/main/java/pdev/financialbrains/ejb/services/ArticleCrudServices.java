package pdev.financialbrains.ejb.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pdev.financialbrains.ejb.contracts.IArticleCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IArticleCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Article;
import pdev.financialbrains.ejb.entities.Currency;

@Stateless
@LocalBean
public class ArticleCrudServices implements IArticleCrudServicesLocal, IArticleCrudServicesRemote {

	@PersistenceContext(unitName = "data")
	private EntityManager entityManager;

	public ArticleCrudServices() {

	}

	/**
	 * add new article
	 */
	@Override
	public void create(Article article) {
		entityManager.persist(article);

	}

	/**
	 * delete an article with finding it by id
	 */
	@Override
	public void delete(Integer id) {
		entityManager.remove(entityManager.find(Article.class, id));

	}

	/**
	 * update an article
	 */
	@Override
	public void update(Article article) {
		entityManager.merge(article);

	}

	@Override
	public Article read(Integer id) {
		return entityManager.find(Article.class, id);
	}

	@Override
	public List<Article> read(Date date) {

		Query query = entityManager.createQuery("SELECT a from article where date= :d",Article.class);
		query.setParameter("d", date);
		return query.getResultList();
	}

	/**
	 * recover all the article in the database
	 */
	@Override
	public List<Article> readAll() {

		return entityManager.createQuery("select a from Article a", Article.class).getResultList();
	}
	@Override
	public Boolean delete1(Article a) {
		try {
			entityManager.remove(entityManager.find(Article.class, a.getId()));
			return true;
		} catch (Exception e) {
			System.err.println("doesn't exist");
		}
		return false;
	}
}
