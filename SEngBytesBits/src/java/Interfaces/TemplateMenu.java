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
public class TemplateMenu {
    
    public static void header(PrintWriter out, String title, String url) {
        /* TODO output your page here. You may use following sample code. */
        out.println("<!doctype html>  \n" +
            "<html lang=\"en\">\n" +
            "	\n" +
            "	<head>\n" +
            "		<meta charset=\"utf-8\">\n" +
            "		\n" +
            "		<title>stroll.js - CSS3 Scroll Effects</title>\n" +
            "\n" +
            "		<meta name=\"description\" content=\"A set of list scroll effects applied via CSS.\">\n" +
            "		<meta name=\"author\" content=\"Hakim El Hattab\">\n" +
            "		\n" +
            "		<link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic' rel='stylesheet' type='text/css'>\n" +
            "		\n" +
            "		<link rel=\"stylesheet\" href=\"example.css\">\n" +
            "		<link rel=\"stylesheet\" href=\"stroll.css\">\n" +
            "\n" +
            "		<style>\n" +
            "			body {\n" +
            "				overflow: hidden;\n" +
            "			}\n" +
            "			header {\n" +
            "				margin-bottom: 0;\n" +
            "			}\n" +
            "			ul {\n" +
            "				position: fixed;\n" +
            "				top: 1px;\n" +
            "				left: 5px;\n" +
            "				height: 300px;\n" +
            "				width: 30%;\n" +
            "				margin: 0 auto;\n" +
            "				margin-left: 0;\n" +
            "				overflow-x: visible;\n" +
            "				padding: 0;\n" +
            "			}\n" +
            "			ul li {\n" +
            "				position: relative;\n" +
            "				width: 58%;\n" +
            "				height: 50px;\n" +
            "				margin: 0;\n" +
            "				padding: 80px;\n" +
            "				padding-left: 20px;\n" +
            "				padding-top: 45px;\n" +
            "				padding-bottom: 20px;\n" +
            "			}\n" +
            "		</style>\n" +
            "	</head>\n" +
            "	\n" +
            "	<body>\n" +
            "		<ul class=\"fan\">\n" +
            "			<li>" + title + "</li>\n" +
            "			<li><a href = \"VerArticulos\" STYLE= \"text-decoration:none\">Ver Articulos</a></li>\n" +
        "			<li><a href = \"VerRevistas\" STYLE= \"text-decoration:none\">Ver Revistas</a></li>\n" +
        "			<li><a href = \"VerSuscriptores\" STYLE= \"text-decoration:none\">Ver Suscriptores</a></li>\n" +
        "			<li><a href = \"VerAutores\" STYLE= \"text-decoration:none\">Ver Autores</a></li>\n" +
        "			<li><a href = \"AnaRevista\" STYLE= \"text-decoration:none\">Analisis Revista</a></li>\n" +
        "			<li><a href = \"AnaSuscriptor\" STYLE= \"text-decoration:none\">Analisis Suscriptor</a></li>\n" +
        "			<li><a href = \"AnaAutor\" STYLE= \"text-decoration:none\">Analisis Autor</a></li>\n" +
        "			<li><a href = \"BuscarAutor\" STYLE= \"text-decoration:none\">Buscar Autor</a></li>\n" +
        "                       <li><a href = \"BuscarArticulo\" STYLE= \"text-decoration:none\">Buscar Articulo</a></li>\n" +
        "			<li><a href = \"CrearSuscriptor\" STYLE= \"text-decoration:none\">Crear Suscriptor</a></li>\n" +
        "                       <li><a href = \"CrearCarta\" STYLE= \"text-decoration:none\">Crear Carta Editor</a></li>\n" +
        "			<li><a href = \"VotarArticulo\" STYLE= \"text-decoration:none\">Votar por Articulo</a></li>\n" +
        "			<li><a href = \"AprobarJuez\" STYLE= \"text-decoration:none\">Aprobar Juez</a></li>\n" +
        "			<li><a href = \"HacerPedido\" STYLE= \"text-decoration:none\">Hacer Pedido</a></li>\n" +
        "			<li><a href = \"AdministrarPago\" STYLE= \"text-decoration:none\">Administrar Pagos</a></li>\n" +
"		</ul>\n" +
            "\n" +
            "		<script src=\"stroll.js\"></script>\n" +
            "		<script>\n" +
            "			var list = document.querySelector( 'ul' );\n" +
            "			var type = window.location.search.slice( 1 ) || 'fan';\n" +
            "\n" +
            "			list.className = type;\n" +
            "			\n" +
            "			window.addEventListener( 'resize', updateHeight, false );\n" +
            "\n" +
            "			updateHeight();\n" +
            "\n" +
            "			function updateHeight() {\n" +
            "				list.style.height = window.innerHeight + 'px';\n" +
            "				stroll.bind( 'ul' );\n" +
            "			}\n" +
            "		</script>\n" +
            "\n" +
            "\n" +
            "		<!-- Third party shizzle -->\n" +
            "\n" +
            "		<a href=\"https://github.com/hakimel/stroll.js\"><img style=\"position: absolute; top: 0; right: 0; border: 0;\" src=\"https://a248.e.akamai.net/camo.github.com/e6bef7a091f5f3138b8cd40bc3e114258dd68ddf/687474703a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f7265645f6161303030302e706e67\" alt=\"Fork me on GitHub\"></a>\n" +
            "\n" +
            "		<script type=\"text/javascript\" src=\"http://platform.twitter.com/widgets.js\"></script>\n" +
            "\n" +
            "		<script>\n" +
            "		var _gaq = [['_setAccount', 'UA-15240703-1'], ['_trackPageview']];\n" +
            "		(function(d, t) {\n" +
            "		var g = d.createElement(t),\n" +
            "		    s = d.getElementsByTagName(t)[0];\n" +
            "		g.async = true;\n" +
            "		g.src = ('https:' == location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\n" +
            "		s.parentNode.insertBefore(g, s);\n" +
            "		})(document, 'script');\n" +
            "		</script>\n" +
            "		\n" +
            "	</body>\n" +
            "</html>");
            }
    public static void footer(PrintWriter out) {
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}

