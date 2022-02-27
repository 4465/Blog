package com.xfnlp.servlet;

import com.xfnlp.dao.UserDAOImpl;
import com.xfnlp.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    private UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf8");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String err = "";
        String url = "/register.jsp";

        if(username.equals("")||password.equals("")){
            err += "必须输入完整信息！";
        }else{
            if(userDAO.checkUser(username) == true){
                err += "用户名已经被注册！";
            }
        }

        if (err.length() > 0) {
            request.setAttribute("err", err);
        }

        try{
            if(err.length()==0){
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                userDAO.addUser(new User(0, username,password));
                userDAO.login(username, password);
                Cookie loginCookie = new Cookie("username",username);
                //setting cookie to expiry in 30 mins
                loginCookie.setMaxAge(30*60);
                response.addCookie(loginCookie);
                response.sendRedirect("index.jsp");
            }else {
                url = "/register.jsp";
                RequestDispatcher rd = getServletContext()
                        .getRequestDispatcher(url);
                rd.forward(request, response);
            }
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/register.jsp");
        }
    }
}
