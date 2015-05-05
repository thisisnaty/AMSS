/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entities.EditorEnJefe;

/**
 *
 * @author nataliagarcia
 */
public class ControlLogin {
    EditorEnJefe eej;
    Conexion conn;
    public ControlLogin() {
        eej = new EditorEnJefe(conn);
    }
}
