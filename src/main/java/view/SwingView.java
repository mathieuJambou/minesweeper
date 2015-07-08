package view;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import controller.Finalise;
import controller.Running;
import exception.AreaDiscoveredException;
import exception.MineException;
import exception.OutOfDeskException;
import model.Desk;

public class SwingView implements DeskView{

	private Desk desk;
	private JFrame minesWeeperWindow;
	final static Logger logger = Logger.getLogger(ConsoleView.class);
	
	@Override
	public void displayDesk(Desk d) {
		
		setDesk(d);
		
		minesWeeperWindow = new JFrame();
		minesWeeperWindow.setTitle("Mines weeper");
		minesWeeperWindow.setSize(800, 600);
		minesWeeperWindow.setResizable(false);
		minesWeeperWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		minesWeeperWindow.setLocationRelativeTo(null);
		
		MinesPanel minesPanel = new MinesPanel();
		minesWeeperWindow.add(minesPanel);
		
		minesWeeperWindow.setVisible(true);
	}
	
	public class MinesPanel extends JPanel 
	{
	    private JButton Areas[][];

	    public MinesPanel() 
	    {
	        setLayout(new GridLayout(desk.getHeight(), desk.getWidth()));
	        Areas = new JButton[desk.getHeight()][desk.getWidth()];

	        buildButtons();
	    }
	    
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
	    
	    private class MouseHandler extends MouseAdapter
	    {
	    	
	    	public  int i, j; 
	        public MouseHandler(int i, int j)
	        {
	            this.i = i;
	            this.j = j;
	        }

	    	public void mouseClicked(MouseEvent e)
	    	{
	    		if(e.getButton() == 1)
	    		{
	    			try {
			    		Running.discoverArea(desk, i, j);
			    		
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
	    		else if(e.getButton() == 3)
	    		{
	    			Running.indicateArea(desk, i, j);
	    			
	    			Areas[i][j].setText(desk.getMyDesk()[i][j].getDisplayState().toString());
	    		}
	    		
	    		if(Finalise.IsFinished(desk))
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

	public JFrame getMinesWeeperWindow() {
		return minesWeeperWindow;
	}

	public void setMinesWeeperWindow(JFrame minesWeeperWindow) {
		this.minesWeeperWindow = minesWeeperWindow;
	}
	
}
