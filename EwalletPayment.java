
/**
 * Abstract sub-class for EwalletPayment from super-class Invoice
 *
 * @author Ivan Widjanarko
 * @version 01-04-2021
 */
public class EwalletPayment extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;
    
    /**
     * Constructor 1 for objects of class EwalletPayment
     * @param id Jobseeker's ID
     * @param job Job
     * @param date Date of Invoice
     * @param jobseeker Jobseeker Information
     * @param status Invoice's Status
     */
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
    }
    
    /**
     * Constructor 2 for objects of class EwalletPayment
     * @param id Jobseeker's ID
     * @param job Job
     * @param date Date of Invoice
     * @param jobseeker Jobseeker Information
     * @param bonus Bonus
     * @param status Invoice's Status
     */
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, Bonus bonus, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
        this.bonus = bonus;
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
     * method for getBonus
     * @return    Bonus
     */
    public Bonus getBonus()
    {
        return bonus;
    }
    
    /**
     * method for setBonus
     * @param bonus Bonus
     */
    public void setBonus(Bonus bonus)
    {
        this.bonus = bonus;
    }
    
    /**
     * method for setTotalFee
     * @param totalFee Total Fee
     */
    @Override
    public void setTotalFee()
    {
        if(bonus instanceof Bonus && bonus.getActive() && getJob().getFee() >= bonus.getMinTotalFee())
        {
            super.totalFee = super.getJob().getFee() + bonus.getExtraFee();
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
        if (bonus instanceof Bonus && bonus.getActive() && getJob().getFee() >= bonus.getMinTotalFee()) {
            System.out.println("Referral Code: " + bonus.getReferralCode());
        }
        System.out.println("Total Fee: " + super.totalFee);
        System.out.println("Status: " + getInvoiceStatus().toString());
        System.out.println("Payment Type: " + PAYMENT_TYPE.toString());
    }
}
