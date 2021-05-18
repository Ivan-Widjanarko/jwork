package ivanwidjanarko.jwork;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;

/**
 * Abstract class for Invoice
 *
 * @author Ivan Widjanarko
 * @version 18-05-2021
 */
abstract class Invoice
{
    private int id;
    protected int totalFee;
    private ArrayList<Job> jobs = new ArrayList<Job>();
    private Calendar date;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor for objects of class Invoice
     * @param id Jobseeker's ID
     * @param jobs Job
     * @param jobseeker Jobseeker Information
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
     * method for getId
     * @return    Jobseeker's ID
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * method for getJobs
     * @return    Jobs
     */
    public ArrayList<Job> getJobs()
    {
        return jobs;
    }
    
    /**
     * method for getDate
     * @return    Date of Invoice
     */
    public Calendar getDate()
    {
        return date;
    }
    
    /**
     * method for getTotalFee
     * @return    Total of Fee
     */
    public int getTotalFee()
    {
        return totalFee;
    }
    
    /**
     * method for getJobseeker
     * @return    Jobseeker Information
     */
    public Jobseeker getJobseeker()
    {
        return jobseeker;
    }
    
    /**
     * abstract method for getPaymentType
     * @return null
     */
    public abstract PaymentType getPaymentType();
    
    /**
     * method for getInvoiceStatus
     * @return    Invoice's Status
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }
    
    /**
     * method for setId
     * @param id Jobseeker's ID
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * method for setJobs
     * @param jobs Job
     */
    public void setJobs(ArrayList<Job> jobs)
    {
        this.jobs = jobs;
    }
    
    /**
     * method for setDate
     * @param date Date when the Jobseeker join the app
     */
    public void setDate(Calendar date)
    {
        this.date = date;
    }
    
    /**
     * method for setDate
     * @param year Year of Join Date
     * @param month Month of Join Date
     * @param dayOfMonth Day of Join Date
     */
    public void setDate(int year, int month, int dayOfMonth)
    {
        date = new GregorianCalendar(year, month, dayOfMonth);
    }
    
    /**
     * abstract method for setTotalFee
     */
    public abstract void setTotalFee();
    
    /**
     * method for setJobseeker
     * @param jobseeker Jobseeker Information
     */
    public void setJobseeeker(Jobseeker jobseeker)
    {
        this.jobseeker = jobseeker;
    }
    
    /**
     * method for setInvoiceStatus
     * @param invoiceStatus Invoice's Status
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }
    
    /**abstract method for print Data*/
    public abstract String toString();
}
