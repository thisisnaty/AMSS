package Controladores;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
   public Connection conn;
   public Statement stmt;

   Conexion(){
      try {
        String userName = "root";
        String password = "";
        //on localhost
        String url = "jdbc:mysql://localhost:3306/SEngBytesBits";
        //on local file
        //String url = "jdbc:mysql:/Users/pescalante/Desktop/Tec/Universidad/4Semestre/AMSSmateria/AMSS/SEngBytesBits";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = (Statement) conn.createStatement();     
      }
      catch (Exception e) { 
           JOptionPane.showMessageDialog(null,e);
           System.out.println ("Cannot connect to database server"); 
      }
   }   
}