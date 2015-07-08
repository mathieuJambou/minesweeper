package controller.facade;

import exception.AreaDiscoveredException;
import exception.MineException;
import exception.OutOfDeskException;
import model.Desk;

/**
 * @author mathieu
 *
 */
public interface MineSweeper {
	
	public Boolean putRandownMines(Desk desk, int mines);
	
	public Desk initialiseDesk(int width, int height);
	
	public void discoverArea(Desk d,int row,int col) throws AreaDiscoveredException, OutOfDeskException, MineException;

	public void indicateArea(Desk d, int row, int col);
	
	public Boolean IsFinished(Desk desk);

}
