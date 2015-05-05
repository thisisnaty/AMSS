package Entities;

import java.util.Date;
import Controladores.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class CartaEditor {
    private String idCarta;
    private String titulo;
    private Date fechaPublicacion;
    private String tema;
    private boolean publicado;
    private String idEditor;
    private String idRevista;
    /*SQL connection global variables*/
    //connection variable
    private transient Conexion conn;
    //prepare statement for query
    PreparedStatement pst;
    //result of query
    ResultSet rs;
    
    public CartaEditor(Conexion conn) {
        this.conn = conn;
    }

    public CartaEditor() {
        this.idCarta = null;
        this.titulo = null;
        this.fechaPublicacion = null;
        this.tema = null;
        this.publicado = false;
        this.idEditor = null;
        this.idRevista = null;
    }
    
    public CartaEditor(String idCarta, String titulo, Date fechaPublicacion, String tema, boolean publicado, String idEditor, String idRevista) {
        this.idCarta = idCarta;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.tema = tema;
        this.publicado = publicado;
        this.idEditor = idEditor;
        this.idRevista = idRevista;
    }
    
    Revista getRevista() {
        try {
            String sql = "SELECT * FROM Revista WHERE idRevista = ?";
            //make sql script
            conn.stmt.executeUpdate(sql);
            pst.setString(1,idRevista);
            //executes query
            rs = pst.executeQuery();
            if(rs.next()){
            //checks all responses
            Revista aux = new Revista(rs.getString("nombre"), rs.getString("idRevista"), rs.getDate("fechaPublicacion"), rs.getInt("numeroImpresiones"));
                //String nombre, String idRevista, Date fechaPublicacion, int numeroImpresiones, 
            return aux;
            }
            else {
                Revista aux = new Revista();
                return aux;
            }
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            Revista aux = new Revista();
            return aux;
        }
    }
    
    //wat is dis
    void todasRevistasComoJefe() {
        
    }
    
    //wat is dis
    String getEditor() {
         try {
            String sql = "SELECT * FROM EditorEnJefe WHERE idEditor = ?";
            //make sql script
            conn.stmt.executeUpdate(sql);
            pst.setString(1,idEditor);
            //executes query
            rs = pst.executeQuery();
            String editor = rs.getString("nombreCompleto");
            return editor;
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            String aux="error";
            return aux;
        }
    }
}
