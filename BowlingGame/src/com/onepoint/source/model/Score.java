package com.onepoint.source.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Score {
	Integer score = 0; 
	List<Frame> frames;

	/** Instance unique pré-initialisée */
    private static Score INSTANCE = new Score();
     
    /** Point d'accès pour l'instance unique du singleton */
    public static Score getInstance()
    {   
    	return INSTANCE;
    }
	
	/** Constructeur privé */
    private Score() {
		frames = new ArrayList<Frame>(10);
	}
	
	public void setScore(int frameScore) 
	{
		this.score += frameScore;
	}
	
	public int getScrore()
	{
		return score;
	}
	
	public int getLastFrameScore() {
		return frames.get(frames.size() - 1).getFrame_score();
	}
	
	public void addFrame(Frame frame) 
	{
		frames.add(frame);
	}

	public void print() 
	{
		
		System.out.println("|___1___|___2___|___3___|___4___|___5___|___6___|___7___|___8___|___9___|_____10______|");
		this.computeFinalScore();
		System.out.print("\r");
		System.out. print("|_______|_______|_______|_______|_______|_______|_______|_______|_______|_____________|");
	}
	
	public void computeFinalScore() 
	{
		String score_per_frame = "";
		for(int i=0; i < this.frames.size(); i++)
		{
			Frame frame = frames.get(i);
			//Print rolls values
			frame.print();
			if(frame.isStrike() && i < frames.size() - 1)
			{
				Frame nextFrame = frames.get(i + 1);
				if(nextFrame.isStrike() && i < frames.size() - 2) 
				{
					frame.setFrameScore(frame.getFrame_score() + nextFrame.getFrame_score());
				}
					frame.setFrameScore(frame.getFrame_score() + nextFrame.getFrame_score());
			}
			else if(frame.isSpare() && i < frames.size() - 1)
			{
				Frame nextFrame = frames.get(i + 1);
				frame.setFrameScore(frame.getFrame_score() + nextFrame.getRolls().get(0).getCurrent_roll_score());
			}
			this.score += frame.getFrame_score() + frame.getLast_frame_bonus_score();
			score_per_frame +=  printScoreCase(score);
			
		}
		// Print score per frame
		System.out.print("\r");
		System.out.print(score_per_frame);
	}
	
	String printScoreCase(int score) 
	{
		if(0 <= this.score && this.score < 10) 
			return "|      " + score + "";

		else if(10 <= this.score && this.score < 100)  
			return "|     " + score + "";

		return "|    " + score + "";
	}
	
}
