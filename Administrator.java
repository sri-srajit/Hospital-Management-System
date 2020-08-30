package org.eclipse.wb.swt;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Administrator extends JFrame {
	Connection con = null;
	Statement st = null;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Administrator frame = new Administrator();
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
	public Administrator() {
		setTitle("Log In");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrator.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(0, 0, 128));
		lblUsername.setFont(new Font("Arial", Font.BOLD, 15));
		lblUsername.setBounds(174, 51, 79, 32);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(263, 58, 125, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(0, 0, 128));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblPassword.setBounds(174, 103, 79, 32);
		contentPane.add(lblPassword);
		
		JButton btnLogIn = new JButton("Log IN");
		btnLogIn.setForeground(new Color(0, 0, 128));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = sqlconnection.sqlconnect();
				try {
					st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from login");
					rs.next();
					String un = textField.getText();
					String pass = passwordField.getText();
					if(un.equals(rs.getString(1))&&pass.equals(rs.getString(2)))
					{
						JOptionPane.showMessageDialog(null, "Logged in");
						Manage man = new Manage();
						man.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username or Password is incorrect!");

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnLogIn.setFont(new Font("Arial", Font.BOLD, 15));
		btnLogIn.setBounds(222, 172, 89, 32);
		contentPane.add(btnLogIn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Administrator.class.getResource("/org/eclipse/wb/swt/images/login.png")));
		label.setBounds(10, 51, 154, 138);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Administrator.class.getResource("/org/eclipse/wb/swt/images/check.png")));
		label_1.setBounds(174, 172, 38, 32);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(263, 110, 125, 20);
		contentPane.add(passwordField);
	}
}
