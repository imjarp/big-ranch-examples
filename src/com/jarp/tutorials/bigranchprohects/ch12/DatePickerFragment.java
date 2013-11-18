/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch12;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

import com.jarp.tutorials.bigranchprohects.R;

/**
 * @author JARP
 *
 */
public class DatePickerFragment extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		
		View v = getActivity().getLayoutInflater().inflate(R.layout.ch12_date_view,null);
		
		
		return new AlertDialog.Builder(getActivity())
		.setTitle(R.string.date_picker_title)
		.setPositiveButton(android.R.string.ok, null)
		.setView(v)
		.create();

	}

}
