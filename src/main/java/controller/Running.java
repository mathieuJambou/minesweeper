package controller;

import java.io.ObjectInputStream.GetField;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import model.BackgroundState;
import model.Desk;
import model.DisplayState;

/**
 * @author mathieu
 *
 */
public class Running {
	
	final static Logger logger = Logger.getLogger(Running.class);
	
	
	//TODO check if i/j are in the desk
	
	/**
	 * @param d
	 * @param i
	 * @param j
	 * @return true if area[i,j] is inside the Desk else return false 
	 */
	public static Boolean isInsideDesk(Desk d, int i, int j) {
        return (i >= 0 && i < d.getHeight()) && 
               (j >= 0 && j < d.getWidth());
    }
	
	/**
	 * @param desk
	 * @param i 
	 * @param j 
	 * @return true if desk[i][j] isn't hide else false
	 */
	public static Boolean checkAreaAlreadyDiscovered(Desk desk, int i, int j)
	{
		logger.debug("checkAreaAlreadyDiscovered : position Y : " + i + " , position X: " + j);

		if(!desk.getMyDesk()[i][j].getDisplayState().equals(DisplayState.HIDE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @param desk
	 * @param i
	 * @param j
	 * @return  true if desk[i][j] contains a mine else false
	 */
	public static Boolean checkAreaWithMine(Desk desk, int i, int j)
	{
		logger.debug("checkAreaWithMine : position Y : " + i + " , position X: " + j);

		if(desk.getMyDesk()[i][j].getBackgroundState().equals(BackgroundState.MINE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @param desk
	 * @param i
	 * @param j
	 *  change the state of the desk[i][j] to be marked
	 */
	public static void indicateArea(Desk desk, int i, int j)
	{
		logger.debug("indicateArea : position Y : " + i + " , position X: " + j);

		desk.getMyDesk()[i][j].setDisplayState(DisplayState.MARK);
	}

	/**
	 * @param desk
	 * @param i
	 * @param j
	 * @return the number of the mines around desk[i][j]
	 */
	public static Integer neightborMines(Desk desk, int i, int j)
	{
		logger.debug("indicateArea : position Y : " + i + " , position X: " + j);

		Integer result=0;
		int m = desk.getHeight();
		int n = desk.getWidth();
		
		// max(i-1,0) and min(i+1,m) / max(j-1,0) and min(j+1,n) don't cross the limit of the desk
		for(int y= Math.max(i-1,0); y<= Math.min(i+1,m); y++)
		{
			for(int x = Math.max(j-1,0); x <= Math.min(j+1, n); x++ )
			{
				if(desk.getMyDesk()[y][x].getBackgroundState().equals(BackgroundState.MINE) && !(y ==i && x==j))
				{
					result++;
				}
			}
		}
		return result;
	}
	
}
