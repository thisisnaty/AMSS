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
     /*SQL connection global variables*/
    //connection variable
    private final transient Conexion conn;
    //prepare statement for query
    PreparedStatement pst;
    //result of query
    ResultSet rs;
    
    public Suscriptor (Conexion conn) {
        this.conn = conn;
    }

    public boolean validateLogin(String u, String p) {
        try {
            String sql = "SELECT * FROM Suscriptor WHERE username=? AND password=?";
            pst = conn.conn.prepareStatement(sql);
            pst.setString(1, u);
            pst.setString(2, p);
            rs = pst.executeQuery();
            //encontro usuario
            if(rs.next()){
                idSuscriptor = rs.getString("idSuscriptor");
                nombreCompleto = rs.getString("nombreCompleto");
                compania = rs.getString("corporacion");
                fechaNacimiento = rs.getDate("fechaNacimiento");
                password = rs.getString("password");
                fechaEntrada = rs.getDate("fechaEntrada");
                fechaExpiracion = rs.getDate("fechaExpiracion");
                sexo = rs.getString("sexo").charAt(0);
                direccion = rs.getString("direccion");
                tarjetaCredito = rs.getString("tarjetaCredito");
                clave = rs.getInt("clave");
                return true;
            }
            //no encontro
            else{
                return false;
            }
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }
    }

    public boolean register(String username, String password, String nombre, String corp, java.sql.Date nacimiento, char sexo, String direccion, String tarjeta, int clave, java.sql.Date expiracion, java.sql.Date hoy) {
        try {
            String sql = "SELECT COUNT(idSuscriptor) as mycount FROM Suscriptor";
            pst = conn.conn.prepareStatement(sql);
            rs = pst.executeQuery();
            int cuantosSuscriptores = 0;
            //encontro usuario
            if(rs.next()){
                cuantosSuscriptores = rs.getInt("mycount");
                cuantosSuscriptores++;
            }
            String id = "S"+Integer.toString(cuantosSuscriptores);
            sql = "INSERT INTO Suscriptor (idSuscriptor, nombreCompleto, corporacion, fechaNacimiento, fechaEntrada, sexo, direccion, tarjetaCredito, clave, fechaExpiracion, username, password)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
            pst = conn.conn.prepareStatement(sql);
            pst.setString(1,id);
            pst.setString(2,nombre);
            pst.setString(3,corp);
            pst.setDate(4, nacimiento);
            pst.setDate(5,hoy);
            pst.setString(6,String.valueOf(sexo));
            pst.setString(7,direccion);
            pst.setString(8,tarjeta);
            pst.setInt(9,clave);
            pst.setDate(10,expiracion);
            pst.setString(11,username);
            pst.setString(12,password);
            //executes query
            pst.executeUpdate();
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
