/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch16;


import java.util.ArrayList;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.jarp.tutorials.bigranchprohects.R;

/**
 * @author JARP
 *
 */
public class CrimeListFragment extends ListFragment {
	
	
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

	
			if(requestCode == REQUEST_CRIME)
			{
				
			}
	}

	private static final int REQUEST_CRIME = 1;
	
	
	@Override
	public void onResume() {

		super.onResume();
		
		((CrimeAdapter) getListAdapter()).notifyDataSetChanged();
	}

	private static final String TAG = "CrimeListFragment";
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		
		
		//Crime c = (Crime) (getListAdapter()).getItem(position);
		
		Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);
		/*
		 * CH 10
		 * */
		//Intent i = new Intent(getActivity(), CrimeActivity.class);
		//i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getmId());
		//startActivity(i);
		
		Intent i = new Intent(getActivity(), CrimePagerActivity.class);
		i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getmId());
		
		startActivity(i);
				
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
		 
		//adapter = new ArrayAdapter<Crime>(getActivity(),android.R.layout.simple_list_item_1,mCrimes);
		
		adapter = new CrimeAdapter(mCrimes);
		
		
		setListAdapter(adapter);
		
		setHasOptionsMenu(true);
		
	}
	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(com.jarp.tutorials.bigranchprohects.R.menu.fragment_crime_list, menu);
	}
	
	@TargetApi(11)
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		
		switch (item.getItemId()) 
		{
			case R.id.menu_item_new_crime:
				Crime c = new Crime();
				CrimeLab.get(getActivity()).addCrime(c);
				Intent i = new Intent(getActivity(),CrimePagerActivity.class);
				i.putExtra(CrimeFragment.EXTRA_CRIME_ID,c.getmId());
				startActivityForResult(i,0);
				return true;
				
			case R.id.menu_item_show_subtitle:
				if(getActivity().getActionBar().getSubtitle()==null)
				{
					getActivity().getActionBar().setSubtitle(R.string.show_subtitle);
					item.setTitle(R.string.hide_subtitle);
				}
				else
				{
					getActivity().getActionBar().setSubtitle(null);
					item.setTitle(R.string.show_subtitle);
				}
					
				
				
				return true;

			default:
				return super.onOptionsItemSelected(item);
				
		}
		
	}
	
	
	private class CrimeAdapter extends ArrayAdapter<Crime>
	{

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			if(convertView ==null)
			{
				convertView = getActivity().getLayoutInflater().inflate(R.layout.ch12_list_item_crime , null);
			}
			
			
			Crime c = getItem(position);
			
			
			TextView titleTextView = (TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
			
			titleTextView.setText(c.getmTitle());
			
			
			TextView dateTextView = (TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
			
			dateTextView.setText(c.getDate().toString());
			
			CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
			
			solvedCheckBox.setChecked(c.isSolved());
			
			return convertView;
			
			
		}

		public CrimeAdapter(ArrayList<Crime> Crimes) {
			super(getActivity(),0,Crimes);
			// TODO Auto-generated constructor stub
		}
		
	}
	
		

}
