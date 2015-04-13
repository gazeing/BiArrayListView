package com.example.biarraylistview;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BiArrayListFragment extends Fragment{
	
	   private RecyclerView mRecyclerView,mRecyclerView2,mRecyclerView3;
	   private RecyclerView.Adapter mAdapter;
	   private RecyclerView.LayoutManager mLayoutManager,mLayoutManager2,mLayoutManager3;
	
	public BiArrayListFragment(){
		
		
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_list, container,
				false);
		
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        mRecyclerView2 = (RecyclerView) rootView.findViewById(R.id.my_recycler_view2);
        mRecyclerView3 = (RecyclerView) rootView.findViewById(R.id.my_recycler_view3);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView2.setHasFixedSize(true);
//        mRecyclerView3.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);  
        
        mRecyclerView.setLayoutManager(mLayoutManager);
        
        mLayoutManager2 = new LinearLayoutManager(this.getActivity());
        ((LinearLayoutManager) mLayoutManager2).setOrientation(LinearLayoutManager.HORIZONTAL); 
        mRecyclerView2.setLayoutManager(mLayoutManager2);
        
        mLayoutManager3 = new LinearLayoutManager(this.getActivity());
        ((LinearLayoutManager) mLayoutManager3).setOrientation(LinearLayoutManager.HORIZONTAL); 
        mRecyclerView3.setLayoutManager(mLayoutManager3);
        
        // specify an adapter (see also next example)
        


        List<ArticleCategory> categoryList = new ArrayList<ArticleCategory>();
        List<Article> testlist = new ArrayList<Article>();
        for(int i =0;i<10;i++){
        	Article a = new Article(i+"", "", "title "+i, "", "", "", "");
        	testlist.add(a);
        }
        ArticleCategory cate = new ArticleCategory("1", "news", testlist);
        categoryList.add(cate);
        
        mAdapter = new ArticleAdapter(testlist,getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView2.setAdapter(mAdapter);
        mRecyclerView3.setAdapter(mAdapter);
		
		return rootView;
	}

}
