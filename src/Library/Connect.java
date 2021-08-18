/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sanjay
 */
public class Connect {
    
    public static Connection Connect(){
		Connection con;
		String url = "jdbc:mysql://localhost:3307/library_management_system";
		String uname="root";
		String pass="root";
		
		
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection(url,uname,pass);
             return con;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
		
  	

		
	}
    
}
