package com.jarp.tutorials.bigranchprohects;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager fm = getSupportFragmentManager();
		
		Fragment f = fm.findFragmentById(R.id.mainChapter_fragmentContainer);
		
		
		
		if(f==null)
		{
			f = new ListChapterFragments();
			
			fm.beginTransaction()
			.add(R.id.mainChapter_fragmentContainer, f)
			.commit();
		}
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
