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
import javax.swing.DefaultComboBoxModel;

public class EditStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField namef;
	private JTextField emailf;
	private JTextField phonef;
	private JTextField coursef;
	private JTextField idf;
	private JComboBox levelf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudent frame = new EditStudent();
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
	public EditStudent() {
		setTitle("Edit Course");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 583);
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
		lblAddCourse.setText("Edit Student");
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
		lblCourseName.setText("Student Name");
		lblCourseName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCourseName.setBackground(new Color(102, 102, 102));
		lblCourseName.setBounds(46, 163, 125, 20);
		panel_1.add(lblCourseName);
		
		emailf = new JTextField();
		emailf.setToolTipText("");
		emailf.setForeground(new Color(102, 102, 102));
		emailf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		emailf.setBounds(46, 260, 332, 40);
		panel_1.add(emailf);
		
		JLabel lblNoOfSeats = new JLabel();
		lblNoOfSeats.setText("Email");
		lblNoOfSeats.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNoOfSeats.setBackground(new Color(102, 102, 102));
		lblNoOfSeats.setBounds(46, 237, 125, 20);
		panel_1.add(lblNoOfSeats);
		
		JLabel lblBatch = new JLabel();
		lblBatch.setText("Phone No.");
		lblBatch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblBatch.setBackground(new Color(102, 102, 102));
		lblBatch.setBounds(46, 310, 157, 20);
		panel_1.add(lblBatch);
		
		JButton btnUpdate = new JButton();
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idf.getText();				
				String name =  namef.getText();
				String email = emailf.getText();
				String phone = phonef.getText();		
				String course = coursef.getText();	
				String level = (String) levelf.getSelectedItem();
				
				System.out.printf("%s %s %s %s %s",id, name, email, phone,course);
				
				
				boolean validCourse = DataBaseExtension.checkCourse(course);
				boolean validEmail = DataBaseExtension.checkEmail(email,  "students_data");
				
				if(!validCourse) {
					JOptionPane.showMessageDialog(null, "Course Not Found in College");
				}
				
				
				else if(id.equals("") || name.equals("") || email.equals("") || phone.equals("") || course.equals("")) {
					
					JOptionPane.showMessageDialog(null, "All Fields required");
				}
				
				else if(validEmail) {
					JOptionPane.showMessageDialog(null, "Email already Exist");
				}
				
				else {			
					
					// inserting data to sms.course
					int res = DataBaseExtension.editStudent(id, name, email, phone, course, level);
					
					
					if(res == 1) {
						JOptionPane.showMessageDialog(null, "Data updated");
						
						Dashboard.getStudent();
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Edit failed wrong StudentID");
						Dashboard.getStudent();
						dispose();
					}
										
				}

										
			}
		});
		btnUpdate.setText("Update Details");
		btnUpdate.setForeground(new Color(0, 100, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(226, 485, 152, 40);
		
		// btn style
		btnUpdate.setBackground(new Color(240, 240, 240));
		btnUpdate.setForeground(UIManager.getColor("Button.disabledShadow"));
		
		
		
		panel_1.add(btnUpdate);
		
		JLabel lblNoOfYears = new JLabel();
		lblNoOfYears.setText("Course");
		lblNoOfYears.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNoOfYears.setBackground(new Color(102, 102, 102));
		lblNoOfYears.setBounds(46, 385, 125, 20);
		panel_1.add(lblNoOfYears);
		
		phonef = new JTextField();
		phonef.setToolTipText("");
		phonef.setForeground(new Color(102, 102, 102));
		phonef.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		phonef.setBounds(46, 335, 332, 40);
		panel_1.add(phonef);
		
		coursef = new JTextField();
		coursef.setToolTipText("");
		coursef.setForeground(new Color(102, 102, 102));
		coursef.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		coursef.setBounds(46, 406, 332, 40);
		panel_1.add(coursef);
		
		JLabel lblId = new JLabel();
		lblId.setText("Student ID");
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblId.setBackground(new Color(102, 102, 102));
		lblId.setBounds(46, 89, 125, 20);
		panel_1.add(lblId);
		
		idf = new JTextField();
		idf.setForeground(new Color(102, 102, 102));
		idf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		idf.setBounds(46, 113, 332, 40);
		panel_1.add(idf);
		
		levelf = new JComboBox();
		levelf.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
		levelf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		levelf.setBounds(46, 485, 140, 40);
		panel_1.add(levelf);
		
		JLabel lblLevel = new JLabel();
		lblLevel.setText("Level");
		lblLevel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLevel.setBackground(new Color(102, 102, 102));
		lblLevel.setBounds(46, 462, 125, 20);
		panel_1.add(lblLevel);
	}
}
