package com.onepoint.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.onepoint.source.model.Bowling;
import com.onepoint.source.model.Frame;
import com.onepoint.source.model.Player;
import com.onepoint.source.model.Roll;
import com.onepoint.source.model.Score;

class BowlingTest 
{

	
	@Test
	void testFrame() 
	{
		Bowling bowling = new Bowling();
		bowling.start();
		assertTrue(true);
		
		
	}

}
