package controller;

import org.apache.log4j.Logger;

import model.BackgroundState;
import model.Desk;
import model.DisplayState;

/**
 * @author mathieu
 *
 */
public class Finalise {

	final static Logger logger = Logger.getLogger(Finalise.class);


	/**
	 * @param desk
	 * @return true if all the empty Areas are discovered 
	 */
	public static Boolean IsFinished(Desk desk)
	{
		for(int i=0; i<desk.getHeight(); i++) 
		{
			for(int j=0; j<desk.getWidth(); j++) 
			{
				logger.debug("IsFinished : y: " + i +" , x: " + j +" , BackgroundState: "+  desk.getMyDesk()[i][j].getBackgroundState() + " , DisplayState: " + desk.getMyDesk()[i][j].getDisplayState() );
				if((desk.getMyDesk()[i][j].getBackgroundState().equals(BackgroundState.EMPTY) && 
						desk.getMyDesk()[i][j].getDisplayState().equals(DisplayState.HIDE)) ||
						(desk.getMyDesk()[i][j].getBackgroundState().equals(BackgroundState.EMPTY)	  &&
						desk.getMyDesk()[i][j].getDisplayState().equals(DisplayState.MARK)))
						{
							return false ;
						}
			}
		}
		
		return true ;
	}
}
