package com.jarp.tutorials.bigranchprohects.ch18ABS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import android.R.array;
import android.content.Context;
import android.os.Environment;

public class CriminalIntentJsonSerializer {
	
	
	private Context mContext;
	private String fileName;
	
	public CriminalIntentJsonSerializer(Context mContext, String fileName) {
		this.mContext = mContext;
		this.fileName = fileName;
	}
	
	private boolean hasPermissionToWriteInStorage()
	{
		String state = Environment.getExternalStorageState();
		
		if(Environment.MEDIA_MOUNTED.equals(state))
			return true;
		else
			return false;
		
	}
	
	public void saveCrimes(ArrayList<Crime> crimes) throws IOException, JSONException
	{
		JSONArray array= new JSONArray();
		
		for (Crime c : crimes)
		{	
			array.put(c.toJSON() );
		}
		
		Writer writer = null;
	
		
		try {
				OutputStream out = mContext.openFileOutput(fileName, Context.MODE_PRIVATE);
				writer = new OutputStreamWriter(out);
				writer.write(array.toString());
		} finally
		{
			if(writer!= null)
				writer.close();
		}
				
	}
	
	
	public ArrayList<Crime> loadCrimes() throws IOException, JSONException
	{
		
		ArrayList< Crime>crimes = new ArrayList<Crime>();
		BufferedReader reader = null;
		
		try
		{
			InputStream in = mContext.openFileInput(fileName);
			reader = new BufferedReader(new InputStreamReader(in));
			StringBuilder jsonString= new StringBuilder();
			String line = null;
			while((line= reader.readLine())!= null)
			{
				jsonString.append(line);
				
			}
			
			JSONArray jsonArray =(JSONArray) new JSONTokener(jsonString.toString()).nextValue();
			for (int i = 0; i < jsonArray.length(); i++) {
				crimes.add(new Crime(jsonArray.getJSONObject(i)));
			}
			
		}
		catch(FileNotFoundException f)
		{
		}
		finally
		{
			if(reader!=null)
				reader.close();
		}
		
		return crimes;
		
	}


}
