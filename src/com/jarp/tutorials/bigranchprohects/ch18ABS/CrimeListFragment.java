/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch18ABS;


import java.util.ArrayList;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.jarp.tutorials.bigranchprohects.R;

/**
 * @author JARP
 *
 */
public class CrimeListFragment extends SherlockListFragment  {

	
	private boolean mSubtTitleVisible;
	private static final int REQUEST_CRIME = 1;
	private static final String TAG = "CrimeListFragment";
	private ArrayList<Crime> mCrimes ;
	private ArrayAdapter<Crime> adapter;
	
	
	
	

	@TargetApi(11)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		 
		View v =   inflater.inflate(R.layout.ch18_crime_list_fragment,null,false);
		
		ListView l = (ListView) v.findViewById(android.R.id.list);
		
		
		
		if(CrimeLab.get(getActivity()).getCrimes().size()==0)
		{
			View emptyView = v.findViewById(android.R.id.empty);
			l.setEmptyView(emptyView);
		}
		
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
		{
			if(mSubtTitleVisible)
			{
				getActivity().getActionBar().setSubtitle(R.string.show_subtitle);
			}
		
		}
		if(Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB)
		{
			registerForContextMenu(l);
		}
		else
		{
			l.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
			l.setMultiChoiceModeListener(new MultiChoiceModeListener() {
				
				public void onItemCheckedStateChanged(ActionMode mode, int position,
						long id, boolean checked) {
					// TODO Auto-generated method stub
					
				}
				
				public boolean onCreateActionMode(ActionMode mode, Menu menu) {
				
					MenuInflater inflater = mode.getMenuInflater();
					inflater.inflate(R.menu.crime_list_item_context,menu);
					
					return true;
				}
				
				public boolean onPrepareActionMode(ActionMode arg0, Menu arg1) {
					// TODO Auto-generated method stub
					return false;
				}
				
				
				public void onDestroyActionMode(ActionMode arg0) {
					// TODO Auto-generated method stub
					
				}
				
				
				public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
					switch (item.getItemId()) {
					case R.id.menu_item_delete_crime:
						CrimeAdapter adapter = (CrimeAdapter)getListAdapter();
						CrimeLab crimeLab = CrimeLab.get(getActivity());
						for (int i = adapter.getCount()-1; i>=0; i--) {
							
							if(getListView().isItemChecked(i))
							{
								crimeLab.deleteCrime(adapter.getItem(i));
							}
						}
						
						mode.finish();
						adapter.notifyDataSetChanged();
						return true;
						
					default:
						break;
					}

					return false;
				}
				
				
			});
		}
		
		return v;
	}

	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
	{
		getActivity().getMenuInflater().inflate(R.menu.crime_list_item_context, menu);	
	}
	
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		AdapterContextMenuInfo info = (AdapterContextMenuInfo)item.getMenuInfo();
		int position = info.position;
		
		CrimeAdapter adapter = (CrimeAdapter) getListAdapter();
		
		Crime crime = adapter.getItem(position);
		
		switch (item.getItemId()) {
		case R.id.menu_item_delete_crime:
			CrimeLab.get(getActivity()).deleteCrime(crime);
			adapter.notifyDataSetChanged();
			return true;
		default:
			break;
		}
		
		return super.onContextItemSelected(item);
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

	
			if(requestCode == REQUEST_CRIME)
			{
				
			}
	}

	
	
	
	@Override
	public void onResume() {

		super.onResume();
		
		((CrimeAdapter) getListAdapter()).notifyDataSetChanged();
	}

	
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		
		Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);

		Intent i = new Intent(getActivity(), CrimePagerActivity.class);
		i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getmId());
		
		startActivity(i);
				
		Log.d(TAG, c.getmTitle() + "was clicked");
		
	}

	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crime_titles);
		
		mCrimes = CrimeLab.get(getActivity()).getCrimes();
		 
		
		adapter = new CrimeAdapter(mCrimes);
		
				
		mSubtTitleVisible = false;
		
		setRetainInstance(true);
		
		setListAdapter(adapter);
		
		
		setHasOptionsMenu(true);
		
	}
	
	
	@Override
	public void onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu, com.actionbarsherlock.view.MenuInflater inflater) {
		
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(com.jarp.tutorials.bigranchprohects.R.menu.fragment_crime_list, menu);
		
		com.actionbarsherlock.view.MenuItem showSubtitle = menu.findItem(R.id.menu_item_show_subtitle);
		
		if(showSubtitle!=null && mSubtTitleVisible)
			showSubtitle.setTitle(R.string.hide_subtitle);
	}
	
	@TargetApi(11)
	@Override
	public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
			
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
				if(getSherlockActivity().getActionBar().getSubtitle()==null)
				{
					//getActivity().getActionBar().setSubtitle(R.string.show_subtitle);
					getSherlockActivity().getActionBar().setSubtitle(R.string.show_subtitle);
					mSubtTitleVisible = true;
					item.setTitle(R.string.hide_subtitle);
				}
				else
				{
					getSherlockActivity().getActionBar().setSubtitle(null);
					mSubtTitleVisible = false;
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
				convertView = getActivity().getLayoutInflater().inflate(R.layout.ch18_list_item_crime , null);
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
			//super(getActivity(),0,Crimes);
            super(getActivity(), android.R.layout.simple_list_item_1, Crimes);
			// TODO Auto-generated constructor stub
		}
		
	}
	
		

}
