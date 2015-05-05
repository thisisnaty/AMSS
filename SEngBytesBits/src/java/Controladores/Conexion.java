package Controladores;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
   public Connection conn;
   public Statement stmt;

   Conexion(){
      try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/ordenes";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = (Statement) conn.createStatement();     
      }catch (Exception e) { 
          System.out.println ("Cannot connect to database server"); 
      }
   }   
}