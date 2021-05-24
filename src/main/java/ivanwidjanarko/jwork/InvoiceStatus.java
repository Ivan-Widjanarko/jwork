package ivanwidjanarko.jwork;

/**
 * Enumeration class for InvoiceStatus
 *
 * @author Ivan Widjanarko
 * @version 24-05-2021
 */
public enum InvoiceStatus
{
    OnGoing("On Going"),
    Finished("Finished"),
    Canceled("Canceled");
    
    private String invoiceStatus;
    
    InvoiceStatus(String invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }
    
    public String toString(){
        return invoiceStatus;
    }
}
