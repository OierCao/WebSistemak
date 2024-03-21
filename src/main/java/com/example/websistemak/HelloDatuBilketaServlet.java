package com.example.websistemak;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloDatuBilketaServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("---> Hello");

        String zenbakia = request.getParameter("zenbakia");
        System.out.println("---> HelloDatuBilaketa servlet-a: zenbakia = " + zenbakia);

        String alfabetoa = "TRWAGMYFPDXBNJZSQVHLCKE";
        Integer modulua = Integer.parseInt(zenbakia) % 23;
        char letra = alfabetoa.charAt(modulua);
        System.out.println("--->");

        response.setContentType("text/plain");
        PrintWriter erantzunaren_edukia = response.getWriter();
        erantzunaren_edukia.println(letra);

        System.out.println("--->");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void destroy() {
    }
}
