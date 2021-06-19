package ivanwidjanarko.jwork;

/**
 * Class for Bonus Not Found Exception
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */

public class BonusNotFoundException extends Exception {
    private final int bonus_error;

    /**
     * Constructor for class BonusNotFoundException
     * @param bonus_input Bonus Input
     */
    public BonusNotFoundException(int bonus_input) {
        super("Bonus ID: ");
        bonus_error = bonus_input;
    }

    /**
     * Method for get the exception message
     * @return    exception message
     */
    public String getMessage() {
        return super.getMessage() + bonus_error + " not found";
    }
}
