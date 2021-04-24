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

        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Web Developer", DatabaseRecruiter.getRecruiterById(1), 1000000, JobCategory.WebDeveloper));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Front End", DatabaseRecruiter.getRecruiterById(1), 1000000, JobCategory.FrontEnd));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Front End", DatabaseRecruiter.getRecruiterById(1), 1000000, JobCategory.FrontEnd));

        for(Job job: DatabaseJob.getJobByCategory(JobCategory.FrontEnd)){
            System.out.println(job.toString());
        }

        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "VANKO456", 10, 60, false));
        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "VANKO456", 10, 60, false));
    }
}
