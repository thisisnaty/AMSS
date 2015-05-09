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
import java.util.LinkedList;
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
        this.idCarta = null;
    }

    public Revista(String nombre, String idRevista, Date fechaPublicacion, int numeroImpresiones,
        String idCarta) {
        this.nombre = nombre;
        this.idRevista = idRevista;
        this.fechaPublicacion = fechaPublicacion;
        this.numeroImpresiones = numeroImpresiones;
        this.idCarta = idCarta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdRevista() {
        return idRevista;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public int getNumeroImpresiones() {
        return numeroImpresiones;
    }

    public String getIdCarta() {
        return idCarta;
    }
    
    public LinkedList<Revista> getRevistas() {
        String idR, idC, nom;
        int numImp;
        Date fechaPub;
        ResultSet rs2;
        LinkedList<Revista> lklRevistas = new LinkedList();
        try {
            String sql = "SELECT * FROM Revista";
            pst = conn.conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()) {
                idR = rs.getString("idRevista");
                nom = rs.getString("nombre");
                fechaPub = rs.getDate("fechaPublicacion");
                numImp = rs.getInt("numeroImpresiones");
                idC = "nada";
//                sql = "SELECT idCarta FROM CartaEditor WHERE idRevista=?";
//                pst = conn.conn.prepareStatement(sql);
//                pst.setString(1, idR);
//                rs2 = pst.executeQuery();
//                
//                if(rs2.next()){
//                    idC = rs.getString("idCarta");
//                }
//                else {
//                    idC = null;
//                }
                
                Revista revista = new Revista(nom, idR, fechaPub, numImp, idC);
                lklRevistas.add(revista);
                
                while(rs.next()) {
                    idR = rs.getString("idRevista");
                    nom = rs.getString("nombre");
                    fechaPub = rs.getDate("fechaPublicacion");
                    numImp = rs.getInt("numeroImpresiones");
                    
//                    sql = "SELECT idCarta FROM CartaEditor WHERE idRevista=?";
//                    pst.setString(1, idR);
//                    rs2 = pst.executeQuery();
//                    if(rs2.next()){
//                        idC = rs.getString("idCarta");
//                    }
                    idC = "nada";
                    revista = new Revista(nom, idR, fechaPub, numImp, idC);
                    lklRevistas.add(revista);
                }
            }
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            lklRevistas.add(new Revista());
        }
        return lklRevistas;
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
    
    public String[] arrString() {
        int temp = this.numeroImpresiones;
        
        String[] arr = { this.nombre, this.idRevista, this.fechaPublicacion.toString(), Integer.toString(temp),
         this.idCarta };
        return arr;
    }
        /*this.nombre = null;
        this.idRevista = null;
        this.fechaPublicacion = null;
        this.numeroImpresiones = 0;
        this.idCarta = null;*/
}

