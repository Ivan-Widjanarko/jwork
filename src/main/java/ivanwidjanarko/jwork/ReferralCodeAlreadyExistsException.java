package ivanwidjanarko.jwork;

/**
 * Class for Referral Code Already Exists Exception
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */

public class ReferralCodeAlreadyExistsException extends Exception {
    private Bonus referral_error;

    /**
     * Constructor for class ReferralCodeAlreadyExistsException
     * @param referral_input Referral Input
     */
    public ReferralCodeAlreadyExistsException(Bonus referral_input) {
        super("Referral Code: ");
        referral_error = referral_input;
    }

    /**
     * Method for get the exception message
     * @return    exception message
     */
    public String getMessage() {
        return super.getMessage() + referral_error.getReferralCode() + " already exists.";
    }
}
