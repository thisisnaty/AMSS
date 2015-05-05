/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Interfaces;

import java.io.PrintWriter;

/**
 *
 * @author nataliagarcia
 */
public class Template {
    
    public static void header(PrintWriter out, String title, String url) {
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + title +"</title>");
        out.println("<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>");
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>");
        out.println("<link rel='stylesheet' href = 'main.css'>");
        out.println("<script src='https://code.jquery.com/jquery-2.1.4.min.js'></script>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='nav'>\n" +
                "      <div class='container'>\n" +
                "        <ul class='pull-left'>\n" +
                "          <li><p>SEng Bytes & Bits</p></li>\n" +
                "        </ul>\n" +
                "      </div>\n" +
                "    </div>");
    }
}

