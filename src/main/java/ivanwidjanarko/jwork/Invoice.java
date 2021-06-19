package ivanwidjanarko.jwork;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;

/**
 * Abstract class for Invoice
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public abstract class Invoice
{
    private int id;
    protected int totalFee;
    private ArrayList<Job> jobs = new ArrayList<Job>();
    private Calendar date;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor for objects of class Invoice
     * @param id Invoice's ID
     * @param jobs Job
     * @param jobseeker Jobseeker
     */
    public Invoice(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        this.id = id;
        this.jobs = jobs;
        this.invoiceStatus = InvoiceStatus.OnGoing;
        this.date = Calendar.getInstance();
        this.jobseeker = jobseeker;
    }

    /**
     * Method for get invoice's ID
     * @return    invoice's ID
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Method for get jobs
     * @return    Jobs
     */
    public ArrayList<Job> getJobs()
    {
        return jobs;
    }
    
    /**
     * Method for get invoice's date
     * @return    date of the invoice
     */
    public Calendar getDate()
    {
        return date;
    }
    
    /**
     * Method for get total fee
     * @return    Total of the fee
     */
    public int getTotalFee()
    {
        return totalFee;
    }
    
    /**
     * Method for getJobseeker
     * @return    Jobseeker
     */
    public Jobseeker getJobseeker()
    {
        return jobseeker;
    }
    
    /**
     * Abstract method for get payment type
     * @return null
     */
    public abstract PaymentType getPaymentType();
    
    /**
     * Method for get invoice's status
     * @return    Invoice's Status
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }
    
    /**
     * Method for set invoice's ID
     * @param id Invoice's ID
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Method for set jobs
     * @param jobs Job
     */
    public void setJobs(ArrayList<Job> jobs)
    {
        this.jobs = jobs;
    }
    
    /**
     * Method 1 for set invoice's date
     * @param date Date of the invoice
     */
    public void setDate(Calendar date)
    {
        this.date = date;
    }

    /**
     * Method 2 for set invoice's date
     * @param year Year of the invoice
     * @param month Month of the invoice
     * @param dayOfMonth Day of the invoice
     */
    public void setDate(int year, int month, int dayOfMonth)
    {
        date = new GregorianCalendar(year, month, dayOfMonth);
    }

    /**
     * Abstract method for set the total fee
     */
    public abstract void setTotalFee();
    
    /**
     * Method for set jobseeker
     * @param jobseeker Jobseeker
     */
    public void setJobseeeker(Jobseeker jobseeker)
    {
        this.jobseeker = jobseeker;
    }
    
    /**
     * Method for set invoice's status
     * @param invoiceStatus Invoice's Status
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * Abstract method for print invoice's detail
     */
    public abstract String toString();
}
