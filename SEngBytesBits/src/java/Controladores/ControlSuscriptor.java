/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entities.Suscriptor;
import java.sql.Date;
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

}
