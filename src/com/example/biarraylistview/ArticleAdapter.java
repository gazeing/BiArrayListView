package com.example.biarraylistview;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleAdapter extends Adapter<ArticleAdapter.ArticleViewHolder> {

   List<Article> m_ArticleList;
   private LayoutInflater mInflater;  
	
	public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImageView;
        public ArticleViewHolder(View v) {
            super(v);

        }
    }

	
	
	public ArticleAdapter(List<Article> m_ArticleList,Context context) {
		super();
		this.m_ArticleList = m_ArticleList;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getItemCount() {
		
		return m_ArticleList.size();
	}

	@Override
	public void onBindViewHolder(ArticleViewHolder holder, int position) {
		holder.mTextView.setText(m_ArticleList.get(position).getTitle());
		holder.mImageView.setBackgroundResource(R.drawable.item_background);
		
	}

	@Override
	public ArticleViewHolder onCreateViewHolder(ViewGroup parent,
            int viewType) {
		// create a new view
        View view = mInflater.inflate(R.layout.item_list, parent, false);

        // set the view's size, margins, paddings and layout parameters
       
        ArticleViewHolder vh = new ArticleViewHolder(view);
        
        vh.mTextView = (TextView) view.findViewById(R.id.itemTitle);
        vh.mImageView = (ImageView) view.findViewById(R.id.itemImage);
        return vh;
	}
}
