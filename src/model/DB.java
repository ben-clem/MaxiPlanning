package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    // ATTRIBUTS
    String DBuserName = "root";
    String DBpassword = "root";
    String DBurl = "jdbc:mysql://localhost:8889/MaxiPlanning?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris";
    Connection conn = null;
    
    // METHODES
    
    public DB() {}
    
    public Connection connect() {
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(DBurl, DBuserName, DBpassword);

            System.out.println("Database connection established");
           
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {

            System.err.println("Cannot connect to database server");
            e.printStackTrace(System.err);

        }
        
        return conn;
    }
}
