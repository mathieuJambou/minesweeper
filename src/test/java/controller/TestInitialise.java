package controller;

import static org.junit.Assert.*;
import model.BackgroundState;
import model.Desk;

import org.junit.Before;
import org.junit.Test;

public class TestInitialise {

	Desk d;

	int x = 6;
	int y = 9;

	@Before
	public void init() throws Exception {
		d = Initialise.initialiseDesk(x, y);
	}

	@Test
	public void testInitDesk() throws Exception {
		assertNotNull("Desk can't be null", d);
	}

	@Test
	public void testWidthDesk() throws Exception {
		assertEquals(x, (int) d.getWidth());
		for (int i = 0; i < d.getMyDesk().length; i++) {
			assertEquals((int) d.getWidth(), d.getMyDesk()[i].length);
		}
	}

	@Test
	public void testHeightDesk() throws Exception {
		assertEquals(y, (int) d.getHeight());
		assertEquals((int) d.getHeight(), d.getMyDesk().length);
	}

	@Test
	public void testMinesDesk() throws Exception {
		int mines = 2;
		int minesput = 0;

		assertEquals(true, Initialise.putRandownMines(d, mines));

		for (int i = 0; i < d.getHeight(); i++) {
			for (int j = 0; j < d.getWidth(); j++) {
				if (d.getMyDesk()[i][j].getBackgroundState().equals(
						BackgroundState.MINE)) {
					minesput++;
				}
			}
		}
		assertEquals(mines, minesput);
	}

}
