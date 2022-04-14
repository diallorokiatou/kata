package com.onepoint.source.model;

import java.util.ArrayList;
import java.util.List;



public class Frame {
	private List<Pin> pins;
	private List<Roll> rolls;
	public Score score;
	private int frame_score = 0;
	private int last_frame_bonus_score = 0;
	private Boolean isStrike 	= false;
	private Boolean isSpare 	= false;
	
	public Frame(Score score) 
	{
		// initialize pins
		pins = new ArrayList<Pin>();
		for (int i = 0; i < 10; i++) 
		{
			this.pins.add(new Pin());
		}
		rolls = new ArrayList<Roll>();
		this.score = score;
		
		// Add this frame to score
		score.addFrame(this);
	}
	
	public void setPinsDown() 
	{
		Roll roll 		 = new Roll(this.frame_score);
		if(rolls.size() >= 1) roll.setHasNextRoll(false);
		int numberOfPin  = Integer.parseInt(""+pins.stream().filter(x -> x.getState()).count());
		int down 		 = roll.pinsDownOnRoll(numberOfPin);
		this.frame_score += down;
		updatePins();
		this.rolls.add(roll);
		if(roll.isStrike())
		{
			this.isStrike = true;
			return;
		}
		else if(roll.isSpare()) 
		{
			this.isSpare = true;
			return;
		}
		else 
		{
			if(roll.hasNextRoll()) 
			{
				setPinsDown();
			}
		}	
	}
	
	public void setExtraPinsDown() 
	{
		Roll roll 		 = new Roll(this.frame_score);
		int numberOfPin  = 10;
		if(rolls.size() > 2) roll.setHasNextRoll(false);
		int down = roll.pinsDownOnRoll(numberOfPin);
		// When lastRoll is not strike => add to frame score
		this.frame_score += (rolls.size() < 2) ? down : 0;
		// When lastRoll is strike => add an bonus score
		this.last_frame_bonus_score =  (rolls.size() >= 2) ? down : 0;
		this.rolls.add(roll);
		if(roll.isStrike() && (rolls.size() < 3)) 
			setExtraPinsDown();
	}
	
	public String print() 
	{
		System.out.print("|");
		String score_per_roll = "   ";
		for (Roll roll : this.getRolls()) 
		{
			if(roll.isStrike()) 
				score_per_roll += "X" + "   ";
			else if(roll.isSpare()) 
				score_per_roll += "/" + " ";
			else if(roll.isMiss()) 
				score_per_roll += "-" + " ";
			else 
				score_per_roll += roll.getCurrent_roll_score() + " ";
		}
		System.out.print(score_per_roll);
		return "";
	}
	
	private void updatePins() 
	{
		for(int i=0; i < frame_score; i++)
		{
			pins.get(i).setDown();
		}	
	}

	public void addRoll(Roll roll) 
	{
		rolls.add(roll);
	}
	
	public void setFrameScore(int frameScore) 
	{
		this.frame_score = frameScore;
	}

	public List<Roll> getRolls() 
	{
		return rolls;
	}

	public void setRolls(List<Roll> rolls) 
	{
		this.rolls = rolls;
	}

	public int getFrame_score() 
	{
		return frame_score;
	}

	public Boolean isStrike() 
	{
		return isStrike;
	}

	public void setIsStrike(Boolean isStrike) 
	{
		this.isStrike = isStrike;
	}

	public Boolean isSpare() 
	{
		return isSpare;
	}

	public void setIsSpare(Boolean isSpare) 
	{
		this.isSpare = isSpare;
	}

	public int getLast_frame_bonus_score() 
	{
		return last_frame_bonus_score;
	}


}
