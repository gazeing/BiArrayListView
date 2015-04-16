package com.example.biarraylistview;

import java.util.List;

public class ArticleCategory {


	String category_id;
	String category_name;
	List<Article> article_list;
	
	
	public ArticleCategory(String category_id, String category_name,
			List<Article> article_list) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.article_list =article_list;
		
	}

	
	public int addArticle(Article a){
		article_list.add(a);
		return article_list.size();
	}

	public String getCategory_id() {
		return category_id;
	}


	public String getCategory_name() {
		return category_name;
	}


	public List<Article> getArticle_list() {
		return article_list;
	}
	
	
	
	
}
