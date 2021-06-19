package ivanwidjanarko.jwork;

/**
 * Class for Recruiter Not Found Exception
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */

public class RecruiterNotFoundException extends Exception {
    private final int recruiter_error;

    /**
     * Constructor for class RecruiterNotFoundException
     * @param recruiter_input Job Input
     */
    public RecruiterNotFoundException(int recruiter_input) {
        super("Recruiter ID: ");
        recruiter_error = recruiter_input;
    }

    /**
     * Method for get the exception message
     * @return    exception message
     */
    public String getMessage() {
        return super.getMessage() + recruiter_error + " not found";
    }
}
