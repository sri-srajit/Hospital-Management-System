package org.eclipse.wb.swt;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class AboutUs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AboutUs frame = new AboutUs();
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
	public AboutUs() {
		setTitle("About Us");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AboutUs.class.getResource("/org/eclipse/wb/swt/images/hosptl.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 522, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJeevanRakshaHospital = new JLabel("JEEVAN RAKSHA HOSPITAL");
		lblJeevanRakshaHospital.setForeground(new Color(34, 139, 34));
		lblJeevanRakshaHospital.setVerticalAlignment(SwingConstants.TOP);
		lblJeevanRakshaHospital.setFont(new Font("Arial", Font.BOLD, 20));
		lblJeevanRakshaHospital.setBounds(115, 11, 273, 24);
		contentPane.add(lblJeevanRakshaHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Srajit Srivastava\\Downloads\\hospital-4-24.png"));
		label.setBounds(79, 11, 26, 30);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Srajit Srivastava\\Downloads\\hospital-4-24.png"));
		label_1.setBounds(398, 11, 26, 30);
		contentPane.add(label_1);
		
		JLabel lblWeServeFor = new JLabel("Welcome to Jeevan Raksha Hospital");
		lblWeServeFor.setForeground(new Color(34, 139, 34));
		lblWeServeFor.setFont(new Font("Arial", Font.BOLD, 14));
		lblWeServeFor.setBounds(125, 36, 263, 24);
		contentPane.add(lblWeServeFor);
		
		JLabel lblWeServeFor_1 = new JLabel("We serve for you");
		lblWeServeFor_1.setForeground(new Color(34, 139, 34));
		lblWeServeFor_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblWeServeFor_1.setBounds(205, 61, 100, 18);
		contentPane.add(lblWeServeFor_1);
		
		JTextArea txtrJeevanRakshaHospitals = new JTextArea();
		txtrJeevanRakshaHospitals.setForeground(new Color(0, 102, 0));
		txtrJeevanRakshaHospitals.setEditable(false);
		txtrJeevanRakshaHospitals.setWrapStyleWord(true);
		txtrJeevanRakshaHospitals.setLineWrap(true);
		txtrJeevanRakshaHospitals.setText("Jeevan Raksha Hospital's vision of excellence and leadership  is driven  by  its  core values, which are shared by all members of Hartford HealthCare. These are: Caring, Safety, Excellence and Integrity.");
		txtrJeevanRakshaHospitals.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		txtrJeevanRakshaHospitals.setBackground(SystemColor.control);
		txtrJeevanRakshaHospitals.setBounds(79, 90, 345, 73);
		contentPane.add(txtrJeevanRakshaHospitals);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AboutUs.class.getResource("/org/eclipse/wb/swt/images/about.jpg")));
		label_2.setBounds(79, 174, 174, 159);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(AboutUs.class.getResource("/org/eclipse/wb/swt/images/about2.jpg")));
		label_3.setBounds(174, 174, 250, 159);
		contentPane.add(label_3);
		
		JLabel lblPhone = new JLabel("Phone: +252856");
		lblPhone.setForeground(new Color(34, 139, 34));
		lblPhone.setFont(new Font("Arial", Font.BOLD, 12));
		lblPhone.setBounds(10, 349, 95, 24);
		contentPane.add(lblPhone);
		
		JLabel lblEmailHospitaljeevanrakshacom = new JLabel("email: jeevan.raksha@gmail.com");
		lblEmailHospitaljeevanrakshacom.setForeground(new Color(34, 139, 34));
		lblEmailHospitaljeevanrakshacom.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmailHospitaljeevanrakshacom.setBounds(10, 371, 200, 14);
		contentPane.add(lblEmailHospitaljeevanrakshacom);
		
		JLabel lblFacebookJeevanrakshahospital = new JLabel("Facebook: JeevanRakshaHospital");
		lblFacebookJeevanrakshahospital.setForeground(new Color(34, 139, 34));
		lblFacebookJeevanrakshahospital.setFont(new Font("Arial", Font.BOLD, 12));
		lblFacebookJeevanrakshahospital.setBounds(304, 354, 213, 14);
		contentPane.add(lblFacebookJeevanrakshahospital);
		
		JLabel lblInstagramJeevanrakshahospital = new JLabel("Instagram: JeevanRakshaHospital");
		lblInstagramJeevanrakshahospital.setForeground(new Color(34, 139, 34));
		lblInstagramJeevanrakshahospital.setFont(new Font("Arial", Font.BOLD, 12));
		lblInstagramJeevanrakshahospital.setBounds(304, 371, 225, 14);
		contentPane.add(lblInstagramJeevanrakshahospital);
	}
}
