package com.project.Servlet;

import com.project.Connection.*;
import com.project.DAO.*;
import com.project.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",value ="/user-login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { response.sendRedirect("login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        try (PrintWriter out = response.getWriter();) {
            String email = request.getParameter("login-email");
            String password = request.getParameter("login-password");
            try {

                UserDAO udao = new UserDAO(DatabaseConnection.getConnection());
                User user = udao.userLogin(email, password);
                if (user != null) {
                    request.getSession().setAttribute("auth", user);
                    response.sendRedirect("index.jsp");
                } else {
                    out.println("invalid user");
                }

            } catch (SQLException | ClassNotFoundException var18) {
                var18.printStackTrace();
            }

        }
    }
}
