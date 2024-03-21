package com.example.websistemak;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


public class HelloGoiburuakServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Hello GoiburuakServlet-ean sartzen...");

        System.out.println("---> HelloGoiburuak ---> /jsp/goiburuak.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/goiburuak.jsp");
        rd.forward(request, response);

        System.out.println("---> Hello GoiburuakServlet-etik irtetzen...");
    }

    public void destroy() {
    }
}
