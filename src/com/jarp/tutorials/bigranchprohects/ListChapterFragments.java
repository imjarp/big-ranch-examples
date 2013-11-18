/**
 * 
 */
package com.jarp.tutorials.bigranchprohects;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author JARP
 *
 */
public class ListChapterFragments extends ListFragment {

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		//super.onListItemClick(l, v, position, id);
		Intent i  = null;
		
		
		switch (position) {
		case 0:
			//Chapter 7 
			i = new Intent(getActivity(), com.jarp.tutorials.bigranchprohects.crimeproject.CrimeActivity.class);
			
			break;
			
		case 1:
			//Chapter 8 
			i = new Intent(getActivity(), com.jarp.tutorials.bigranchprohects.ch8.CrimeActivity.class);
			break;
		case 2:
			//Chapter 9
			i = new Intent(getActivity(), com.jarp.tutorials.bigranchprohects.ch9.CrimeListActivity.class);
			break;
			
		case 3:
			//Chapter 10
			i = new Intent(getActivity(), com.jarp.tutorials.bigranchprohects.ch10.CrimeListActivity.class);
			break;
			
		case 4:

			//Chapter 11
			i = new Intent(getActivity(), com.jarp.tutorials.bigranchprohects.ch11.CrimeListActivity.class);
			break;
			
		case 5:
			//Chapter 12
			i = new Intent(getActivity(), com.jarp.tutorials.bigranchprohects.ch12.CrimeListActivity.class);
			break;

		default:
			break;
		}
		
		if(i!=null)
			startActivity(i);
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		getActivity().setTitle("Examples by Chapter");
		
		
		
		String[] objects = new String []{"Chapter 7 ", "Chapter 8 ", "Chapter 9", "Chapter 10 ", "Chapter 11","Chapter 12"} ;
		
		ArrayAdapter<String> chapterAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simple_list_item_1, objects);
		
		setListAdapter(chapterAdapter);
		
	}

	

}

