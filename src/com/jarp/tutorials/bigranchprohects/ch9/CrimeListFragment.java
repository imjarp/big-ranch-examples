/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch9;


import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jarp.tutorials.bigranchprohects.R;

/**
 * @author JARP
 *
 */
public class CrimeListFragment extends ListFragment {
	
	
	private static final String TAG = "CrimeListFragment";
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Crime c = (Crime) (getListAdapter()).getItem(position);
		Log.d(TAG, c.getmTitle() + "was clicked");
		
	}

	private ArrayList<Crime> mCrimes ;
	
	private ArrayAdapter<Crime> adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crime_titles);
		
		mCrimes = CrimeLab.get(getActivity()).getCrimes();
		 
		adapter = new ArrayAdapter<Crime>(getActivity(),android.R.layout.simple_list_item_1,mCrimes);  
		
		setListAdapter(adapter);
		
	}
	
	
	private class CrimeAdapter extends ArrayAdapter<Crime>
	{

		public CrimeAdapter(ArrayList<Crime> Crimes) {
			super(getActivity(),0,Crimes);
			// TODO Auto-generated constructor stub
		}
		
	}
	

}
