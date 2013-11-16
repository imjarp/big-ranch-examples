/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch10;

import android.support.v4.app.Fragment;

/**
 * @author JARP
 *
 */
public class CrimeListActivity extends SingleFragmentActivity {

	/* (non-Javadoc)
	 * @see com.jarp.tutorials.bigranchprohects.ch9.SingleFragmentActivity#createFragment()
	 */
	
	
	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return new CrimeListFragment();
	}

}
