/**
 * Class for JWork
 *
 * @author Ivan Widjanarko
 * @version 01-04-2021
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
        Bonus bonusOne = new Bonus(1, "VANKO123", 10, 150, true);
        Bonus bonusTwo = new Bonus(2, "VANKO456", 10, 50, true);
        EwalletPayment EPayOne = new EwalletPayment(1, jobOne, "01-04-2021", jobseekerOne, InvoiceStatus.OnGoing);
        EwalletPayment EPayTwo = new EwalletPayment(2, jobOne, "01-04-2021", jobseekerOne, bonusOne, InvoiceStatus.OnGoing);
        EwalletPayment EPayThree = new EwalletPayment(3, jobOne, "01-04-2021", jobseekerOne, bonusTwo, InvoiceStatus.OnGoing);
        
        EPayOne.setTotalFee();
        EPayTwo.setTotalFee();
        EPayThree.setTotalFee();
        EPayOne.printData();
        EPayTwo.printData();
        EPayThree.printData();
    }
}
