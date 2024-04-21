package courseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField namef;
	private JTextField emailf;
	private JTextField phonef;
	private JTextField facultyf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTutor frame = new AddTutor();
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
	public AddTutor() {
		setTitle("Add Tutor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 471, 553);
		contentPane.add(panel_1);
		
		JLabel lblAddStudents = new JLabel();
		lblAddStudents.setText("Add Tutor");
		lblAddStudents.setForeground(new Color(0, 102, 102));
		lblAddStudents.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblAddStudents.setBackground(new Color(0, 102, 102));
		lblAddStudents.setBounds(138, 30, 219, 58);
		panel_1.add(lblAddStudents);
		
		namef = new JTextField();
		namef.setForeground(new Color(102, 102, 102));
		namef.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		namef.setBounds(46, 111, 332, 40);
		panel_1.add(namef);
		
		JLabel lblFullname = new JLabel();
		lblFullname.setText("Full Name");
		lblFullname.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFullname.setBackground(new Color(102, 102, 102));
		lblFullname.setBounds(46, 87, 125, 20);
		panel_1.add(lblFullname);
		
		emailf = new JTextField();
		emailf.setToolTipText("");
		emailf.setForeground(new Color(102, 102, 102));
		emailf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		emailf.setBounds(46, 195, 332, 40);
		panel_1.add(emailf);
		
		JLabel lblEmail = new JLabel();
		lblEmail.setText("Email");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmail.setBackground(new Color(102, 102, 102));
		lblEmail.setBounds(46, 172, 125, 20);
		panel_1.add(lblEmail);
		
		JLabel lblPhone = new JLabel();
		lblPhone.setText("Phone");
		lblPhone.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblPhone.setBackground(new Color(102, 102, 102));
		lblPhone.setBounds(46, 247, 61, 20);
		panel_1.add(lblPhone);
		
		JButton addbtn = new JButton();
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name = namef.getText();
				String email = emailf.getText();		
				String phone = phonef.getText();
				String faculty =  facultyf.getText();
	
				boolean validCourse = DataBaseExtension.checkCourse(faculty);
				boolean validEmail = DataBaseExtension.checkEmail(email,  "tutor_data");
				
				
				if(!validCourse) {
					JOptionPane.showMessageDialog(null, "Course Not Found in College");
				}
				
				else if(name.equals("") || email.equals("") || phone.equals("") || faculty.equals("")  ) {
					
					JOptionPane.showMessageDialog(null, "All Fields required");
				}
				
				else if(validEmail) {
					JOptionPane.showMessageDialog(null, "Email already Exist");
				}
				
				
				else {			

					// inserting data to sms.tutor_data					
					boolean res = DataBaseExtension.addTutor(name, email, phone, faculty);
					
					if(res) {
						
						JOptionPane.showMessageDialog(null, "Tutor Added!");					
						String message = "Admin: New Tutor," + email + " Recently Added " + DataBaseExtension.currentTime();					
						DataBaseExtension.addActivities(message);
											
						
						
						Dashboard.getTutors();
						dispose();
					}
					
				}
				

			}
		});
		addbtn.setText("Add Tutor");
		addbtn.setForeground(new Color(0, 100, 0));
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		addbtn.setBackground(UIManager.getColor("Button.background"));
		addbtn.setBounds(148, 405, 140, 40);
		
		addbtn.setBackground(new Color(240, 240, 240));
		addbtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		
		
		panel_1.add(addbtn);
		
		JLabel lblCourse = new JLabel();
		lblCourse.setText("Course");
		lblCourse.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCourse.setBackground(new Color(102, 102, 102));
		lblCourse.setBounds(46, 320, 125, 20);
		panel_1.add(lblCourse);
		
		phonef = new JTextField();
		phonef.setToolTipText("");
		phonef.setForeground(new Color(102, 102, 102));
		phonef.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		phonef.setBounds(46, 270, 332, 40);
		panel_1.add(phonef);
		
		facultyf = new JTextField();
		facultyf.setToolTipText("");
		facultyf.setForeground(new Color(102, 102, 102));
		facultyf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		facultyf.setBounds(46, 341, 332, 40);
		panel_1.add(facultyf);
	}

}
