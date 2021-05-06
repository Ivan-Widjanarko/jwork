/**
 * Class for JobNotFoundException
 *
 * @author Ivan Widjanarko
 * @version 06-05-2021
 */

public class JobNotFoundException extends Exception {
    private int job_error;

    /**
     * Constructor for class JobNotFoundException
     * @param job_input Job Input
     */
    public JobNotFoundException(int job_input) {
        super("Job ID: ");
        job_error = job_input;
    }

    /**
     * method for getMessage
     * @return    Message
     */
    public String getMessage() {
        return super.getMessage() + job_error + " not found";
    }
}
