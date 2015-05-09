/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entities.Autor;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author nataliagarcia
 */
public class ControlAutor {
    Autor autor;
    private transient Conexion conexion;
    
    public ControlAutor() {
        conexion = new Conexion();     
        autor = new Autor(conexion);
    }
    
    public String[][] verAutores(){
        LinkedList<String> lklArticulos = autor.getAutores();
        int size = lklArticulos.size();
        String[][] matAutores = new String[size/8][8];
        int cont = 0;
        for (int i = 0; i < size/8; i++) {
            for (int j = 0; j < 8; j++){
                matAutores[i][j] = lklArticulos.get(cont);
                cont++;
            }
        }
        return matAutores;
    }
}
