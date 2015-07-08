package controller.service;

import model.Desk;

/**
 * @author mathieu
 *
 */
public interface InitialiseService {

	public Boolean putRandownMines(Desk desk, int mines);
	
	public Desk initialiseDesk(int width, int height);
}
