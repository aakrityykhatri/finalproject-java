package courseManagementSystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class Dbcon {

    public static void main(String[] args) {
    	
    }
	
	 public static boolean performDatabaseOperations(String userName, String email, String pass, String userType) {
        String url = "jdbc:mysql://localhost"; 
        String username = "root";
        String password = "";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            
            Statement stmt = con.createStatement();


            String query = " CREATE DATABASE IF NOT EXISTS sms";      
    
            
            stmt.executeUpdate(query);

            
            String createTable = "CREATE TABLE IF NOT EXISTS sms." + userType
                    + "(id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "fullname VARCHAR(50), "
                    + "email VARCHAR(100), "
                    + "password VARCHAR(100)) ";
 
//          Execute the SQL statement to create the table
            stmt.executeUpdate(createTable);
            

            if(userType.equals("Admin")) {           	
            	
                String data = "INSERT INTO sms.Admin (fullname, email, password) VALUES('" + userName + "', '" + email + "','" + pass + "') ";
                stmt.executeUpdate(data);
            }
            

            else if(userType.equals("Teacher")) {
            	          	
                String data = "INSERT INTO sms.Teacher (fullname, email, password) VALUES('" + userName + "', '" + email + "','" + pass + "') ";
                stmt.executeUpdate(data);
            }
            

        	else if(userType.equals("Student")) {            	
        		
                String data = "INSERT INTO sms.Student (fullname, email, password) VALUES('" + userName + "', '" + email + "','" + pass + "') ";
                stmt.executeUpdate(data);
            }
            
 

            System.out.println("\nsuccessfully"); 
 
            stmt.close();
            con.close();
            return true;
            
        } catch (SQLException e) {
        	
        
            e.printStackTrace();
            System.err.println("Error executing SQL query: " + e.getMessage());
            return false;
          
        }
		
    }
}
