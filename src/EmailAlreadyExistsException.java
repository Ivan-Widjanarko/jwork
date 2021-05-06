/**
 * Class for EmailAlreadyExistsException
 *
 * @author Ivan Widjanarko
 * @version 06-05-2021
 */

public class EmailAlreadyExistsException extends Exception {
    private Jobseeker jobseeker_error;

    /**
     * Constructor for class EmailAlreadyExistsException
     * @param jobseeker_input Jobseeker Input
     */
    public EmailAlreadyExistsException(Jobseeker jobseeker_input) {
        super("Jobseeker Email: ");
        jobseeker_error = jobseeker_input;
    }

    /**
     * method for getMessage
     * @return    Message
     */
    public String getMessage() {
        return super.getMessage() + jobseeker_error.getEmail() + " already exists.";
    }
}
