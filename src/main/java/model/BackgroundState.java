package model;

/**
 * @author mathieu
 *
 */
public enum BackgroundState {

	/**
	 * Different state of the background of a area
	 * Either the area contains a mine or is empty
	 */
	EMPTY("empty"), MINE("mine");
	
	
	private String name = "";
	   
	BackgroundState(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }
	  
}
