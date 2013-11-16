/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.ch11;

import java.util.Date;
import java.util.UUID;

/**
 * @author JARP
 *
 */
public class Crime {
	
	private UUID mId;
	
	private Date mDate ;
	
	private boolean mSolved;
	
	private String mTitle;
	
	public Crime()
	{
		this.mId = UUID.randomUUID();
		this.mDate = new Date();
	
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
