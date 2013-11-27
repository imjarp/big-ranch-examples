/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch16;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.jarp.tutorials.bigranchprohects.R;

/**
 * @author JARP
 *
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

	
	protected abstract  Fragment createFragment();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ch16_activity_fragment);
		
		FragmentManager fm = getSupportFragmentManager();
		
		Fragment fragment = fm.findFragmentById(R.id.ch16_fragmentContainer);
		
		if(fragment==null)
		{
			fragment = createFragment();
		
			fm.beginTransaction()
			.add(R.id.ch16_fragmentContainer, fragment)
			.commit();
		}
	}

}
