/**
 * Class for InvoiceNotFoundException
 *
 * @author Ivan Widjanarko
 * @version 08-05-2021
 */

public class InvoiceNotFoundException extends Exception {
    private int invoice_error;

    /**
     * Constructor for class InvoiceNotFoundException
     * @param invoice_input Invoice Input
     */
    public InvoiceNotFoundException(int invoice_input) {
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }

    /**
     * method for getMessage
     * @return    Message
     */
    public String getMessage() {
        return super.getMessage() + invoice_error + " not found";
    }
}
