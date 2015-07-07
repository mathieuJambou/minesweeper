package controller;

import java.util.Random;

import model.BackgroundState;
import model.Desk;

/**
 * @author mathieu
 *
 */
public class Initialise {

	
	/**
	 * @param width of the desk
	 * @param height of the desk
	 * @return desk if width/height are correct 
	 */
	public static Desk initialiseDesk(int width, int height) {
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
				}

			}
			return true;
		}

	}
}
