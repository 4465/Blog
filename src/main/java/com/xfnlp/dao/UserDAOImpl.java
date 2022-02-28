package com.xfnlp.dao;


import com.xfnlp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{
    @Override
    public void addUser(User u) {
        Connection conn = DBConnect.getConnection();
        String sql = "insert into t_user value(0,?,?)";
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean checkUser(String name) {
        Connection conn = DBConnect.getConnection();
        String sql = "select * from t_user where username = '" +  name + "' ";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                conn.close();
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        Connection conn = DBConnect.getConnection();
        String sql = "select * from t_user where username = ? and password = ?";
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                conn.close();
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateUser(User u) {
        Connection conn  = DBConnect.getConnection();
        String sql = "update t_user set password= ? where username = ?";
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getPassword());
            ps.setString(2, u.getUsername());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User getUser(String name) {
        Connection conn = DBConnect.getConnection();
        String sql = "select * from t_user where username='" + name + "'";
        User u = new User();
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getNString("username");
                String password = rs.getNString("password");
                u = new User(id, username, password);
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return u;
    }
}


