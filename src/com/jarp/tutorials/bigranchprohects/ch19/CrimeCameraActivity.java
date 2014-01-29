/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch19;

import android.support.v4.app.Fragment;

/**
 * @author JARP
 *
 */
public class CrimeCameraActivity extends SingleFragmentActivity {

	/* (non-Javadoc)
	 * @see com.jarp.tutorials.bigranchprohects.ch19.SingleFragmentActivity#createFragment()
	 */
	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return new CrimeCameraFragment();
	}

}
