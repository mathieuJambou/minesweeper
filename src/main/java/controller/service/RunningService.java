package controller.service;

import model.Desk;
import exception.AreaDiscoveredException;
import exception.MineException;
import exception.OutOfDeskException;

/**
 * @author mathieu
 *
 */
public interface RunningService {

	public void discoverArea(Desk d,int row,int col) throws AreaDiscoveredException, OutOfDeskException, MineException;

	public void indicateArea(Desk d, int row, int col);
	
}
