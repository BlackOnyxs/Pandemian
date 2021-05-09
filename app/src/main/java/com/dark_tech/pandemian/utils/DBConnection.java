package com.dark_tech.pandemian.utils;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;
    private static final String IP = "192.168.0.4";
    private static final String PORT = "1433";
    private static final String CLASSES = "net.sourceforge.jtds.jdbc.Driver";
    private static final String DATABASE = "Pandemian";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:jtds:sqlserver://"+IP+";"+PORT+"/"+DATABASE;

    @SuppressLint("NewApi")
    public Connection connectionClass(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Class.forName(CLASSES);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Log.i("DB", "Conexion establecida");
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return connection;
    }

}


