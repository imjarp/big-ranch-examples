package com.jarp.tutorials.bigranchprohects.ch15;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.jarp.tutorials.bigranchprohects.R;

public class HelloMoonFragment extends Fragment {
	
	

	

	private Button btnPlay;
	
	private Button btnPause;
	
	private AudioPlayer mPAudioPlayer = new AudioPlayer( );

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.ch15_fragment_hellomoon, null) ;
		
		btnPlay = (Button)v.findViewById(R.id.button_hellomoon_play);
		
		btnPlay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
					mPAudioPlayer.play(getActivity( ));
					Toast.makeText(getActivity(), "Is Playing", Toast.LENGTH_SHORT).show();
			
				
			}
		});
		
		btnPause = (Button)v.findViewById(R.id.button_hellomoon_pause);
		
		btnPause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				mPAudioPlayer.stop();
				
			}
		});
		
		return v;

	}
	
	@Override
	public void onStop() {
	
		super.onStop();
		
		mPAudioPlayer.stop();
		
		
	}

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setRetainInstance(true);
		
	}
	

}

