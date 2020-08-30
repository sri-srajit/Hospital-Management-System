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
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Payment extends JFrame {
	Connection con = null;
	Statement st = null;
	Statement st1 = null;
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Payment frame = new Payment();
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
	public Payment() {
		setTitle("Payment");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Payment.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJeevanRakshaHospital = new JLabel("JEEVAN RAKSHA HOSPITAL");
		lblJeevanRakshaHospital.setForeground(new Color(34, 139, 34));
		lblJeevanRakshaHospital.setFont(new Font("Arial", Font.BOLD, 18));
		lblJeevanRakshaHospital.setBounds(89, 0, 260, 33);
		contentPane.add(lblJeevanRakshaHospital);
		
		JLabel lblNewLabel = new JLabel("For successful registration you need to pay the fee \u20B9500. ");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 53, 375, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnPayNow = new JButton("Pay Now");
		btnPayNow.setForeground(new Color(0, 0, 128));
		btnPayNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = sqlconnection.sqlconnect();
				try {
					String query1 = "select balance from account;";
					st = con.createStatement();
					ResultSet rs = st.executeQuery(query1);
					rs.next();
					int bal = rs.getInt("balance");
					bal = bal+500;
					String query = "update account set balance="+bal+";";
					st1 = con.createStatement();
					int c = st1.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Thank You! :-)");
					con.close();
					st.close();
					st1.close();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			});
		btnPayNow.setFont(new Font("Arial", Font.BOLD, 15));
		btnPayNow.setBounds(145, 217, 131, 34);
		contentPane.add(btnPayNow);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Payment.class.getResource("/org/eclipse/wb/swt/images/pay-per-click.png")));
		label.setBounds(145, 78, 131, 128);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Payment.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label_1.setBounds(60, 0, 33, 33);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Payment.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label_2.setBounds(341, 0, 33, 33);
		contentPane.add(label_2);
	}

}
