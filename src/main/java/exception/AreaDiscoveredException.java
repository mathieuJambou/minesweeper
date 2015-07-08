package exception;

/**
 * @author mathieu
 *
 */
public class AreaDiscoveredException  	extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AreaDiscoveredException() {
        super("The area is already discovered");
    }
}
