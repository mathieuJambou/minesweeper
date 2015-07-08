package exception;

public class OutOfDeskException 	extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6199681556655997394L;

	public OutOfDeskException() {
        super("The coordonates are out of the desk");
    }

}
