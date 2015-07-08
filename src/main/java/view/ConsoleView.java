package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import controller.facade.MineSweeper;
import exception.AreaDiscoveredException;
import exception.MineException;
import exception.OutOfDeskException;
import model.Desk;

/**
 * @author mathieu
 *
 */
public class ConsoleView 
implements DeskView{

	private Desk d;
	final static Logger logger = Logger.getLogger(ConsoleView.class);
	private static Scanner reader;
	
	private MineSweeper mineSweeper;
	
	@Override
	public void displayDesk(Desk d, MineSweeper mineSweeper) {
		
		setD(d);
		setMineSweeper(mineSweeper);
		
		
		boolean loop=true;
		reader = new Scanner(System.in);
		
		do {
			
			DisplayBoard(d);
			
			int row = 0, col = 0, action = 0;
			
			while (loop)
		    {
		    	 try {
		    		 System.out.print("Enter an action 1:open; 2:mark; 3:quit: ");
		    		 action = reader.nextInt();
		    		 logger.debug("action selected: " + action);
		             loop = false;
		    	 } catch (InputMismatchException e) {
		             System.out.println("Invalid value!");
		        } 
		    }
		    loop= true;
			
			while (loop)
		    {
		    	 try {
		    		 System.out.print("Enter a row: ");
		    		 row = reader.nextInt();
		    		 logger.debug("row selected: " + row);
		    		 loop = false;
		    	 } catch (InputMismatchException e) {
		    		 System.out.print("Invalid value!");
		        } 
		    }
		    loop= true;
		    while (loop)
		    {
		    	 try {
		    		 System.out.print("Enter a col: ");
		             col = reader.nextInt();
		             logger.debug("col selected: " + col);
		             loop = false;
		    	 } catch (InputMismatchException e) {
		    		 System.out.print("Invalid value!");
		        } 
		    }
		    loop= true;
		    
		    if(action == 1)
		    {
		    	try {
		    		mineSweeper.discoverArea(d, row, col);
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
		    	mineSweeper.indicateArea(d, row, col);
		    }
		    else if(action == 3)
		    {
		    	System.exit(0);
		    }
		    else
		    {
		    	System.out.print("--- Invalid action!---");
		    }			
			
		}
		while(!mineSweeper.IsFinished(d));
		
		System.out.print("--- You've found the result. ---");
		DisplayBoard(d);
		logger.info("--- End ---");
			
		
	}
	
	
	public void DisplayBoard(Desk d){
	
		for(int i =0; i<d.getHeight(); i++)
		{
			String line ="[ ";
			for(int j=0; j<d.getWidth(); j++)
			{
				line = j==0? line +" " + d.getMyDesk()[i][j].getDisplayState()  : line  +" | " +  d.getMyDesk()[i][j].getDisplayState();
			}
			line = line + " ]";
			System.out.println(line);
		}
	}


	public Desk getD() {
		return d;
	}


	public void setD(Desk d) {
		this.d = d;
	}


	public MineSweeper getMineSweeper() {
		return mineSweeper;
	}


	public void setMineSweeper(MineSweeper mineSweeper) {
		this.mineSweeper = mineSweeper;
	}
	
	

}
