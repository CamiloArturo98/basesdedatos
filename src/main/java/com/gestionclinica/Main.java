package com.gestionclinica;

import java.sql.Connection;
import java.sql.SQLException;

import com.gestionclinica.view.SwingApp;


public class Main {
    public static void main(String[] args)throws SQLException {
      
      SwingApp app = new SwingApp();
      app.setVisible(true);
    }
}