package com.xfnlp.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

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

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "root");

            PreparedStatement ps = conn.prepareStatement("insert into t_user(username,password) values(?,?)");

            ps.setString(1,username);
            ps.setString(2,password);

            int i = ps.executeUpdate();

            if(i>0){
                out.print("您已经注册成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(e);
        }
        out.close();
    }
}
