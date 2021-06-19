package ivanwidjanarko.jwork;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Abstract sub-class for Bank Payment from super-class of Invoice
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public class BankPayment extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee = 5000;
    
    /**
     * Constructor 1 for objects of class BankPayment
     * @param id Invoice's ID
     * @param jobs Job
     * @param jobseeker Jobseeker
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        super(id, jobs, jobseeker);
    }
    
    /**
     * Constructor 2 for objects of class BankPayment
     * @param id Jobseeker's ID
     * @param jobs Job
     * @param jobseeker Jobseeker Information
     * @param adminFee Administration Fee
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, int adminFee)
    {
        super(id, jobs, jobseeker);
        this.adminFee = adminFee;
    }
    
    /**
     * Method for get payment type, in this case Bank Payment ad the payment type
     * @return    Payment Type
     */
    @Override public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    /**
     * Method for get administration's fee
     * @return    adminFee
     */
    public int getAdminFee()
    {
        return adminFee;
    }
    
    /**
     * Method for set administration's fee
     * @param adminFee Admin Fee
     */
    public void setAdminFee(int adminFee)
    {
        this.adminFee = adminFee;
    }
    
    /**
     * Method for set the total fee
     */
    @Override
    public void setTotalFee()
    {
        if(adminFee != 0)
        {
            for(Job job: getJobs())
            {
                totalFee += job.getFee();
            }
            totalFee -= adminFee;
        }
        else
        {
            for(Job job: getJobs())
            {
                totalFee += job.getFee();
            }
        }
    }
    
    /**
     * Method for print bank payment's detail
     * @return details
     */
    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            
        String value = "===================== INVOICE =====================" + "\n" +
            "ID: " + getId() + "\n" +
            "Job: ";

        for(Job job: getJobs())
        {
            value += job.getName() + ", ";
        }

        value +=
            "\nDate: " + sdf.format(getDate().getTime()) + "\n" +
            "Job Seeker: " + getJobseeker().getName() + "\n" +
            "Admin Fee: " + getAdminFee() + "\n" + 
            "Total Fee: " + super.totalFee + "\n" +
            "Status: " + getInvoiceStatus().toString() + "\n" +
            "Payment Type: " + PAYMENT_TYPE.toString() + "\n";

        return value;
    }
}
