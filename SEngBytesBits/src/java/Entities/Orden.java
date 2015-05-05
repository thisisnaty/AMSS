package Entities;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pescalante
 */
public class Orden {
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
