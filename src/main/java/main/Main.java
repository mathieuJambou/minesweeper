package main;

import org.apache.log4j.Logger;

import view.ConsoleView;
import view.DeskView;
import controller.Initialise;
import controller.Running;
import model.Desk;

public class Main {

	private static DeskView deskView;
	final static Logger logger = Logger.getLogger(Main.class);


	public static void main(String[] args) {

		logger.info("--- Start Main ---");

		int x = 4;
		int y=4;
		
		int mines = 2;
		
		logger.info("--- Initialise ---");
		
		Desk d = Initialise.initialiseDesk(x, y);
		
		if(d == null)
		{
			logger.info("--- initialise with errors---");
			return;
		}
		
		logger.info("--- Put mines ---");
		Initialise.putRandownMines(d, mines);
		
		deskView = new ConsoleView();
		
		deskView.displayDesk(d);
		
		logger.info("--- End ---");
		
	}

}
