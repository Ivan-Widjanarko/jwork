package ivanwidjanarko.jwork;

/**
 * Class for BonusCodeAlreadyExistsException
 *
 * @author Ivan Widjanarko
 * @version 18-05-2021
 */

public class ReferralCodeAlreadyExistsException extends Exception {
    private Bonus referral_error;

    /**
     * Constructor for class ReferralCodeAlreadyExistsException
     * @param referral_input Bonus Input
     */
    public ReferralCodeAlreadyExistsException(Bonus referral_input) {
        super("Referral Code: ");
        referral_error = referral_input;
    }

    /**
     * method for getMessage
     * @return    Message
     */
    public String getMessage() {
        return super.getMessage() + referral_error.getReferralCode() + " already exists.";
    }
}
