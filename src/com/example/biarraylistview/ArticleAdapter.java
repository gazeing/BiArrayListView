package com.example.biarraylistview;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleAdapter extends Adapter<ArticleAdapter.ArticleViewHolder> {
	
	
	 /** 
     * ItemClick call back 
     * @author steve 
     * 
     */  
    public interface OnItemClickLitener  
    {  
        void onItemClick(View view, int position,String categoryName);  
    }  
  
    private OnItemClickLitener mOnItemClickLitener;  
  
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)  
    {  
        this.mOnItemClickLitener = mOnItemClickLitener;  
    }  
	

   List<Article> m_ArticleList;
   private LayoutInflater mInflater; 
   String mcategoryName;
	
	public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImageView;
        public ArticleViewHolder(View v) {
            super(v);

        }
    }

	
	
	public ArticleAdapter(List<Article> m_ArticleList,Context context,String categoryName) {
		super();
		this.m_ArticleList = m_ArticleList;
		mInflater = LayoutInflater.from(context);
		this.mcategoryName = categoryName;
	}

	@Override
	public int getItemCount() {
		
		return m_ArticleList.size();
	}

	@Override
	public void onBindViewHolder(final ArticleViewHolder holder, final int position) {
		holder.mTextView.setText(m_ArticleList.get(position).getTitle());
		holder.mImageView.setBackgroundResource(R.drawable.item_background);
		
	       if (mOnItemClickLitener != null)  
	        {  
	    	   holder.itemView.setOnClickListener(new OnClickListener()  
	            {  
	                @Override  
	                public void onClick(View v)  
	                {  
	                    mOnItemClickLitener.onItemClick(holder.itemView, position,mcategoryName);  
	                }  
	            });  
	  
	        }  
		
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
