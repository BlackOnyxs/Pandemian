package com.dark_tech.pandemian.utils;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection conn;
    private String username, pass, ip, port, database;

    @SuppressLint("NewApi")
    public Connection connectionClass(){
        ip = "192.168.0.4";
        port = "1433";
        database = "Pandemian";
        username = "admin";
        pass = "123456";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionString = null;

        try {
            Class.forName( "net.sourceforge.jtds.jdbc.Driver");
            connectionString ="jdbc:jtds:sqlserver://"+ip+":"+port+";"+"database="+database+";user="+username+";password="+pass+";";
            connection = DriverManager.getConnection(connectionString);
            Log.i("DB", "Conexion establecida");
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return connection;
    }

}


