package ivanwidjanarko.jwork;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static ivanwidjanarko.jwork.DatabaseConnectionPostgre.connection;

/**
 * Class for Database Job Postgre
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public class DatabaseJobPostgre {

    private static Connection c = null;
    private static Statement stmt = null;

    /**
     * Method for get Job's Database
     * @return    Array List of Job
     */
    public static ArrayList<Job> getJobDatabase() {
        ArrayList<Job> jobObject = new ArrayList<>();
        Job value = null;
        Connection c = connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM job_recruiter_location;");
            while (rs.next()) {
                int job_id = rs.getInt("job_id");
                String job_name = rs.getString("job_name");
                int recruiter_id = rs.getInt("recruiter_id");
                String recruiter_name = rs.getString("recruiter_name");
                String recruiter_email = rs.getString("recruiter_email");
                String recruiter_phone_number = rs.getString("recruiter_phone_number");
                String location_province = rs.getString("location_province");
                String location_city = rs.getString("location_city");
                String location_description = rs.getString("location_description");
                int job_fee = rs.getInt("job_fee");
                String job_category = rs.getString("job_category");
                value = new Job(job_id, job_name, new Recruiter(recruiter_id, recruiter_name, recruiter_email, recruiter_phone_number,
                        new Location(location_province, location_city, location_description)), job_fee, job_category);
                jobObject.add(value);
            }
            rs.close();
            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        return jobObject;
    }

    /**
     * Method for get Last ID from Job's Database
     * @return    last ID
     */
    public static int getLastId() {
        int value = 0;
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX (id) FROM job;");
            while (rs.next()) {
                value = rs.getInt("max");
            }
            rs.close();
            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        return value;
    }

    /**
     * Method for get job by its ID
     * @param job_id Job's ID
     * @return    job
     */
    public static Job getJobById(int job_id) {
        Job value = null;
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM job_recruiter_location WHERE job_id = "+ job_id + ";");
            while (rs.next()) {
                job_id = rs.getInt("job_id");
                String job_name = rs.getString("job_name");
                int recruiter_id = rs.getInt("recruiter_id");
                String recruiter_name = rs.getString("recruiter_name");
                String recruiter_email = rs.getString("recruiter_email");
                String recruiter_phone_number = rs.getString("recruiter_phone_number");
                String location_province = rs.getString("location_province");
                String location_city = rs.getString("location_city");
                String location_description = rs.getString("location_description");
                int job_fee = rs.getInt("job_fee");
                String job_category = rs.getString("job_category");
                value = new Job(job_id, job_name, new Recruiter(recruiter_id, recruiter_name, recruiter_email, recruiter_phone_number,
                        new Location(location_province, location_city, location_description)), job_fee, job_category);
            }
            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        return value;
    }

    /**
     * Method for get job by Recruiter's ID
     * @param recruiter_id Recruiter's ID
     * @return    job
     */
    public static Job getJobByRecruiter(int recruiter_id) {
        Job value = null;
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM job_recruiter_location WHERE recruiter_id = "+ recruiter_id + ";");
            while (rs.next()) {
                int job_id = rs.getInt("job_id");
                String job_name = rs.getString("job_name");
                recruiter_id = rs.getInt("recruiter_id");
                String recruiter_name = rs.getString("recruiter_name");
                String recruiter_email = rs.getString("recruiter_email");
                String recruiter_phone_number = rs.getString("recruiter_phone_number");
                String location_province = rs.getString("location_province");
                String location_city = rs.getString("location_city");
                String location_description = rs.getString("location_description");
                int job_fee = rs.getInt("job_fee");
                String job_category = rs.getString("job_category");
                value = new Job(job_id, job_name, new Recruiter(recruiter_id, recruiter_name, recruiter_email, recruiter_phone_number,
                        new Location(location_province, location_city, location_description)), job_fee, job_category);
            }
            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        return value;
    }

    /**
     * Method for get job by Its Category
     * @param job_category Job's Category
     * @return    job
     */
    public static Job getJobByCategory(String job_category) {
        Job value = null;
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM job_recruiter_location WHERE job_category = "+ job_category + ";");
            while (rs.next()) {
                int job_id = rs.getInt("job_id");
                String job_name = rs.getString("job_name");
                int recruiter_id = rs.getInt("recruiter_id");
                String recruiter_name = rs.getString("recruiter_name");
                String recruiter_email = rs.getString("recruiter_email");
                String recruiter_phone_number = rs.getString("recruiter_phone_number");
                String location_province = rs.getString("location_province");
                String location_city = rs.getString("location_city");
                String location_description = rs.getString("location_description");
                int job_fee = rs.getInt("job_fee");
                job_category = rs.getString("job_category");
                value = new Job(job_id, job_name, new Recruiter(recruiter_id, recruiter_name, recruiter_email, recruiter_phone_number,
                        new Location(location_province, location_city, location_description)), job_fee, job_category);
            }
            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        return value;
    }

    /**
     * Method for add Job into database
     * @param job Job
     * @return job addition status
     */
    public static Job addJob (Job job) {
        c = connection();
        try {
            stmt = c.createStatement();
            int id = job.getId();
            String name = job.getName();
            int recruiterId = job.getRecruiter().getId();
            int fee = job.getFee();
            String category = job.getCategory();

            String query = "INSERT INTO job (id, name, recruiter_id, fee, category) " +
                    "VALUES (" + id + ",'" + name + "', " + recruiterId + ", " + fee + ",'" + category + "');";
            stmt.executeUpdate(query);

            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
            return null;
        }
        return job;
    }

    /**
     * Method for remove the job from database
     * @param id Job's ID
     * @return    job deletion status
     */
    public static boolean removeJob(int id) {
        c = connection();
        try {
            stmt = c.createStatement();
            String query = "DELETE FROM job WHERE id = "+ id + ";";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        }

        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        return true;
    }

}
