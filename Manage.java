package org.eclipse.wb.swt;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Manage extends JFrame {
	Connection con = null;
	Statement st = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Manage frame = new Manage();
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
	public Manage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Manage.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 587, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JEEVAN RAKSHA HOSPITAL\r\n\r\n");
		lblNewLabel.setForeground(new Color(34, 139, 34));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setBounds(159, 11, 260, 27);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Manage.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label.setBounds(132, 11, 26, 38);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Manage.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label_1.setBounds(393, 11, 26, 38);
		contentPane.add(label_1);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setToolTipText("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword chng = new ChangePassword();
				chng.setVisible(true);
			}
		});
		btnChangePassword.setForeground(new Color(0, 0, 128));
		btnChangePassword.setBackground(UIManager.getColor("Button.background"));
		btnChangePassword.setSelectedIcon(new ImageIcon("C:\\Users\\Srajit Srivastava\\Downloads\\icons8-password-reset-48.png"));
		btnChangePassword.setFont(new Font("Arial", Font.BOLD, 10));
		btnChangePassword.setBounds(481, 46, 53, 22);
		contentPane.add(btnChangePassword);
		
		JButton btnViewStaff = new JButton("View Staff");
		btnViewStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffView staff = new StaffView();
				staff.setVisible(true);
			}
		});
		btnViewStaff.setForeground(new Color(0, 0, 128));
		btnViewStaff.setFont(new Font("Arial", Font.BOLD, 10));
		btnViewStaff.setBackground(UIManager.getColor("Button.background"));
		btnViewStaff.setBounds(66, 147, 92, 27);
		contentPane.add(btnViewStaff);
		
		JButton btnViewAccounts = new JButton("View Patients");
		btnViewAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPatient list = new  ListPatient();
				list.setVisible(true);
			}
		});
		btnViewAccounts.setForeground(new Color(0, 0, 128));
		btnViewAccounts.setFont(new Font("Arial", Font.BOLD, 10));
		btnViewAccounts.setBackground(UIManager.getColor("Button.background"));
		btnViewAccounts.setBounds(221, 147, 107, 27);
		contentPane.add(btnViewAccounts);
		
		JButton btnViewAccount = new JButton("View Account");
		btnViewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = sqlconnection.sqlconnect();
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from account;");
					rs.next();
					int bal = rs.getInt(1);
					JOptionPane.showMessageDialog(null, "The total balance in hospital's account is  "+bal);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnViewAccount.setForeground(new Color(0, 0, 128));
		btnViewAccount.setFont(new Font("Arial", Font.BOLD, 10));
		btnViewAccount.setBackground(UIManager.getColor("Button.background"));
		btnViewAccount.setBounds(393, 303, 107, 27);
		contentPane.add(btnViewAccount);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Manage.class.getResource("/org/eclipse/wb/swt/images/icons8-staff-96.png")));
		label_3.setBounds(66, 79, 90, 65);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Manage.class.getResource("/org/eclipse/wb/swt/images/icons8-nurse-call-96.png")));
		label_4.setBounds(221, 70, 90, 74);
		contentPane.add(label_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Manage.class.getResource("/org/eclipse/wb/swt/images/icons8-general-ledger-96.png")));
		lblNewLabel_1.setBounds(399, 227, 101, 65);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Manage.class.getResource("/org/eclipse/wb/swt/images/icons8-lock-48.png")));
		label_5.setBounds(481, 0, 48, 49);
		contentPane.add(label_5);
		
		JButton btnAddDoctors = new JButton("Add Doctors");
		btnAddDoctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDoctors add = new AddDoctors();
				add.setVisible(true);
			}
		});
		btnAddDoctors.setForeground(new Color(0, 0, 128));
		btnAddDoctors.setFont(new Font("Arial", Font.BOLD, 10));
		btnAddDoctors.setBackground(UIManager.getColor("Button.background"));
		btnAddDoctors.setBounds(66, 303, 92, 27);
		contentPane.add(btnAddDoctors);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Manage.class.getResource("/org/eclipse/wb/swt/images/icons8-stethoscope-96.png")));
		label_2.setBounds(68, 210, 90, 74);
		contentPane.add(label_2);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Manage.class.getResource("/org/eclipse/wb/swt/images/icons8-add-user-group-man-man-96 (1).png")));
		label_6.setBounds(227, 210, 101, 96);
		contentPane.add(label_6);
		
		JButton btnAddStaff = new JButton("Add Staff");
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStaff add = new AddStaff();
				add.setVisible(true);
			}
		});
		btnAddStaff.setForeground(new Color(0, 0, 128));
		btnAddStaff.setFont(new Font("Arial", Font.BOLD, 10));
		btnAddStaff.setBackground(UIManager.getColor("Button.background"));
		btnAddStaff.setBounds(221, 303, 107, 27);
		contentPane.add(btnAddStaff);
		
		JButton btnPaySalary = new JButton("Pay Salary");
		btnPaySalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaySalary pay = new PaySalary();
				pay.setVisible(true);
			}
		});
		btnPaySalary.setForeground(new Color(0, 0, 128));
		btnPaySalary.setFont(new Font("Arial", Font.BOLD, 10));
		btnPaySalary.setBackground(UIManager.getColor("Button.background"));
		btnPaySalary.setBounds(393, 147, 107, 27);
		contentPane.add(btnPaySalary);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Manage.class.getResource("/org/eclipse/wb/swt/images/icons8-get-cash-96.png")));
		label_7.setBounds(403, 70, 90, 76);
		contentPane.add(label_7);
		
		
	}
}
