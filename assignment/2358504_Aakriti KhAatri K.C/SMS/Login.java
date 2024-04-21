package courseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import  courseManagementSystem.Dblogin;
import  courseManagementSystem.Dblogin.LoginResult;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Email;
	private JPasswordField password;
	private JComboBox mode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 787, 464);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 102, 102));
		panel_1.setBounds(0, 0, 397, 491);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\java IDE\\Project\\src\\logo\\Herald.png"));
		lblNewLabel_1.setBounds(10, 65, 537, 179);
		panel_1.add(lblNewLabel_1);
		
		JPanel Left = new JPanel();
		Left.setMinimumSize(new Dimension(400, 500));
		Left.setBackground(Color.WHITE);
		Left.setBounds(398, 0, 400, 500);
		panel.add(Left);
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("Welcome Back!");
		jLabel1.setForeground(new Color(0, 102, 102));
		jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 36));
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("Email");
		jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jLabel2.setBackground(new Color(102, 102, 102));
		
		Email = new JTextField();
		Email.setForeground(new Color(102, 102, 102));
		Email.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel jLabel3 = new JLabel();
		jLabel3.setText("Password");
		jLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jLabel3.setBackground(new Color(102, 102, 102));
		
		password = new JPasswordField();
		
		JLabel jLabel4 = new JLabel();
		jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel4.setText("I don't have an account.");
		
		mode = new JComboBox();
		mode.setModel(new DefaultComboBoxModel(new String[] {"Student", "Admin", "Teacher"}));
		mode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton signbtn = new JButton();
		
		signbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String email = Email.getText();
				String pass = password.getText();	
				String userType = (String) mode.getSelectedItem();
							
				
				LoginResult checkLogin = Dblogin.loginOperation(email, pass, userType);			
				if(checkLogin.isSuccess()) {	
					
					String message = " "+ userType + ": "+ email + " logged in on " + DataBaseExtension.currentTime();
					DataBaseExtension.addActivities(message);
					
					System.out.println("you are logedin as " + checkLogin.getUsername());
					JOptionPane.showMessageDialog(null, "Welcome Back! "+ checkLogin.getUsername());
					
					
					if(userType.equals("Admin")) {
						//
						Dashboard dash = new Dashboard();
						
						Dashboard.userEmail = email;
						Dashboard.tableName = userType;
						
						dash.setVisible(true);
						dispose();
						//
					}
					
					else if(userType.equals("Teacher")) {
						//
						TeachersDashboard techdash = new TeachersDashboard();
						
						TeachersDashboard.userEmail = email;
						TeachersDashboard.tableName = userType;
						
						techdash.setVisible(true);
						dispose();
						//
					}
					
					else if(userType.equals("Student")) {
						//
						StudentsDashboard techdash = new StudentsDashboard();
						
						StudentsDashboard.userEmail = email;
						StudentsDashboard.tableName = userType;
						
						techdash.setVisible(true);
						dispose();
						//
					}
					
//					
					
				}else {
					System.out.println("username or password not mathched");
					JOptionPane.showMessageDialog(null, "check your email or password");
				}
				
				
			}
		});
		signbtn.setText("Login");
		signbtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		signbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		//

		
		signbtn.setBackground(new Color(240, 240, 240));

		
		//
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
								
				Signup sup = new Signup();
				sup.setVisible(true);
				dispose();
				
				System.out.println("thi is sign UP click part 2");
			}
		});
		lblSignUp.setForeground(new Color(0, 128, 0));
		lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_Left = new GroupLayout(Left);
		gl_Left.setHorizontalGroup(
			gl_Left.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Left.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_Left.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel2)
						.addComponent(Email, 343, 343, 343)
						.addComponent(jLabel3)
						.addComponent(password, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
						.addGroup(gl_Left.createSequentialGroup()
							.addComponent(mode, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
							.addComponent(signbtn, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(gl_Left.createSequentialGroup()
							.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSignUp, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
				.addGroup(gl_Left.createSequentialGroup()
					.addGap(67)
					.addComponent(jLabel1)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_Left.setVerticalGroup(
			gl_Left.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Left.createSequentialGroup()
					.addGap(48)
					.addComponent(jLabel1)
					.addGap(43)
					.addComponent(jLabel2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Email, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jLabel3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(password, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_Left.createParallelGroup(Alignment.BASELINE)
						.addComponent(mode, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(signbtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_Left.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel4)
						.addComponent(lblSignUp))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		Left.setLayout(gl_Left);
	}
}
