package Entities;

import Controladores.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;
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
            revistaPertenece = new Revista(nombre, idRevista, publicacion, numImpresiones);
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
    
    List<Autor> getAutores() {
        List<Autor> autores = new List<Autor>() {

            @Override
            public int size() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isEmpty() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean contains(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Iterator<Autor> iterator() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object[] toArray() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public <T> T[] toArray(T[] a) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean add(Autor e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean remove(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean addAll(Collection<? extends Autor> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean addAll(int index, Collection<? extends Autor> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void clear() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Autor get(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Autor set(int index, Autor element) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(int index, Autor element) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Autor remove(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int indexOf(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int lastIndexOf(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public ListIterator<Autor> listIterator() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public ListIterator<Autor> listIterator(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Autor> subList(int fromIndex, int toIndex) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        try {
            String sql = "SELECT idAutor FROM ArticuloAutor WHERE idArticulo=?";
            conn.stmt.executeUpdate(sql);
            pst.setString(1, idArticulo);
            rs = pst.executeQuery();
            if(rs.next()) {
                autores = new List<Autor>() {
                    
                    @Override
                    public int size() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean isEmpty() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean contains(Object o) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public Iterator<Autor> iterator() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public Object[] toArray() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public <T> T[] toArray(T[] a) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean add(Autor e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean remove(Object o) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean containsAll(Collection<?> c) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean addAll(Collection<? extends Autor> c) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean addAll(int index, Collection<? extends Autor> c) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean removeAll(Collection<?> c) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean retainAll(Collection<?> c) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public void clear() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public Autor get(int index) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public Autor set(int index, Autor element) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public void add(int index, Autor element) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public Autor remove(int index) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public int indexOf(Object o) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public int lastIndexOf(Object o) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public ListIterator<Autor> listIterator() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public ListIterator<Autor> listIterator(int index) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public List<Autor> subList(int fromIndex, int toIndex) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
                autores.add(0, new Autor());
                while(rs.next()) {
                    String idAutor = rs.getString("idAutor");
                    sql = "SELECT * FROM Autor WHERE idAutor=?";
                    conn.stmt.executeUpdate(sql);
                    pst.setString(1, idAutor);
                    ResultSet rs2 = pst.executeQuery();
                    //checks all responses
                    if(rs2.next()){
                        String nombre = rs2.getString("nombreCompleto");
                        Date nacimiento = rs2.getDate("fechaNacimiento");
                        String corporacion = rs2.getString("corporacion");
                        char sexo = rs2.getString("sexo").charAt(0);
                        String permiso = rs2.getString("permiso");
                        String tipo = rs2.getString("tipo");
                        Autor aux = new Autor(idAutor, nombre, nacimiento, sexo, corporacion, permiso, tipo);
                        autores.add(aux);
                    }
                }
            }
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
            autores = new List<Autor>() {
                    
                    @Override
                    public int size() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean isEmpty() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean contains(Object o) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public Iterator<Autor> iterator() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public Object[] toArray() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public <T> T[] toArray(T[] a) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean add(Autor e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean remove(Object o) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean containsAll(Collection<?> c) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean addAll(Collection<? extends Autor> c) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean addAll(int index, Collection<? extends Autor> c) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean removeAll(Collection<?> c) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public boolean retainAll(Collection<?> c) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public void clear() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public Autor get(int index) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public Autor set(int index, Autor element) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public void add(int index, Autor element) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public Autor remove(int index) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public int indexOf(Object o) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public int lastIndexOf(Object o) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public ListIterator<Autor> listIterator() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public ListIterator<Autor> listIterator(int index) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public List<Autor> subList(int fromIndex, int toIndex) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
            autores.add(0, new Autor());
        }
        return autores;
    }
    
}
