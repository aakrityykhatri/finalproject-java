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
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditTutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField namef;
	private JTextField emailf;
	private JTextField phonef;
	private JTextField facultf;
	private JTextField idf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditTutor frame = new EditTutor();
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
	public EditTutor() {
		setTitle("Edit Tutor ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-20, -14, 451, 593);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 10, 428, 574);
		panel.add(panel_1);
		
		JLabel lblAddCourse = new JLabel();
		lblAddCourse.setText("Update Tutor ");
		lblAddCourse.setForeground(new Color(0, 102, 102));
		lblAddCourse.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblAddCourse.setBackground(new Color(0, 102, 102));
		lblAddCourse.setBounds(122, 29, 219, 58);
		panel_1.add(lblAddCourse);
		
		namef = new JTextField();
		namef.setForeground(new Color(102, 102, 102));
		namef.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		namef.setBounds(46, 187, 332, 40);
		panel_1.add(namef);
		
		JLabel lblCourseName = new JLabel();
		lblCourseName.setText("Tutor Name");
		lblCourseName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCourseName.setBackground(new Color(102, 102, 102));
		lblCourseName.setBounds(46, 163, 125, 20);
		panel_1.add(lblCourseName);
		
		emailf = new JTextField();
		emailf.setToolTipText("");
		emailf.setForeground(new Color(102, 102, 102));
		emailf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		emailf.setBounds(46, 271, 332, 40);
		panel_1.add(emailf);
		
		JLabel lblNoOfSeats = new JLabel();
		lblNoOfSeats.setText("Email");
		lblNoOfSeats.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNoOfSeats.setBackground(new Color(102, 102, 102));
		lblNoOfSeats.setBounds(46, 248, 125, 20);
		panel_1.add(lblNoOfSeats);
		
		JLabel lblBatch = new JLabel();
		lblBatch.setText("Phone No.");
		lblBatch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblBatch.setBackground(new Color(102, 102, 102));
		lblBatch.setBounds(46, 321, 157, 20);
		panel_1.add(lblBatch);
		
		JButton btnUpdate = new JButton();
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idf.getText();				
				String name =  namef.getText();
				String email = emailf.getText();
				String phone = phonef.getText();		
				String faculty = facultf.getText();	
				
				System.out.printf("%s %s %s %s %s",id, name, email, phone,faculty);
				
				
				boolean validCourse = DataBaseExtension.checkCourse(faculty);
				boolean validEmail = DataBaseExtension.checkEmail(email,  "tutor_data");
				
				
				 if(id.equals("") || name.equals("") || email.equals("") || phone.equals("") || faculty.equals("")) {
					
					JOptionPane.showMessageDialog(null, "All Fields required");
				}
				 
				 
				 else if(!validCourse) {
						JOptionPane.showMessageDialog(null, "Course Not Found in College");
					}
					
				 
					else if(validEmail) {
						JOptionPane.showMessageDialog(null, "Email already Exist");
					}
				 
				else {			
					
					// inserting data to sms.course
					int res = DataBaseExtension.editTutor(id, name, email, phone, faculty);
					
					
					if(res == 1) {
						JOptionPane.showMessageDialog(null, "Data updated");
						
						Dashboard.getTutors();

						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Edit failed wrong TutoridID");
						Dashboard.getTutors();

							
					}
										
				}

										
			}
		});
		btnUpdate.setText("Update Details");
		btnUpdate.setForeground(new Color(0, 100, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(140, 473, 152, 39);
		
		// btn style
		btnUpdate.setBackground(new Color(240, 240, 240));
		btnUpdate.setForeground(UIManager.getColor("Button.disabledShadow"));
		
		
		
		panel_1.add(btnUpdate);
		
		JLabel lblNoOfYears = new JLabel();
		lblNoOfYears.setText("Faculty");
		lblNoOfYears.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNoOfYears.setBackground(new Color(102, 102, 102));
		lblNoOfYears.setBounds(46, 396, 125, 20);
		panel_1.add(lblNoOfYears);
		
		phonef = new JTextField();
		phonef.setToolTipText("");
		phonef.setForeground(new Color(102, 102, 102));
		phonef.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		phonef.setBounds(46, 346, 332, 40);
		panel_1.add(phonef);
		
		facultf = new JTextField();
		facultf.setToolTipText("");
		facultf.setForeground(new Color(102, 102, 102));
		facultf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		facultf.setBounds(46, 417, 332, 40);
		panel_1.add(facultf);
		
		JLabel lblId = new JLabel();
		lblId.setText("Tutor  ID");
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblId.setBackground(new Color(102, 102, 102));
		lblId.setBounds(46, 89, 125, 20);
		panel_1.add(lblId);
		
		idf = new JTextField();
		idf.setForeground(new Color(102, 102, 102));
		idf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		idf.setBounds(46, 113, 332, 40);
		panel_1.add(idf);
	}
}
