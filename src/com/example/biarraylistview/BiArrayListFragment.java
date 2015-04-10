package com.example.biarraylistview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BiArrayListFragment extends Fragment{
	
	   private RecyclerView mRecyclerView;
	   private RecyclerView.Adapter mAdapter;
	   private RecyclerView.LayoutManager mLayoutManager;
	
	public BiArrayListFragment(){
		
		
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_list, container,
				false);
		
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        
        String[] mydataset = {"1","2","3","4","5","6","7","8","1","2","3","4","5","6","7","8"};
        mAdapter = new MyAdapter(mydataset);
        mRecyclerView.setAdapter(mAdapter);
		
		return rootView;
	}

}
