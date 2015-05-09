/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Controladores.ControlSuscriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pescalante
 */
@WebServlet(name = "CrearSuscriptor", urlPatterns = {"/CrearSuscriptor"})
public class CrearSuscriptor extends HttpServlet {

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
            out.println("<title>Crear Suscriptor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style='text-align:right'>Crear Suscriptor</h1>");
            out.write("<div style='overflow:auto'>");
            out.write("<form action='Login' method='POST'>");
            out.println("<p style='text-align:right'>Nombre Completo</p>");
            out.write("<input type='text' name='nombre' class='form-control' style='float:right'><br>");
            out.println("<p style='text-align:right'>Corporacion</p>");
            out.write("<input type='text' name='corp' class='form-control' style='float:right'><br>");
            out.println("<p style='text-align:right'>Fecha de nacimiento</p>");
            out.write("<input type='datetime' name='nacimiento' class='form-control' style='float:right'><br>");
            out.println("<p style='text-align:right'>Sexo</p>");
            out.write("<input type='char' name='sexo' class='form-control' style='float:right'><br>");
            out.println("<p style='text-align:right'>Direccion</p>");
            out.write("<input type='text' name='direccion' class='form-control' style='float:right'><br>");
            out.println("<p style='text-align:right'>Tarjeta de Credito</p>");
            out.write("<input type='text' name='tarjeta' class='form-control' style='float:right'><br>");
            out.println("<p style='text-align:right'>Clave</p>");
            out.write("<input type='int' name='clave' class='form-control' style='float:right'><br>");
            out.println("<p style='text-align:right'>Fecha de Expiracion</p>");
            out.write("<input type='datetime' name='expiracion' class='form-control' style='float:right'><br>");
            out.println("<p style='text-align:right'>Nombre de usuario</p>");
            out.write("<input type='text' name='username' class='form-control' style='float:right'><br>");
            out.println("<p style='text-align:right'>Contraseña</p>");
            out.write("<input type='password' name='password' class='form-control' style='float:right'><br>");
            out.write("<br>");
            out.write("<input type='submit' class='btn btn-primary btn-block' value='register' style='float:right'>");
            out.write("</form>");
            out.write("</div>");
            out.println("</body>");
            out.println("</html>");
            Template.footer(out);
        }
    }
    
    protected void sendRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String corp = request.getParameter("corp");
        Date nacimiento = Date.valueOf(request.getParameter("nacimiento"));
        char sexo = request.getParameter("sexo").charAt(0);
        String direccion = request.getParameter("direccion");
        String tarjeta = request.getParameter("tarjeta");
        int clave = Integer.parseInt(request.getParameter("clave"));
        Date expiracion = Date.valueOf(request.getParameter("expiracion"));
        
        //response.sendRedirect("Articulos");
        ControlSuscriptor userRegister = new ControlSuscriptor();
        
        if (userRegister.register(username, password, nombre, corp, nacimiento, sexo, direccion, tarjeta, clave, expiracion)) {
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
