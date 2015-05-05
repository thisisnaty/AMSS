package Entities;
import Controladores.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pescalante
 */
public class Suscriptor {
    private String idSuscriptor;
    private String nombreCompleto;
    private String username;
    private String password;
    private Date fechaNacimiento;
    private Date fechaEntrada;
    private Date fechaExpiracion;
    private char sexo;
    private String compania;
    private String direccion;
    private String tarjetaCredito;
    private int clave;
    private List<Orden> ordenes;
     /*SQL connection global variables*/
    //connection variable
    private final transient Conexion conn;
    //prepare statement for query
    PreparedStatement pst;
    //result of query
    ResultSet rs;
    
    Suscriptor (Conexion conn) {
        this.conn = conn;
    }

    boolean validateLogin() {
        try {
            String sql = "SELECT * FROM Suscriptor WHERE username=? AND password=?";
            conn.stmt.executeUpdate(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            username = rs.getString("username");
            password = rs.getString("password");
            idSuscriptor = rs.getString("idSuscriptor");
            nombreCompleto = rs.getString("nombreCompleto");
            sexo = rs.getString("sexo").charAt(0);
            fechaNacimiento = rs.getDate("fechaNacimiento");
            fechaEntrada = rs.getDate("fechaEntrada");
            return true;
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }
    }
}
