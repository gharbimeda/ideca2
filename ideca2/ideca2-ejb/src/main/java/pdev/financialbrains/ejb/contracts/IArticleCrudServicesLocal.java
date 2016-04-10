package pdev.financialbrains.ejb.contracts;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.Article;

@Local
public interface IArticleCrudServicesLocal {
	void create(Article article);

	void delete(Integer id);

	void update(Article article);

	Article read (Integer id);
	
	List<Article> read (Date date);
	
	List<Article> readAll();
}
