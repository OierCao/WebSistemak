package nirepaketea;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class MainServlet extends HttpServlet {

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> MainServlet ---> doGet() metodoan sartzen");
        response.setHeader("Cache-Control", "no-cache");

        String logout = request.getParameter("logout");
        System.out.println("---> MainServlet ---> Logout: " + logout);

        if (logout != null){ //erabiltzaileak saioa itxi nahi du
            if (logout.equals("true")){
                System.out.println("---> MainServlet ---> User log out: redirecting to login form");
                HttpSession session = request.getSession(false);
                session.invalidate();

                request.setAttribute("log_out", true);
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/login_form.jsp");
                rd.forward(request, response);
            }

        }
        else {
            if (request.getSession(false) != null){
                System.out.println("---> MainServlet ---> User is logged: redirecting to welcome");
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/welcome.jsp");
                rd.forward(request, response);
            }
            else {
                System.out.println("---> MainServlet ---> User not logged: redirecting to login form");
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/login_form.jsp");
                rd.forward(request, response);
            }
        }

        System.out.println("---> MainServlet ---> doGet() metodotik irtetzen");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void destroy() {
    }
}