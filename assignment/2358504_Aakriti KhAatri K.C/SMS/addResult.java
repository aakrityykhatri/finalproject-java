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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addResult extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idf;
	private JTextField module_1;
	private JTextField module_2;
	private JTextField marks_1;
	private JTextField marks_2;
	private JComboBox levelf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addResult frame = new addResult();
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
	public addResult() {
		setTitle("Submit Result");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel result = new JPanel();
		result.setLayout(null);
		result.setBackground(Color.WHITE);
		result.setBounds(0, 0, 496, 533);
		contentPane.add(result);
		
		JLabel lblResult = new JLabel();
		lblResult.setText("Create Result");
		lblResult.setForeground(new Color(0, 102, 102));
		lblResult.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblResult.setBackground(new Color(0, 102, 102));
		lblResult.setBounds(128, 47, 242, 58);
		result.add(lblResult);
		
		idf = new JTextField();
		idf.setForeground(new Color(102, 102, 102));
		idf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		idf.setBounds(46, 162, 144, 40);
		result.add(idf);
		
		JLabel lblSid = new JLabel();
		lblSid.setText("S.ID");
		lblSid.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSid.setBackground(new Color(102, 102, 102));
		lblSid.setBounds(46, 138, 61, 20);
		result.add(lblSid);
		
		JLabel jLabel6 = new JLabel();
		jLabel6.setText("level");
		jLabel6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jLabel6.setBackground(new Color(102, 102, 102));
		jLabel6.setBounds(279, 138, 34, 20);
		result.add(jLabel6);
		
		JLabel jLabel7 = new JLabel();
		jLabel7.setText("Module");
		jLabel7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jLabel7.setBackground(new Color(102, 102, 102));
		jLabel7.setBounds(46, 265, 61, 20);
		result.add(jLabel7);
		
		JButton submitBtn = new JButton();
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sid = idf.getText();
				String level = (String) levelf.getSelectedItem();
				String module1 = module_1.getText();
				String module2 = module_2.getText();
				String mark1 = marks_1.getText();
				String mark2 = marks_2.getText();
			
				// check for students in database
				boolean resCheckStd = DataBaseExtension.checkStudent(sid, level);
				
				
				if(resCheckStd) {
					
					boolean resModule1  = DataBaseExtension.addResult(sid, level, module1, mark1);
					boolean resModule2  = DataBaseExtension.addResult(sid, level, module2, mark2);
					
					
					
					if(resModule1 && resModule2) {
						JOptionPane.showMessageDialog(null, "Result Submited!");
						dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "Failed");
					}
					
					
//					boolean resModule = DataBaseExtension.addModule(sid, level, module1, module2);
//					
//				if(resModule) {
//					boolean resMarks = DataBaseExtension.addMarks(sid, level, mark1, mark2);
//					
//					if(resMarks) {
//						JOptionPane.showMessageDialog(null, "Result Submited!");
//						// dispose();
//					}else {
//						JOptionPane.showMessageDialog(null, "Failed to update result");
//					}
//				}
//				
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Student Not Found!");
			}
			}
		});
		submitBtn.setText("Submit Result");
		submitBtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		submitBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		submitBtn.setBackground(new Color(240, 240, 240));
		submitBtn.setBounds(143, 430, 187, 40);
		result.add(submitBtn);
		


		
		
		levelf = new JComboBox();
		levelf.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
		levelf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		levelf.setBounds(279, 162, 144, 40);
		result.add(levelf);
		
		module_1 = new JTextField();
		module_1.setToolTipText("");
		module_1.setForeground(new Color(102, 102, 102));
		module_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		module_1.setBounds(46, 287, 144, 40);
		result.add(module_1);
		
		module_2 = new JTextField();
		module_2.setToolTipText("");
		module_2.setForeground(new Color(102, 102, 102));
		module_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		module_2.setBounds(46, 346, 144, 40);
		result.add(module_2);
		
		JLabel lblMarks = new JLabel();
		lblMarks.setText("Marks");
		lblMarks.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMarks.setBackground(new Color(102, 102, 102));
		lblMarks.setBounds(279, 265, 61, 20);
		result.add(lblMarks);
		
		marks_1 = new JTextField();
		marks_1.setToolTipText("");
		marks_1.setForeground(new Color(102, 102, 102));
		marks_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		marks_1.setBounds(279, 287, 144, 40);
		result.add(marks_1);
		
		marks_2 = new JTextField();
		marks_2.setToolTipText("");
		marks_2.setForeground(new Color(102, 102, 102));
		marks_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		marks_2.setBounds(279, 346, 144, 40);
		result.add(marks_2);
	}
}
