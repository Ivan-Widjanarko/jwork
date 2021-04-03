/**
 * Class for JWork
 *
 * @author Ivan Widjanarko
 * @version 03-04-2021
 */

public class JWork
{
    /**
     * method for entry point (main method)
     * @param  args  List String Arguments
     */
    
    public static void main(String[] args)
    {
        Location locationOne = new Location("DKI Jakarta", "Depok", "Ivan's House");
        Recruiter recruiterOne = new Recruiter(1806148706, "Ivan", "ivan@ui.ac.id", "08558069151", locationOne);
        Job jobOne = new Job(1806148706, "Programmer", recruiterOne, 100, JobCategory.WebDeveloper);
        Jobseeker jobseekerOne = new Jobseeker(1806148706, "Widjanarko", "widjanarko@ui.ac.id", "123456", "18-03-2021");
        Bonus bonusOne = new Bonus(1, "VANKO123", 10, 110, true);
        Bonus bonusTwo = new Bonus(2, "VANKO456", 10, 60, true);
        EwalletPayment EPayOne = new EwalletPayment(1, jobOne, "01-04-2021", jobseekerOne, InvoiceStatus.OnGoing);
        EwalletPayment EPayTwo = new EwalletPayment(2, jobOne, "01-04-2021", jobseekerOne, bonusOne, InvoiceStatus.Finished);
        EwalletPayment EPayThree = new EwalletPayment(3, jobOne, "01-04-2021", jobseekerOne, bonusTwo, InvoiceStatus.Cancelled);
        BankPayment BPayOne = new BankPayment(1, jobOne, "03-04-2021", jobseekerOne, InvoiceStatus.Finished);
        BankPayment BPayTwo = new BankPayment(2, jobOne, "03-04-2021", jobseekerOne, InvoiceStatus.Finished, 10);
        
        //EPayOne.setTotalFee();
        //EPayTwo.setTotalFee();
        //EPayThree.setTotalFee();
        BPayOne.setTotalFee();
        BPayTwo.setTotalFee();
        
        //EPayOne.printData();
        //EPayTwo.printData();
        //EPayThree.printData();
        BPayOne.printData();
        BPayTwo.printData();
    }
}
