/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch18;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.YuvImage;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TimePicker;

import com.jarp.tutorials.bigranchprohects.R;

/**
 * @author JARP
 *
 */
public class TimePickerFragment extends DialogFragment   implements TimePickerDialog.OnTimeSetListener {
	
	private Date mDate;
	
	public static final String EXTRA_TIME="com.jarp.tutorials.bigranchprojects.ch12.time";
	 
	
	public static TimePickerFragment newInstace(Date date)
	{
				
		TimePickerFragment mTimePickerFragment = new TimePickerFragment();
		
		Bundle args = new Bundle();
		
		args.putSerializable(EXTRA_TIME, date);
		
		mTimePickerFragment.setArguments(args);
		
		return mTimePickerFragment;
	}
	
	private void sendResult(int resultCode)
	{
		if(getTargetFragment()==null)
			return ;
		
		Intent i   = new Intent();
		
		i.putExtra(EXTRA_TIME, mDate);
		
		
		getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
		
	}
	
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		//return super.onCreateDialog(savedInstanceState);
		
		mDate =  ((Date)getArguments().getSerializable(EXTRA_TIME));
		
		Calendar c = Calendar.getInstance();
		
		c.setTime(mDate);
		
		int hour =c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE) ;
		int second = c.get(Calendar.SECOND);
		
		View v = getActivity().getLayoutInflater().inflate(R.layout.ch18_time_view,null);
		
		TimePicker mTimePicker = (TimePicker)v.findViewById(R.id.dialog_date_timePicker);

		mTimePicker.setCurrentHour(hour);
		mTimePicker.setCurrentMinute(minute);
		
		 return new TimePickerDialog(getActivity(), this, hour, minute,
	                DateFormat.is24HourFormat(getActivity()));
		
		
		
		/*return new AlertDialog.Builder(getActivity())
		.setTitle(R.string.time_picker_title)
		//.setPositiveButton(android.R.string.ok, null)
		.setPositiveButton(android.R.string.ok, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				sendResult(Activity.RESULT_OK);
			}
		})
		.setView(v)
		.create();*/
		
		
		
		
	}

	@Override
	public void onTimeSet(TimePicker arg0, int hourOfDay, int minute) {
		
		
		Calendar tempCalendar = Calendar.getInstance();
		tempCalendar.setTime(mDate);
		
		Calendar mCalendar = Calendar.getInstance();
		
		mCalendar.set(Calendar.YEAR, tempCalendar.get(Calendar.YEAR));
		
		mCalendar.set(Calendar.MONTH, tempCalendar.get(Calendar.MONTH));
		
		mCalendar.set(Calendar.DAY_OF_MONTH, tempCalendar.get(Calendar.DAY_OF_MONTH));
		
		mCalendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
		
		mCalendar.set(Calendar.MINUTE, minute);
		
		mCalendar.set(Calendar.SECOND, tempCalendar.get(Calendar.SECOND));
		
		mDate = mCalendar.getTime();
		
		sendResult(Activity.RESULT_OK);
		//getArguments().putSerializable(EXTRA_TIME, mDate);
		
	}
	
	
	
	
	
	
	

}
