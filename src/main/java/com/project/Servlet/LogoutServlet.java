package com.project.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/log-out"})
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LogoutServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Throwable var3 = null;
        Object var4 = null;

        try {
            PrintWriter out = response.getWriter();

            try {
                if (request.getSession().getAttribute("auth") != null) {
                    request.getSession().removeAttribute("auth");
                    response.sendRedirect("login.jsp");
                } else {
                    response.sendRedirect("index.jsp");
                }
            } finally {
                if (out != null) {
                    out.close();
                }

            }

        } catch (Throwable var11) {
            if (var3 == null) {
                var3 = var11;
            } else if (var3 != var11) {
                var3.addSuppressed(var11);
            }

            try {
                throw var3;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
