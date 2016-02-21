package pdev.financialbrains.client.boot;

import pdev.financialbrains.client.delegate.ArticleManagementDelegate;
import pdev.financialbrains.ejb.entities.Article;

public class TestArticle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Article article = new Article();
		//article.setId(1);
		article.setText("122");
		article.setTitle("xxxx");
		article.setAuthor("yyyy");
		
		//ArticleManagementDelegate.doCreate(article);
//System.out.println(ArticleManagementDelegate.doReadAll().toString());
ArticleManagementDelegate.doReadAll().stream().forEach(e->System.out.println(e.toString()));
	}

}
