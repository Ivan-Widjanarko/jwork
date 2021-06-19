package ivanwidjanarko.jwork;

/**
 * Class for Ongoing Invoice Already Exists Exception
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */

public class OngoingInvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

    /**
     * Constructor for class OngoingInvoiceAlreadyExistsException
     * @param invoice_input Invoice Input
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input) {
        super("Ongoing Invoice ");
        invoice_error = invoice_input;
    }

    /**
     * Method for get the exception message
     * @return    exception message
     */
    public String getMessage() {
        return super.getMessage() + " already exists.";
    }
}