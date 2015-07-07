package controller;

import model.BackgroundState;
import model.Desk;
import model.DisplayState;

/**
 * @author mathieu
 *
 */
public class Running {
	
	
	/**
	 * @param desk
	 * @param i 
	 * @param j 
	 * @return true if desk[i][j] isn't hide else false
	 */
	public Boolean checkAreaAlreadyDiscovered(Desk desk, int i, int j)
	{
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
	public Boolean checkAreaWithMine(Desk desk, int i, int j)
	{
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
	public void indicateArea(Desk desk, int i, int j)
	{
		desk.getMyDesk()[i][j].setDisplayState(DisplayState.MARK);
	}

	/**
	 * @param desk
	 * @param i
	 * @param j
	 * @return the number of the mines around desk[i][j]
	 */
	public Integer neightborMines(Desk desk, int i, int j)
	{
		Integer result=0;
		int m = desk.getHeight();
		int n = desk.getWidth();
		
		// max(i-1,0) and min(i+1,m) / max(j-1,0) and min(j+1,n) don't cross the limit of the desk
		for(int y= Math.max(i-1,0); y<= Math.min(i+1,m); y++)
		{
			for(int x = Math.max(j-1,0); x <= Math.min(j+1, n); x++ )
			{
				if(desk.getMyDesk()[y][x].getBackgroundState().equals(BackgroundState.MINE) && (y !=i && x!=j))
				{
					result++;
				}
			}
		}
		return result;
	}
	
}
