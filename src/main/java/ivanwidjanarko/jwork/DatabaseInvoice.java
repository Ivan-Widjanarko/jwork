package ivanwidjanarko.jwork;

import java.util.ArrayList;

/**
 * Class for DatabaseInvoice
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public class DatabaseInvoice
{
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;

    /**
     * Method for get Invoice's Database
     * @return    Array List of INVOICE_DATABASE
     */
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }

    /**
     * Method for get Last ID from Invoice's Database
     * @return    last ID
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Method for get invoice by its ID
     * @param id Invoice's ID
     * @return    invoice
     * @throws InvoiceNotFoundException Exception if Invoice not found
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException
    {
        Invoice returnObject = null;
        for(Invoice recruiterObject: INVOICE_DATABASE)
        {
            if(recruiterObject.getId() == id)
            {
                returnObject = recruiterObject;
            }
        }
        if (returnObject == null) {
            throw new InvoiceNotFoundException(id);
        } else {
            return returnObject;
        }
    }

    /**
     * Method for get invoice by Jobseeker's ID
     * @param jobseekerId Jobseeker's ID
     * @return    invoice
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
     * Method for add Invoice into database
     * @param invoice Invoice
     * @return invoice addition status
     * @throws OngoingInvoiceAlreadyExistsException Exception if Ongoing Invoice already exists
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException
    {
        for(Invoice invoiceObject: INVOICE_DATABASE)
        {
            if(invoiceObject.getJobseeker() == invoice.getJobseeker() && invoiceObject.getInvoiceStatus() == InvoiceStatus.OnGoing)
            {
                throw new OngoingInvoiceAlreadyExistsException(invoiceObject);
            }
        }
        lastId = invoice.getId();
        return INVOICE_DATABASE.add(invoice);
    }

    /**
     * Method for change the invoice's status
     * @param id Invoice's ID
     * @param invoiceStatus Invoice Status
     * @return    invoice change status
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
     * Method for remove the invoice from database
     * @param id Invoice's ID
     * @return    invoice deletion status
     * @throws InvoiceNotFoundException Exception if Invoice not found
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        boolean status = false;
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getId() == id)
            {
                INVOICE_DATABASE.remove(invoice);
                status = true;
            }
        }
        if(status == false)
        {
            InvoiceNotFoundException e = new InvoiceNotFoundException(id);
            System.out.println(e.getMessage());
        }
        return status;
    }
}