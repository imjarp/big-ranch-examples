package com.jarp.tutorials.bigranchprohects.ch15;


import com.jarp.tutorials.bigranchprohects.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class HelloMoonActivity extends FragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setTheme(android.R.style.Theme_Holo);
		setContentView(R.layout.ch15_activity_hellomoon);
		
	}
	
	

}
