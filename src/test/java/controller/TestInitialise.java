package controller;

import static org.junit.Assert.*;
import model.BackgroundState;
import model.Desk;

import org.junit.Test;


public class TestInitialise {

	
	@Test
	public void testInitDesk() throws Exception {

		int x = 6;
		int y=9;
		
		Desk d = Initialise.initialiseDesk(x, y);
		assertNotNull("Desk can't be null", d);

	}
	
	@Test
	public void testWidthDesk() throws Exception {

		int x = 6;
		int y=9;
		
		Desk d = Initialise.initialiseDesk(x, y);
		
		for(int i =0; i< d.getMyDesk().length; i++)
		{
			assertEquals((int)d.getWidth(), d.getMyDesk()[i].length);
		}
		
		

	}
	
	@Test
	public void testHeightDesk() throws Exception {

		int x = 6;
		int y=9;
		
		Desk d = Initialise.initialiseDesk(x, y);
		
		assertEquals((int)d.getHeight(), d.getMyDesk().length);

	}
	
	@Test
	public void testMinesDesk() throws Exception {

		int x = 6;
		int y=9;
		
		int mines = 2;
		
		int minesput = 0;
		
		Desk d = Initialise.initialiseDesk(x, y);
		
		assertEquals(true, Initialise.putRandownMines(d, mines));
		
		for(int i= 0; i< d.getHeight(); i++)
		{
			for(int j= 0; j< d.getWidth(); j++)
			{
				if(d.getMyDesk()[i][j].getBackgroundState().equals(BackgroundState.MINE))
				{
					minesput++;
				}
			}
			
		}
		
		assertEquals(mines, minesput);

	}
	
	
	
	
}
