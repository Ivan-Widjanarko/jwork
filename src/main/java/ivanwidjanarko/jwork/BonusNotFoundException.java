package ivanwidjanarko.jwork;

/**
 * Class for BonusNotFoundException
 *
 * @author Ivan Widjanarko
 * @version 18-05-2021
 */

public class BonusNotFoundException extends Exception {
    private int bonus_error;

    /**
     * Constructor for class BonusNotFoundException
     * @param bonus_input Bonus Input
     */
    public BonusNotFoundException(int bonus_input) {
        super("Bonus ID: ");
        bonus_error = bonus_input;
    }

    /**
     * method for getMessage
     * @return    Message
     */
    public String getMessage() {
        return super.getMessage() + bonus_error + " not found";
    }
}
