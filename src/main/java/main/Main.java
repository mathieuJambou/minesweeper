package main;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import view.ConsoleView;
import view.DeskView;
import view.SwingView;
import controller.Finalise;
import controller.Initialise;
import controller.Running;
import exception.AreaDiscoveredException;
import exception.MineException;
import exception.OutOfDeskException;
import model.Desk;

public class Main {

	private static DeskView deskView;
	final static Logger logger = Logger.getLogger(Main.class);
	private static Scanner reader;


	public static void main(String[] args) {

		logger.info("--- Start Main ---");
		
		reader = new Scanner(System.in);
		
		 int rows = 0, cols = 0, mines = 0;
	     boolean loop = true;

	     while (loop)
	     {
	     	 try {
	                System.out.println("Enter the number of rows: ");
	                rows = reader.nextInt();
	                logger.debug("rows selected: " + rows);
	                loop = false;
	     	 } catch (InputMismatchException e) {
	                System.out.println("Invalid value!");
	         } 
	     }
	     loop= true;
	     while (loop)
	     {
	     	 try {
	                System.out.println("Enter the number of cols: ");
	                cols = reader.nextInt();
	                logger.debug("cols selected: " + cols);
	                loop = false;
	     	 } catch (InputMismatchException e) {
	                System.out.println("Invalid value!");
	         } 
	     }
	     loop =true;
	     while (loop)
	     {
	     	 try {
	                System.out.println("Enter the number of mines: ");
	                mines = reader.nextInt();
	                logger.debug("mines selected: " + mines);
	                loop = false;
	     	 } catch (InputMismatchException e) {
	                System.out.println("Invalid value!");
	         } 
	     }
		
		logger.info("--- Initialise ---");
		
		Desk d = Initialise.initialiseDesk(rows, cols);
		
		if(d == null)
		{
			logger.info("--- initialise with errors---");
			return;
		}
		
		
		logger.info("--- Put mines ---");
		Boolean validMines = Initialise.putRandownMines(d, mines);
		if(!validMines)
		{
			logger.info("--- Put mines with errors---");
			return;
		}
		
		deskView = new SwingView();
		
		deskView.displayDesk(d);
			
	}

}
