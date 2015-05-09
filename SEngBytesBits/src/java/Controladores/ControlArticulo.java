/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Entities.Articulo;
import Entities.Autor;
import Entities.Juez;
import Entities.Revista;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rrs94
 */
public class ControlArticulo {
    Articulo articulo;
    private transient Conexion conexion;
    
     //Prepara la conexión que comparte con las entidades
    ControlArticulo(){
      conexion = new Conexion();     
      articulo = new Articulo(conexion);
    }
//    public void nuevoArticulo (String idArticulo, String titulo, String tema, Date fechaPublicacion,
//            boolean publicado, boolean autorizado, Juez juezSupervisor, Revista revistaPertenece,
//            List<Autor> autores){
//      articulo = new Articulo();
//      articulo.crearArticulo(titulo, autor);
//    }
    
    public String[][] verArticulos(){
        LinkedList<String> lklArticulos = articulo.getArticulos();
        int size = lklArticulos.size();
        String[][] matArticulos = new String[size][5];
        int cont = 0;
        for (int i = 0; i < size/6; i++) {
            for (int j = 0; j < 6; j++){
                matArticulos[i][j] = lklArticulos.get(cont);
                cont++;
            }
        }
        return matArticulos;
    }


}
