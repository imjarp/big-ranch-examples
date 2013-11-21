/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch12;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

import com.jarp.tutorials.bigranchprohects.R;

/**
 * @author JARP
 *
 */
public class DatePickerFragment extends DialogFragment {
	
	public static final String EXTRA_DATE="com.jarp.tutorials.bigranchprojects.ch12.date";
	
	private Date mDate;
	
	private Fragment fg ;
	
	private int requestCode;
	
	
	private void sendResult(int resultCode)
	{
		if(getTargetFragment()==null)
			return ;
		
		Intent i   = new Intent();
		
		i.putExtra(EXTRA_DATE, mDate);
		
		
		getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
		
	}
	
	
	public static DatePickerFragment newInstance(Date date)
	{
		Bundle args = new Bundle();
		
		args.putSerializable(EXTRA_DATE, date);
		
		DatePickerFragment fragment = new DatePickerFragment();
		
		fragment.setArguments(args);
		
		return fragment;
	
	}
	

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		
		mDate =  ((Date)getArguments().getSerializable(EXTRA_DATE));
		
		Calendar c = Calendar.getInstance();
		
		c.setTime(mDate);
		
		int year =c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH); ;
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		
		
		View v = getActivity().getLayoutInflater().inflate(R.layout.ch12_date_view,null);
		
		DatePicker datePicker = (DatePicker)v.findViewById(R.id.dialog_date_datePicker);
		
		
		datePicker.init(year, month, day,new OnDateChangedListener() {
			
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
			 mDate = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();
			
		 	getArguments().putSerializable(EXTRA_DATE, mDate);
				
			}
		});
	
		
		
		return new AlertDialog.Builder(getActivity())
		.setTitle(R.string.date_picker_title)
		//.setPositiveButton(android.R.string.ok, null)
		.setPositiveButton(android.R.string.ok, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				sendResult(Activity.RESULT_OK);
			}
		})
		.setView(v)
		.create();

	}

}
