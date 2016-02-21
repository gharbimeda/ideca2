package pdev.financialbrains.client.delegate;

import java.util.Date;
import java.util.List;

import pdev.financialbrains.client.locator.ServiceLocator;
import pdev.financialbrains.ejb.contracts.IArticleCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Article;


public class ArticleManagementDelegate {

	private static IArticleCrudServicesRemote remote;
	private static final String jndi="/ideca2-ejb/ArticleCrudServices!pdev.financialbrains.ejb.contracts.IArticleCrudServicesRemote";
	
	
	private static IArticleCrudServicesRemote getProxy(){
		return (IArticleCrudServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public static void doCreate(Article article){
		getProxy().create(article);
	}

	public static void doDelete(Article article){
		getProxy().delete(article.getId());
	}

	public static void doUpdate(Article article){
		getProxy().update(article);
	}

	public static Article doRead (Integer id){
		return getProxy().read(id);
	}
	
	public static List<Article> doRead (Date date){
		return getProxy().read(date);
	}
	
	public static List<Article> doReadAll(){
		return getProxy().readAll();
	}
	
}
