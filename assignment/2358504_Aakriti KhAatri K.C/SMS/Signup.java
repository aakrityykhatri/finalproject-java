package courseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import courseManagementSystem.Dblogin.LoginResult;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;

public class Signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField eml;
	private JPasswordField pass;
	private JComboBox mode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(395, 0, 404, 477);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel jLabel4 = new JLabel();
		jLabel4.setForeground(new Color(0, 102, 102));
		jLabel4.setBounds(143, 29, 138, 58);
		jLabel4.setText("SIGN UP");
		jLabel4.setFont(new Font("Segoe UI", Font.BOLD, 30));
		jLabel4.setBackground(new Color(0, 102, 102));
		panel_1.add(jLabel4);
		
		name = new JTextField();
		name.setForeground(new Color(102, 102, 102));
		name.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		name.setBounds(46, 111, 332, 40);
		panel_1.add(name);
		
		JLabel jLabel5 = new JLabel();
		jLabel5.setText("Full name");
		jLabel5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jLabel5.setBackground(new Color(102, 102, 102));
		jLabel5.setBounds(46, 87, 61, 20);
		panel_1.add(jLabel5);
		
		eml = new JTextField();
		eml.setToolTipText("");
		eml.setForeground(new Color(102, 102, 102));
		eml.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		eml.setBounds(46, 195, 332, 40);
		panel_1.add(eml);
		
		JLabel jLabel6 = new JLabel();
		jLabel6.setText("Email");
		jLabel6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jLabel6.setBackground(new Color(102, 102, 102));
		jLabel6.setBounds(46, 172, 34, 20);
		panel_1.add(jLabel6);
		
		pass = new JPasswordField();
		pass.setForeground(new Color(102, 102, 102));
		pass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pass.setBounds(46, 287, 332, 40);
		panel_1.add(pass);
		
		JLabel jLabel7 = new JLabel();
		jLabel7.setText("Password");
		jLabel7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jLabel7.setBackground(new Color(102, 102, 102));
		jLabel7.setBounds(46, 262, 61, 20);
		panel_1.add(jLabel7);
		
		JButton signbtn = new JButton();
		signbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		signbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fullName =  name.getText();
				String email = eml.getText();
				String password = pass.getText();										
				String userType = (String) mode.getSelectedItem();
				
				System.out.println(fullName+ " " + email + " "  +password +" " + userType);
				
				
				
				if(!fullName.equals("") && !email.equals("") && !password.equals("")) {
					
					// Regex for UserName					
					String regexUName = "[a-zA-Z]+ [a-zA-Z0-9]+"; // if full name required 
					

					Pattern uName = Pattern.compile(regexUName);
					
					Matcher UN  = uName.matcher(fullName);					
					boolean isValidUserName = UN.matches();
					
					// Regex for password
					String regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,15}$";
					Pattern p = Pattern.compile(regexp);
					
					Matcher Pasw = p.matcher(password);
					boolean isPassValid = Pasw.matches();
					 
					 
					// Regex for email
					String regex = "[a-zA-Z0-9_]+[@][a-z]+[.][a-z]+" ;
					Pattern EM = Pattern.compile(regex);
					
					Matcher em = EM.matcher(email);					
					boolean isEmailValid = em.matches();
					
					
					System.out.println(("\n" + isValidUserName + " " + isEmailValid + " " + isPassValid ));
						
					
					// check if user exists
					boolean isExists = DataBaseExtension.checkEmail(email, userType);	
		
					
					// Check for validation   		
					if(isValidUserName &&  isPassValid && isEmailValid  && !isExists) {	

						
						String encPass = Encrypt.getEncryptedValue(password, 8);
					
						System.out.println("enc:" +encPass);
						
						if(userType.equals("Admin")) {
									
							
							boolean res = Dbcon.performDatabaseOperations(fullName, email, encPass, userType);
							
							if(res) {
								String message = " Admin: "+ email + " added on " + DataBaseExtension.currentTime();
								DataBaseExtension.addActivities(message);
								
								System.out.println("Sign up as Admin");
								JOptionPane.showMessageDialog(null, "Sign up as Admin");
							}

						}
						else if(userType.equals("Teacher")) {
							
							boolean res = Dbcon.performDatabaseOperations(fullName, email, encPass, userType);
							
							if(res) {
								String message = " Teacher: "+ email + " added on " + DataBaseExtension.currentTime();
								DataBaseExtension.addActivities(message);
								
								System.out.println("Sign up as Teacher");
								JOptionPane.showMessageDialog(null, "Sign up as Teacher");
							}
							
						} 
						
						else if(userType.equals("Student")) {
							
							
							boolean res = Dbcon.performDatabaseOperations(fullName, email, encPass, userType);
							
							if(res) {
								
								String message = " Student: "+ email + " added on " + DataBaseExtension.currentTime();
								DataBaseExtension.addActivities(message);
								
								System.out.println("Sign up as Student");
								JOptionPane.showMessageDialog(null, "Sign up as Student");
							}
							
						}
						
						else {
							System.out.println("Sign up as other");
							JOptionPane.showMessageDialog(null, "Sign up as Other");
						}
					
					}									    										
					else {
						
						if(isExists) {
							System.out.println("Email Already Exists ");
							JOptionPane.showMessageDialog(null, "Email Already Exists");
						}
						
						if(!isEmailValid) {
							System.out.println("Wrong emale formate");
							JOptionPane.showMessageDialog(null, "Wrong emale formate");
						}
						if(!isPassValid) {
							System.out.println("Enter a strong Password");
							JOptionPane.showMessageDialog(null, "Enter a strong Password");
						}
						
						if(!isValidUserName) {
							System.out.println("Invalid Name Foramte");
							JOptionPane.showMessageDialog(null, "Invalid Name Foramte");
						}
					}
					
				} else {
					
					System.out.println("Please fill all filed ");
					JOptionPane.showMessageDialog(null, "Please fill all filed ");
				}
			}
		});
		signbtn.setText("Sign Up");
		signbtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		signbtn.setBounds(245, 354, 117, 40);
		panel_1.add(signbtn);
		
		signbtn.setBackground(new Color(240, 240, 240));

			
		
		
		JLabel lblAlreadyHaveAn = new JLabel();
		lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAlreadyHaveAn.setText("Already have an account?");
		lblAlreadyHaveAn.setBounds(46, 417, 138, 13);
		panel_1.add(lblAlreadyHaveAn);
		
		JLabel login = new JLabel("Log in");
		login.setForeground(new Color(0, 0, 205));
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
								
				Login l = new Login();
				l.setVisible(true);
				dispose();
				System.out.println("thi is login test232");
								
			}
		});
		login.setFont(new Font("Tahoma", Font.PLAIN, 12));
		login.setBounds(179, 416, 45, 13);
		panel_1.add(login);
		
		mode = new JComboBox();
		mode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mode.setModel(new DefaultComboBoxModel(new String[] {"Student", "Admin", "Teacher"}));
		mode.setBounds(46, 354, 138, 40);
		panel_1.add(mode);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 102));
		panel.setBounds(0, 0, 397, 491);
		contentPane.add(panel);
		panel.setLayout(null);
		

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\java IDE\\Project\\src\\logo\\Herald.png"));
		lblNewLabel_1.setBounds(10, 65, 537, 179);
		panel.add(lblNewLabel_1);
	}
}

