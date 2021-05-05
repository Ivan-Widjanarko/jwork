import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Abstract sub-class for BankPayment from super-class Invoice
 *
 * @author Ivan Widjanarko
 * @version 05-05-2021
 */
public class BankPayment extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;
    
    /**
     * Constructor 1 for objects of class BankPayment
     * @param id Jobseeker's ID
     * @param jobs Job
     * @param jobseeker Jobseeker Information
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
     * @param adminFee Admin Fee
     */
    public void setAdminFee(int adminFee)
    {
        this.adminFee = adminFee;
    }
    
    /**
     * method for setTotalFee
     */
    @Override
    public void setTotalFee()
    {
        if(adminFee != 0)
        {
            totalFee = 0;
            for(Job job: getJobs())
            {
                totalFee += job.getFee();
            }
            totalFee -= adminFee;
        }
        else
        {
            totalFee = 0;
            for(Job job: getJobs())
            {
                totalFee += job.getFee();
            }
        }
    }
    
    /**method for print detail*/
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
