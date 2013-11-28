/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch16;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
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
	private Button mTimeButton;
	
	
	public static final String EXTRA_CRIME_ID ="EXTRA_CRIME_ID";
	public static final String TAG_DIALOG_DATE = "FRAGMENT_PICK";
	public static final String TAG_DIALOG_TIME = "FRAGMENT_DATE_PICK";
	
	private static final String FORMAT_DATE = "yyyy-MM-dd";
	private static final String FORMAT_TIME = "HH:mm-ss";
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
	
	private static SimpleDateFormat timeFormat = new SimpleDateFormat(FORMAT_TIME);
	
	private static final int REQUEST_DATE = 0;
	private static final int REQUEST_TIME = 1;


	

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode!=Activity.RESULT_OK) return;
		if(requestCode==REQUEST_DATE)
		{
			Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
			mCrime.setDate(date);
			updateDate();
		}
		else if(requestCode==REQUEST_TIME)
		{
				Date date = (Date) data.getSerializableExtra(TimePickerFragment.EXTRA_TIME);
				mCrime.setDate(date);
				updateTime();
		}
			
	}

	
	
	
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
		
		
		
		
		
		setHasOptionsMenu(true);
		
		
	}
	
	@TargetApi(11)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//View v = inflater.inflate (R.layout.)
		View v = inflater. inflate(R.layout.ch16_fragment_crime,container,false);
		
		if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.HONEYCOMB)
		{
			if(NavUtils.getParentActivityIntent(getActivity())!=null)
			{
				getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			}
		}
		
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
		updateDate();
		
		//mDateButton.setEnabled(false);
		
		mDateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

			FragmentManager fm = getActivity().getSupportFragmentManager();
			DatePickerFragment dateFragment = DatePickerFragment.newInstance(mCrime.getDate());
			dateFragment.setTargetFragment(CrimeFragment.this, REQUEST_DATE);
			dateFragment.show(fm, TAG_DIALOG_DATE);
			
			}
		});
		
		mTimeButton = (Button) v.findViewById(R.id.crime_time);
		
		mTimeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			FragmentManager fm = getActivity().getSupportFragmentManager();
			
			TimePickerFragment timeDialog = TimePickerFragment.newInstace(mCrime.getDate());
			
			timeDialog.setTargetFragment(CrimeFragment.this, REQUEST_TIME);
			
			timeDialog.show(fm,TAG_DIALOG_TIME);
			
			
			
				
			}
		});
		
		updateTime();
		
		
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

	
	public void updateTime()
	{
		mTimeButton.setText(timeFormat.format(mCrime.getDate()));
	}

	public void updateDate()
	{
		mDateButton.setText(dateFormat.format (mCrime.getDate()));
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		switch (item.getItemId()) {
		case android.R.id.home:
				if(NavUtils.getParentActivityIntent(getActivity())!=null)
					NavUtils.navigateUpFromSameTask(getActivity());
				
			return true;
			
			
			
		default:
			return super.onOptionsItemSelected(item);
			
		}
		
		
	}
	

}
