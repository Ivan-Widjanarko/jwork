package ivanwidjanarko.jwork;

/**
 * Enumeration class for Invoice's Status
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public enum InvoiceStatus
{
    OnGoing("On Going"),
    Finished("Finished"),
    Canceled("Canceled");

    /**
     * Method for set invoice's status
     */
    private final String invoiceStatus;

    /**
     * Method for get invoice's status
     * @param invoiceStatus invoice's status
     */
    InvoiceStatus(String invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * Method for print invoice status' detail
     * @return invoice's status
     */
    public String toString(){
        return invoiceStatus;
    }
}
