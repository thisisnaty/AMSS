
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
}
