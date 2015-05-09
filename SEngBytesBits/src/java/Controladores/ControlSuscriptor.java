/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entities.Suscriptor;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author rrs94
 */

public class ControlSuscriptor {
    Suscriptor suscriptor;
    private transient Conexion conexion;
    
     //Prepara la conexión que comparte con las entidades
    public ControlSuscriptor(){
      conexion = new Conexion();     
      suscriptor = new Suscriptor(conexion);
    }
    public boolean login (String username, String password){
        
        return suscriptor.validateLogin(username, password);
    }
    public boolean register (String username, String password, String nombre, String corp, Date nacimiento, char sexo, String direccion, String tarjeta, int clave, Date expiracion){
        Date hoy = new Date(System.currentTimeMillis());
        return suscriptor.register(username, password, nombre, corp, nacimiento, sexo, direccion, tarjeta, clave, expiracion,hoy);
    }
    
    public String[][] verSuscriptores(){
        LinkedList<String> lklSusc = suscriptor.getSuscriptores();
        int size = lklSusc.size();
        String[][] matSusc = new String[size/11][11];
        int cont = 0;
        for (int i = 0; i < size/11; i++) {
            for (int j = 0; j < 11; j++){
                matSusc[i][j] = lklSusc.get(cont);
                cont++;
            }
        }
        return matSusc;
    }

}
