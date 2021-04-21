import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Abstract class for Invoice
 *
 * @author Ivan Widjanarko
 * @version 01-04-2021
 */
abstract class Invoice
{
    private int id;
    protected int totalFee;
    private Job job;
    private Calendar date;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor for objects of class Invoice
     * @param id Jobseeker's ID
     * @param job Job
     * @param date Date of Invoice
     * @param jobseeker Jobseeker Information
     * @param status Invoice's Status
     */
    public Invoice(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        this.id = id;
        this.job = job;
        this.jobseeker = jobseeker;
        this.invoiceStatus = invoiceStatus;
        date = Calendar.getInstance();
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
     * method for getJob
     * @return    Job
     */
    public Job getJob()
    {
        return job;
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
     * method for setIdJob
     * @param idJob Job's ID
     */
    public void setJob(Job job)
    {
        this.job = job;
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
     * @return    Date when the Jobseeker join the app
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
