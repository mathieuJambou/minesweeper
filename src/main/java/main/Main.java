package main;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import view.ConsoleView;
import view.DeskView;
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
	                loop = false;
	     	 } catch (InputMismatchException e) {
	                System.out.println("Invalid value!");
	         } 
	     }
	     loop= true;
		
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
		
		deskView = new ConsoleView();
		
		do {
			
			deskView.displayDesk(d);
			
			int row = 0, col = 0, action = 0;
			
			while (loop)
		    {
		    	 try {
		    		 System.out.print("Enter an action 1:open; 2:mark; 3:quit: ");
		    		 action = reader.nextInt();
		               loop = false;
		    	 } catch (InputMismatchException e) {
		               System.out.println("Invalid value!");
		        } 
		    }
		    loop= true;
			
			while (loop)
		    {
		    	 try {
		               System.out.println("Enter a row: ");
		               row = reader.nextInt();
		               loop = false;
		    	 } catch (InputMismatchException e) {
		               System.out.println("Invalid value!");
		        } 
		    }
		    loop= true;
		    while (loop)
		    {
		    	 try {
		               System.out.println("Enter a col: ");
		               col = reader.nextInt();
		               loop = false;
		    	 } catch (InputMismatchException e) {
		               System.out.println("Invalid value!");
		        } 
		    }
		    loop= true;
		    
		    if(action == 1)
		    {
		    	try {
		    		Running.discoverArea(d, row, col);
		    	}
		    	catch( OutOfDeskException e)
		    	{
		    		System.out.println(e.getMessage());
		    	} 
		    	catch (AreaDiscoveredException e) 
		    	{
		    		System.out.println(e.getMessage());
				} 
		    	catch (MineException e) 
		    	{
					System.out.println(e.getMessage());
					System.exit(0);
				}
		    	
		    }
		    else if(action == 2)
		    {
		    	Running.indicateArea(d, row, col);
		    }
		    else if(action == 3)
		    {
		    	System.exit(0);
		    }
		    else
		    {
		    	System.out.println("Invalid action!");	
		    }			
			
		}
		while(!Finalise.IsFinished(d));
		
		deskView.displayDesk(d);
		
		
		logger.info("--- End ---");
		
	}

}
