package main;

import controller.Initialise;
import model.Desk;

public class Main {

	public static void main(String[] args) {

		System.out.println("Start");
		
		int x = 4;
		int y=4;
		
		int mines = 2;
		
		System.out.println("--- Initialise ---");
		
		Desk d = Initialise.initialiseDesk(x, y);
		
		if(d!= null)
		{
			System.out.println("--- Put mines ---");
			
			Initialise.putRandownMines(d, mines);
		}
		
		
		System.out.println("End");
		
	}

}
