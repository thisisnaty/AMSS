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
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>");
        out.println("<link rel='stylesheet' href = 'main.css'>");
        out.println("<script src='https://code.jquery.com/jquery-2.1.4.min.js'></script>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>");
        out.println("</head>");
        out.println("<div>\n" +
"        <h2>SEng Bytes & Bits</h2>\n" +
"        </div>");
    }
    public static void footer(PrintWriter out) {
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}

