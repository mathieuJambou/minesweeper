package controller;

import java.util.Random;

import org.apache.log4j.Logger;

import model.BackgroundState;
import model.Desk;

/**
 * @author mathieu
 *
 */
public class Initialise {
	
	final static Logger logger = Logger.getLogger(Initialise.class);

	
	/**
	 * @param width of the desk
	 * @param height of the desk
	 * @return desk if width/height are correct 
	 */
	public static Desk initialiseDesk(int width, int height) {
		
		logger.debug("initialiseDesk : width: " + width + " , height: " + height );
		if (width > 0 && height > 0) {
			Desk desk = new Desk();

			desk.createMyDesk(width, height);

			return desk;
		} else {
			return null;
		}

	}

	/**
	 * @param desk
	 * @param mines number of mines to add on the desk
	 * @return desk with mines if the number of mines is correct
	 */
	public static Boolean putRandownMines(Desk desk, int mines) {

		logger.debug("putRandownMines : nb mines: " + mines + " , desk size: " + desk.getHeight() * desk.getWidth() );
		
		if (mines >= desk.getHeight() * desk.getWidth() -1) {
			return false;
		} else {
			int nbMine = 0;
			while (nbMine < mines) {
				Random random = new Random();
				int randomX = random.nextInt(desk.getWidth());
				int randomY = random.nextInt(desk.getHeight());

				if (!desk.getMyDesk()[randomY][randomX].getBackgroundState()
						.equals(BackgroundState.MINE)) {
					desk.getMyDesk()[randomY][randomX]
							.setBackgroundState(BackgroundState.MINE);
					nbMine++;
					logger.debug("putRandownMines : mine Y : " + randomY + " , mine X: " + randomX);

				}

			}
			return true;
		}

	}
	
	
	/**
	 * @param desk
	 * @param i
	 * @param j
	 * @return true if the mine is put else false
	 */
	public static Boolean putMine(Desk desk, int i, int j) {

		logger.debug("putMine : position Y: " + i + " , position X: " + j );

		if (!desk.getMyDesk()[i][j].getBackgroundState().equals(BackgroundState.MINE)) 
		{
			desk.getMyDesk()[i][j].setBackgroundState(BackgroundState.MINE);
			return true;
		}
		else
		{
			return false;
		}

	}
}
