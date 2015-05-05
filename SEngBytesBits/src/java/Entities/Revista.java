package Entities;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controladores.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulina Escalante A01191962
 * @author Natalia Garcia A01191853
 */
public class Revista {
    private String nombre;
    private String idRevista;
    private Date fechaPublicacion;
    private int numeroImpresiones;
    private String idCarta;
    /*SQL connection global variables*/
    //connection variable
    private transient Conexion conn;
    //prepare statement for query
    PreparedStatement pst;
    //result of query
    ResultSet rs;
    
    public Revista(Conexion conn) {
        this.conn = conn;
    }
    
    public Revista() {
        this.nombre = null;
        this.idRevista = null;
        this.fechaPublicacion = null;
        this.numeroImpresiones = 0;
    }

    public Revista(String nombre, String idRevista, Date fechaPublicacion, int numeroImpresiones) {
        this.nombre = nombre;
        this.idRevista = idRevista;
        this.fechaPublicacion = fechaPublicacion;
        this.numeroImpresiones = numeroImpresiones;
    }
    
    int cantidadLectores() {
        try {
            String sql = "SELECT COUNT(DISTINCT idSuscriptor) FROM Orden WHERE idRevista=?";
            conn.stmt.executeUpdate(sql);
            pst.setString(1, idRevista);
            rs = pst.executeQuery();
            return rs.getInt(1);
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            return -1;
        }
    }
    
    int cantidadImpresiones() {
        try {
            String sql = "SELECT numeroImpresiones FROM Revista WHERE idRevista=?";
            conn.stmt.executeUpdate(sql);
            pst.setString(1, idRevista);
            rs = pst.executeQuery();
            return rs.getInt("numeroImpresiones");
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            return -1;
        }
    }
    
    int cantidadArticulos() {
        try {
            String sql = "SELECT COUNT* FROM Articulo WHERE idRevista=?";
            conn.stmt.executeUpdate(sql);
            pst.setString(1, idRevista);
            rs = pst.executeQuery();
            return rs.getInt(1);
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            return -1;
        }
    }
    
    //wat is dis
    void editorEnJefe() {
        
    }
}

