package Entities;
import java.util.Date;
import java.util.List;

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
    private List<Articulo> articulosRevisados;
    private List<Orden> ordenes; 
    
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
    
    
    
    
}
