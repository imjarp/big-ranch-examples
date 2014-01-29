/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch19;

import java.util.ArrayList;
import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.jarp.tutorials.bigranchprohects.R;

/**
 * @author JARP
 *
 */
public class CrimePagerActivity extends FragmentActivity {

	private ViewPager mViewPager;
	
	private ArrayList<Crime> mCrimes;
	
	@Override
	protected void onCreate(Bundle savedInstance) {

		super.onCreate(savedInstance);
		
		mViewPager = new ViewPager(this);
		
		mViewPager.setId(R.id.viewPager);
		
		setContentView(mViewPager);
		
		FragmentManager fm = getSupportFragmentManager();
		
		mCrimes = CrimeLab.get(this).getCrimes();
		
		
		
		mViewPager.setAdapter(new FragmentPagerAdapter(fm) {
			
			@Override
			public int getCount() {

				return mCrimes.size();
			}
			
			@Override
			public Fragment getItem(int index) {

				Crime c = mCrimes.get(index);
				
				
				return CrimeFragment.newInstance(c.getmId());
			}
		});
			
		
		UUID crimeID = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID) ;
		
		for (int i = 0; i < mCrimes.size(); i++) {
			
			if(mCrimes.get(i).getmId().equals(crimeID))
			{
				mViewPager.setCurrentItem(i);
				
				if(mCrimes.get(i).getmTitle()!=null)
				{
					setTitle(mCrimes.get(i).getmTitle());
				}
				
				break;
			}
		}
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				Crime c = mCrimes.get(arg0);
				
				if(c.getmTitle()!=null)
				{
					setTitle(c.getmTitle());
				}
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		

	}

}
