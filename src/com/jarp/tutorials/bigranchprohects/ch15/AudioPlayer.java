/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch15;


import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.jarp.tutorials.bigranchprohects.R;


/**
 * @author JARP
 *
 */
public class AudioPlayer  {

	
	private MediaPlayer mPlayer;
	
	public void stop()
	{
		if(mPlayer != null)
		{
			mPlayer.release( );
			mPlayer = null;
		}
	}
	
	public void play (Context c)
	{
		stop( );
		
		
		mPlayer = MediaPlayer.create( c, R.raw.one_small_step );
		
		
		mPlayer.setOnCompletionListener(new  OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer arg0) {
					stop();
				}
		});
		
		mPlayer.start();
		
	}
	

}
