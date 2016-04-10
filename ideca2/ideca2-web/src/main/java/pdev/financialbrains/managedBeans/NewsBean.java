package pdev.financialbrains.managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.New;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pdev.financialbrains.ejb.contracts.NewsServiceRemoteLocalRemote;
import pdev.financialbrains.ejb.entities.News;
import pdev.financialbrains.ejb.services.NewsServiceRemoteLocal;


@ManagedBean
@ViewScoped
public class NewsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private News news = new News();
	private String url;
	private String contenu;
		private List<News> news3 = new ArrayList<News>();
@PostConstruct
public void init(){
	news3=service.DisplayAllNews();
}
	

	

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	@EJB
	private NewsServiceRemoteLocal service;
	private News news2 = new News();

	public List<News> addnews() {
		Document doc = null;
		Elements news = null;
		List<String> listUrls = new ArrayList<>();
		List<News> news2 = new ArrayList<News>();
		News temp = null;
		try {
			doc = Jsoup.connect("http://www.bloomberg.com/").get();
			news = doc.getElementsByClass("markets-bar-story");
			System.out.println(news.size());

			for (int i = 0; i < news.size(); i++) {
				temp = new News();

				temp.setContenu(news.get(i).text());
				temp.setUrl("http://www.bloomberg.com"
						+ news.get(i).attr("href"));
				news2.add(temp);
				// service.createNews(news3);
			}
			System.out.println(listUrls.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return news2;
	}

	public String addnews1() {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int mois = cal.get(Calendar.MONTH);

		int heure = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		String ch = heure + ":" + min + " " + day + "" + mois;
		news.setDate(ch);
		service.create(news);
		return "interfacebanquecentrale";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public List<News> displayallnews() {
		return news3 = service.DisplayAllNews();
	}

	public List<News> getNews3() {
		return news3;
	}

	public void setNews3(List<News> news3) {
		this.news3 = news3;
	}
	public List<News> addneweurope() {
		Document doc = null;
		Elements news = null;
		List<String> listUrls = new ArrayList<>();
		List<News> news2 = new ArrayList<News>();
		News temp = null;
		try {
			doc = Jsoup.connect("http://www.bloomberg.com/europe").get();
			news = doc.getElementsByClass("markets-bar-story");
			System.out.println(news.size());

			for (int i = 0; i < news.size(); i++) {
				temp = new News();

				temp.setContenu(news.get(i).text());
				temp.setUrl("http://www.bloomberg.com/europe"
						+ news.get(i).attr("href"));
				news2.add(temp);
				// service.createNews(news3);
			}
			System.out.println(listUrls.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return news2;
	}
	public List<News> addnewamerica() {
		Document doc = null;
		Elements news = null;
		List<String> listUrls = new ArrayList<>();
		List<News> news2 = new ArrayList<News>();
		News temp = null;
		try {
			doc = Jsoup.connect("http://www.bloomberg.com/").get();
			news = doc.getElementsByClass("markets-bar-story");
			System.out.println(news.size());

			for (int i = 0; i < news.size(); i++) {
				temp = new News();

				temp.setContenu(news.get(i).text());
				temp.setUrl("http://www.bloomberg.com/"
						+ news.get(i).attr("href"));
				news2.add(temp);
				// service.createNews(news3);
			}
			System.out.println(listUrls.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return news2;
	}
	
	public List<News> addnewsasia() {
		Document doc = null;
		Elements news = null;
		List<String> listUrls = new ArrayList<>();
		List<News> news2 = new ArrayList<News>();
		News temp = null;
		try {
			doc = Jsoup.connect("http://www.bloomberg.com/asia").get();
			news = doc.getElementsByClass("markets-bar-story");
			System.out.println(news.size());

			for (int i = 0; i < news.size(); i++) {
				temp = new News();

				temp.setContenu(news.get(i).text());
				temp.setUrl("http://www.bloomberg.com/asia"
						+ news.get(i).attr("href"));
				news2.add(temp);
				// service.createNews(news3);
			}
			System.out.println(listUrls.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return news2;
	}
	
	public List<News> addnewsWORLD() {
		Document doc = null;
		Elements news = null;
		List<String> listUrls = new ArrayList<>();
		List<News> news2 = new ArrayList<News>();
		News temp = null;
		try {
			doc = Jsoup.connect("http://www.bloomberg.com/news/world").get();
			news = doc.getElementsByClass("feed__items");
			System.out.println(news.size());

			for (int i = 0; i < news.size(); i++) {
				temp = new News();

				temp.setContenu(news.get(i).text());
				temp.setUrl("http://www.bloomberg.com/news/world"
						+ news.get(i).attr("href"));
				news2.add(temp);
				// service.createNews(news3);
			}
			System.out.println(listUrls.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return news2;
	}
	
	/*public List<News> addyahoo() {
		Document doc = null;
		Elements news = null;
		List<String> listUrls = new ArrayList<>();
		List<News> news2 = new ArrayList<News>();
		News temp = null;
		try {
			doc = Jsoup.connect("https://www.yahoo.com/news/").get();
			news = doc.getElementsByClass("StretchedBox");
			System.out.println(news.size());

			for (int i = 0; i < news.size(); i++) {
				temp = new News();

				temp.setContenu(news.get(i).text());
				temp.setUrl("https://www.yahoo.com/news/"
						+ news.get(i).attr("href"));
				news2.add(temp);
				// service.createNews(news3);
			}
			System.out.println(listUrls.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return news2;
	}*/
	public List<News> addGoogle() {
		Document doc = null;
		Elements news = null;
		List<String> listUrls = new ArrayList<>();
		List<News> news2 = new ArrayList<News>();
		News temp = null;
		try {
		//	doc = Jsoup.connect("https://news.google.fr/").get();
			doc = Jsoup.connect("https://www.google.com/finance/market_news").get();
			
			//news = doc.getElementsByClass("titletext");
			news = doc.getElementsByClass("name");

			System.out.println(news.size());

			for (int i = 0; i < news.size(); i++) {
				temp = new News();

				temp.setContenu(news.get(i).text());
			//	temp.setUrl("https://news.google.fr/"
					//	+ news.get(i).attr("href"));
				temp.setUrl("https://www.google.com/finance/market_news"
						+ news.get(i).attr("href"));
				news2.add(temp);
				// service.createNews(news3);
			}
			System.out.println(listUrls.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return news2;
}
/*public List<News>	yahoo() throws IOException{
	Document doc = null;
	Elements news = null;
	List<String> listUrls = new ArrayList<>();
	List<News> news2 = new ArrayList<News>();
	News temp = null;
	
		doc = Jsoup.connect("http://finance.yahoo.com/rss/topfinstories").get();
	for( Element item : doc.select("item") )
	{
	    final String title = item.select("title").first().text();
	    final String description = item.select("description").first().text();
	    final String link = item.select("link").first().nextSibling().toString();

	    temp.setContenu(description);
	    temp.setUrl(link);
	    temp.setTitle(title);
	    //System.out.println(title);
	    //System.out.println(description);
	   // System.out.println(link);
	   // System.out.println("");
	    news2.add(temp);
	}
	return news2;
}*/
}
