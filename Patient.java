package org.eclipse.wb.swt;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Patient extends JFrame {
	Connection con = 	 sqlconnection.sqlconnect();

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Patient frame = new Patient();
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
	public Patient() {
		setTitle("Patient Registration");
		setFont(new Font("Arial", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Patient.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(new Color(0, 0, 128));
		lblName.setFont(new Font("Arial", Font.BOLD, 13));
		lblName.setBounds(10, 41, 48, 24);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(80, 43, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAge = new JLabel(" Age :");
		lblAge.setForeground(new Color(0, 0, 128));
		lblAge.setFont(new Font("Arial", Font.BOLD, 13));
		lblAge.setBounds(10, 81, 48, 14);
		contentPane.add(lblAge);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 79, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDisease = new JLabel("Disease :");
		lblDisease.setForeground(new Color(0, 0, 128));
		lblDisease.setFont(new Font("Arial", Font.BOLD, 13));
		lblDisease.setBounds(10, 121, 60, 14);
		contentPane.add(lblDisease);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 120, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setForeground(new Color(0, 0, 128));
		lblGender.setFont(new Font("Arial", Font.BOLD, 13));
		lblGender.setBounds(10, 161, 60, 14);
		contentPane.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(new Color(0, 0, 128));
		rdbtnMale.setFont(new Font("Arial", Font.BOLD, 13));
		rdbtnMale.setBounds(80, 161, 56, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setForeground(new Color(0, 0, 128));
		rdbtnFemale.setFont(new Font("Arial", Font.BOLD, 13));
		rdbtnFemale.setBounds(146, 161, 76, 23);
		contentPane.add(rdbtnFemale);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(new Color(0, 0, 128));
		btnRegister.setFont(new Font("Arial", Font.BOLD, 13));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String name = textField.getText();
					int age = Integer.parseInt(textField_1.getText());
					String disease = textField_2.getText().toLowerCase();
					String gender;
					if(rdbtnMale.isSelected())
						gender = "Male";
					else
						gender = "Female";
						String query = "insert into patient values(?,?,?,?);";
						try {
							PreparedStatement st = null;
							st =  con.prepareStatement(query);
							st.setString(1,name);
							st.setInt(2, age);
							st.setString(3, disease);
							st.setString(4, gender);
							st.executeUpdate();
							JOptionPane.showMessageDialog(null, "You have registered successfully! :-)");
							dispose();
							RegSlip reg = new RegSlip();
							reg.setVisible(true);
							st.close();
							con.close();
					        }
						 catch (SQLException e1) {
							e1.printStackTrace();
						}
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(Patient.class.getResource("/org/eclipse/wb/swt/images/patient (1).png")));
		lblNewLabel.setBounds(241, 11, 133, 172);
		contentPane.add(lblNewLabel);
		
		JLabel lblPleaseDepositThe = new JLabel("Please deposit the fee:");
		lblPleaseDepositThe.setForeground(new Color(0, 0, 128));
		lblPleaseDepositThe.setFont(new Font("Arial", Font.BOLD, 13));
		lblPleaseDepositThe.setBounds(10, 201, 150, 14);
		contentPane.add(lblPleaseDepositThe);
	
		JButton btnNewButton = new JButton("Pay Now");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegister.setBounds(71, 227, 89, 23);
				contentPane.add(btnRegister);
				Payment pay = new Payment();
				pay.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setBounds(170, 197, 89, 23);
		contentPane.add(btnNewButton);
	}
}
