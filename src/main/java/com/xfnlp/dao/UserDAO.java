package com.xfnlp.dao;


import com.xfnlp.model.User;

public interface UserDAO {
    public void addUser(User u);

    public boolean checkUser(String name);

    public boolean login(String username, String password);

    public void updateUser(User u);

    public User getUser(String username);
}
