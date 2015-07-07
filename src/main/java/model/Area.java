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
	
	

	
	public Area(Integer positionX, Integer positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		//TODO add displayState
		this.backgroundState = BackgroundState.EMPTY;
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
