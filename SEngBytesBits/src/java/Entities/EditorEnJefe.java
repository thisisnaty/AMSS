package Entities;


import Controladores.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
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
public class EditorEnJefe {
    static String email;
    static String password;
    private String idEditor;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private Date fechaEntrada;
    private char sexo;
    /*SQL connection global variables*/
    //connection variable
    private transient Conexion conn;
    //prepare statement for query
    PreparedStatement pst;
    //result of query
    ResultSet rs;
    
    EditorEnJefe (Conexion conn) {
        this.conn = conn;
    }
    
    //wat is dis
    void tiempoEmpleado() {
        
    }
    
    //wat is dis tu
    void juecesAtendidos() {
        
    }
    
    List<CartaEditor> cartasEscritas() {
        List<CartaEditor> cartas = new List<CartaEditor>() {

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
            public Iterator<CartaEditor> iterator() {
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
            public boolean add(CartaEditor e) {
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
            public boolean addAll(Collection<? extends CartaEditor> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean addAll(int index, Collection<? extends CartaEditor> c) {
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
            public CartaEditor get(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public CartaEditor set(int index, CartaEditor element) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(int index, CartaEditor element) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public CartaEditor remove(int index) {
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
            public ListIterator<CartaEditor> listIterator() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public ListIterator<CartaEditor> listIterator(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<CartaEditor> subList(int fromIndex, int toIndex) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        try {
            String sql = "SELECT * FROM CartaEditor WHERE idEditor=?";
            //make sql script
            conn.stmt.executeUpdate(sql);
            pst.setString(1,idEditor);
            //executes query
            rs = pst.executeQuery();
            //checks all responses
            if(rs.next()){
                //reset categories array
                cartas = new List<CartaEditor>() {

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
                    public Iterator<CartaEditor> iterator() {
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
                    public boolean add(CartaEditor e) {
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
                    public boolean addAll(Collection<? extends CartaEditor> c) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public boolean addAll(int index, Collection<? extends CartaEditor> c) {
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
                    public CartaEditor get(int index) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public CartaEditor set(int index, CartaEditor element) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void add(int index, CartaEditor element) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public CartaEditor remove(int index) {
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
                    public ListIterator<CartaEditor> listIterator() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public ListIterator<CartaEditor> listIterator(int index) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public List<CartaEditor> subList(int fromIndex, int toIndex) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
                cartas.add(0, new CartaEditor());
                //adds first category
                CartaEditor aux = new CartaEditor(rs.getString("idCarta"), rs.getString("titulo"),
                        rs.getDate("fechaPublicacion"), rs.getString("tema"), rs.getBoolean("publicado"),
                        rs.getString("idEditor"));
                
                cartas.add(aux);
                //while there are more categories
                while(rs.next()){
                    //found a new category
                    aux = new CartaEditor(rs.getString("idCarta"), rs.getString("titulo"),
                            rs.getDate("fechaPublicacion"), rs.getString("tema"), rs.getBoolean("publicado"),
                            rs.getString("idEditor"));
                    
                    cartas.add(aux);
                }
            }
            //error in finding database
            else {
                cartas = new List<CartaEditor>() {

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
                    public Iterator<CartaEditor> iterator() {
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
                    public boolean add(CartaEditor e) {
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
                    public boolean addAll(Collection<? extends CartaEditor> c) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public boolean addAll(int index, Collection<? extends CartaEditor> c) {
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
                    public CartaEditor get(int index) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public CartaEditor set(int index, CartaEditor element) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void add(int index, CartaEditor element) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public CartaEditor remove(int index) {
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
                    public ListIterator<CartaEditor> listIterator() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public ListIterator<CartaEditor> listIterator(int index) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public List<CartaEditor> subList(int fromIndex, int toIndex) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
                cartas.add(0, new CartaEditor());
            }
        }
        //error in database
        catch (SQLException ex){
            //displays error
            JOptionPane.showMessageDialog(null,ex);
        }
        return cartas;
    }
    
    boolean validateLogin() {
        try {
            String sql = "SELECT * FROM Editor WHERE email=? AND password=?";
            conn.stmt.executeUpdate(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            email = rs.getString("email");
            password = rs.getString("password");
            idEditor = rs.getString("idEditor");
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
