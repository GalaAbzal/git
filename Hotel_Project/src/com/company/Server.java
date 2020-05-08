package com.company;
import java.net.*;

import java.sql.*;
import java.lang.ClassNotFoundException;

public class Server {
    public static Connection connection;
    public static void main(String[] args) {
        try{
            connectToDb();
            ServerSocket ss = new ServerSocket(3306);

            while(true){
                System.out.println("waiting for client");
                Socket socket = ss.accept();
                System.out.println("new client connected");

                ServerThread sth = new ServerThread(socket,connection);
                sth.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static  void connectToDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                            "root",
                            "");
            System.out.println("Connected to DB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
