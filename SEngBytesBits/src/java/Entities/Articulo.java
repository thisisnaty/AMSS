package Entities;

import Controladores.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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
public class Articulo {
    private String idArticulo;
    private String titulo;
    private String tema;
    private Date fechaPublicacion;
    private boolean publicado;
    private boolean autorizado;
    //private Juez juezSupervisor;
    private String idJuezSupervisor;
    //private Revista revistaPertenece;
    private String idrevistaPertenece;
    /*SQL connection global variables*/
    //connection variable
    private transient Conexion conn;
    //prepare statement for query
    PreparedStatement pst;
    //result of query
    ResultSet rs;
    
    public Articulo(Conexion conn) {
        this.conn = conn;
    }
    
    public Articulo() {
        this.idArticulo = null;
        this.titulo = null;
        this.tema = null;
        this.fechaPublicacion = null;
        this.publicado = false;
        this.autorizado = false;
    }
    
    public Articulo(String idArticulo, String titulo, String tema, Date fechaPublicacion,
            boolean publicado, boolean autorizado) {
        this.idArticulo = idArticulo;
        this.titulo = titulo;
        this.tema = tema;
        this.fechaPublicacion = fechaPublicacion;
        this.publicado = publicado;
        this.autorizado = autorizado;
    }
    
    boolean crearArticulo(String id, String tit, String tem, Date fechaP, boolean pub, boolean aut, String idR, String idJ) {
         //SQL query
        String sql = "INSERT INTO Articulo (idArticulo, titulo, tema, fechaPublicacion, publicado, autorizado, idRevista, idJuez)" +
                     "VALUES(?, ?, ?, ?, ?, ?);";
        try {
            //make sql script
            pst = conn.conn.prepareStatement(sql);
            pst.setString(1,id);
            pst.setString(2,tit);
            pst.setString(3,tem);
            pst.setDate(4, fechaP);
            pst.setBoolean(5,pub);
            pst.setBoolean(6,aut);
            pst.setString(5,idR);
            pst.setString(6,idJ);
            //executes query
            pst.executeQuery();
            return true;
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }
    }
    
    Juez getJuez() {
        Juez juezSupervisor;
        try {
            String sql = "SELECT idJuez FROM Articulo WHERE idArticulo=?";
            conn.stmt.executeUpdate(sql);
            pst.setString(1, idArticulo);
            rs = pst.executeQuery();
            String idJuez = rs.getString("idJuez");
            sql = "SELECT * FROM Juez WHERE idJuez=?";
            conn.stmt.executeUpdate(sql);
            pst.setString(1, idJuez);
            rs = pst.executeQuery();
            String nombre = rs.getString("nombreCompleto");
            Date nacimiento = rs.getDate("fechaNacimiento");
            Date entrada = rs.getDate("fechaEntrada");
            char sexo = rs.getString("sexo").charAt(0);
            juezSupervisor = new Juez(idJuez, nombre, nacimiento, entrada, sexo);
            return juezSupervisor;
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            juezSupervisor = new Juez();
        }
        return juezSupervisor;
    }
    
    Revista getRevista() {
        Revista revistaPertenece;
        try {
            String sql = "SELECT idRevista FROM Articulo WHERE idArticulo=?";
            conn.stmt.executeUpdate(sql);
            pst.setString(1, idArticulo);
            rs = pst.executeQuery();
            String idRevista = rs.getString("idRevista");
            sql = "SELECT * FROM Revista WHERE idRevista=?";
            conn.stmt.executeUpdate(sql);
            pst.setString(1, idRevista);
            rs = pst.executeQuery();
            String nombre = rs.getString("nombre");
            Date publicacion = rs.getDate("fechaPublicacion");
            int numImpresiones = rs.getInt("numeroImpresiones");
            revistaPertenece = new Revista(nombre, idRevista, publicacion, numImpresiones, "nada");
            return revistaPertenece;
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            revistaPertenece = new Revista();
        }
        return revistaPertenece;
    }
    
    public LinkedList<String> getArticulos() {
        LinkedList<String> articulos = new LinkedList();
        try {
            String sql = "SELECT * FROM ArticuloAutor aa INNER JOIN Articulo ar \n" +
                        "   ON aa.idArticulo = ar.idArticulo JOIN Autor au\n" +
                        "   ON aa.idAutor = au.idAutor";
            conn.stmt.executeUpdate(sql);
            rs = pst.executeQuery();
            if(rs.next()) {
                while(rs.next()) {
                    articulos.add(rs.getString("titulo"));
                    articulos.add(rs.getString("tema"));
                    articulos.add(rs.getString("fechaPublicacion"));
                    articulos.add("Autor: " + rs.getString("nombreCompleto"));
                    
                    //articulo es publicado
                    if (rs.getBoolean("publicado")){
                        articulos.add("Publicado");
                    }
                    else {
                        articulos.add("No publicado");
                    }
                    
                    //articulo no publicado
                    if (rs.getBoolean("autorizado")){
                        articulos.add("Autorizado");
                    }
                    else {
                        articulos.add("No autorizado");
                    }
                }
            }
        }
        
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            articulos.add("");
        }
        
        return articulos;
    }
    
}
