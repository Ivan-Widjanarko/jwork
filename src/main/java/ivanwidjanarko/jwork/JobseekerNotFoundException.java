package ivanwidjanarko.jwork;

/**
 * Class for JobseekerNotFoundException
 *
 * @author Ivan Widjanarko
 * @version 18-05-2021
 */

public class JobseekerNotFoundException extends Exception {
    private int jobseeker_error;

    /**
     * Constructor for class JobseekerNotFoundException
     * @param jobseeker_input Job Input
     */
    public JobseekerNotFoundException(int jobseeker_input) {
        super("Jobseeker ID: ");
        jobseeker_error = jobseeker_input;
    }

    /**
     * method for getMessage
     * @return    Message
     */
    public String getMessage() {
        return super.getMessage() + jobseeker_error + " not found";
    }
}
