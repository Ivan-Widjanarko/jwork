package ivanwidjanarko.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class for JWork
 *
 * @author Ivan Widjanarko
 * @version 18-05-2021
 */
@SpringBootApplication
public class JWork {

    /**
     * method for entry point (main method)
     * @param  args  List String Arguments
     */
    public static void main(String[] args) {
        Location locationOne = new Location("DKI Jakarta", "Jakarta", "First House");
        Location locationTwo = new Location("Jawa Barat", "Depok", "Second House");
        Location locationThree = new Location("Sumatera Barat", "Medan", "Third House");

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Ivan", "ivan@ui.ac.id", "08558069151", locationOne));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Widjanarko", "widjanarko@ui.ac.id", "085780736569", locationTwo));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Fajar", "fajar@ui.ac.id", "0895333889470", locationThree));;

        try
        {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Web Developer", DatabaseRecruiter.getRecruiterById(1), 100, JobCategory.WebDeveloper));
        }
        catch (RecruiterNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        try
        {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Front End", DatabaseRecruiter.getRecruiterById(1), 150, JobCategory.FrontEnd));
        }
        catch (RecruiterNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        try
        {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Back End", DatabaseRecruiter.getRecruiterById(2), 200, JobCategory.BackEnd));
        }
        catch (RecruiterNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        try
        {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "User Interface", DatabaseRecruiter.getRecruiterById(3), 250, JobCategory.UI));
        }
        catch (RecruiterNotFoundException errorMessage)
        {
            System.out.println(errorMessage.getMessage());
        }

        SpringApplication.run(JWork.class, args);
    }
}