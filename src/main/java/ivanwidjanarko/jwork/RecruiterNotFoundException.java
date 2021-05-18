package ivanwidjanarko.jwork;

/**
 * Class for RecruiterNotFoundException
 *
 * @author Ivan Widjanarko
 * @version 18-05-2021
 */

public class RecruiterNotFoundException extends Exception {
    private int recruiter_error;

    /**
     * Constructor for class RecruiterNotFoundException
     * @param recruiter_input Job Input
     */
    public RecruiterNotFoundException(int recruiter_input) {
        super("Recruiter ID: ");
        recruiter_error = recruiter_input;
    }

    /**
     * method for getMessage
     * @return    Message
     */
    public String getMessage() {
        return super.getMessage() + recruiter_error + " not found";
    }
}
