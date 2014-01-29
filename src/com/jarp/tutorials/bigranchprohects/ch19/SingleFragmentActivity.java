/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch19;

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
		setContentView(R.layout.ch19_activity_fragment);
		
		FragmentManager fm = getSupportFragmentManager();
		
		Fragment fragment = fm.findFragmentById(R.id.ch19_fragmentContainer);
		
		if(fragment==null)
		{
			fragment = createFragment();
		
			fm.beginTransaction()
			.add(R.id.ch19_fragmentContainer, fragment)
			.commit();
		}
	}

}
