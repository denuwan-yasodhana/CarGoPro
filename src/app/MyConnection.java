/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SAMSUNG
 */
public class MyConnection {
    
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/car_rental_system";
    private final String userName = "root";
    private final String password = "";
    
    private Connection con = null;
    
    public MyConnection()
    {
        try
        {
            Class.forName(driverName);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex.toString());
        }
    }
    
    public Connection createConnection()
    {
        try
        {
            con = DriverManager.getConnection(URL, userName, password);
        }
        
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return con;
    }
    
}
