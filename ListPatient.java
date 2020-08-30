package org.eclipse.wb.swt;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

public class ListPatient extends JFrame {
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
//					ListPatient frame = new ListPatient();
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
	public ListPatient() {
		setTitle("Patients List");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListPatient.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJeevanRakshaHospital = new JLabel("JEEVAN RAKSHA HOSPITAL PATIENTS");
		lblJeevanRakshaHospital.setForeground(new Color(34, 139, 34));
		lblJeevanRakshaHospital.setFont(new Font("Arial", Font.BOLD, 17));
		lblJeevanRakshaHospital.setBounds(81, 11, 324, 35);
		contentPane.add(lblJeevanRakshaHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ListPatient.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label.setBounds(53, 11, 26, 35);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ListPatient.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		label_1.setBounds(403, 11, 26, 35);
		contentPane.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 57, 376, 254);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		con = sqlconnection.sqlconnect();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from patient;");
			int c=1;
			textArea.append("  Name                Age            Disease            Gender\n");
			while(rs.next())
			{
				String name = rs.getString(1);
				int age = rs.getInt(2);
				String disease = rs.getString(3);
				String gender = rs.getString(4);
				textArea.append(c+". "+name+"           "+age+"           "+disease+"           "+gender+"\n");
				c++;
			}
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
