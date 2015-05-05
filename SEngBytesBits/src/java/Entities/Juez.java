package Entities;
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
public class Juez {
    private String idJuez;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private Date fechaEntrada;
    private char sexo;
    private String idEditorSupervisor;
    
    public Juez () {
        this.idJuez = null;
        this.nombreCompleto = null;
        this.fechaNacimiento = null;
        this.fechaEntrada = null;
        this.sexo = '0';
        this.idEditorSupervisor = null;
    }

    public Juez(String idJuez, String nombreCompleto, Date fechaNacimiento, Date fechaEntrada, 
            char sexo) {
        this.idJuez = idJuez;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaEntrada = fechaEntrada;
        this.sexo = sexo;
    }
    
    
}
