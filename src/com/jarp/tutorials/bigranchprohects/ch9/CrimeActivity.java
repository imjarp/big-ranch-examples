/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch9;





import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.jarp.tutorials.bigranchprohects.R;


/**
 * @author JARP
 *
 */
public class CrimeActivity extends SingleFragmentActivity {
	
	/*
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ch9_activity_fragment);
		
		FragmentManager fm = getSupportFragmentManager();
		
		Fragment fragment = fm.findFragmentById(R.id.ch9_fragmentContainer);
		
		if(fragment==null)
		{
			fragment = new CrimeFragment();
		
			fm.beginTransaction()
			.add(R.id.ch9_fragmentContainer, fragment)
			.commit();
		}
		
		
	}*/

	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return new CrimeFragment();
	}


	
	
	
	
	

}
