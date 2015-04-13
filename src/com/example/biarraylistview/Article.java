package com.example.biarraylistview;

public class Article {

	
	String article_id;
	String link;
	String title;
	String author;
	String date;
	String image_link;
	String introtext;
	
	
	
	
	public Article(String article_id, String link, String title, String author,
			String date, String image_link, String introtext) {
		super();
		this.article_id = article_id;
		this.link = link;
		this.title = title;
		this.author = author;
		this.date = date;
		this.image_link = image_link;
		this.introtext = introtext;
	}
	
	public String getArticle_id() {
		return article_id;
	}
	public String getLink() {
		return link;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getDate() {
		return date;
	}
	public String getImage_link() {
		return image_link;
	}
	public String getIntrotext() {
		return introtext;
	}
	
	
}
