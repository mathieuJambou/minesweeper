package view;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
public class SwingView implements DeskView{

	private Desk desk;
	private JFrame mineSweeperWindow;
	private MineSweeper mineSweeper;
	final static Logger logger = Logger.getLogger(ConsoleView.class);
	
	@Override
	public void displayDesk(Desk d,  MineSweeper mineSweeper) {
		
		setDesk(d);
		setMineSweeper(mineSweeper);
		
		mineSweeperWindow = new JFrame();
		mineSweeperWindow.setTitle("Mines weeper");
		mineSweeperWindow.setSize(800, 600);
		mineSweeperWindow.setResizable(false);
		mineSweeperWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mineSweeperWindow.setLocationRelativeTo(null);
		
		MinesPanel minesPanel = new MinesPanel();
		mineSweeperWindow.add(minesPanel);
		
		mineSweeperWindow.setVisible(true);
	}
	
	public class MinesPanel extends JPanel 
	{
	    /**
		 * 
		 */
		private static final long serialVersionUID = -6552384886987090696L;
		
		private JButton Areas[][];

	    /*
	     * Define the layout the Desk
	     */
	    public MinesPanel() 
	    {
	        setLayout(new GridLayout(desk.getHeight(), desk.getWidth()));
	        Areas = new JButton[desk.getHeight()][desk.getWidth()];

	        buildButtons();
	    }
	    
	    /*
	     * Build the Desk
	     */
	    public void buildButtons()
	    {
	        for(int i = 0; i < desk.getHeight(); i++)
	        {
	            for(int j = 0; j < desk.getWidth(); j++)
	            {
	            	Areas[i][j] = new JButton(desk.getMyDesk()[i][j].getDisplayState().toString());
	            	Areas[i][j].addMouseListener(new MouseHandler(i,j));
	                add(Areas[i][j]);
	            }
	        }
	    }
	    
	    /*
	     * Define the events
	     */
	    private class MouseHandler extends MouseAdapter
	    {
	    	
	    	private  int i, j; 
	        public MouseHandler(int i, int j)
	        {
	            this.i = i;
	            this.j = j;
	        }

	    	public void mouseClicked(MouseEvent e)
	    	{
	    		/*
	    		 * Catch the left click
	    		 */
	    		if(e.getButton() == 1)
	    		{
	    			try {
	    				mineSweeper.discoverArea(desk, i, j);
			    		
			    		for(int u=0; u<desk.getHeight(); u++)
			    		{
			    			for(int v=0; v<desk.getWidth(); v++)
			    			{
			    				Areas[u][v].setText(desk.getMyDesk()[u][v].getDisplayState().toString());
			    			}
			    		}
			    	}
			    	catch( OutOfDeskException ex)
			    	{
			    		System.out.println(ex.getMessage());
			    	} 
			    	catch (AreaDiscoveredException ex) 
			    	{
			    		System.out.println(ex.getMessage());
					} 
			    	catch (MineException ex) 
			    	{
						System.out.println(ex.getMessage());
						System.exit(0);
					}
	    	    }
	    		
	    		/*
	    		 * Catch the right click
	    		 */
	    		else if(e.getButton() == 3)
	    		{
	    			mineSweeper.indicateArea(desk, i, j);
	    			
	    			Areas[i][j].setText(desk.getMyDesk()[i][j].getDisplayState().toString());
	    		}
	    		
	    		/*
	    		 * Check the state of the game
	    		 */
	    		if(mineSweeper.IsFinished(desk))
	    		{
	    			System.out.println("You've found the result.");
	    			System.exit(0);
	    		}
    	    }
	    }
	}

	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	public JFrame getMineSweeperWindow() {
		return mineSweeperWindow;
	}

	public void setMineSweeperWindow(JFrame mineSweeperWindow) {
		this.mineSweeperWindow = mineSweeperWindow;
	}

	public MineSweeper getMineSweeper() {
		return mineSweeper;
	}

	public void setMineSweeper(MineSweeper mineSweeper) {
		this.mineSweeper = mineSweeper;
	}
	
}
