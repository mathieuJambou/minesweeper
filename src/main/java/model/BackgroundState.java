package model;

public enum BackgroundState {

	EMPTY("empty"), MINE("mine");
	
	
	private String name = "";
	   
	BackgroundState(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }
	  
}
