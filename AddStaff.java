package org.eclipse.wb.swt;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddStaff extends JFrame {
	Connection con = null;
	PreparedStatement st = null;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddStaff frame = new AddStaff();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AddStaff() {
		setTitle("Add Staff");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddStaff.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJeevanRakshaHospital = new JLabel("JEEVAN RAKSHA HOSPITAL");
		lblJeevanRakshaHospital.setForeground(new Color(34, 139, 34));
		lblJeevanRakshaHospital.setFont(new Font("Arial", Font.BOLD, 19));
		lblJeevanRakshaHospital.setBounds(74, 0, 292, 32);
		contentPane.add(lblJeevanRakshaHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddStaff.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label.setBounds(46, 0, 31, 32);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AddStaff.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label_1.setBounds(346, 0, 31, 32);
		contentPane.add(label_1);
		
		JLabel lblAddStaffMembers = new JLabel("Add Staff Members");
		lblAddStaffMembers.setForeground(new Color(34, 139, 34));
		lblAddStaffMembers.setFont(new Font("Arial", Font.BOLD, 17));
		lblAddStaffMembers.setBounds(140, 32, 174, 32);
		contentPane.add(lblAddStaffMembers);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(new Color(0, 0, 128));
		lblName.setBackground(new Color(0, 0, 128));
		lblName.setFont(new Font("Arial", Font.BOLD, 15));
		lblName.setBounds(46, 92, 76, 28);
		contentPane.add(lblName);
		
		JLabel lblDesignation = new JLabel("Designation :");
		lblDesignation.setForeground(new Color(0, 0, 128));
		lblDesignation.setBackground(new Color(0, 0, 128));
		lblDesignation.setFont(new Font("Arial", Font.BOLD, 15));
		lblDesignation.setBounds(46, 131, 99, 32);
		contentPane.add(lblDesignation);
		
		textField = new JTextField();
		textField.setBounds(151, 97, 145, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 138, 145, 20);
		contentPane.add(textField_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(0, 0, 128));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = sqlconnection.sqlconnect();
				try {
					st = con.prepareStatement("insert into staff values(?,?);");
					String name = textField.getText();
					String des = textField_1.getText();
					st.setString(1, name);
					st.setString(2,des);
					int c = st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Added Successfully!");
					textField.setText("");
					textField_1.setText("");
				} catch (SQLException e1) {
							e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
		btnAdd.setBounds(140, 193, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AddStaff.class.getResource("/org/eclipse/wb/swt/images/icons8-add-user-group-man-man-96 (1).png")));
		label_2.setBounds(306, 75, 99, 118);
		contentPane.add(label_2);
	}

}
