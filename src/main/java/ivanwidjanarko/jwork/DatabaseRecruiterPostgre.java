package ivanwidjanarko.jwork;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static ivanwidjanarko.jwork.DatabaseConnectionPostgre.connection;

/**
 * Class for Database Recruiter Postgre
 *
 * @author Ivan Widjanarko
 * @version 25-06-2021
 */
public class DatabaseRecruiterPostgre {

    private static Connection c = null;
    private static Statement stmt = null;

    /**
     * Method for get Recruiter's Database
     * @return    Array List of Recruiter
     */
    public static ArrayList<Recruiter> getRecruiterDatabase() {
        ArrayList<Recruiter> recruiterObject = new ArrayList<>();
        Recruiter value = null;
        Connection c = connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM recruiter_location;");
            while (rs.next()) {
                int recruiter_id = rs.getInt("recruiter_id");
                String recruiter_name = rs.getString("recruiter_name");
                String recruiter_email = rs.getString("recruiter_email");
                String recruiter_phoneNumber = rs.getString("recruiter_phone_number");
                String location_province = rs.getString("location_province");
                String location_city = rs.getString("location_city");
                String location_description = rs.getString("location_description");
                value = new Recruiter(recruiter_id, recruiter_name, recruiter_email, recruiter_phoneNumber,
                        new Location(location_province, location_city, location_description));
                recruiterObject.add(value);
            }
            rs.close();
            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
        return recruiterObject;
    }

    /**
     * Method for get Last ID from Recruiter's Database
     * @return    last ID
     */
    public static int getLastId() {
        int value = 0;
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX (id) FROM recruiter;");
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
        }
        return value;
    }

    /**
     * Method for get Recruiter by its ID
     * @param recruiter_id Recruiter's ID
     * @return    recruiter
     * @throws RecruiterNotFoundException Exception if Recruiter not found
     */
    public static Recruiter getRecruiterById(int recruiter_id) throws RecruiterNotFoundException {
        Recruiter value = null;
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM" +
                    "(SELECT * FROM recruiter WHERE id = " + recruiter_id +
                    ") AS id;");
            while (rs.next()) {
                int count = rs.getInt("count");

                if (count == 0) {
                    throw new RecruiterNotFoundException(recruiter_id);
                }
                else {
                    rs = stmt.executeQuery("SELECT * FROM recruiter_location WHERE recruiter_id = " + recruiter_id + ";");
                    while (rs.next()) {
                        recruiter_id = rs.getInt("recruiter_id");
                        String recruiter_name = rs.getString("recruiter_name");
                        String recruiter_email = rs.getString("recruiter_email");
                        String recruiter_phoneNumber = rs.getString("recruiter_phone_number");
                        String location_province = rs.getString("location_province");
                        String location_city = rs.getString("location_city");
                        String location_description = rs.getString("location_description");
                        value = new Recruiter(recruiter_id, recruiter_name, recruiter_email, recruiter_phoneNumber,
                                new Location(location_province, location_city, location_description));
                    }
                }
            }
            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
        return value;
    }

    /**
     * Method for add Recruiter into database
     * @param recruiter Recruiter
     * @return recruiter addition status
     */
    public static Recruiter addRecruiter (Recruiter recruiter) {
        c = connection();
        try {
            stmt = c.createStatement();
            int id = recruiter.getId();
            String name = recruiter.getName();
            String email = recruiter.getEmail();
            String phoneNumber = recruiter.getPhoneNumber();
            String province = recruiter.getLocation().getProvince();
            String city = recruiter.getLocation().getCity();
            String description = recruiter.getLocation().getDescription();

            String query = "INSERT INTO location (province, city, description)" +
                    "VALUES ('" + province + "','" + city + "','"+ description + "');";
            stmt.executeUpdate(query);

            query = "INSERT INTO recruiter (id, name, email, phone_number, location_id) " +
                    "VALUES (" + id + ",'" + name + "','"+ email + "','"+ phoneNumber + "', " +
                    "(SELECT MAX (id) FROM location));";
            stmt.executeUpdate(query);

            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            return null;
        }
        return recruiter;
    }

    /**
     * Method for remove the recruiter from database
     * @param id recruiter's ID
     * @return    recruiter deletion status
     * @throws RecruiterNotFoundException Exception if Recruiter not found
     */
    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException {
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM" +
                    "(SELECT * FROM recruiter WHERE id = " + id +
                    ") AS id;");
            while (rs.next()) {
                int count = rs.getInt("count");

                if (count == 0) {
                    throw new RecruiterNotFoundException(id);
                }
                else {
                    String query = "DELETE FROM location WHERE id = " + id + ";";
                    stmt.executeUpdate(query);
                    stmt.close();
                    c.close();
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
        return true;
    }
}
