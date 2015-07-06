package model;

public class Desk {

	
	private Area[][] myDesk;
	
	private Integer width;
	private Integer height;
	
	
	
	public void createMyDesk(int width, int height)
	{
		
		this.myDesk = new Area[height][width];
		this.height = myDesk.length;
		this.width = myDesk[0].length;
		
		for(int i = 0; i < this.height; i++)
		{
			for(int j = 0; j < this.width; j++)
			{
				this.myDesk[i][j] = new Area(i,j);
			}
		}
		
	}

	public Area[][] getMyDesk() {
		return myDesk;
	}

	public void setMyDesk(Area[][] myDesk) {
		this.myDesk = myDesk;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
	
	
	
}
