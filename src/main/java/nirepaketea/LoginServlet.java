package nirepaketea;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> LoginServlet ---> doGet() metodoan sartzen");
        response.setHeader("Cache-Control", "no-cache");

        String erabiltzailea = request.getParameter("username");
        String pasahitza = request.getParameter("password");
        System.out.print("---> LoginServlet ---> Erabiltzailea: " + erabiltzailea);
        System.out.println("---> LoginServlet ---> Pasahitza: " + pasahitza);

        if(erabiltzailea != null && pasahitza !=null) {
            if (erabiltzailea.equals("ws") && pasahitza.equals("1234")) { // erabiltzailea eta pasahitza zuzenak dira
                System.out.println("---> LoginServlet --> Login OK");
                HttpSession session = request.getSession(true); // Saioa ez bada exisititzen, saioa sortu
                session.setAttribute("username", erabiltzailea); //Saioari lotutako atributua

                System.out.println("----> LoginServlet --> Redirecting to MainServlet");
                ServletContext context = request.getServletContext();
                RequestDispatcher rd = context.getNamedDispatcher("MainServlet"); //web.xml fitxategiko <servlet-name>
                rd.forward(request, response);

                /*
                response.setContentType("text/plain");
                PrintWriter http_out= response.getWriter();
                http_out.println("Login OK!");
                */

            } else { // erabiltzailea eta pasahitza okerrak dira
                System.out.println("---> LoginServlet --> Login error: redirecting to login form");
                boolean login_error = true;
                request.setAttribute("login_error", login_error);
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/login_form.jsp");
                rd.forward(request, response);
            }


        } else if (request.getSession(false) != null){
            System.out.println("---> LoginServlet --> User already logged: redirecting to MainServlet");
            ServletContext context = request.getServletContext();
            RequestDispatcher rd = context.getNamedDispatcher("MainServlet"); //web.xml fitxategiko <servlet-name>
            rd.forward(request, response);
        }
        else { // servlet-a zuzenean, parametrorik gabe, deitzen da eta ez da saiorik existitzen
            System.out.println("---> LoginServlet ---> User not logged: redirecting to login form");
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/login_form.jsp");
            rd.forward(request, response);
        }

        System.out.println("---> LoginServlet ---> doGet() metodotik irtetzen");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void destroy() {
    }
}