
/**
 * Enumeration class for InvoiceStatus
 *
 * @author Ivan Widjanarko
 * @version 05-05-2021
 */
public enum InvoiceStatus
{
    OnGoing("On Going"),
    Finished("Finished"),
    Cancelled("Cancelled");
    
    private String invoiceStatus;
    
    InvoiceStatus(String invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }
    
    public String toString(){
        return invoiceStatus;
    }
}
