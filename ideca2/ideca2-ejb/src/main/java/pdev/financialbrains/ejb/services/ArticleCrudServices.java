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

@Stateless
@LocalBean
public class ArticleCrudServices implements IArticleCrudServicesLocal, IArticleCrudServicesRemote {

	@PersistenceContext(unitName="data")
	private EntityManager entityManager;

	public ArticleCrudServices() {

	}

	@Override
	public void create(Article article) {
		entityManager.persist(article);

	}

	@Override
	public void delete(Article article) {
		entityManager.remove(article);

	}

	@Override
	public void update(Article article) {
		entityManager.merge(article);

	}

	@Override
	public Article read(Integer id) {
		return entityManager.find(Article.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Article> read(Date date) {
		
		Query query = entityManager.createQuery("SELECT a from t_article where date= :d");
		query.setParameter("d", date);
		return query.getResultList();
	}

}
