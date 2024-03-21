package com.example.websistemak;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloJSPServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Ongi etorri Tomcat-era";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Hello JSPservlet-ean sartzen...");

        //HTTP eskaera adierazten duen objetuan atributu bat gehitu
        //atributu horren balioa 'message' String-a delarik
        request.setAttribute("katea", message);

        System.out.println("Loko");
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/bista.jsp");
        rd.forward(request, response);

        System.out.println("---> Hello JSPservlet-etik irtetzen...");
    }

    public void destroy() {
    }
}
