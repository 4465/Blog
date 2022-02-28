package com.xfnlp.servlet;

import com.xfnlp.dao.UserDAOImpl;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    UserDAOImpl userDAO = new UserDAOImpl();


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

        String err = "";
        if(username.equals("") || password.equals("")){
            err += "必须输入完整信息";
        }
        else {
            if(userDAO.login(username, password) == false){
                err += "用户名或密码不正确!";
            }
        }

        if(err.length() > 0){
            request.setAttribute("err", err);
        }

        try{
            if(err.length() == 0){
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                userDAO.login(username,password);
                Cookie loginCookie = new Cookie("username", username);
                loginCookie.setMaxAge(30*60);
                response.addCookie(loginCookie);
                response.sendRedirect("index.jsp");
            }else {

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("/login.jsp");
        }
    }
}
