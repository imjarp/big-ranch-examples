/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch8;





import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

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
		setContentView(R.layout.ch8_activity_crime);
		
		FragmentManager fm = getSupportFragmentManager();
		
		Fragment fragment = fm.findFragmentById(R.id.ch8_fragmentContainer);
		
		if(fragment==null)
		{
			fragment = new CrimeFragment();
		
			fm.beginTransaction()
			.add(R.id.ch8_fragmentContainer, fragment)
			.commit();
		}
		
		
	}


	
	
	
	
	

}
