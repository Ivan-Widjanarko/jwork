import java.util.ArrayList;

/**
 * Class for DatabaseInvoice
 *
 * @author Ivan Widjanarko
 * @version 05-05-2021
 */
public class DatabaseInvoice
{
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;

    /**
     * method for getInvoiceDatabase
     * @return RECRUITER_DATABASE
     */
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }

    /**
     * method for getLastId
     * @return    lastId
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * method for getInvoiceById
     * @param id Invoice ID
     * @return returnObject
     */
    public static Invoice getInvoiceById(int id)
    {
        Invoice returnObject = null;
        for(Invoice recruiterObject: INVOICE_DATABASE)
        {
            if(recruiterObject.getId() == id)
            {
                returnObject = recruiterObject;
            }
        }
        return returnObject;
    }

    /**
     * method for getInvoiceByJobseeker
     * @param jobseekerId Jobseeker's ID
     * @return    returnObject
     */
    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId)
    {
        ArrayList<Invoice> returnObject = new ArrayList<Invoice>();
        for(Invoice invoiceObject: INVOICE_DATABASE)
        {
            if(invoiceObject.getJobseeker().getId() == jobseekerId)
            {
                returnObject.add(invoiceObject);
            }
        }
        return returnObject;
    }

    /**
     * method for addInvoice
     * @param invoice Invoice
     * @return INVOICE_DATABASE.add(invoice)
     */
    public static boolean addInvoice(Invoice invoice)
    {
        for(Invoice invoiceObject: INVOICE_DATABASE)
        {
            if(invoiceObject.getJobseeker() == invoice.getJobseeker() && invoiceObject.getInvoiceStatus() == InvoiceStatus.OnGoing)
            {
                return false;
            }
        }
        lastId = invoice.getId();
        return INVOICE_DATABASE.add(invoice);
    }

    /**
     * method for changeInvoiceStatus
     * @param id Bonus ID
     * @param invoiceStatus Invoice Status
     * @return    boolean
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for(Invoice invoiceObject: INVOICE_DATABASE) {
            if (invoiceObject.getId() == id && invoiceObject.getInvoiceStatus() == InvoiceStatus.OnGoing) {
                invoiceObject.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    /**
     * method for removeInvoice
     * @param id Invoice ID
     * @return    boolean
     */
    public static boolean removeInvoice(int id)
    {
        return INVOICE_DATABASE.removeIf(invoice -> invoice.getId() == id);
    }
}