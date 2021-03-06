/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import android.content.Context;
import android.util.Log;

/**
 * @author JARP
 *
 */
public class CrimeLab {
	
	private ArrayList<Crime> mCrimes;
	
	private static final String TAG= "CrimeLab";
	
	private static final String fileName = "crimes.json";
	
	private CriminalIntentJsonSerializer mSerializer;
	
	private static CrimeLab sCrimeLab;
			
	private Context mAppContext;
	
	private CrimeLab(Context context)
	{
		mAppContext= context;
		
		mSerializer = new CriminalIntentJsonSerializer(mAppContext, fileName);
		
		try
		{
			mCrimes = mSerializer.loadCrimes();
		}
		catch(Exception e)
		{
			mCrimes = new ArrayList<Crime>();
			Log.e(TAG, "Error al cargar crimes " + e.getMessage());
		}
		

}
	
	
	
	public static CrimeLab get (Context c)
	{
		if(sCrimeLab ==null)
			sCrimeLab = new CrimeLab(c.getApplicationContext());
		return sCrimeLab;
	}
	
	public ArrayList<Crime> getCrimes()
	{
		return mCrimes;
	}
	
	public Crime getCrime( UUID id)
	{
	
		for (Crime c : mCrimes) {
			if(c.getmId().equals(id))
				return c;
		}
		return null;
	}
	

	public void  addCrime(Crime c)
	{
		mCrimes.add(c);
	}
	
	public void deleteCrime(Crime c)
	{
		mCrimes.remove(c);
	}
	
	public boolean saveCrimes()
	{
		try {
			
			mSerializer.saveCrimes(mCrimes);
			Log.d(TAG, "crimes saved to file");
			return true;
		} catch (Exception e) {
			Log.e(TAG, "Error saving crimes " , e); 
				return false;
		}
	}
	

}



