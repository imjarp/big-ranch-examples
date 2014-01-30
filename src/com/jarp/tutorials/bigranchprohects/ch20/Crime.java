/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch20;

import java.util.Date;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author JARP
 *
 */
public class Crime {
	
	private UUID mId;
	private Date mDate ;
	private boolean mSolved;
	private String mTitle;
	private static final String JSON_ID= "id";
	private static final String JSON_TITLE= "title";
	private static final String JSON_SOLVED= "solved";
	private static final String JSON_DATE= "date";
	
	
	
	public Crime()
	{
		this.mId = UUID.randomUUID();
		this.mDate = new Date();
	}
	
	public JSONObject toJSON() throws JSONException
	{
		JSONObject json = new JSONObject();
		
		json.put(JSON_ID, this.mId.toString());
		json.put(JSON_TITLE, this.mTitle);
		json.put(JSON_SOLVED, this.mSolved);
		json.put(JSON_DATE, this.mDate.toString());
		
		return json;
		
	}
	
	public Crime (JSONObject json ) throws JSONException
	{
		
		//mId  = (UUID) json.get(JSON_ID);
		mId = UUID.fromString(json.get(JSON_ID).toString());
		mTitle = json.getString(JSON_TITLE);
		mSolved = json.getBoolean(JSON_SOLVED);
		mDate = new Date(json.getString(JSON_DATE));
		
	}
	
	public Date getDate() {
		return mDate;
	}


	public void setDate(Date mDate) {
		this.mDate = mDate;
	}


	public boolean isSolved() {
		return mSolved;
	}


	public void setSolved(boolean solved) {
		this.mSolved = solved;
	}

	
	
	public UUID getmId() {
		return mId;
	}

	
	
	@Override
	public String toString()
	{
		return mTitle;
	}
	
	
	

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	
}
