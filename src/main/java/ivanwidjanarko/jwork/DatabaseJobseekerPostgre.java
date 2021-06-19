package ivanwidjanarko.jwork;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static ivanwidjanarko.jwork.DatabaseConnectionPostgre.connection;

/**
 * Class for Database Jobseeker Postgre
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public class DatabaseJobseekerPostgre {

    private static Connection c = null;
    private static Statement stmt = null;

    /**
     * Method for get Jobseeker's Database
     * @return    Array List of Jobseeker
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase() {
        ArrayList<Jobseeker> jobseekerObject = new ArrayList<>();
        Jobseeker value = null;
        Connection c = connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM jobseeker;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Date joinDate = rs.getDate("joinDate");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(joinDate);
                value = new Jobseeker(id, name, email, password, calendar);
                jobseekerObject.add(value);
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
        return jobseekerObject;
    }

    /**
     * Method for get Last ID from Jobseeker's Database
     * @return    last ID
     */
    public static int getLastId() {
        int value = 0;
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX (id) FROM jobseeker;");
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
     * Method for get jobseeker by its ID
     * @param id Jobseeker's ID
     * @return    jobseeker
     */
    public static Jobseeker getJobseekerById(int id) {
        Jobseeker value = null;
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM jobseeker WHERE id = "+ id + ";");
            while (rs.next()) {
                id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Date joinDate = rs.getDate("join_date");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(joinDate);
                value = new Jobseeker(id, name, email, password, calendar);
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
     * Method for add Jobseeker into database
     * @param jobseeker Jobseeker
     * @return job addition status
     */
    public static Jobseeker addJobseeker (Jobseeker jobseeker) {
        c = connection();
        try {
            stmt = c.createStatement();
            int id = jobseeker.getId();
            String name = jobseeker.getName();
            String email = jobseeker.getEmail();
            String password = jobseeker.getPassword();
            Calendar cal = jobseeker.getJoinDate();
            cal.add(Calendar.DATE, 0);

            Date date = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String joinDate = sdf.format(date);

            String query =  "INSERT INTO jobseeker (id, name, email, password, join_date)"
                    + "VALUES (" + id + ",'" + name + "','"+ email + "','"+ password + "','" + joinDate + "');";
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
        return jobseeker;
    }

    /**
     * Method for remove the jobseeker from database
     * @param id Jobseeker's ID
     * @return    jobseeker deletion status
     */
    public static boolean removeJobseeker(int id) {
        c = connection();
        try {
            stmt = c.createStatement();
            String query = "DELETE FROM jobseeker WHERE id = "+ id + ";";
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

    /**
     * Method for jobseeker to login
     * @param emailParam Jobseeker's Email
     * @param passwordParam Jobseeker's Password
     * @return    Jobseeker
     */
    public static Jobseeker jobseekerLogin(String emailParam, String passwordParam) {
        Connection c = connection();
        PreparedStatement stmt;
        Jobseeker jobseeker;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        String date;
        Calendar cal = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM jobseeker WHERE email = '" + emailParam + "' AND password = '" + passwordParam + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                date = rs.getString("join_date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                cal = Calendar.getInstance();
                cal.setTime(sdf.parse(date));
            }
            rs.close();
            stmt.close();
            c.close();

            if (id == 0) {
                return null;
            }

            else {
                jobseeker = new Jobseeker(id, name, email, password, cal);
                return jobseeker;
            }
        }

        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
            return null;
        }
    }

}
