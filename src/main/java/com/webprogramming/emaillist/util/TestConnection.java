package com.webprogramming.emaillist.util;

import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        try (Connection connection = DBConnection.getConnection()) {

            if (connection != null) {
                System.out.println("Connected to PostgreSQL successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}