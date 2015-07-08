package controller.service;

import model.Desk;
import controller.Initialise;

/**
 * @author mathieu
 *
 */
public class InitialiseServiceImpl implements InitialiseService {

	@Override
	public Boolean putRandownMines(Desk desk, int mines) {
		return Initialise.putRandownMines(desk, mines);
	}

	@Override
	public Desk initialiseDesk(int width, int height) {
		return Initialise.initialiseDesk(width, height);
	}
}
