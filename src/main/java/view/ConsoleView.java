package view;

import model.Desk;

public class ConsoleView 
implements DeskView{

	@Override
	public void displayDesk(Desk d) {
		
		
		// TODO with displayState
		
		for(int i =0; i<d.getHeight(); i++)
		{
			String line ="[ ";
			for(int j=0; j<d.getWidth(); j++)
			{
				line = j==0? line +" " + d.getMyDesk()[i][j].getBackgroundState()  : line  +" | " +  d.getMyDesk()[i][j].getBackgroundState();
			}
			line = line + " ]";
			System.out.println(line);
		}
		
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

}
