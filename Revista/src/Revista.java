/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.List;

/**
 *
 * @author pau escalante
 */
public class Revista {
    
    private String nombre;
    private String idRevista;
    private Date fechaPublicacion;
    private int numeroImpresiones;
    private List<Articulo> articulos;
    private CartaEditor carta;
    private List<Orden> ordenes;  
}

class CartaEditor {
    private String idCarta;
    private String titulo;
    private String tema;
    private Date fechaPublicacion;
    private boolean publicado;
    private EditorEnJefe editor;
    private Revista revistaPertenece;
}

class EditorEnJefe {
    private String idEditor;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private Date fechaEntrada;
    private char sexo;
    private List<CartaEditor> cartas;
    private List<Juez> juecesDeSupervisor;
}

class Juez {
    private String idJuez;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private Date fechaEntrada;
    private char sexo;
    private List<Articulo> articulosRevisados;
    private EditorEnJefe editorSupervisor;
    private List<Orden> ordenes; 
}

class Articulo {
    private String idArticulo;
    private String titulo;
    private String tema;
    private Date fechaPublicacion;
    private boolean publicado;
    private boolean autorizado;
    private Juez juezSupervisor;
    private Revista revistaPertenece;
    private List<Autor> autores;
}

class Autor {
    private String idAutor;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private char sexo;
    private String corporacion;
    private String permiso;
    private String tipo;
    private List<Articulo> articulosRevisados;
    private List<Orden> ordenes; 
}

class Suscriptor {
    private String idSuscriptor;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private Date fechaEntrada;
    private Date fechaExpiracion;
    private char sexo;
    private String compania;
    private String direccion;
    private String tarjetaCredito;
    private int clave;
    private List<Orden> ordenes; 
}

class Pago {
    private String idPago;
    private Date fechaPago;
    private double fecha;
    private Orden ordenPagada;
}

class Orden {
    private String idOrden;
    private double precio;
    private char tipoRevista;
    private double descuento;
    private int cantidad;
    private Date fechaExpiracion;
    private Suscriptor suscriptorDeOrden;
    private Autor suscriptorAutor;
    private Revista revistaOrdenada;    
    private Pago pagoOrden;
}

