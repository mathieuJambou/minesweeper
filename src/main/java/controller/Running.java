package controller;

import java.io.ObjectInputStream.GetField;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import exception.AreaDiscoveredException;
import exception.MineException;
import exception.OutOfDeskException;
import model.BackgroundState;
import model.Desk;
import model.DisplayState;

/**
 * @author mathieu
 *
 */
public class Running {
	
	final static Logger logger = Logger.getLogger(Running.class);
	
	
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
		if(desk.getMyDesk()[i][j].getDisplayState().equals(DisplayState.HIDE))
		{
			desk.getMyDesk()[i][j].setDisplayState(DisplayState.MARK);

		}
		else if(desk.getMyDesk()[i][j].getDisplayState().equals(DisplayState.MARK))
		{
			desk.getMyDesk()[i][j].setDisplayState(DisplayState.HIDE);
		}
	}
	
	/**
	 * @param desk
	 * @param i
	 * @param j
	 * @param minesNumber
	 *  display the numbers of mines around the area
	 */
	public static Boolean DisplayNbMines(Desk desk, int i, int j, Integer minesNumber)
	{
		logger.debug("DisplayNbMines : position Y : " + i + " , position X: " + j + " , number of mines: " + minesNumber);
		
		Boolean displayNbMines = true;
		
		switch (minesNumber){
			case 0:
			desk.getMyDesk()[i][j].setDisplayState(DisplayState.ZERO);
			break;
			case 1:
				desk.getMyDesk()[i][j].setDisplayState(DisplayState.ONE);
				break;
			case 2:
				desk.getMyDesk()[i][j].setDisplayState(DisplayState.TWO);
				break;
			case 3:
				desk.getMyDesk()[i][j].setDisplayState(DisplayState.THREE);
				break;
			case 4:
				desk.getMyDesk()[i][j].setDisplayState(DisplayState.FOUR);
				break;
			case 5:
				desk.getMyDesk()[i][j].setDisplayState(DisplayState.FIVE);
				break;
			case 6:
				desk.getMyDesk()[i][j].setDisplayState(DisplayState.SIX);
				break;
			case 7:
				desk.getMyDesk()[i][j].setDisplayState(DisplayState.SEVEN);
				break;
			case 8:
				desk.getMyDesk()[i][j].setDisplayState(DisplayState.EIGHT);
				break;
			default: 
				displayNbMines= false;
				break;
		}
		
		return displayNbMines;
		
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
		int m = desk.getHeight()-1;
		int n = desk.getWidth()-1;
		
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
	
	public static void checkMinesByRecursivity(Desk d, int i, int j)
	{
		Integer nbNeighborMines = Running.neightborMines(d, i, j);
		
		Running.DisplayNbMines(d, i, j, nbNeighborMines);
		
		if(nbNeighborMines==0)
		{
			int m = d.getHeight()-1;
			int n = d.getWidth()-1;
			// max(i-1,0) and min(i+1,m) / max(j-1,0) and min(j+1,n) don't cross the limit of the desk
			for(int y= Math.max(i-1,0); y<= Math.min(i+1,m); y++)
			{
				for(int x = Math.max(j-1,0); x <= Math.min(j+1, n); x++ )
				{
					if(d.getMyDesk()[y][x].getDisplayState().equals(DisplayState.HIDE))
					{
						checkMinesByRecursivity(d,y,x);
					}
				}
			}
		}
	}
	
	
	/**
	 * @param desk
	 * @param i
	 * @param j
	 * @throws Exception
	 * 
	 */
	public static void discoverArea(Desk desk, int i, int j) throws AreaDiscoveredException, OutOfDeskException, MineException
	{
		if(!Running.isInsideDesk(desk, i, j))
		{
			throw new OutOfDeskException();
		}
				
		if(!Running.checkAreaAlreadyDiscovered(desk,i,j))
		{
			if(Running.checkAreaWithMine(desk, i, j))
			{
				throw new MineException();
			}
			else
			{
				Running.checkMinesByRecursivity( desk, i, j);
			}
			
		}
		else
		{
			throw new AreaDiscoveredException();
		}
		
	}
	
	
}
