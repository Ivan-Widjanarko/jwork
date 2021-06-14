package ivanwidjanarko.jwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnectionPostgre {

    public static Connection connection() {
        Connection c = null;
        Statement stmt = null;
        String db_name = "ivan_jwork";
        String db_user = "postgres";
        String db_password = "root";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+ db_name, db_user, db_password);
            if (c != null) {
                System.out.println("Connection OK");
            }
            else {
                System.out.println("Connection Failed");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }

        System.out.println("Opened database successfully");
        return c;
    }
}
