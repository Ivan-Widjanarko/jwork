
/**
 * Class for Invoice
 *
 * @author Ivan Widjanarko
 * @version 27-03-2021
 */
public class Invoice
{
    private int id, idJob, totalFee;
    private String date;
    private Jobseeker jobseeker;
    private PaymentType paymentType;
    private InvoiceStatus status;

    /**
     * Constructor for objects of class Invoice
     * @param id Jobseeker's ID
     * @param idJob Job's ID
     * @param date Date of Invoice
     * @param totalFee Total of Fee
     * @param jobseeker Jobseeker Information
     * @param totalPrice Total of price
     * @param status Invoice's Status
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker, PaymentType paymentType, InvoiceStatus status)
    {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
        this.paymentType = paymentType;
        this.status = status;
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
     * method for getIdJob
     * @return    Job's ID
     */
    public int getIdJob()
    {
        return idJob;
    }
    
    /**
     * method for getDate
     * @return    Date of Invoice
     */
    public String getDate()
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
     * method for getPaymentType
     * @return    Type of Payment
     */
    public PaymentType getPaymentType()
    {
        return paymentType;
    }
    
    /**
     * method for getInvoiceStatus
     * @return    Invoice's Status
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return status;
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
    public void setIdJob(int idJob)
    {
        this.idJob = idJob;
    }
    
    /**
     * method for setDate
     * @param date Date of Invoice
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    
    /**
     * method for setTotalFee
     * @param totalFee Total of Fee
     */
    public void setTotalFee(int totalFee)
    {
        this.totalFee = totalFee;
    }
    
    /**
     * method for setJobseeker
     * @param jobseeker Jobseeker Information
     */
    public void setJobseeeker(Jobseeker jobseeker)
    {
        this.jobseeker = jobseeker;
    }
    
    /**
     * method for setPaymentType
     * @param paymentType Type of Payment
     */
    public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    
    /**
     * method for setInvoiceStatus
     * @param invoiceStatus Invoice's Status
     */
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status = status;
    }
    
    /**method for print Total Fee*/
    public void printData()
    {
        System.out.println("===================== INVOICE =====================");
        System.out.println("ID: " + id);
        System.out.println("ID Job: " + idJob);
        System.out.println("Date: " + date);
        System.out.println("Seeker: " + jobseeker.getName());
        System.out.println("Fee: " + totalFee);
        System.out.println("Status: " + status.toString());
    }
}
