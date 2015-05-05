/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entities.Articulo;
import Controladores.Conexion;

/**
 *
 * @author rrs94
 */
public class CrearArticulo {
    Articulo articulo;
    Conexion conn;
    public CrearArticulo() {
        articulo = new Articulo (conn);
    }
    
}
