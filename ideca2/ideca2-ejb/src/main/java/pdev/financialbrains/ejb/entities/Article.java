package pdev.financialbrains.ejb.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import javax.resource.spi.AuthenticationMechanism;

/**
 * Entity implementation class for Entity: Article
 *
 */
@Entity
@Table(name="t_article")

public class Article implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String author;
	private String text;
	private Date date;
	private String url;
	private static final long serialVersionUID = 1L;

	public Article() {
	
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", text=" + text + ", date=" + date
				+ ", url=" + url + "]";
	}

   
}
