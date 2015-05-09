/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Controladores.ControlArticulo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pescalante
 */
@WebServlet(name = "CrearCarta", urlPatterns = {"/CrearCarta"})
public class CrearCarta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            TemplateMenu.header(out, "Crear Suscriptor", request.getRequestURI());
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Crear Articulo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style='text-align:right'>Crear Articulo</h1>");
            out.write("<div style='overflow:auto'>");
            out.write("<form action='CrearCarta' method='POST'>");
            out.println("<p style='text-align:right'>Titulo</p>");
            out.write("<input type='text' name='titulo' class='form-control' style='float:right'><br>");
            out.println("<p style='text-align:right'>Tema</p>");
            out.write("<input type='text' name='tema' class='form-control' style='float:right'><br>");
            out.println("<p style='text-align:right'>Autor</p>");
            out.write("<input type='text' name='autor' class='form-control' style='float:right'><br>");
            out.println("<p style='text-align:right'>Revista</p>");
            out.write("<input type='datetime' name='revista' class='form-control' style='float:right'><br>");
            out.write("<br>");
            out.write("<input type='submit' class='btn btn-primary btn-block' value='crear' style='float:right'>");
            out.write("</form>");
            out.write("</div>");
            out.println("</body>");
            out.println("</html>");
            Template.footer(out);
        }
    }
    
    protected void sendRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String titulo = request.getParameter("titulo");
        String tema = request.getParameter("tema");
        String autor = request.getParameter("autor");
        String revista = request.getParameter("revista");
        Date hoy = new Date(System.currentTimeMillis());
        ControlArticulo articulo = new ControlArticulo();
        
        if (articulo.register(titulo,tema,autor,revista,hoy)) {
            response.sendRedirect("MenuPrincipal.html");
        }     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sendRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
