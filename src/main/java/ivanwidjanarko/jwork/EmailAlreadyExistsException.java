package ivanwidjanarko.jwork;

/**
 * Class for Email Already Exists Exception
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */

public class EmailAlreadyExistsException extends Exception {
    private final Jobseeker jobseeker_error;

    /**
     * Constructor for class EmailAlreadyExistsException
     * @param jobseeker_input Jobseeker Input
     */
    public EmailAlreadyExistsException(Jobseeker jobseeker_input) {
        super("Jobseeker Email: ");
        jobseeker_error = jobseeker_input;
    }

    /**
     * Method for get the exception message
     * @return    exception message
     */
    public String getMessage() {
        return super.getMessage() + jobseeker_error.getEmail() + " already exists.";
    }
}
