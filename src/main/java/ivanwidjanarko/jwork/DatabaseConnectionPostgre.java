package ivanwidjanarko.jwork;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class for Database Connection to PostgreSQL
 *
 * @author Ivan Widjanarko
 * @version 25-06-2021
 */
public class DatabaseConnectionPostgre {

    /**
     * Method to turn on the coonection to database
     * @return    connection
     */
    public static Connection connection() {
        Connection c = null;
        String db_name = "ivan_jwork";
        String db_user = "postgres";
        String db_password = "root";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+ db_name, db_user, db_password);
        }
        catch(Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }

        return c;
    }
}
