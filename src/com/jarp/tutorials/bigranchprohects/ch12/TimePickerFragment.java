/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch12;

import java.io.Serializable;
import java.util.Date;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.Time;

/**
 * @author JARP
 *
 */
public class TimePickerFragment extends DialogFragment {
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return super.onCreateDialog(savedInstanceState);
	}

	public static final String EXTRA_TIME="com.jarp.tutorials.bigranchprojects.ch12.time";
	
	public static TimePickerFragment newInstace(Time time)
	{
		
		TimePickerFragment mTimePickerFragment = new TimePickerFragment();
		
		Bundle args = new Bundle();
		
		args.putSerializable(EXTRA_TIME, (Serializable)time);
		
		mTimePickerFragment.setArguments(args);
		
		return mTimePickerFragment;
	}
	
	

}
