
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
    private List<Articulo> articulosRevisados;
    private EditorEnJefe editorSupervisor;
    private List<Orden> ordenes; 
}
