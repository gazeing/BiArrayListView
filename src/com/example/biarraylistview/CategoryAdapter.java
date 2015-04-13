package com.example.biarraylistview;


import java.util.List;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class CategoryAdapter extends Adapter<CategoryAdapter.CategoryViewHolder> {
	
	List<ArticleCategory> m_CategoryList;
	 private LayoutInflater mInflater;  
	 Context mContext;

	public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        public ArticleCategoryView mRecyclerView;
       
        
        public CategoryViewHolder(ArticleCategoryView v) {
            super(v);
            mRecyclerView = v;
           
        }
    }
	
	

	public CategoryAdapter(List<ArticleCategory> m_CategoryList,Context context) {
		super();
		this.m_CategoryList = m_CategoryList;
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getItemCount() {
		
		return m_CategoryList.size();
	}

	@Override
	public void onBindViewHolder(CategoryViewHolder holder, int position) {
		ArticleAdapter mAdapter = new ArticleAdapter(m_CategoryList.get(position).getArticle_list(),mContext);  
        
		RecyclerView r = (RecyclerView) holder.mRecyclerView.findViewById(R.id.horizontal_recycler_view);
		
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);  
      linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);  
      r.setLayoutManager(linearLayoutManager); 
	
		
		r.setAdapter(mAdapter);  
		
	}

	@Override
	public CategoryViewHolder onCreateViewHolder(ViewGroup parent,
            int viewType) {
		// create a new view
		ArticleCategoryView v = (ArticleCategoryView) mInflater.inflate(R.layout.category_list,parent, false);
        
		
 
//        
        
        // set the view's size, margins, paddings and layout parameters
       
        CategoryViewHolder vh = new CategoryViewHolder((ArticleCategoryView) v);
        return vh;
	}



}
