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

public class AddCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField coursef;
	private JTextField seatf;
	private JTextField batchf;
	private JTextField yearf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse frame = new AddCourse();
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
	public AddCourse() {
		setTitle("Add Course");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-20, -14, 427, 511);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 10, 404, 477);
		panel.add(panel_1);
		
		JLabel lblAddCourse = new JLabel();
		lblAddCourse.setText("Add Course");
		lblAddCourse.setForeground(new Color(0, 102, 102));
		lblAddCourse.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblAddCourse.setBackground(new Color(0, 102, 102));
		lblAddCourse.setBounds(112, 29, 219, 58);
		panel_1.add(lblAddCourse);
		
		coursef = new JTextField();
		coursef.setForeground(new Color(102, 102, 102));
		coursef.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		coursef.setBounds(46, 111, 332, 40);
		panel_1.add(coursef);
		
		JLabel lblCourseName = new JLabel();
		lblCourseName.setText("Course Name");
		lblCourseName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCourseName.setBackground(new Color(102, 102, 102));
		lblCourseName.setBounds(46, 87, 125, 20);
		panel_1.add(lblCourseName);
		
		seatf = new JTextField();
		seatf.setToolTipText("");
		seatf.setForeground(new Color(102, 102, 102));
		seatf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		seatf.setBounds(46, 195, 332, 40);
		panel_1.add(seatf);
		
		JLabel lblNoOfSeats = new JLabel();
		lblNoOfSeats.setText("No. of Seats");
		lblNoOfSeats.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNoOfSeats.setBackground(new Color(102, 102, 102));
		lblNoOfSeats.setBounds(46, 172, 125, 20);
		panel_1.add(lblNoOfSeats);
		
		JLabel lblBatch = new JLabel();
		lblBatch.setText("Batch");
		lblBatch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblBatch.setBackground(new Color(102, 102, 102));
		lblBatch.setBounds(46, 245, 61, 20);
		panel_1.add(lblBatch);
		
		JButton btnAddCourse = new JButton();
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String course =  coursef.getText();
				String seat = seatf.getText();
				String batch = batchf.getText();		
				String year = yearf.getText();		
				
				System.out.printf("%s %s %s %s",course, seat, batch, year);
				
				if(course.equals("") || seat.equals("") ||  batch.equals("") || year.equals("")) {
									
					JOptionPane.showMessageDialog(null, "All Fields required");
				}
				
				else {			
					
					// inserting data to sms.course
					boolean res = DataBaseExtension.addCourse(course, seat, batch, year);
					
					if(res) {
						Dashboard.getCourse();
						dispose();
					}
					
				}
	
				
			}
		});
		btnAddCourse.setText("Add Course");
		btnAddCourse.setForeground(new Color(0, 100, 0));
		btnAddCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddCourse.setBounds(148, 405, 117, 40);
		
		// btn style
		btnAddCourse.setBackground(new Color(240, 240, 240));
		btnAddCourse.setForeground(UIManager.getColor("Button.disabledShadow"));
		
		
		
		panel_1.add(btnAddCourse);
		
		JLabel lblNoOfYears = new JLabel();
		lblNoOfYears.setText("No, of Years");
		lblNoOfYears.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNoOfYears.setBackground(new Color(102, 102, 102));
		lblNoOfYears.setBounds(46, 320, 125, 20);
		panel_1.add(lblNoOfYears);
		
		batchf = new JTextField();
		batchf.setToolTipText("");
		batchf.setForeground(new Color(102, 102, 102));
		batchf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		batchf.setBounds(46, 270, 332, 40);
		panel_1.add(batchf);
		
		yearf = new JTextField();
		yearf.setToolTipText("");
		yearf.setForeground(new Color(102, 102, 102));
		yearf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearf.setBounds(46, 341, 332, 40);
		panel_1.add(yearf);
	}
}
