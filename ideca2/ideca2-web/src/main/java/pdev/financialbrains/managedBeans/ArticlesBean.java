package pdev.financialbrains.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.IArticleCrudServicesLocal;
import pdev.financialbrains.ejb.entities.Article;

@ManagedBean(name = "articleBean")
@ViewScoped
public class ArticlesBean {
	@EJB
	private IArticleCrudServicesLocal articleCrudServicesLocal;
	private List<Article> articles=new ArrayList<Article>();
	private Article article;
	private boolean  showform ;
	
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	@PostConstruct
	public void init(){
		articles=articleCrudServicesLocal.readAll();
		article =new Article();
		
	}
	public void showAll(){
		articleCrudServicesLocal.readAll();
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public String doAdd() {
			articleCrudServicesLocal.update(article);
			return "articleManagement?faces-redirect=true";

		}
	public String doUpdate(){
		articleCrudServicesLocal.update(article);
		return null;
	}
	public String doDelete(Article a){
		articleCrudServicesLocal.delete1(a);
		init();
		return null;
	}
	
	
	public String doShowForm(){
		setShowform(true);
		return null;
	}
	public boolean isShowform() {
		return showform;
	}
	public void setShowform(boolean showform) {
		this.showform = showform;
	}
}
