package ivanwidjanarko.jwork;

/**
 * Class for Invoice Not Found Exception
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public class InvoiceNotFoundException extends Exception {
    private final int invoice_error;

    /**
     * Constructor for class InvoiceNotFoundException
     * @param invoice_input Invoice Input
     */
    public InvoiceNotFoundException(int invoice_input) {
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }

    /**
     * Method for get the exception message
     * @return    exception message
     */
    public String getMessage() {
        return super.getMessage() + invoice_error + " not found";
    }
}
