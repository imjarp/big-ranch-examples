/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch12;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
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
		.setPositiveButton(android.R.string.ok, null)
		.setView(v)
		.create();

	}

}
