package org.eclipse.wb.swt;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegSlip extends JFrame {
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
//					RegSlip frame = new RegSlip();
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
	public RegSlip() {
		setTitle("Registration Slip\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegSlip.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 379, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.ITALIC, 15));
		textArea.setBounds(10, 58, 336, 321);
		contentPane.add(textArea);
		
		JLabel lblHereIsYour = new JLabel("Here is your registration slip:");
		lblHereIsYour.setForeground(new Color(0, 0, 128));
		lblHereIsYour.setFont(new Font("Arial", Font.BOLD, 14));
		lblHereIsYour.setBounds(10, 0, 210, 28);
		contentPane.add(lblHereIsYour);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setForeground(new Color(0, 0, 128));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean com = textArea.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setFont(new Font("Arial", Font.BOLD, 13));
		btnPrint.setBounds(119, 28, 89, 23);
		contentPane.add(btnPrint);
		con = sqlconnection.sqlconnect();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from patient;");
			String name = null,disease = null,gender = null;
			int age = 0;
			while(rs.next())
			{
				name = rs.getString(1);
				age = rs.getInt(2);
				disease = rs.getString(3);
				gender = rs.getString(4);
			}
			rs = st.executeQuery("select * from specialization where disease='"+disease+"';");
			rs.next();
			String spec1 = rs.getString(2);
			rs = st.executeQuery("select *  from doctor where speciality = '"+spec1+"';");
			rs.next();
			String dname = rs.getString(1);
			String spec = rs.getString(2);
			String droom = rs.getString(3);
			textArea.append("                       JEEVAN RAKSHA HOSPITAL      \n");
			textArea.append("                           Patient Registration Slip\n");
			textArea.append("Name:           "+name+"\n");
			textArea.append("Age:              "+age+"\n");
			textArea.append("Disease:       "+disease+"\n");
			textArea.append("Gender:       "+gender+"\n");
			textArea.append("Doctor:         "+dname+"\n");
			textArea.append("Speciality:   "+spec+"\n");
			textArea.append("Room No.:    "+droom+"\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
