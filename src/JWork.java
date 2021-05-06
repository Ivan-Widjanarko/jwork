import java.util.ArrayList;

/**
 * Class for JWork
 *
 * @author Ivan Widjanarko
 * @version 05-05-2021
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

        try
        {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Ivan", "ivan@ui.ac.id", "Pass123"));
        }
        catch (EmailAlreadyExistsException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        try
        {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Ivan", "ivan@ui.ac.id", "Pass123"));
        }
        catch (EmailAlreadyExistsException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        try
        {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Fajar", "fajar@ui.ac.id", "Pass123"));
        }
        catch (EmailAlreadyExistsException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        try
        {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "FM", "fm@ui.ac.id", "Pass123"));
        }
        catch (EmailAlreadyExistsException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        /*for(Jobseeker jobseeker: DatabaseJobseeker.getJobseekerDatabase()){
            System.out.println(jobseeker.toString());
        }*/

        try
        {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Web Developer", DatabaseRecruiter.getRecruiterById(1), 100, JobCategory.WebDeveloper));
        }
        catch (RecruiterNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }


        //DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Front End", DatabaseRecruiter.getRecruiterById(1), 100, JobCategory.FrontEnd));
        try
        {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Front End", DatabaseRecruiter.getRecruiterById(100), 60, JobCategory.FrontEnd));
        }
        catch (RecruiterNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        /*for(Job job: DatabaseJob.getJobByCategory(JobCategory.FrontEnd)){
            System.out.println(job.toString());
        }*/

        try
        {
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "VANKO456", 10, 60, false));
        }
        catch (ReferralCodeAlreadyExistsException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        try
        {
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "VANKO456", 10, 60, false));
        }
        catch (ReferralCodeAlreadyExistsException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        /*for(Bonus bonus: DatabaseBonus.getBonusDatabase()){
            System.out.println(bonus.toString());
        }*/

        /*ArrayList<Job> arrayJob = new ArrayList<Job>();
        arrayJob.add(DatabaseJob.getJobById(1));
        arrayJob.add(DatabaseJob.getJobById(2));*/

        try
        {
            DatabaseInvoice.addInvoice(new BankPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1)));
        }
        catch (JobseekerNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        ArrayList<Invoice> invoice = DatabaseInvoice.getInvoiceByJobseeker(1);
        invoice.get(invoice.size() - 1).setTotalFee();

        try
        {
            DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(100)));
        }
        catch (JobseekerNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        invoice.get(invoice.size() - 1).setTotalFee();

        /*for(Invoice invoiceObject: DatabaseInvoice.getInvoiceDatabase()){
            System.out.println(invoiceObject.toString());
        }*/

        DatabaseInvoice.changeInvoiceStatus(1, InvoiceStatus.Finished);

        try
        {
            DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(2), DatabaseBonus.getBonusByReferralCode("VANKO456")));
        }
        catch (JobseekerNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        DatabaseBonus.activateBonus(1);

        DatabaseInvoice.getInvoiceDatabase().forEach(invoiceObj -> invoiceObj.setTotalFee());

        try
        {
            DatabaseJob.getJobById(100);
        }
        catch (JobNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        try
        {
            DatabaseBonus.getBonusById(100);
        }
        catch (BonusNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        for(Invoice invoiceObject: DatabaseInvoice.getInvoiceDatabase()){
            System.out.println(invoiceObject.toString());
        }

        for(Bonus bonusObject: DatabaseBonus.getBonusDatabase()){
            System.out.println(bonusObject.toString());
        }

        for(Job jobObject: DatabaseJob.getJobDatabase()){
            System.out.println(jobObject.toString());
        }

        for(Jobseeker jobseekerObject: DatabaseJobseeker.getJobseekerDatabase()){
            System.out.println(jobseekerObject.toString());
        }

        for(Recruiter recruiterObject: DatabaseRecruiter.getRecruiterDatabase()){
            System.out.println(recruiterObject.toString());
        }

        /*###################*/

        Invoice invoiceOne = null;
        Invoice invoiceTwo = null;
        Invoice invoiceThree = null;

        try
        {
            invoiceOne = new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1), DatabaseBonus.getBonusByReferralCode("VANKO456"));
        }
        catch (JobseekerNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        try
        {
            invoiceTwo = new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(2), DatabaseBonus.getBonusByReferralCode("VANKO456"));
        }
        catch (JobseekerNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        try
        {
            invoiceThree = new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(3), DatabaseBonus.getBonusByReferralCode("VANKO456"));
        }
        catch (JobseekerNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        DatabaseInvoice.addInvoice(invoiceOne);
        DatabaseInvoice.addInvoice(invoiceTwo);
        DatabaseInvoice.addInvoice(invoiceThree);
        
    }
}
