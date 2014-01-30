/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch20;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author JARP
 *	
 */
public class CrimeCameraActivity extends SingleFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstance)
	{
		
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		super.onCreate(savedInstance);
	}
	
	/* (non-Javadoc)
	 * @see com.jarp.tutorials.bigranchprohects.ch19.SingleFragmentActivity#createFragment()
	 */
	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		
		return new CrimeCameraFragment();
	}

}
