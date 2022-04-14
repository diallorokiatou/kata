package com.onepoint.source.model;

import java.util.Random;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Roll {
	private Boolean isStrike 	= false;
	private Boolean isSpare 	= false;
	private Boolean isMiss 		= false;
	private Boolean hasNextRoll = true;
	private int lastFrameScore = 0;
	private int current_roll_score = 0;
	
	
	public Roll(int lastFrameScore) 
	{
		this.lastFrameScore = lastFrameScore;
	}
	
	public int pinsDownOnRoll(int n) 
	{
		// random
		Random r = new Random();
		current_roll_score = r.nextInt(n + 1);
		if(current_roll_score == 10) 
			setIsStrike();
		
		else if(current_roll_score == 0) 
			setIsMiss();
		
		else if(!this.hasNextRoll) 
		{
			if(current_roll_score + lastFrameScore == 10)
				setIsSpare();
		}
		return current_roll_score;
	}
	
	public int getCurrent_roll_score() 
	{
		return current_roll_score;
	}

	public Boolean isStrike() 
	{
		return isStrike;
	}

	public void setIsStrike() 
	{
		this.hasNextRoll = false;
		this.isStrike = true;
	}

	public Boolean isSpare() 
	{
		return isSpare;
	}

	public void setIsSpare() 
	{
		this.isSpare = true;
	}

	public Boolean hasNextRoll() 
	{
		return this.hasNextRoll;
	}

	public void setHasNextRoll(Boolean hasNextRoll) 
	{
		this.hasNextRoll = hasNextRoll;
	}

	public Boolean isMiss() 
	{
		return this.isMiss;
	}

	public void setIsMiss() 
	{
		this.isMiss = true;
	}
	
}
