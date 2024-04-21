package courseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteTutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteTutor frame = new DeleteTutor();
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
	public DeleteTutor() {
		setTitle("Student ID");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(-12, -17, 458, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddCourse = new JLabel();
		lblAddCourse.setBounds(110, 63, 270, 58);
		lblAddCourse.setText("Delete Tutor");
		lblAddCourse.setForeground(new Color(0, 102, 102));
		lblAddCourse.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblAddCourse.setBackground(new Color(0, 102, 102));
		panel.add(lblAddCourse);
		
		JLabel lblId = new JLabel();
		lblId.setText("Tutor ID");
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblId.setBackground(new Color(102, 102, 102));
		lblId.setBounds(62, 142, 125, 20);
		panel.add(lblId);
		
		idf = new JTextField();
		idf.setForeground(new Color(102, 102, 102));
		idf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		idf.setBounds(62, 166, 270, 40);
		panel.add(idf);
		
		JButton btndel = new JButton();
		btndel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idf.getText();				
				boolean res = DataBaseExtension.deleteTutor(id);
				
				if(res) {
					JOptionPane.showMessageDialog(null, "Tutor Deleted");
					Dashboard.getTutors();
					
					String message = "Admin: Tutor id no." + id + " Removed " + DataBaseExtension.currentTime();					
					DataBaseExtension.addActivities(message);
										
					
					dispose();
				} else {
					
					JOptionPane.showMessageDialog(null, "Enter Correct TutorID");
				}
				
			}
		});
		btndel.setText("Delete  Tutor");
		btndel.setForeground(new Color(0, 100, 0));
		btndel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btndel.setBackground(UIManager.getColor("Button.background"));
		btndel.setBounds(127, 235, 153, 38);
		
		btndel.setBackground(new Color(240, 240, 240));	
		btndel.setForeground(UIManager.getColor("Button.disabledShadow"));
		
		panel.add(btndel);
	}

}
