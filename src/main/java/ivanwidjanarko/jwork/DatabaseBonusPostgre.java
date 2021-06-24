package ivanwidjanarko.jwork;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static ivanwidjanarko.jwork.DatabaseConnectionPostgre.connection;

/**
 * Class for Database Bonus Postgre
 *
 * @author Ivan Widjanarko
 * @version 25-06-2021
 */
public class DatabaseBonusPostgre {

    private static Connection c = null;
    private static Statement stmt = null;

    /**
     * Method for get Bonus' Database
     * @return    Array List of Bonus
     */
    public static ArrayList<Bonus> getBonusDatabase() {
        ArrayList<Bonus> bonusObject = new ArrayList<>();
        Bonus value = null;
        Connection c = connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bonus;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String referralCode = rs.getString("referral_code");
                int extraFee = rs.getInt("extra_fee");
                int minTotalFee = rs.getInt("min_total_fee");
                boolean active = rs.getBoolean("active");
                value = new Bonus(id, referralCode, extraFee, minTotalFee, active);
                bonusObject.add(value);
            }
            rs.close();
            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
        return bonusObject;
    }

    /**
     * Method for get Last ID from Bonus' Database
     * @return    last ID
     */
    public static int getLastId() {
        int value = 0;
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX (id) FROM bonus;");
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
     * Method for get bonus by its ID
     * @param id Bonus' ID
     * @return    bonus
     * @throws BonusNotFoundException Exception if Bonus not found
     */
    public static Bonus getBonusById(int id) throws BonusNotFoundException {
        Bonus value = null;
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM" +
                    "(SELECT * FROM bonus WHERE id = " + id +
                    ") AS id;");
            while (rs.next()) {
                int count = rs.getInt("count");

                if (count == 0) {
                    throw new BonusNotFoundException(id);
                }
                else {
                    rs = stmt.executeQuery("SELECT * FROM bonus WHERE id = "+ id + ";");
                    while (rs.next()) {
                        id = rs.getInt("id");
                        String referralCode = rs.getString("referral_code");
                        int extraFee = rs.getInt("extra_fee");
                        int minTotalFee = rs.getInt("min_total_fee");
                        boolean active = rs.getBoolean("active");
                        value = new Bonus(id, referralCode, extraFee, minTotalFee, active);
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
     * Method for get Bonus by Its Referral Code
     * @param referralCode Referral Code
     * @return    bonus
     */
    public static Bonus getBonusByReferralCode(String referralCode) {
        Bonus value = null;
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bonus WHERE referral_code = '"+ referralCode + "';");
            while (rs.next()) {
                int id = rs.getInt("id");
                referralCode = rs.getString("referral_code");
                int extraFee = rs.getInt("extra_fee");
                int minTotalFee = rs.getInt("min_total_fee");
                boolean active = rs.getBoolean("active");
                value = new Bonus(id, referralCode, extraFee, minTotalFee, active);
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
     * Method for add Bonus into database
     * @param bonus Bonus
     * @return    bonus addition status
     * @throws ReferralCodeAlreadyExistsException Exception if Referral Code already exists
     */
    public static Bonus addBonus (Bonus bonus) throws ReferralCodeAlreadyExistsException {
        c = connection();
        try {
            stmt = c.createStatement();
            int id = bonus.getId();
            String referralCode = bonus.getReferralCode();
            int extraFee = bonus.getExtraFee();
            int minTotalFee = bonus.getMinTotalFee();
            boolean active = bonus.getActive();

            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM" +
                    "(SELECT * FROM bonus WHERE referral_code = '" + referralCode +
                    "') AS referral_code;");
            while (rs.next()) {
                int count = rs.getInt("count");

                if (count != 0) {
                    throw new ReferralCodeAlreadyExistsException(bonus);
                }
                else {
                    String query =  "INSERT INTO bonus (id, referral_code, extra_fee, min_total_fee, active)"
                            + "VALUES (" + id + ",'" + referralCode + "','"+ extraFee + "','"+ minTotalFee + "','" + active + "');";
                    stmt.executeUpdate(query);
                    stmt.close();
                    c.close();
                }
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            return null;
        }
        return bonus;
    }

    /**
     * Method for activate the bonus
     * @param id Bonus' ID
     * @return    bonus activation status
     */
    public static boolean activateBonus(int id)
    {
        c = connection();
        try {
            stmt = c.createStatement();
            boolean active = true;
            String query =  "UPDATE bonus SET active = "+ active + "WHERE id = " + id + ";" + ";";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
        return true;
    }

    /**
     * Method for deactivate the bonus
     * @param id Bonus' ID
     * @return    bonus deactivation status
     */
    public static boolean deactivateBonus(int id)
    {
        c = connection();
        try {
            stmt = c.createStatement();
            boolean active = false;
            String query =  "UPDATE bonus SET active = "+ active + "WHERE id = " + id + ";" + ";";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
        return true;
    }

    /**
     * Method for remove the bonus from database
     * @param id Bonus' ID
     * @return    bonus deletion status
     * @throws BonusNotFoundException Exception if Bonus not found
     */
    public static boolean removeBonus(int id) throws BonusNotFoundException {
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM" +
                    "(SELECT * FROM bonus WHERE id = " + id +
                    ") AS id;");
            while (rs.next()) {
                int count = rs.getInt("count");

                if (count == 0) {
                    throw new BonusNotFoundException(id);
                }
                else {
                    String query = "DELETE FROM bonus WHERE id = " + id + ";";
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
