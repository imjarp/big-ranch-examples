/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.crimeproject;

import com.jarp.tutorials.bigranchprohects.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * @author JARP
 *
 */
public class CrimeFragment extends Fragment {
	


	private Crime mCrime ;
	private EditText mTitleField;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		mCrime = new Crime();
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//View v = inflater.inflate (R.layout.)
		View v = inflater.inflate(R.layout.fragment_crime,container,false);
		mTitleField = (EditText)v.findViewById(R.id.crime_title);
		
		mTitleField.addTextChangedListener( new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mCrime.setmTitle(c.toString());
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		return v;
	}

	
	
	

}
