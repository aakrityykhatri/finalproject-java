package courseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import courseManagementSystem.Dblogin.LoginResult;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Result extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idf;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public static String[] nameCourse(String id) {
		
	       String url = "jdbc:mysql://localhost"; 
	       String username = "root";
	       String password = "";
		
	       String details[] = {"XXX XXX","XXX"};
	       try {
	           Connection con = DriverManager.getConnection(url, username, password);
	           
	           Statement stmt = con.createStatement();

	           
	           String query = "select * from sms.students_data";
	           ResultSet rs = stmt.executeQuery(query);

//	           String details[] = {"",""};
	    	   
	           while(rs.next()) {
	        	   
	        	   String did = rs.getString(1);
	        	   String dusername = rs.getString(2);
	        	   String dcourse = rs.getString(5);


	        	   if(did.equals(id) ) {
	        	 
//	        	    details[] = {dusername, dcourse};
	        		   details[0] = dusername;
	        		   details[1] = dcourse;
	        	   
	        	   return details;

	        	   }
	           }         
	       }
			
			catch (SQLException e) {   	
	           e.printStackTrace();
	           return details;
	       }	
	       return details;
		
	}
	
    public static String gradeConverter(String marks) {
    	int score  = Integer.valueOf(marks);  	
    	String grade;

    	if (score >= 70) {
    	    grade = "A";
    	} else if (score >= 60 && score <= 69) {
    	    grade = "B";
    	} else if (score >= 50 && score <= 59) {
    	    grade = "C";
    	} else if (score >= 40 && score <= 49) {
    	    grade = "D";
    	} else {
    	    grade = "F";
    	}

//    	System.out.println("Grade: " + grade);	
    	return grade;

    }

	
	 public static void getResult(String sid) {
		   String url = "jdbc:mysql://localhost"; 
	       String username = "root";
	       String password = "";
	
	       
			DefaultTableModel tmodel = (DefaultTableModel)table.getModel();
			 tmodel.setRowCount(0);
			
	       try {
	           Connection con = DriverManager.getConnection(url, username, password);
	           
	           Statement stmt = con.createStatement();
	           
//	            String query = "SELECT * " +
//                     "FROM modules m " +
//                     "JOIN marks mk ON m.sid = mk.sid " +
//                     "WHERE m.sid = " + sid;
	           
	           String query = "SELECT * FROM sms.result WHERE sid ="+ sid ;
	            
	           ResultSet rs = stmt.executeQuery(query);

	         
	    	
	           
	           while(rs.next()) {	        	 
	        	   
	        	   String dlevel =  rs.getString(2);
	        	   String dsub1 = rs.getString(3);
	        	   
	        	   String dmark1 =  rs.getString(4);
	        	   String grade = gradeConverter(dmark1);

	        	   
//	        	   String dlevel2 =  rs.getString("level");             
//	        	   String dsub2 = rs.getString("module2");
//	        	   
//	        	   String dmark2 =  rs.getString("marks2");        	  
//	        	   String grade2 = gradeConverter(dmark2);
	        	   
//             System.out.printf("level: %s sub1: %s marks:%s \nlevel: %s sub1: %s marks:%s",dlevel,dsub1,mark1, dlevel, dsub2, mark2);

	        	   String data1[]= { dlevel,  dsub1, dmark1, grade };	
	        	   tmodel.addRow(data1);	
	        	   
//	        	   String data2[]= { dlevel2,  dsub2, dmark2, grade2 };	        	   
//	        	   tmodel.addRow(data2);	 

	        	   
	           }
	           
	        
	           
               rs.close();
               stmt.close();
               con.close();

	       }
			
			catch (SQLException e) {
	     	
	           e.printStackTrace();

	       }
	
	
}
	
	public Result() {
		setTitle("Result");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel result = new JPanel();
		result.setLayout(null);
		result.setBackground(Color.WHITE);
		result.setBounds(0, -24, 800, 533);
		contentPane.add(result);
		
		JLabel lblStudentName = new JLabel();
		lblStudentName.setText("Student Name :");
		lblStudentName.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblStudentName.setBackground(new Color(102, 102, 102));
		lblStudentName.setBounds(70, 130, 149, 32);
		result.add(lblStudentName);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 74, 106));
		panel.setBounds(50, 65, 209, 40);
		result.add(panel);
		panel.setLayout(null);
		
		JLabel lblProgressReport = new JLabel();
		lblProgressReport.setBounds(10, 0, 206, 37);
		panel.add(lblProgressReport);
		lblProgressReport.setText("Progress Report");
		lblProgressReport.setForeground(new Color(255, 255, 255));
		lblProgressReport.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblProgressReport.setBackground(new Color(255, 51, 87));
		
		JLabel lblCourse = new JLabel();
		lblCourse.setText("Course :");
		lblCourse.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblCourse.setBackground(new Color(102, 102, 102));
		lblCourse.setBounds(70, 172, 94, 32);
		result.add(lblCourse);
		
		JLabel course = new JLabel();
		course.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		course.setBackground(new Color(102, 102, 102));
		course.setBounds(174, 172, 149, 32);
		result.add(course);
		
		JLabel name = new JLabel();
		name.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		name.setBackground(new Color(102, 102, 102));
		name.setBounds(229, 130, 149, 32);
		result.add(name);
		
		idf = new JTextField();
		idf.addKeyListener(new KeyAdapter() {
		
			
			  @Override
			    public void keyPressed(KeyEvent e) {
				  
				 
			        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			          
			        	String id = idf.getText();	

			        	String student[] = nameCourse(id);

			        	course.setText(student[0]);
			        	name.setText(student[1]);
  	
			        	getResult(id);
			      		            
			        }
			    }		
		});
		
	
		idf.setBounds(452, 172, 197, 30);
		result.add(idf);
		idf.setColumns(10);
		
		JLabel lblEnterStudentId = new JLabel();
		lblEnterStudentId.setText("Enter Student ID");
		lblEnterStudentId.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblEnterStudentId.setBackground(new Color(102, 102, 102));
		lblEnterStudentId.setBounds(452, 142, 149, 32);
		result.add(lblEnterStudentId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 294, 592, 124);
		
		result.add(scrollPane);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
		
				
			},
			new String[] {
				"Level", "Module", "Percent", "Grade"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(0).setMaxWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(240);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setMaxWidth(80);
		table.getColumnModel().getColumn(3).setMaxWidth(80);
		scrollPane.setViewportView(table);
		
    
		
		
	}
}
