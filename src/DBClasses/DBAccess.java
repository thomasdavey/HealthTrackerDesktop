package DBClasses;

import java.sql.Connection;
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



}
