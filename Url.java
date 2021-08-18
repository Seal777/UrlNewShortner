package com.UrlShort.Url;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="URL")
@Table(name="URL")
public class Url {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private int id;
	@Column(name="SHORTURL")
	private String shortUrl;
	@Column(name="ORIGINALURL")
	private String originalUrl;
	@Column(name="COUNT")
	private int count;
	
	public Url()
	{
		
	}
	
	
	public Url(int id, String shortUrl, String originalUrl,int count) {
		super();
		this.id = id;
		this.shortUrl = shortUrl;
		this.originalUrl = originalUrl;
		this.count=0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
