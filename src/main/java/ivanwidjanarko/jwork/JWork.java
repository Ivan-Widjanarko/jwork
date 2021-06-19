package ivanwidjanarko.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class for JWork
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
@SpringBootApplication
public class JWork {

    /**
     * Method for entry point (main method)
     * @param  args  List String Arguments
     */
    public static void main(String[] args) {
//        Location locationOne = new Location("DKI Jakarta", "Jakarta", "First House");
//        Location locationTwo = new Location("Jawa Barat", "Depok", "Second House");
//        Location locationThree = new Location("Sumatera Barat", "Medan", "Third House");
//
//        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Ivan", "ivan@ui.ac.id", "08558069151", locationOne));
//        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Widjanarko", "widjanarko@ui.ac.id", "085780736569", locationTwo));
//        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Fajar", "fajar@ui.ac.id", "0895333889470", locationThree));
//
//        try
//        {
//            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "User Interface", DatabaseRecruiter.getRecruiterById(1), 100000, "WebDeveloper"));
//        }
//        catch (RecruiterNotFoundException errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }
//
//        try
//        {
//            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Front End", DatabaseRecruiter.getRecruiterById(1), 150000, "FrontEnd"));
//        }
//        catch (RecruiterNotFoundException errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }
//
//        try
//        {
//            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Back End", DatabaseRecruiter.getRecruiterById(2), 200000, "BackEnd"));
//        }
//        catch (RecruiterNotFoundException errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }
//
//        try
//        {
//            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Web Developer", DatabaseRecruiter.getRecruiterById(3), 250000, "UI"));
//        }
//        catch (RecruiterNotFoundException errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }
//
//        try
//        {
//            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "VANKO123", 10000, 5000, true));
//        }
//        catch (ReferralCodeAlreadyExistsException errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }

//---------------------------------------------------------------------------------

//        Location locationOne = new Location("DKI Jakarta", "Jakarta", "First House");
//        Location locationTwo = new Location("Jawa Barat", "Depok", "Second House");
//        Location locationThree = new Location("Sumatera Barat", "Medan", "Third House");
//
//        DatabaseRecruiterPostgre.addRecruiter(new Recruiter(DatabaseRecruiterPostgre.getLastId() + 1, "Ivan", "ivan@ui.ac.id", "08558069151", locationOne));
//        DatabaseRecruiterPostgre.addRecruiter(new Recruiter(DatabaseRecruiterPostgre.getLastId()+1, "Widjanarko", "widjanarko@ui.ac.id", "085780736569", locationTwo));
//        DatabaseRecruiterPostgre.addRecruiter(new Recruiter(DatabaseRecruiterPostgre.getLastId()+1, "Fajar", "fajar@ui.ac.id", "0895333889470", locationThree));
//
//        try
//        {
//            DatabaseJobPostgre.addJob(new Job(DatabaseJobPostgre.getLastId()+1, "User Interface", DatabaseRecruiterPostgre.getRecruiterById(1), 100000, "UI"));
//        }
//        catch (Exception errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }
//
//        try
//        {
//            DatabaseJobPostgre.addJob(new Job(DatabaseJobPostgre.getLastId()+1, "Front End", DatabaseRecruiterPostgre.getRecruiterById(1), 150000, "FrontEnd"));
//        }
//        catch (Exception errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }
//
//        try
//        {
//            DatabaseJobPostgre.addJob(new Job(DatabaseJobPostgre.getLastId()+1, "Back End", DatabaseRecruiterPostgre.getRecruiterById(2), 200000, "BackEnd"));
//        }
//        catch (Exception errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }
//
//        try
//        {
//            DatabaseJobPostgre.addJob(new Job(DatabaseJobPostgre.getLastId()+1, "Web Developer", DatabaseRecruiterPostgre.getRecruiterById(3), 250000, "WebDeveloper"));
//        }
//        catch (Exception errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }
//
//        try
//        {
//            DatabaseBonusPostgre.addBonus(new Bonus(DatabaseBonusPostgre.getLastId()+1, "VANKO123", 10000, 5000, true));
//        }
//        catch (Exception errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }

        SpringApplication.run(JWork.class, args);
    }
}