/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.List;

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
    private List<Articulo> articulos;
    private CartaEditor carta;
    private List<Orden> ordenes;  
}

