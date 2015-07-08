package controller;

import static org.junit.Assert.*;
import model.BackgroundState;
import model.Desk;
import model.DisplayState;

import org.junit.Before;
import org.junit.Test;

public class TestRunning {

	
	Desk d;

	int x = 6;
	int y = 9;

	@Before
	public void init() throws Exception {
		d = Initialise.initialiseDesk(x, y);
	}
	
	@Test
	public void testisInsideDesk() throws Exception {
		
		assertEquals(true, Running.isInsideDesk(d, 0,0));
		assertEquals(true, Running.isInsideDesk(d, 1,1));
		assertEquals(true, Running.isInsideDesk(d, 0,3));
		assertEquals(false, Running.isInsideDesk(d, -2,2));
		assertEquals(false, Running.isInsideDesk(d, 41,3));
		assertEquals(false, Running.isInsideDesk(d, 9,6));
		assertEquals(false, Running.isInsideDesk(d, 6,9));
	
	}
	
	
	@Test
	public void testDiscoveredState() throws Exception {
		
		d.getMyDesk()[2][2].setDisplayState(DisplayState.HIDE);
		d.getMyDesk()[3][3].setDisplayState(DisplayState.MARK);
		d.getMyDesk()[4][3].setDisplayState(DisplayState.FOUR);
		
		assertEquals(false, Running.checkAreaAlreadyDiscovered(d, 1,1));
		assertEquals(false, Running.checkAreaAlreadyDiscovered(d, 2,2));
		assertEquals(true, Running.checkAreaAlreadyDiscovered(d, 3,3));
		assertEquals(true, Running.checkAreaAlreadyDiscovered(d, 4,3));
		
	}
	
	@Test
	public void testAreaContainsMine() throws Exception {
	
		d.getMyDesk()[2][2].setBackgroundState(BackgroundState.MINE);
		
		assertEquals(false, Running.checkAreaWithMine(d, 1,1));
		assertEquals(true, Running.checkAreaWithMine(d, 2,2));
	}
	
	@Test
	public void testIndicateArea() throws Exception {
		
		Running.indicateArea(d, 3, 3);
		
		assertEquals(DisplayState.MARK, d.getMyDesk()[3][3].getDisplayState());
	}
	
	@Test
	public void testNumberofNeightborMines() throws Exception {
	
		d.getMyDesk()[0][0].setBackgroundState(BackgroundState.MINE);
		d.getMyDesk()[0][1].setBackgroundState(BackgroundState.MINE);
		d.getMyDesk()[1][0].setBackgroundState(BackgroundState.MINE);
		
		assertEquals((Integer)3 , Running.neightborMines(d, 1, 1));
		assertEquals((Integer)0 , Running.neightborMines(d, 4, 3));
	}
	
	
	
	
	
	
	
}
