package nirepaketea;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.TimeZone;


public class CacheServlet extends HttpServlet {

    private SimpleDateFormat data_formatua;
    private long lastModified;

    public void init(ServletConfig config) {
        System.out.println("---> CacheServlet ---> init()");

        data_formatua = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        data_formatua.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));

        long now = System.currentTimeMillis();
        lastModified = now - (now % 1000);

        System.out.println("---> CacheServlet ---> Last-Modified: " + data_formatua.format(lastModified));
        System.out.println("<--- CacheServlet <--- init()");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("---> CacheServlet ---> doGet()");

        String update = request.getParameter("update");

        if(update != null) {
            long now = System.currentTimeMillis();
            lastModified = now - (now % 1000);

            System.out.println("---> CacheServlet ---> NEW Last-Modified: " + data_formatua.format(lastModified));

            PrintWriter http_out = response.getWriter();
            http_out.println("Last-Modified eguneratu da: " + data_formatua.format(lastModified));

        } else {
            long ifModifiedSince = request.getDateHeader("If-Modified-Since");

            PrintWriter http_out = response.getWriter();

            if (ifModifiedSince >= lastModified) {
                System.out.println("---> CacheServlet ---> Status: 304 Not-Modified");
                response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);

                System.out.println("If-Modified-Since: " + data_formatua.format(ifModifiedSince));
                System.out.println("Last-Modified: " + data_formatua.format(lastModified));

                System.out.println("<--- CahcheServlet");

            } else {
                System.out.println("---> CacheServlet ---> Status: 200 OK");
                response.setStatus(HttpServletResponse.SC_OK);

                response.setDateHeader("Last-Modified", lastModified);
                response.addHeader("Cache-Control", "max-age=15");
                response.setContentType("text/plain; charset=utf-8");

                System.out.println("If-Modified-Since: " + data_formatua.format(ifModifiedSince));
                System.out.println("Last-Modified: " + data_formatua.format(lastModified));

                System.out.println("<--- CahcheServlet");
            }
            http_out.println("If-Modified-Since: " + data_formatua.format(ifModifiedSince));
            http_out.println("Last-Modified: " + data_formatua.format(lastModified));
        }

        System.out.println("<--- CacheServlet <--- doGet()");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}