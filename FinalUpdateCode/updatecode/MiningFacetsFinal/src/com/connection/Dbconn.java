package com.connection;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Dbconn {
 
    public Dbconn() throws SQLException {
              
    }
      
    public static Connection conn() throws SQLException, ClassNotFoundException{
                Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/crawler1", "root", "admin");
        
       return(con);
    
}
           
}
