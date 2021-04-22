import java.util.GregorianCalendar;

/**
 * Class for JWork
 *
 * @author Ivan Widjanarko
 * @version 22-04-2021
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
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Fajar", "fajar@ui.ac.id", "0895333889470", locationOne));
        //Job jobOne = new Job(1806148706, "Programmer", recruiterOne, 100, JobCategory.WebDeveloper);
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Ivan", "ivan@ui.ac.id", "Pass123"));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Ivan", "ivan@ui.ac.id", "Pass123"));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Fajar", "fajar@ui.ac.id", "Pass123"));

        for(Jobseeker jobseeker: DatabaseJobseeker.getJobseekerDatabase()){
            System.out.println(jobseeker.toString());
        }

        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Programmer", DatabaseRecruiter.getRecruiterById(1), 1000000, JobCategory.WebDeveloper));

        Bonus bonusOne = new Bonus(1, "VANKO123", 10, 110, true);
        Bonus bonusTwo = new Bonus(2, "VANKO456", 10, 60, true);
        EwalletPayment EPayOne = new EwalletPayment(1, jobOne, jobseekerOne);
        EwalletPayment EPayTwo = new EwalletPayment(2, jobOne, jobseekerOne, bonusOne, InvoiceStatus.Finished);
        EwalletPayment EPayThree = new EwalletPayment(3, jobOne, jobseekerOne, bonusTwo, InvoiceStatus.Cancelled);
        BankPayment BPayOne = new BankPayment(1, jobOne, jobseekerOne, InvoiceStatus.Finished);
        BankPayment BPayTwo = new BankPayment(2, jobOne, jobseekerOne, InvoiceStatus.Finished, 10);
        
        System.out.println(jobseekerOne.toString());
        System.out.println(jobseekerTwo.toString());
        System.out.println(jobseekerThree.toString());
        
        jobseekerOne.setEmail("widjanarko@ui.ac.id");
        jobseekerTwo.setEmail("widjanarko@ui.ac.id");
        jobseekerThree.setEmail("widjanarko@ui.ac.id");
        
        jobseekerOne.setPassword("Pass123");
        jobseekerTwo.setPassword("Pass123");
        jobseekerThree.setPassword("Pass123");
        
        System.out.println(jobseekerOne.toString());
        System.out.println(jobseekerTwo.toString());
        System.out.println(jobseekerThree.toString());
        
        EPayOne.setTotalFee();
        EPayTwo.setTotalFee();
        EPayThree.setTotalFee();
        BPayOne.setTotalFee();
        BPayTwo.setTotalFee();
        
        System.out.println(EPayOne.toString());
        System.out.println(EPayTwo.toString());
        System.out.println(EPayThree.toString());
        System.out.println(BPayOne.toString());
        System.out.println(BPayTwo.toString());
    }
}
