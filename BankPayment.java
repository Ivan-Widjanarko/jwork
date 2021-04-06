
/**
 * Abstract sub-class for BankPayment from super-class Invoice
 *
 * @author Ivan Widjanarko
 * @version 03-04-2021
 */
public class BankPayment extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;
    
    /**
     * Constructor 1 for objects of class BankPayment
     * @param id Jobseeker's ID
     * @param job Job
     * @param date Date of Invoice
     * @param jobseeker Jobseeker Information
     * @param status Invoice's Status
     */
    public BankPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
    }
    
    /**
     * Constructor 2 for objects of class BankPayment
     * @param id Jobseeker's ID
     * @param job Job
     * @param date Date of Invoice
     * @param jobseeker Jobseeker Information
     * @param bonus Bonus
     * @param status Invoice's Status
     */
    public BankPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus, int adminFee)
    {
        super(id, job, date, jobseeker, invoiceStatus);
        this.adminFee = adminFee;
    }
    
    /**
     * method for getPaymentType
     * @return    Payment Type
     */
    @Override public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    /**
     * method for getAdminFee
     * @return    Bonus
     */
    public int getAdminFee()
    {
        return adminFee;
    }
    
    /**
     * method for setAdminFee
     * @param bonus Bonus
     */
    public void setAdminFee(int adminFee)
    {
        this.adminFee = adminFee;
    }
    
    /**
     * method for setTotalFee
     * @param totalFee Total Fee
     */
    @Override
    public void setTotalFee()
    {
        if(adminFee!=0)
        {
            super.totalFee = super.getJob().getFee() - adminFee;
        }
        else {
            super.totalFee = super.getJob().getFee();
        }
    }
    
    /**method for print */
    @Override
    public void printData()
    {
        System.out.println("===================== INVOICE =====================");
        System.out.println("ID: " + getId());
        System.out.println("Job: " + getJob().getName());
        System.out.println("Date: " + getDate());
        System.out.println("Job Seeker: " + getJobseeker().getName());
        System.out.println("Admin Fee: " + getAdminFee());
        System.out.println("Total Fee: " + super.totalFee);
        System.out.println("Status: " + getInvoiceStatus().toString());
        System.out.println("Payment Type: " + PAYMENT_TYPE.toString());
    }
}
