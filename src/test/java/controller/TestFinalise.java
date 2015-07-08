package controller;

import static org.junit.Assert.*;
import model.BackgroundState;
import model.Desk;
import model.DisplayState;

import org.junit.Before;
import org.junit.Test;

public class TestFinalise {

	
	Desk d;

	int x = 3;
	int y = 3;

	@Before
	public void init() throws Exception {
		d = Initialise.initialiseDesk(x, y);
		
		d.getMyDesk()[0][2].setBackgroundState(BackgroundState.MINE);
		d.getMyDesk()[1][0].setBackgroundState(BackgroundState.MINE);
		d.getMyDesk()[2][0].setBackgroundState(BackgroundState.MINE);
		d.getMyDesk()[2][1].setBackgroundState(BackgroundState.MINE);
		d.getMyDesk()[2][2].setBackgroundState(BackgroundState.MINE);
	}
	
	
	@Test
	public void testIsFinishedTrue() throws Exception {
		
		d.getMyDesk()[0][0].setDisplayState(DisplayState.ONE);
		d.getMyDesk()[0][1].setDisplayState(DisplayState.TWO);
		d.getMyDesk()[0][2].setDisplayState(DisplayState.MARK);
		
		d.getMyDesk()[1][0].setDisplayState(DisplayState.HIDE);
		d.getMyDesk()[1][1].setDisplayState(DisplayState.FIVE);
		d.getMyDesk()[1][2].setDisplayState(DisplayState.THREE);
		
		d.getMyDesk()[2][0].setDisplayState(DisplayState.MARK);
		d.getMyDesk()[2][1].setDisplayState(DisplayState.MARK);
		d.getMyDesk()[2][2].setDisplayState(DisplayState.HIDE);
		
		assertEquals(true, Finalise.IsFinished(d));
	}
	
	@Test
	public void testIsFinishedFalseWithHid() throws Exception {
		
		//HIDE an empty area
		d.getMyDesk()[0][0].setDisplayState(DisplayState.HIDE);
		d.getMyDesk()[0][1].setDisplayState(DisplayState.TWO);
		d.getMyDesk()[0][2].setDisplayState(DisplayState.MARK);
		
		d.getMyDesk()[1][0].setDisplayState(DisplayState.HIDE);
		d.getMyDesk()[1][1].setDisplayState(DisplayState.FIVE);
		d.getMyDesk()[1][2].setDisplayState(DisplayState.THREE);
		
		d.getMyDesk()[2][0].setDisplayState(DisplayState.MARK);
		d.getMyDesk()[2][1].setDisplayState(DisplayState.MARK);
		d.getMyDesk()[2][2].setDisplayState(DisplayState.HIDE);
		
		assertEquals(false, Finalise.IsFinished(d));
		
		//MAK an empty area
		d.getMyDesk()[0][0].setDisplayState(DisplayState.MARK);
		d.getMyDesk()[0][1].setDisplayState(DisplayState.TWO);
		d.getMyDesk()[0][2].setDisplayState(DisplayState.MARK);
		
		d.getMyDesk()[1][0].setDisplayState(DisplayState.HIDE);
		d.getMyDesk()[1][1].setDisplayState(DisplayState.FIVE);
		d.getMyDesk()[1][2].setDisplayState(DisplayState.THREE);
		
		d.getMyDesk()[2][0].setDisplayState(DisplayState.MARK);
		d.getMyDesk()[2][1].setDisplayState(DisplayState.MARK);
		d.getMyDesk()[2][2].setDisplayState(DisplayState.HIDE);
		
		assertEquals(false, Finalise.IsFinished(d));
		
		
	}
	
}
