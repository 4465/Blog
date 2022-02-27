package com.xfnlp.dao;

import java.sql.*;

public class LoginDAO {
    public static boolean validate(String name, String password){
        boolean status = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "root");

            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * from t_user where username=?and password=?"
            );

            ps.setString(1,name);
            ps.setString(2,password);

            ResultSet res =  ps.executeQuery();
            status = res.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return status;
    }
}
