package org.eclipse.wb.swt;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.DropMode;

public class StaffView extends JFrame {
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
//					StaffView frame = new StaffView();
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
	public StaffView() {
		setTitle("Staff View");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StaffView.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 414, 200);
		contentPane.add(scrollPane);
		
		JTextArea txt = new JTextArea();
		txt.setFont(new Font("Arial", Font.PLAIN, 14));
		txt.setEditable(false);
		txt.setWrapStyleWord(true);
		txt.setLineWrap(true);
		scrollPane.setViewportView(txt);
		con = sqlconnection.sqlconnect();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from doctor;");
			txt.append("⇒LIST OF DOCTORS    \n");
			txt.append("  Name            Specialization            Room No.\n");
			//txt.setText("list");
			int c=1;
			while(rs.next())
			{
					String name = rs.getString(1);
					String spec = rs.getString(2);
					String room = rs.getString(3);
					txt.append(c+". "+name+"            "+spec+"                "+room+"\n");
					c++;
			}
			c=1;
			txt.append("\n\n\n");
			rs = st.executeQuery("select * from staff;");
			txt.append("⇒LIST OF STAFF    \n");
			txt.append("  Name              Designation\n");
			while(rs.next())
			{
				String name = rs.getString(1);
				String des = rs.getString(2);
				txt.append(c+". "+name+"               "+des+"\n");
			}
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		JLabel lblJeevanRakshaHospital = new JLabel("JEEVAN RAKSHA HOSPITAL STAFF");
		lblJeevanRakshaHospital.setForeground(new Color(34, 139, 34));
		lblJeevanRakshaHospital.setFont(new Font("Arial", Font.BOLD, 17));
		lblJeevanRakshaHospital.setBounds(63, 11, 295, 28);
		contentPane.add(lblJeevanRakshaHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StaffView.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label.setBounds(36, 11, 26, 28);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(StaffView.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label_1.setBounds(354, 11, 26, 28);
		contentPane.add(label_1);
	}
}
