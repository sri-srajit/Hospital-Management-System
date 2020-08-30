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
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaySalary extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Connection con = null;
	PreparedStatement st = null;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PaySalary frame = new PaySalary();
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
	public PaySalary() {
		setTitle("Pay Salary");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PaySalary.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJeevanRakshaHospital = new JLabel("JEEVAN RAKSHA HOSPITAL");
		lblJeevanRakshaHospital.setForeground(new Color(34, 139, 34));
		lblJeevanRakshaHospital.setFont(new Font("Arial", Font.BOLD, 17));
		lblJeevanRakshaHospital.setBounds(89, 11, 253, 26);
		contentPane.add(lblJeevanRakshaHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PaySalary.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label.setBounds(60, 7, 33, 36);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PaySalary.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label_1.setBounds(331, 7, 33, 36);
		contentPane.add(label_1);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(new Color(25, 25, 112));
		lblName.setFont(new Font("Arial", Font.BOLD, 16));
		lblName.setBounds(31, 71, 62, 26);
		contentPane.add(lblName);
		
		JLabel lblDesignation = new JLabel("Designation :");
		lblDesignation.setForeground(new Color(25, 25, 112));
		lblDesignation.setFont(new Font("Arial", Font.BOLD, 16));
		lblDesignation.setBounds(31, 145, 106, 26);
		contentPane.add(lblDesignation);
		
		JLabel lblWorksAs = new JLabel("Works As :");
		lblWorksAs.setForeground(new Color(25, 25, 112));
		lblWorksAs.setFont(new Font("Arial", Font.BOLD, 16));
		lblWorksAs.setBounds(31, 108, 88, 26);
		contentPane.add(lblWorksAs);
		
		textField = new JTextField();
		textField.setBounds(153, 71, 137, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(153, 150, 137, 20);
		contentPane.add(textField_1);
		
		JRadioButton rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setForeground(new Color(25, 25, 112));
		rdbtnDoctor.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnDoctor.setBounds(153, 112, 77, 23);
		contentPane.add(rdbtnDoctor);
		
		JRadioButton rdbtnOtherStaff = new JRadioButton(" Staff");
		rdbtnOtherStaff.setForeground(new Color(25, 25, 112));
		rdbtnOtherStaff.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnOtherStaff.setBounds(232, 112, 100, 23);
		contentPane.add(rdbtnOtherStaff);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(PaySalary.class.getResource("/org/eclipse/wb/swt/images/icons8-get-cash-96.png")));
		label_2.setBounds(320, 71, 104, 100);
		contentPane.add(label_2);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = sqlconnection.sqlconnect();
				String name = textField.getText();
				String des = textField_1.getText();
				if(rdbtnDoctor.isSelected())
				{
					try {
						st = con.prepareStatement("update doctor set SalaryPaidOn = curdate() where name ='"+name+"'and speciality = '"+des+"';");
						st.executeUpdate();
						ResultSet rs = st.executeQuery("select * from account;");
						rs.next();
						int bal = rs.getInt(1);
						bal = bal- 1000;
						st = con.prepareStatement("update account set balance ="+bal+";");
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Salary Paid");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Please Enter correct values!");
					}
				}
				else if(rdbtnOtherStaff.isSelected())
				{
					try {
						st = con.prepareStatement("update staff set SalaryPaidOn = curdate() where  name= '"+name+"'and designation = '"+des+"';");
						st.executeUpdate();
						ResultSet rs = st.executeQuery("select * from account;");
						rs.next();
						int bal = rs.getInt(1);
						bal = bal- 500;
						st = con.prepareStatement("update account set balance ="+bal+";");
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Salary Paid");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Please Enter correct values!");
					}
					
				}
			}
		});
		btnPay.setForeground(new Color(25, 25, 112));
		btnPay.setFont(new Font("Arial", Font.BOLD, 16));
		btnPay.setBounds(160, 196, 89, 23);
		contentPane.add(btnPay);
	}
}
