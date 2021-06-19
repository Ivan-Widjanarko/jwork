package ivanwidjanarko.jwork;

/**
 * Class for Jobseeker Not Found Exception
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */

public class JobseekerNotFoundException extends Exception {
    private final int jobseeker_error;

    /**
     * Constructor for class JobseekerNotFoundException
     * @param jobseeker_input Job Input
     */
    public JobseekerNotFoundException(int jobseeker_input) {
        super("Jobseeker ID: ");
        jobseeker_error = jobseeker_input;
    }

    /**
     * Method for get the exception message
     * @return    exception message
     */
    public String getMessage() {
        return super.getMessage() + jobseeker_error + " not found";
    }
}
