package view;

import model.Desk;

public class ConsoleView 
implements DeskView{

	@Override
	public void displayDesk(Desk d) {
		
		
		// TODO with displayState
		
		for(int i =0; i<d.getHeight(); i++)
		{
			String line ="";
			for(int j=0; j<d.getWidth(); j++)
			{
				line = line +" " +  d.getMyDesk()[i][j].getBackgroundState();
			}
			System.out.println(line);
		}
	}

}
