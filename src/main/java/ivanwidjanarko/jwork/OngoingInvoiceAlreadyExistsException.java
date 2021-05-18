package ivanwidjanarko.jwork;

/**
 * Class for OngoingInvoiceAlreadyExistsException
 *
 * @author Ivan Widjanarko
 * @version 18-05-2021
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
     * method for getMessage
     * @return    Message
     */
    public String getMessage() {
        return super.getMessage() + " already exists.";
    }
}