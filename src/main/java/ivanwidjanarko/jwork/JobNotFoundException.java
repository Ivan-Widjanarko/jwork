package ivanwidjanarko.jwork;

/**
 * Class for Job Not Found Exception
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public class JobNotFoundException extends Exception {
    private final int job_error;

    /**
     * Constructor for class JobNotFoundException
     * @param job_input Job Input
     */
    public JobNotFoundException(int job_input) {
        super("Job ID: ");
        job_error = job_input;
    }

    /**
     * Method for get the exception message
     * @return    exception message
     */
    public String getMessage() {
        return super.getMessage() + job_error + " not found";
    }
}
