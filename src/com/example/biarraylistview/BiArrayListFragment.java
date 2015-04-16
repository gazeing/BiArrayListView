package com.example.biarraylistview;


import java.util.ArrayList;
import java.util.List;

import com.example.biarraylistview.ArticleAdapter.OnItemClickLitener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class BiArrayListFragment extends Fragment{
	

	
	public BiArrayListFragment(){
		
		
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_list, container,
				false);
		LinearLayout rootLayout = (LinearLayout) rootView.findViewById(R.id.root_layout);
		
		 List<ArticleCategory> categoryList = getData();
		

		
		for(int i=0;i<categoryList.size();i++){
			View layout = inflater.inflate(R.layout.item_category, container, false);
			RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.recycler_view);
			recyclerView.setHasFixedSize(true);
			LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
			((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);  
		        
			 recyclerView.setLayoutManager(layoutManager);
			 
			 RecyclerView.Adapter adapter = new ArticleAdapter(categoryList.get(i).getArticle_list(),getActivity(),categoryList.get(i).getCategory_name());
		        ((ArticleAdapter) adapter).setOnItemClickLitener(new OnItemClickLitener()  
		        {  
		            @Override  
		            public void onItemClick(View view, int position,String name)  
		            {  
		                Toast.makeText(getActivity(), name+": "+position+"", Toast.LENGTH_SHORT)  
		                        .show();  
		            }  
		        }); 
		     recyclerView.setAdapter(adapter);
		     
		     TextView title = (TextView) layout.findViewById(R.id.categoryTitle);
		     title.setText(categoryList.get(i).getCategory_name());
		     rootLayout.addView(layout);
		}
		
		
		
		

		
		return rootView;
	}


	private List<ArticleCategory> getData() {
        List<ArticleCategory> categoryList = new ArrayList<ArticleCategory>();
        List<Article> testlist = new ArrayList<Article>();
        for(int i =0;i<10;i++){
        	Article a = new Article(i+"", "", "title "+i, "", "", "", "");
        	testlist.add(a);
        }
        ArticleCategory cate = new ArticleCategory("1", "news", testlist);
        ArticleCategory cate2 = new ArticleCategory("2", "features", testlist);
        ArticleCategory cate3 = new ArticleCategory("3", "video", testlist);
        
        categoryList.add(cate);
        categoryList.add(cate2);
        categoryList.add(cate3);
        
		return categoryList;
	}

}
