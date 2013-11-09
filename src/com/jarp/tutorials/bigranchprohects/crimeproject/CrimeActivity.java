/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.crimeproject;





import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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
public class CrimeActivity extends FragmentActivity {
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crime);
		
		FragmentManager fm = getSupportFragmentManager();
		
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		
		if(fragment==null)
		{
			fragment = new CrimeFragment();
			
			fm.beginTransaction()
			.add(R.id.fragmentContainer, fragment)
			.commit();
		}
		
		
	}


	
	
	
	
	

}
