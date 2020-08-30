package org.eclipse.wb.swt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ChangePassword extends JFrame {
	Connection con = null;
	Statement st = null;

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setTitle("Change Password");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChangePassword.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChangePassword = new JLabel("Change Your Password");
		lblChangePassword.setForeground(Color.ORANGE);
		lblChangePassword.setFont(new Font("Arial", Font.BOLD, 17));
		lblChangePassword.setBounds(113, 11, 195, 26);
		contentPane.add(lblChangePassword);
		
		JLabel lblOldPassword = new JLabel("Old Password\r\n :");
		lblOldPassword.setForeground(new Color(0, 0, 128));
		lblOldPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblOldPassword.setBounds(10, 48, 104, 26);
		contentPane.add(lblOldPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 52, 141, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewPassword = new JLabel("New Password\r\n :");
		lblNewPassword.setForeground(new Color(0, 0, 128));
		lblNewPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewPassword.setBounds(10, 97, 115, 26);
		contentPane.add(lblNewPassword);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password\r\n :");
		lblRepeatPassword.setForeground(new Color(0, 0, 128));
		lblRepeatPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblRepeatPassword.setBounds(10, 148, 128, 26);
		contentPane.add(lblRepeatPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(139, 101, 141, 20);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(139, 152, 141, 20);
		contentPane.add(passwordField_2);
		
		JButton btnChange = new JButton("Change");
		btnChange.setForeground(new Color(0, 0, 128));
		btnChange.setBackground(UIManager.getColor("Button.background"));
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = sqlconnection.sqlconnect();
				try {
					st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from login");
					rs.next();
					String un = passwordField.getText();
					if(un.equals(rs.getString(2)))
					{
						String newpass = passwordField_1.getText();
						String confpass = passwordField_2.getText();
						if(newpass.equals(confpass)) {
								String query = "update login set password='"+newpass+"';";
								st.execute(query);
								JOptionPane.showMessageDialog(null, "Password changed successfully!");
								st.close();
								con.close();
								dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Password didn't match!");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Old Password is incorrect!");

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnChange.setFont(new Font("Arial", Font.BOLD, 15));
		btnChange.setBounds(113, 203, 89, 23);
		contentPane.add(btnChange);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ChangePassword.class.getResource("/org/eclipse/wb/swt/images/icons8-let's-encrypt-144.png")));
		label.setBounds(290, 48, 134, 138);
		contentPane.add(label);
	}
}
