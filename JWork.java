/**
 * Class for JWork
 *
 * @author Ivan Widjanarko
 * @version 19-03-2021
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
        Job jobOne = new Job(1806148706, "Programmer", recruiterOne, 10000000, JobCategory.WebDeveloper);
        Jobseeker jobseekerOne = new Jobseeker(1806148706, "Widjanarko", "widjanarko@ui.ac.id", "123456", "18-03-2021");
        Invoice invoiceOne = new Invoice(100, jobOne.getId(), "18-03-2021", jobOne.getFee(), jobseekerOne, PaymentType.EwalletPayment, InvoiceStatus.Finished);
        
        System.out.println(recruiterOne.getName());
        recruiterOne.setName("Fajar");
        System.out.println(recruiterOne.getName());
        jobOne.printData();
        invoiceOne.printData();
        
    }
}
