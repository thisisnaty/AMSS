/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entities.Revista;
import java.util.LinkedList;

/**
 *
 * @author nataliagarcia
 */
public class ControlRevista {
    Revista revista;
    private transient Conexion conexion;
    
     //Prepara la conexión que comparte con las entidades
    public ControlRevista(){
      conexion = new Conexion();     
      revista = new Revista(conexion);
    }
    
    public String[][] verRevistas() {
        LinkedList<Revista> lklRevistas = revista.getRevistas();
        int size = lklRevistas.size();
        String[][] matRevista = new String[size][5];
        for (int i = 0; i < size; i++) {
            matRevista[i] = lklRevistas.get(i).arrString();
        }
        return matRevista;
    }
}
