import java.text.SimpleDateFormat;

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
    public EwalletPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, jobseeker, invoiceStatus);
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
    public EwalletPayment(int id, Job job, Jobseeker jobseeker, Bonus bonus, InvoiceStatus invoiceStatus)
    {
        super(id, job, jobseeker, invoiceStatus);
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
    
    /**method for print detail*/
    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            
        String value = "===================== INVOICE =====================" + "\n" +
            "Id = " + getId() + "\n" +
            "Job: " + getJob().getName() + "\n" +
            "Date: " + sdf.format(getDate().getTime()) + "\n" +
            "Job Seeker: " + getJobseeker().getName() + "\n";
        
        if (bonus instanceof Bonus && bonus.getActive() && getJob().getFee() >= bonus.getMinTotalFee()) {
            value += "Referral Code: " + bonus.getReferralCode() + "\n";
        }
        
        value += "Total Fee: " + super.totalFee + "\n" +
            "Status: " + getInvoiceStatus().toString() + "\n" +
            "Payment Type: " + PAYMENT_TYPE.toString() + "\n";
            
        return value;
    }
}
