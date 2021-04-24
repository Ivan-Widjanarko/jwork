import java.util.ArrayList;
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

        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Ivan", "ivan@ui.ac.id", "Pass123"));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Ivan", "ivan@ui.ac.id", "Pass123"));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Fajar", "fajar@ui.ac.id", "Pass123"));

        for(Jobseeker jobseeker: DatabaseJobseeker.getJobseekerDatabase()){
            System.out.println(jobseeker.toString());
        }

        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Web Developer", DatabaseRecruiter.getRecruiterById(1), 100, JobCategory.WebDeveloper));
        //DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Front End", DatabaseRecruiter.getRecruiterById(1), 100, JobCategory.FrontEnd));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Front End", DatabaseRecruiter.getRecruiterById(1), 60, JobCategory.FrontEnd));

        for(Job job: DatabaseJob.getJobByCategory(JobCategory.FrontEnd)){
            System.out.println(job.toString());
        }

        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "VANKO456", 10, 60, false));
        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "VANKO456", 10, 60, false));

        for(Bonus bonus: DatabaseBonus.getBonusDatabase()){
            System.out.println(bonus.toString());
        }

        /*ArrayList<Job> arrayJob = new ArrayList<Job>();
        arrayJob.add(DatabaseJob.getJobById(1));
        arrayJob.add(DatabaseJob.getJobById(2));*/

        DatabaseInvoice.addInvoice(new BankPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1)));

        ArrayList<Invoice> invoice = DatabaseInvoice.getInvoiceByJobseeker(1);
        invoice.get(invoice.size() - 1).setTotalFee();

        DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1)));

        invoice.get(invoice.size() - 1).setTotalFee();

        for(Invoice invoiceObject: DatabaseInvoice.getInvoiceDatabase()){
            System.out.println(invoiceObject.toString());
        }

        DatabaseInvoice.changeInvoiceStatus(1, InvoiceStatus.Finished);

        DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(2), DatabaseBonus.getBonusByReferralCode("VANKO456")));

        DatabaseBonus.getBonusById(1).setActive(true);

        DatabaseInvoice.getInvoiceDatabase().forEach(invoiceObj -> invoiceObj.setTotalFee());

        for(Invoice invoiceObject: DatabaseInvoice.getInvoiceDatabase()){
            System.out.println(invoiceObject.toString());
        }
    }
}
