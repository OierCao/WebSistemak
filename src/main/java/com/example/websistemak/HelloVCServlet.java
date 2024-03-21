package com.example.websistemak;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloVCServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("---> HelloVC servlet-ean sartzen...");

        //302 erantzun bat bueltatu
        response.sendRedirect("/ws/html/bista.html");

        System.out.println("---> HelloVC servlet-etik irtetzen...");
    }

    public void destroy() {
    }
}
