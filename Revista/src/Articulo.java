
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
public class Articulo {
    private String idArticulo;
    private String titulo;
    private String tema;
    private Date fechaPublicacion;
    private boolean publicado;
    private boolean autorizado;
    private Juez juezSupervisor;
    private Revista revistaPertenece;
    private List<Autor> autores;   
}
