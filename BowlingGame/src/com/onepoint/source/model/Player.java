package com.onepoint.source.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	String name;
	int current_frame = 1;
	List<Frame> frames;
	Score score_board;
	
	
	public Player(String name) 
	{
		this.name = name;
		this.frames = new ArrayList<Frame>();
		score_board = Score.getInstance();
	}
	
	public void play() 
	{
		do
		{
			frames.add(new Frame(score_board));
			frames.get(current_frame - 1).setPinsDown();
			current_frame++;
		}while(frames.size() < 10);
		
		// extra Rolls?
		if(frames.size() == 10 && frames.get(frames.size() - 1).getFrame_score() == 10)
			frames.get(frames.size() - 1).setExtraPinsDown();

		score_board.print();
	}
	
	public int getCurrent_frame() 
	{
		return current_frame;
	}

	public void setCurrent_frame(int current_frame) 
	{
		this.current_frame = current_frame;
	}
	
	

}
