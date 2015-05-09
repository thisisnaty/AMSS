package Entities;
import Controladores.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
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
public class Autor {
    private String idAutor;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private char sexo;
    private String corporacion;
    private String permiso;
    private String tipo;
    private String username;
    private String password;
    /*SQL connection global variables*/
    //connection variable
    private transient Conexion conn;
    //prepare statement for query
    PreparedStatement pst;
    //result of query
    ResultSet rs;
    
    public Autor(Conexion conn) {
        this.conn = conn;
    }
    
    public Autor() {
        this.idAutor = null;
        this.nombreCompleto = null;
        this.fechaNacimiento = null;
        this.sexo = '0';
        this.corporacion = null;
        this.permiso = null;
        this.tipo = null;
    }

    public Autor(String idAutor, String nombreCompleto, Date fechaNacimiento, char sexo, String corporacion, String permiso, String tipo) {
        this.idAutor = idAutor;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.corporacion = corporacion;
        this.permiso = permiso;
        this.tipo = tipo;
    }
    
    public LinkedList<String> getAutores() {
        LinkedList<String> autores = new LinkedList();
        try {
            String sql = "SELECT * FROM Autor";
            pst = conn.conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()) {
                autores.add(rs.getString("idAutor"));
                autores.add(rs.getString("nombreCompleto"));
                autores.add(rs.getDate("fechaNacimiento").toString());
                autores.add(rs.getString("sexo"));
                autores.add(rs.getString("corporacion"));
                autores.add(rs.getString("permiso"));
                autores.add(rs.getString("tipo"));
                autores.add(rs.getString("username"));
                rs.getString("password");
                while(rs.next()) {
                    autores.add(rs.getString("idAutor"));
                    autores.add(rs.getString("nombreCompleto"));
                    autores.add(rs.getDate("fechaNacimiento").toString());
                    autores.add(rs.getString("sexo"));
                    autores.add(rs.getString("corporacion"));
                    autores.add(rs.getString("permiso"));
                    autores.add(rs.getString("tipo"));
                    autores.add(rs.getString("username"));
                    rs.getString("password");
                }
            }
        }
        
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            autores.add("");
        }
        
        return autores;
    }
}
