package courseManagementSystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;

import courseManagementSystem.Dblogin.LoginResult;

public class DataBaseExtension {

//	"DELETE FROM course WHERE `course`.`id` = 5"
	
	
	public static void main(String[] args) {
		

	}
	
	
	// Update Password
	public static boolean updatePassword(String useremail,String pass, String table) {

	        String url = "jdbc:mysql://localhost"; 
	        String username = "root";
	        String password = "";
			        
	        try {
	            Connection con = DriverManager.getConnection(url, username, password);
	            Statement stmt = con.createStatement();
	            
	            String updateQuery = "UPDATE sms." + table
	            	    + " SET "	            	   
	            	    + "password = '" + pass + "' "
	            	    + "WHERE email = '" + useremail + "'";


	            int res = stmt.executeUpdate(updateQuery);

	            System.out.println("\nsuccessfully updataed"); 
	            
	            stmt.close();
	            con.close();
	            
	            if(res == 1) {
	            	return true;
	            } else {
	            	return false;
	            }    
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
		
	}
	
	
	
	// Search user from database
	public static String[] searchUser(String email, String tableName) {
					

		
	    String url = "jdbc:mysql://localhost";
	    String username = "root";
	    String password = "";

	    int rowCount = 0;
	    String data[] = {"", ""};
	    try {
	        Connection con = DriverManager.getConnection(url, username, password);

	        Statement stmt = con.createStatement();

	        String query = "SELECT * FROM sms." + tableName + " WHERE email = '" + email + "'";
  
	        ResultSet rs = stmt.executeQuery(query);
	        

	        while (rs.next()) {
	            rowCount++;
	            
	        	   
	        	   String dname = rs.getString(2);
	         	   String demail = rs.getString(3);


	         	   data[0] = dname;
	         	   data[1] = demail;
	         	   
	         	   System.out.println(dname);
	         	   System.out.println(demail);

	        }

	        System.out.println("\ntotal rows: " + rowCount);

	        stmt.close();
	        con.close();

	     // String convert 
	        return data;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return data;
	    }
		

	}
	
	
	// Update Profile
	public static boolean editProfile( String name, String email, String table, String useremail) {
		

        String url = "jdbc:mysql://localhost"; 
        String username = "root";
        String password = "";
		        
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            
            String updateQuery = "UPDATE sms." + table
            	    + " SET "
            	    + "fullname = '" + name + "', "
            	    + "email = '" + email + "' "
            	    + "WHERE email = '" + useremail + "'";


            int res = stmt.executeUpdate(updateQuery);

            System.out.println("\nsuccessfully updataed"); 
            
            stmt.close();
            con.close();
            
            if(res == 1) {
            	return true;
            } else {
            	return false;
            }
            
         
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

		
	}
	
	
	
	// add result 	
	public static boolean addResult(String sid, String lvl, String module,  String marks) {
		
        String url = "jdbc:mysql://localhost"; 
        String username = "root";
        String password = "";
		        
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            
            Statement stmt = con.createStatement();

            String query = " CREATE DATABASE IF NOT EXISTS sms";           
            stmt.executeUpdate(query);

            String createTable = "CREATE TABLE IF NOT EXISTS sms.result "
            		+"(sid varchar(100), "	
            		+"level varchar(50),"
            		+"module varchar(100),"
            		+"marks varchar(100))";
            		            
//          Execute the SQL statement to create the table
            stmt.executeUpdate(createTable);

            
            String data = "INSERT INTO sms.result (sid, level, module, marks ) VALUES('" + sid + "','" + lvl + "','" + module + "','" + marks + "')";          
            int res = stmt.executeUpdate(data);
            
            
          
            stmt.close();
            con.close();
            
            if(res ==1) {
            	return true;
            }else {
            	return false;
            }
            
            
    } catch (SQLException e) {
    	
        e.printStackTrace();
        return false;
    }
	
	}
	
		// inserting module name
		public static boolean addModule(String sid, String lvl, String module1, String module2) {
			
	        String url = "jdbc:mysql://localhost"; 
	        String username = "root";
	        String password = "";
    		        
	        try {
	            Connection con = DriverManager.getConnection(url, username, password);
	            
	            Statement stmt = con.createStatement();

	            String query = " CREATE DATABASE IF NOT EXISTS sms";           
	            stmt.executeUpdate(query);

	            String createTable = "CREATE TABLE IF NOT EXISTS sms.modules "
	            		+"(sid varchar(100), "	
	            		+"level varchar(50),"
	            		+"module1 varchar(100),"
	            		+"module2 varchar(100))";
	            		            
//	          Execute the SQL statement to create the table
	            stmt.executeUpdate(createTable);

	            
	            String data = "INSERT INTO sms.modules (sid, level, module1, module2 ) VALUES('" + sid + "','" + lvl + "','" + module1 + "','" + module2 + "')";          
	            int res = stmt.executeUpdate(data);
	            
	           
                stmt.close();
                con.close();
	            
	            if(res ==1) {
	            	return true;
	            }else {
	            	return false;
	            }
	            
	            
               
	            
        } catch (SQLException e) {
        	
            e.printStackTrace();
            return false;
        }
			
		}
	
		// inserting marks in module
		public static boolean addMarks(String sid, String lvl, String marks1, String marks2) {
			
	        String url = "jdbc:mysql://localhost"; 
	        String username = "root";
	        String password = "";
    		        
	        try {
	            Connection con = DriverManager.getConnection(url, username, password);
	            
	            Statement stmt = con.createStatement();

	            String query = " CREATE DATABASE IF NOT EXISTS sms";           
	            stmt.executeUpdate(query);

	            String createTable = "CREATE TABLE IF NOT EXISTS sms.marks "
	            		+"(sid varchar(100), "	
	            		+"level varchar(50),"
	            		+"marks1 varchar(100),"
	            		+"marks2 varchar(100))";
	            		            
//	          Execute the SQL statement to create the table
	            stmt.executeUpdate(createTable);

	            
	            String data = "INSERT INTO sms.marks (sid, level, marks1, marks2 ) VALUES('" + sid + "','" + lvl + "','" + marks1 + "','" + marks2 + "')";          
	            int res = stmt.executeUpdate(data);
	            
	            
	          
                stmt.close();
                con.close();
	            
	            if(res ==1) {
	            	return true;
	            }else {
	            	return false;
	            }
	            
	            
        } catch (SQLException e) {
        	
            e.printStackTrace();
            return false;
        }
			
		}
		
		
	
		// Activities History
		public static boolean addActivities(String activity) {
	        String url = "jdbc:mysql://localhost"; 
	        String username = "root";
	        String password = "";
    		        
	        try {
	            Connection con = DriverManager.getConnection(url, username, password);
	            
	            Statement stmt = con.createStatement();

	            String query = " CREATE DATABASE IF NOT EXISTS sms";           
	            stmt.executeUpdate(query);

	            String createTable = "CREATE TABLE IF NOT EXISTS sms.activities "
	            		+ "(id INT AUTO_INCREMENT PRIMARY KEY, "		            																						
	            		+ "activity varchar(300))";
	            
	            
//	          Execute the SQL statement to create the table
	            stmt.executeUpdate(createTable);

	            
	            String data = "INSERT INTO sms.activities (activity ) VALUES('" + activity + "')";          
	            int res = stmt.executeUpdate(data);
	            
	           
                stmt.close();
                con.close();
	            
	            if(res ==1) {
	            	return true;
	            }else {
	            	return false;
	            }
	            
	            
        } catch (SQLException e) {
        	
            e.printStackTrace();
            return false;
        }
        
		}

		
		// get current time
		public static String currentTime() {
			
		        // Get the current date and time
		        LocalDateTime currentDateTime = LocalDateTime.now();

		        // Define a format for the date and time
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		        // Format the current date and time using the defined format
		        String formattedDateTime = currentDateTime.format(formatter);

		        // Print the formatted current date and time
//		        System.out.println("Current Date and Time: " + formattedDateTime);

			
			return formattedDateTime;
			
		}
		
	
		// Creating course 
		 public static boolean addCourse( String courseName, String seats, String batch, String year) {
		        String url = "jdbc:mysql://localhost"; 
		        String username = "root";
		        String password = "";
        		        
		        try {
		            Connection con = DriverManager.getConnection(url, username, password);
		            
		            Statement stmt = con.createStatement();

		            String query = " CREATE DATABASE IF NOT EXISTS sms";           
		            stmt.executeUpdate(query);

		            String createTable = "CREATE TABLE IF NOT EXISTS sms.course "
		            		+ "(id INT AUTO_INCREMENT PRIMARY KEY, "		            		
		            		+ "coursename varchar(100),"	            		
							+ "seats varchar(100),"
							+ "batch varchar(100),"																					
		            		+ "year varchar(100))";
		            
		            
//		          Execute the SQL statement to create the table
		            stmt.executeUpdate(createTable);
		            
		            String data = "INSERT INTO sms.course (coursename, seats, batch, year  ) VALUES('" + courseName + "','" +seats + "','" + batch +"', '" + year + "')";          
		            stmt.executeUpdate(data);
	   
		            System.out.println("\nsuccessfully"); 
		            		           
		            stmt.close();
		            con.close();
		            return true;
		            
		        } catch (SQLException e) {
		        	
		            e.printStackTrace();
		            return false;
		        }
		        		        
	}
		 
		 // edit course data
		 public static int editCourse( String courseId,String courseName, String seats, String batch, String year) {
			 
			 
		        String url = "jdbc:mysql://localhost"; 
		        String username = "root";
		        String password = "";
     		        
		        try {
		            Connection con = DriverManager.getConnection(url, username, password);
		            
		            Statement stmt = con.createStatement();

		            String query = " CREATE DATABASE IF NOT EXISTS sms";           
		            stmt.executeUpdate(query);

		            String createTable = "CREATE TABLE IF NOT EXISTS sms.course "
		            		+ "(id INT AUTO_INCREMENT PRIMARY KEY, "		            		
		            		+ "coursename varchar(100),"	            		
							+ "seats varchar(100),"
							+ "batch varchar(100),"																					
		            		+ "year varchar(100))";
		            
		            
//		          Execute the SQL statement to create the table
		            stmt.executeUpdate(createTable);
		            
		            String updateQuery = "UPDATE sms.course SET "
		                    + "coursename = '" + courseName + "', "
		                    + "seats = '" + seats + "', "
		                    + "batch = '" + batch + "', "
		                    + "year = '" + year + "' "
		                    + "WHERE id = " + courseId;


		            int res = stmt.executeUpdate(updateQuery);
		            		            
	   
		            System.out.println("\nsuccessfully"); 
		            		           
		            stmt.close();
		            con.close();
		            return res;
		            
		        } catch (SQLException e) {
		        	
		            e.printStackTrace();
		            return 0;
		        }
			 
		 }
		 
		 // Check email exist or not in database
		 public static boolean checkEmail(String email,  String userType) {
		       String url = "jdbc:mysql://localhost"; 
		       String username = "root";
		       String password = "";
			
		          boolean check = false;   
		      
		       try {
		           Connection con = DriverManager.getConnection(url, username, password);	           
		           Statement stmt = con.createStatement();	           
		           String query = "select * from sms." + userType;
		           ResultSet rs = stmt.executeQuery(query);
  	   
		           while(rs.next()) {

		        	   String demail = rs.getString(3);


		        	   if(demail.equals(email) ) { 	   
		            	  
	            	   check = true;
	                   break;  
		  
		        	   }
		           }

		           if (check) {
		        	   System.out.println("email exists");
		        	   
		               rs.close();
	                    stmt.close();
	                    con.close();
	                    
		        	   return true;
		        	  
		           } else {
		               
		        	   System.out.println("email NOt exists");
		           return false;
		              
		           }
		       }
				
				catch (SQLException e) {

					 System.out.println("email NOt exists");
		           e.printStackTrace();
		           return false;
		       }

		       
			 }
		 
		 // check student in data base with sid and level
		 public static boolean checkStudent(String sid, String level) {
		       String url = "jdbc:mysql://localhost"; 
		       String username = "root";
		       String password = "";
			
		       
		       try {
		           Connection con = DriverManager.getConnection(url, username, password);	           
		           Statement stmt = con.createStatement();
		           
		           String query = "select * from sms.students_data";
		           ResultSet rs = stmt.executeQuery(query);

		    	   boolean check = false;   
		    	   
		    	   
		           while(rs.next()) {
		        	  
		        	   String did = rs.getString(1);
		        	   String dlevel = rs.getString(6);

		        	   if(did.equals(sid) ) {	        	
		        	   
		        		   check = true;
		                   break;
//		        	   if(dlevel.equals(level)) {		            	  
//		            	   check = true;
//		                   break;  
//		        	   }
		                   
		                   
		        	   }
		           }

		           if (check) {
		        	   System.out.println("Student found!");
		        	   
		               rs.close();
	                    stmt.close();
	                    con.close();
		        	   
		               return true;
		           } else {
		               System.out.println("Student not Found!");
		               rs.close();
	                    stmt.close();
	                    con.close();
		               
		               return false;
		           }
		       }
				
				catch (SQLException e) {
     	
		           e.printStackTrace();
		           return false;		       }		       
			 }
		 
		 // delete course 
		 public static boolean deleteCourse(String id) {
			 
		        String url = "jdbc:mysql://localhost"; 
		        String username = "root";
		        String password = "";
     		        
		        try {
		            Connection con = DriverManager.getConnection(url, username, password);
		            
		            Statement stmt = con.createStatement();

		            
		            String data = "DELETE FROM sms.course WHERE id = '" + id + "'";
		           int res =  stmt.executeUpdate(data);

		            System.out.println("\nsuccessfully"); 
		            		           
		            stmt.close();
		            con.close();
		            
		            if(res == 1) {
		            	return true;
		            }
		            else {
		            	return false;
		            }
		         
		            
		        } catch (SQLException e) {
		        	
		            e.printStackTrace();
		            return false;
		        }

		 }



		 
		 
		// Add Students on sms.students_data
		 public static boolean addStudents(String fullName, String email, String phoneNo, String course, String level) {

		     String url = "jdbc:mysql://localhost";
		     String username = "root";
		     String password = "";

		     try {
		         Connection con = DriverManager.getConnection(url, username, password);

		         Statement stmt = con.createStatement();

		         String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS sms";
		         stmt.executeUpdate(createDatabaseQuery);

		         String useDatabaseQuery = "USE sms";
		         stmt.executeUpdate(useDatabaseQuery);

		         String createTableQuery = "CREATE TABLE IF NOT EXISTS sms.students_data "
		                 + "(id INT AUTO_INCREMENT PRIMARY KEY, "
		                 + "name VARCHAR(100), "
		                 + "email VARCHAR(100), "
		                 + "phoneNo VARCHAR(20), "
		                 + "course VARCHAR(100), "
		                 + "level VARCHAR(100))";

		         stmt.executeUpdate(createTableQuery);

		         String insertDataQuery = "INSERT INTO sms.students_data (name, email, phoneNo, course, level) VALUES "
		        		    + "('" + fullName + "','" + email + "','" + phoneNo + "','" + course + "','" + level + "')";

		         stmt.executeUpdate(insertDataQuery);

		         System.out.println("\nSuccessfully added student");

		         stmt.close();
		         con.close();
		         return true;

		     } catch (SQLException e) {

		         e.printStackTrace();
		         return false;
		     }
		 }

		
		// Delete Students from sms.students_data
		 public static boolean deleteStudent(String id) {
			 
		        String url = "jdbc:mysql://localhost"; 
		        String username = "root";
		        String password = "";
  		        
		        try {
		            Connection con = DriverManager.getConnection(url, username, password);
		            
		            Statement stmt = con.createStatement();

		            
		            String data = "DELETE FROM sms.students_data WHERE id = '" + id + "'";
		           int res =  stmt.executeUpdate(data);

		            System.out.println("\nsuccessfully"); 
		            		           
		            stmt.close();
		            con.close();
		            
		            if(res == 1) {
		            	return true;
		            }
		            else {
		            	return false;
		            }
		         
		            
		        } catch (SQLException e) {
		        	
		            e.printStackTrace();
		            return false;
		        }

		 }
		
		 
		 
		 // Update Students details	of sms.students_data	 
		 public static int editStudent( String StudentId,String StudentName,   String email, String phone, String course, String level) {
			 
		
		        String url = "jdbc:mysql://localhost"; 
		        String username = "root";
		        String password = "";
     		        
		        try {
		            Connection con = DriverManager.getConnection(url, username, password);
		            
		            Statement stmt = con.createStatement();

		            
		            String updateQuery = "UPDATE sms.students_data SET "
		                    + "name = '" + StudentName + "', "
		                    + "email = '" + email + "', "
		                    + "phoneNo = '" + phone + "', "
		                    + "course = '" + course + "', "
		                    + "level = '" + level + "' " 
		                    + "WHERE id = " + StudentId;


		            int res = stmt.executeUpdate(updateQuery);
		            		            
	   
		            System.out.println("\nsuccessfully"); 
		            		           
		            stmt.close();
		            con.close();
		            
		            
		            return res;
		            
		        } catch (SQLException e) {
		        	
		            e.printStackTrace();
		            return 0;
		        }
			 
		 }
		 
		 
		 // check for course in course table
		 public static boolean checkCourse(String course) {
		       String url = "jdbc:mysql://localhost"; 
		       String username = "root";
		       String password = "";
			
		          boolean check = false;   
		      
		       try {
		           Connection con = DriverManager.getConnection(url, username, password);	           
		           Statement stmt = con.createStatement();	           
		           String query = "select * from sms.course" ;
		           ResultSet rs = stmt.executeQuery(query);
  	   
		           while(rs.next()) {

		        	   String dcourse = rs.getString(2);


		        	   if(dcourse.equals(course) ) { 	   
		            	  
	            	   check = true;
	                   break;  
		  
		        	   }
		           }
		           
		           
		           rs.close();
                   stmt.close();
                   con.close();

		           if (check) {
		        	   System.out.println("course exists");
		        	   return true;
		        	  
		           } else {
		               
		        	   System.out.println("course NOt exists");
		           return false;
		              
		           }
		       }
				
				catch (SQLException e) {

					 System.out.println("course NOt exists");
		           e.printStackTrace();
		           return false;
		       }

		       
			 }
		 
		 
		// Add tutor on sms.tutor_data
		 public static boolean addTutor(String fullName, String email, String phoneNo, String faculty) {

		     String url = "jdbc:mysql://localhost";
		     String username = "root";
		     String password = "";

		     try {
		         Connection con = DriverManager.getConnection(url, username, password);

		         Statement stmt = con.createStatement();

		         String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS sms";
		         stmt.executeUpdate(createDatabaseQuery);

//		         String useDatabaseQuery = "USE sms";
//		         stmt.executeUpdate(useDatabaseQuery);

		         String createTableQuery = "CREATE TABLE IF NOT EXISTS sms.tutor_data "
		                 + "(id INT AUTO_INCREMENT PRIMARY KEY, "
		                 + "name VARCHAR(100), "
		                 + "email VARCHAR(100), "
		                 + "phoneNo VARCHAR(20), "
		                 + "faculty VARCHAR(100))";

		         stmt.executeUpdate(createTableQuery);

		         String insertDataQuery = "INSERT INTO sms.tutor_data (name, email, phoneNo, faculty) VALUES"
		         		+ "('"+ fullName + "','" + email + "','" + phoneNo + "','" + faculty + "')";

		         stmt.executeUpdate(insertDataQuery);

		         System.out.println("\nSuccessfully added tutor");

		         stmt.close();
		         con.close();
		         return true;

		     } catch (SQLException e) {

		         e.printStackTrace();
		         return false;
		     }
		 }
		 
		 // Update tutor details on Tutor_data table
		 public static int editTutor( String tutorId,String tutorName,   String email, String phone, String faculty) {
			 
		
		        String url = "jdbc:mysql://localhost"; 
		        String username = "root";
		        String password = "";
     		        
		        try {
		            Connection con = DriverManager.getConnection(url, username, password);
		            
		            Statement stmt = con.createStatement();

		            
		            String updateQuery = "UPDATE sms.tutor_data SET "
		                    + "name = '" + tutorName + "', "
		                    + "email = '" + email + "', "
		                    + "phoneNo = '" + phone + "', "
		                    + "faculty = '" + faculty + "' "
		                    + "WHERE id = " + tutorId;


		            int res = stmt.executeUpdate(updateQuery);
		            		            
	   
		            System.out.println("\nsuccessfully"); 
		            		           
		            stmt.close();
		            con.close();
		            
		            
		            return res;
		            
		        } catch (SQLException e) {
		        	
		            e.printStackTrace();
		            return 0;
		        }
			 
		 }
		 
		 // Delete tutor details form sms.tutor_data
		 public static boolean deleteTutor(String id) {
			 
		        String url = "jdbc:mysql://localhost"; 
		        String username = "root";
		        String password = "";
		        
		        try {
		            Connection con = DriverManager.getConnection(url, username, password);
		            
		            Statement stmt = con.createStatement();

		            
		            String data = "DELETE FROM sms.tutor_data WHERE id = '" + id + "'";
		           int res =  stmt.executeUpdate(data);

		            System.out.println("\nsuccessfully"); 
		            		           
		            stmt.close();
		            con.close();
		            
		            if(res == 1) {
		            	return true;
		            }
		            else {
		            	return false;
		            }
		         
		            
		        } catch (SQLException e) {
		        	
		            e.printStackTrace();
		            return false;
		        }

		 }
		 
		 
		 // find total number of columns in tables
		 public static String findTotalColumns(String tableName) {

			    String url = "jdbc:mysql://localhost";
			    String username = "root";
			    String password = "";

			    int rowCount = 0;
			    try {
			        Connection con = DriverManager.getConnection(url, username, password);

			        Statement stmt = con.createStatement();

			        String data = "SELECT * FROM sms." + tableName;
			        ResultSet rs = stmt.executeQuery(data);

			        while (rs.next()) {
			            rowCount++;
			        }

			        System.out.println("\ntotal rows: " + rowCount);

			        stmt.close();
			        con.close();

			     // String convert 
			        return String.valueOf(rowCount);

			    } catch (SQLException e) {
			        e.printStackTrace();
			        return String.valueOf(rowCount);
			    }
			}


		 
}
