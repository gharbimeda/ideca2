package pdev.financialbrains.ejb.contracts;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.Article;


@Remote
public interface IArticleCrudServicesRemote {
	
	void create(Article article);

	void delete(Integer id);

	void update(Article article);

	Article read (Integer id);
	
	List<Article> read (Date date);
	
	List<Article> readAll();

}
