package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import model.Area;
import model.BackgroundState;
import model.Desk;

public class Initialise {

	public static Desk initialiseDesk(int width, int height) {
		if (width > 0 && height > 0) {
			Desk desk = new Desk();

			desk.createMyDesk(width, height);

			return desk;
		} else {
			return null;
		}

	}

	public static Boolean putRandownMines(Desk desk, int mines) {

		if (mines >= desk.getHeight() * desk.getWidth()) {
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
