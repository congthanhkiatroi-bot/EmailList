package com.webprogramming.emaillist.dao;

import com.webprogramming.emaillist.model.User;

public class TestUserDAO {

    public static void main(String[] args) {

        User user = new User(
                "testjava@gmail.com",
                "Thanh",
                "Nguyen"
        );

        UserDAO userDAO = new UserDAO();

        boolean result = userDAO.insertUser(user);

        if (result) {
            System.out.println("User inserted successfully!");
        } else {
            System.out.println("Failed to insert user.");
        }
    }
}