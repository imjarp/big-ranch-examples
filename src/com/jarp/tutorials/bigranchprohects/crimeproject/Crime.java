/**
 * 
 */
package com.jarp.tutorials.bigranchprohects.crimeproject;

import java.util.UUID;

/**
 * @author JARP
 *
 */
public class Crime {
	
	private UUID mId;
	
	private String mTitle;
	
	public Crime()
	{
		this.mId = UUID.randomUUID();
	}
	
	public UUID getmId() {
		return mId;
	}
	

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	
	
	
	

}
