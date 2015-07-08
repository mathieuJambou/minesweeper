package model;


/**
 * @author mathieu
 *
 */
public class Area {

	private Integer positionX;
	private Integer positionY;

	private Enum<DisplayState> displayState;
	private Enum<BackgroundState> backgroundState;
	
	

	
	/**
	 * @param positionX
	 * @param positionY
	 * Default backgroundState is empty
	 * Default displayState is hide
	 */
	public Area(Integer positionX, Integer positionY) {
		super();
		//Verify if positionX/Y are usefull
		this.positionX = positionX;
		this.positionY = positionY;
		this.backgroundState = BackgroundState.EMPTY;
		this.displayState = DisplayState.HIDE;
	}

	public Integer getPositionX() {
		return positionX;
	}

	public void setPositionX(Integer positionX) {
		this.positionX = positionX;
	}

	public Integer getPositionY() {
		return positionY;
	}

	public void setPositionY(Integer positionY) {
		this.positionY = positionY;
	}

	public Enum<DisplayState> getDisplayState() {
		return displayState;
	}

	public void setDisplayState(Enum<DisplayState> displayState) {
		this.displayState = displayState;
	}

	public Enum<BackgroundState> getBackgroundState() {
		return backgroundState;
	}

	public void setBackgroundState(Enum<BackgroundState> backgroundState) {
		this.backgroundState = backgroundState;
	}

}
