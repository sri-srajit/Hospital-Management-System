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

public class AddDoctors extends JFrame {
	Connection con = null;
	PreparedStatement st = null;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddDoctors frame = new AddDoctors();
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
	public AddDoctors() {
		setTitle("Add Doctors");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddDoctors.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JEEVAN RAKSHA HOSPITAL");
		lblNewLabel.setForeground(new Color(34, 139, 34));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel.setBounds(78, 11, 269, 34);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddDoctors.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label.setBounds(45, 11, 33, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AddDoctors.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label_1.setBounds(357, 11, 33, 34);
		contentPane.add(label_1);
		
		JLabel lblAddDoctors = new JLabel("Add Doctors");
		lblAddDoctors.setForeground(new Color(34, 139, 34));
		lblAddDoctors.setFont(new Font("Arial", Font.BOLD, 16));
		lblAddDoctors.setBounds(161, 42, 107, 34);
		contentPane.add(lblAddDoctors);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(0, 0, 128));
		lblName.setFont(new Font("Arial", Font.BOLD, 14));
		lblName.setBounds(45, 94, 48, 14);
		contentPane.add(lblName);
		
		JLabel lblSpecialization = new JLabel("Specialization:");
		lblSpecialization.setForeground(new Color(0, 0, 128));
		lblSpecialization.setFont(new Font("Arial", Font.BOLD, 14));
		lblSpecialization.setBounds(45, 130, 101, 14);
		contentPane.add(lblSpecialization);
		
		JLabel lblRoomNo = new JLabel("Room No.:");
		lblRoomNo.setForeground(new Color(0, 0, 128));
		lblRoomNo.setFont(new Font("Arial", Font.BOLD, 14));
		lblRoomNo.setBounds(45, 164, 90, 14);
		contentPane.add(lblRoomNo);
		
		textField = new JTextField();
		textField.setBounds(190, 87, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 125, 96, 20);
		contentPane.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(190, 162, 96, 20);
		contentPane.add(textField_3);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(0, 0, 128));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = sqlconnection.sqlconnect();
				try {
					st = con.prepareStatement("insert into doctor values(?,?,?);");
					String name = textField.getText();
					String spec = textField_1.getText().toLowerCase();
					String rm = textField_3.getText();
					st.setString(1,name);
					st.setString(2,spec);
					st.setString(3,rm);
					int c = st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Added Successfully :-)");
					textField.setText("");
					textField_1.setText("");
					textField_3.setText("");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Arial", Font.BOLD, 13));
		btnAdd.setBounds(165, 210, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AddDoctors.class.getResource("/org/eclipse/wb/swt/images/icons8-doctor-male-96.png")));
		label_2.setBounds(299, 79, 91, 91);
		contentPane.add(label_2);
	}
}
