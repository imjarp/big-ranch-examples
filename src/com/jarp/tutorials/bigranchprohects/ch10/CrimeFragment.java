/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch10;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

import com.jarp.tutorials.bigranchprohects.R;

/**
 * @author JARP
 *
 */
public class CrimeFragment extends Fragment {
	


	private Crime mCrime;
	private CheckBox mSolvedCheckbox;
	private Button mDateButton;
	private EditText mTitleField;
	
	public static final String EXTRA_CRIME_ID ="EXTRA_CRIME_ID";
	
	public static CrimeFragment newInstance (UUID uuid)
	{
		Bundle args = new Bundle();
		
		args.putSerializable(EXTRA_CRIME_ID, uuid);
		
		CrimeFragment fragment = new CrimeFragment();
		
		fragment.setArguments(args);
		
		return fragment;
		
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		UUID uuid = (UUID) getArguments().getSerializable(EXTRA_CRIME_ID);
		
		mCrime = CrimeLab.get(getActivity()).getCrime(uuid);
		
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//View v = inflater.inflate (R.layout.)
		View v = inflater. inflate(R.layout.ch10_fragment_crime,container,false);
		mTitleField = (EditText)v.findViewById(R.id.crime_title);
		
		mTitleField.setText(mCrime.getmTitle());
		
		
		
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
		
		mDateButton = (Button) v.findViewById(R.id.crime_date);
		
		
		
		mDateButton.setText(mCrime.getDate().toString());
		
		mDateButton.setEnabled(false);
		
		mSolvedCheckbox  = (CheckBox)v.findViewById(R.id.crime_solved);
		
		mSolvedCheckbox.setChecked(mCrime.isSolved());
		
		mSolvedCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				// TODO Auto-generated method stub
				mCrime.setSolved(isChecked);
			}
		});

		
		return v;
	}


	public void returnResult()
	{
		//getActivity().setResult(resultCode, data)
	}
	
	

}
