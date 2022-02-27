package com.xfnlp.servlet;

import com.xfnlp.dao.LoginDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html;charset=utf8");

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(LoginDAO.validate(username,password)){
            RequestDispatcher rd = request.getRequestDispatcher("Welcome");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.include(request,response);
        }
        out.close();
    }
}
