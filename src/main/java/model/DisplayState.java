package model;

/**
 * @author mathieu
 *
 */
public enum DisplayState {

	/**
	 * Different state of the display of a area
	 * Either he is hide or marked or has the number of the mines around
	 */
	HIDE("hide"), MARK("mark"), ZERO("0"), ONE("1"), TWO("2"),THREE("3"),FOUR("4"),FIVE("5"),SIX("6"),SEVEN("7"),EIGHT("8");

	private String name = "";
	   
	DisplayState(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }

}
