package courseManagementSystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Dblogin {
	
	public static class LoginResult {
	    private boolean success;
	    private String username;

	    public LoginResult(boolean success, String username) {
	        this.success = success;
	        this.username = username;
	    }

	    public boolean isSuccess() {
	        return success;
	    }

	    public String getUsername() {
	        return username;
	    }
	}

	public static void main(String[] args) {
		
	}
	
	 public static LoginResult loginOperation(String email, String pass, String userType) {
       String url = "jdbc:mysql://localhost"; 
       String username = "root";
       String password = "";
	
       
       try {
           Connection con = DriverManager.getConnection(url, username, password);
           
           Statement stmt = con.createStatement();

           
           String query = "select * from sms." + userType;
           ResultSet rs = stmt.executeQuery(query);

    	   boolean check = false;   
    	   String dusername = null; 
    	   
           while(rs.next()) {
        	   dusername = rs.getString(2);
        	   String demail = rs.getString(3);
//        	   String dpass = rs.getString(3);

        	   if(demail.equals(email) ) {
        	   String dpass = Encrypt.getDecryptedValue(rs.getString(4), 8);
        	   
        	   if(dpass.equals(pass)) {
        		   
        		   System.out.println("Sign up Successful");       		   
            	   System.out.println("demail: "+ demail);
            	   System.out.println("dpass: "+ dpass);
            	  
            	   check = true;
                   break;  
        	   }
        	   }
           }

           if (check) {
               return new Dblogin.LoginResult(true, dusername);
           } else {
               System.out.println("Login failed");
               return new Dblogin.LoginResult(false, null);
           }
       }
		
		catch (SQLException e) {
           
          
       	
           e.printStackTrace();
           return new LoginResult(false, null);
       }
       
	 }
}
