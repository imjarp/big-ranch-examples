/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch10;





import java.util.UUID;

import android.support.v4.app.Fragment;

import com.jarp.tutorials.bigranchprohects.ch10.CrimeFragment;


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
		
		UUID uuid = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		return CrimeFragment.newInstance(uuid);
	}


	
	
	
	
	

}
