package com.example.cs4420project.connect;

import javafx.collections.ObservableList;

import java.sql.*;

public class Connect {

    private static Connection conn = null;

    public static void connect() {

        try {
            String url = "jdbc:sqlite:src/main/resources/com/example/cs4420project/database/CS4420DB.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void disconnect(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Return true if username and password match a record
    public static boolean login(String username, String password){
        boolean success = false;
        try {
            String querry = "SELECT * FROM users;";
            PreparedStatement statement = conn.prepareStatement(querry);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password)){
                    success = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }



    public static void main(String[] args) {
        connect();
    }
}