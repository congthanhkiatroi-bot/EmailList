package com.webprogramming.emaillist.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException {

        String host = System.getenv("DB_HOST");
        String port = System.getenv("DB_PORT");
        String database = System.getenv("DB_NAME");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        String url = "jdbc:postgresql://" +
                host + ":" +
                port + "/" +
                database;

        return DriverManager.getConnection(url, user, password);
    }
}