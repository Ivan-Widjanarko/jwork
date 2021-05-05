import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Abstract sub-class for EwalletPayment from super-class Invoice
 *
 * @author Ivan Widjanarko
 * @version 05-05-2021
 */
public class EwalletPayment extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;
    
    /**
     * Constructor 1 for objects of class EwalletPayment
     * @param id Jobseeker's ID
     * @param jobs Job
     * @param jobseeker Jobseeker Information
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        super(id, jobs, jobseeker);
    }
    
    /**
     * Constructor 2 for objects of class EwalletPayment
     * @param id Jobseeker's ID
     * @param jobs Job
     * @param jobseeker Jobseeker Information
     * @param bonus Bonus
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Bonus bonus)
    {
        super(id, jobs, jobseeker);
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
     */
    @Override
    public void setTotalFee()
    {
        int total = 0;
        for(Job job: getJobs())
        {
            total += job.getFee();
        }
        if(bonus instanceof Bonus && bonus.getActive() && total > bonus.getMinTotalFee())
        {
            totalFee = total + bonus.getExtraFee();
        }
        else
        {
            totalFee = total;
        }
    }
    
    /**method for print detail*/
    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            
        String value = "===================== INVOICE =====================" + "\n" +
            "Id = " + getId() + "\n" +
                "Job: ";;

        for(Job job: getJobs())
        {
            value += job.getName() + ", ";
        }

        value +=
            "\nDate: " + sdf.format(getDate().getTime()) + "\n" +
            "Job Seeker: " + getJobseeker().getName() + "\n";
        
        if (bonus instanceof Bonus && bonus.getActive() && totalFee >= bonus.getMinTotalFee()) {
            value += "Referral Code: " + bonus.getReferralCode() + "\n";
        }
        
        value += "Total Fee: " + super.totalFee + "\n" +
            "Status: " + getInvoiceStatus().toString() + "\n" +
            "Payment Type: " + PAYMENT_TYPE.toString() + "\n";
            
        return value;
    }
}
