package pdev.financialbrains.ejb.services;

import java.io.IOException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import pdev.financialbrains.ejb.contracts.NewsServiceRemoteLocalRemote;
import pdev.financialbrains.ejb.entities.News;




/**
 * Session Bean implementation class NewsServiceRemoteLocal
 */
@Stateless
@LocalBean
public class NewsServiceRemoteLocal implements NewsServiceRemoteLocalRemote {


	@PersistenceContext(unitName="data")
	private EntityManager entityManger;
	public NewsServiceRemoteLocal() {
		// TODO Auto-generated constructor stub
	}
	
	public void create(News news){
		entityManger.persist(news);
	}
	
	public void delete(News news){
		entityManger.remove(entityManger.merge(news));
	}
	public List<News> DisplayAllNews(){
		return entityManger.createQuery("select c from News c  ",News.class).getResultList();
	}

	@Override
	public void news() throws IOException {
		Document doc=null;
		Elements news=null;
		
			doc = Jsoup.connect("http://www.bloomberg.com/").get();
			news=doc.getAllElements();
			for(int i=0 ; i<5;i++)
			{
				System.out.println(news.text());
			}

		
        	}
		
	
}
