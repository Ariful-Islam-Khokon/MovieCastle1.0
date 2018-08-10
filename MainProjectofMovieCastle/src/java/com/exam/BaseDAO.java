/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author khoko
 */
public class BaseDAO {

 public Connection getConnection() throws ClassNotFoundException, SQLException {
   Class.forName("com.mysql.jdbc.Driver");
   String url = "jdbc:mysql://localhost:3306/saloon";
   String name = "root";
   String password = "acpl123456";

   Connection con = DriverManager.getConnection(url, name, password);
   return con;
 }
}