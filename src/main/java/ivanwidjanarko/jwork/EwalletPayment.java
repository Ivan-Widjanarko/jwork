package ivanwidjanarko.jwork;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Abstract sub-class for E-wallet Payment from super-class of Invoice
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public class EwalletPayment extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;
    
    /**
     * Constructor 1 for objects of class E-walletPayment
     * @param id Invoice's ID
     * @param jobs Job
     * @param jobseeker Jobseeker
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        super(id, jobs, jobseeker);
    }
    
    /**
     * Constructor 2 for objects of class E-walletPayment
     * @param id Invoice's ID
     * @param jobs Job
     * @param jobseeker Jobseeker
     * @param bonus Bonus
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Bonus bonus)
    {
        super(id, jobs, jobseeker);
        this.bonus = bonus;
    }

    /**
     * Method for get payment type, in this case E-wallet Payment ad the payment type
     * @return    Payment Type
     */
    @Override public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }

    /**
     * Method for get bonus
     * @return    bonus
     */
    public Bonus getBonus()
    {
        return bonus;
    }
    
    /**
     * Method for set bonus
     * @param bonus Bonus
     */
    public void setBonus(Bonus bonus)
    {
        this.bonus = bonus;
    }

    /**
     * Method for set the total fee
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

    /**
     * Method for print e-wallet payment's detail
     * @return details
     */
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
