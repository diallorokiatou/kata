package com.onepoint.source.model;

public class Pin {
	private Boolean state = true;

	public Pin() 
	{
	}
	
	public void setDown() 
	{
		this.state = false;
	}
	
	public Boolean getState() 
	{
		return state;
	}

}
