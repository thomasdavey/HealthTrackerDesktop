package DBClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Abstract class storing access credentials
 */
public abstract class DBAccess {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:./database/healthdb;DATABASE_TO_UPPER=false;MVCC=true";

    static final String UN = "admin";
    static final String PW = "password";

    static Connection conn = null;
    static Statement st = null;

    protected static void getConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, UN, PW);
            st = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void closeConnection(){
        try {
            conn.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
