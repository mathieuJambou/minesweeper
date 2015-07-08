package controller.service;

import controller.Running;
import model.Desk;
import exception.AreaDiscoveredException;
import exception.MineException;
import exception.OutOfDeskException;

/**
 * @author mathieu
 *
 */
public class RunningServiceImpl implements RunningService {

	@Override
	public void discoverArea(Desk d, int row, int col) throws AreaDiscoveredException, OutOfDeskException, MineException {
		Running.discoverArea(d, row, col);
	}

	@Override
	public void indicateArea(Desk d, int row, int col) {
		Running.indicateArea(d, row, col);
	}

}
