/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch19;

import java.io.IOException;
import java.util.List;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.jarp.tutorials.bigranchprohects.R;

/**
 * @author JARP
 *
 */
public class CrimeCameraFragment extends Fragment {
	
	private static String TAG = "CrimeCameraFragment";
	private Camera mCamera;
	private SurfaceView mSurfaceView;
	
	@Override
	@SuppressWarnings("deprecation")
	public View onCreateView(LayoutInflater inflater, ViewGroup parent ,Bundle savedInstance)
	{
		View v = inflater.inflate(R.layout.ch19_fragment_crime_camera, parent, false);
		
		Button takePictureButton = (Button)v.findViewById(R.id.crime_camera_takePictureButton);
		takePictureButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getActivity().finish();
			}
		});
		
		mSurfaceView = (SurfaceView) v.findViewById(R.id.crime_camera_surfaceView);
		
		SurfaceHolder mSurfaceHolder = mSurfaceView.getHolder();
		
		//setType() ad SURFACE_TYPE_PUSH_BUFFERSs are both deprecated,
		//but required for Camera preview to work on pre-3.0 devices
		
		mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
		mSurfaceHolder.addCallback(new Callback() {
			
			
			public void surfaceDestroyed(SurfaceHolder holder) {
				if(mCamera!=null)
					mCamera.stopPreview();
				
			}
			
			
			public void surfaceCreated(SurfaceHolder holder) {
			
				try
				{
					if(mCamera!=null)
						mCamera.setPreviewDisplay(holder);
				}
				catch(IOException ioEx)
				{
					Log.e(TAG, "Error setting up preview display",ioEx);
				}
			}
			
			
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				
				if(mCamera==null)return;
				
				Camera.Parameters parameters = mCamera.getParameters();
				
				Size s = getBestSupportedSize(parameters.getSupportedPreviewSizes(), width, height);
				
				
				parameters.setPreviewSize(s.width, s.height);
				
				mCamera.setParameters(parameters);
				
				try
				{
					mCamera.startPreview();
				}
				catch(Exception e)
				{
					Log.w(TAG, "Could not start preview", e);
					mCamera.release();
					mCamera = null;
				}
				
			}
		});
		
		return v;
		
	}
	
	@TargetApi(9)
	@Override
	public void onResume()
	{
		super.onResume();
		
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.GINGERBREAD){
			mCamera= Camera.open(0);
		}
		else
		{
			mCamera= Camera.open();
		}
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		if(mCamera!=null)
		{
			mCamera.release();
			mCamera = null;
		}
	}
	
	private Size getBestSupportedSize(List<Size> sizes, int width, int height)
	{
		Size bestSize =null;
		
		bestSize= sizes.get(0);
		
		int largestArea = bestSize.width * bestSize.height;
		
		for (Size size : sizes) {
			int area = size.width * size.height;
			if(area>largestArea)
			{
				bestSize = size;
				largestArea=area;
			}
		}
		
		return bestSize;
	}

}
