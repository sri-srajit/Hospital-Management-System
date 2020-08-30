package org.eclipse.wb.swt;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
public class HomePage {

	public Shell shlWelcomePage;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HomePage window = new HomePage();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlWelcomePage.open();
		shlWelcomePage.layout();
		while (!shlWelcomePage.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlWelcomePage = new Shell();
		shlWelcomePage.setImage(SWTResourceManager.getImage(HomePage.class, "/org/eclipse/wb/swt/images/hosptl.png"));
		shlWelcomePage.setSize(512, 366);
		shlWelcomePage.setText("Home");
		
		
		Label lblJeevanRakshaHospital = new Label(shlWelcomePage, SWT.NONE);
		lblJeevanRakshaHospital.setAlignment(SWT.CENTER);
		lblJeevanRakshaHospital.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblJeevanRakshaHospital.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblJeevanRakshaHospital.setFont(SWTResourceManager.getFont("Arial", 15, SWT.BOLD));
		lblJeevanRakshaHospital.setBounds(106, 28, 281, 33);
		lblJeevanRakshaHospital.setText("JEEVAN RAKSHA HOSPITAL");
		
		Label lblPatientsClickBelow = new Label(shlWelcomePage, SWT.NONE);
		lblPatientsClickBelow.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblPatientsClickBelow.setFont(SWTResourceManager.getFont("Arial", 11, SWT.BOLD));
		lblPatientsClickBelow.setBounds(112, 61, 275, 19);
		lblPatientsClickBelow.setText("Welcome to Jeevan Raksha Hospital!");
		
		Button btnRegister = new Button(shlWelcomePage, SWT.NONE);
		btnRegister.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		btnRegister.setFont(SWTResourceManager.getFont("Arial", 11, SWT.BOLD));
		btnRegister.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//shlWelcomePage.dispose();
				Patient patient = new Patient();
				patient.setVisible(true);
			}
		});
		btnRegister.setBounds(29, 224, 101, 33);
		btnRegister.setText("Register");
		
		Label lblWeServeFor = new Label(shlWelcomePage, SWT.NONE);
		lblWeServeFor.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblWeServeFor.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		lblWeServeFor.setBounds(187, 81, 112, 15);
		lblWeServeFor.setText("We serve for you");
		
		Label label = new Label(shlWelcomePage, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(HomePage.class, "/org/eclipse/wb/swt/images/hosptl.png"));
		label.setBounds(74, 10, 32, 57);
		
		Label label_1 = new Label(shlWelcomePage, SWT.NONE);
		label_1.setImage(SWTResourceManager.getImage(HomePage.class, "/org/eclipse/wb/swt/images/hosptl.png"));
		label_1.setBounds(394, 10, 32, 57);
		
		Button btnLogIn = new Button(shlWelcomePage, SWT.NONE);
		btnLogIn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		btnLogIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Administrator admin = new Administrator();
				admin.setVisible(true);
			}
		});
		btnLogIn.setText("Log In");
		btnLogIn.setFont(SWTResourceManager.getFont("Arial", 11, SWT.BOLD));
		btnLogIn.setBounds(165, 224, 134, 33);
		
		Button btnAboutUs = new Button(shlWelcomePage, SWT.NONE);
		btnAboutUs.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		btnAboutUs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AboutUs about = new AboutUs();
				about.setVisible(true);
			}
		});
		btnAboutUs.setText("About Us");
		btnAboutUs.setFont(SWTResourceManager.getFont("Arial", 11, SWT.BOLD));
		btnAboutUs.setBounds(322, 224, 134, 33);
		
		Label label_3 = new Label(shlWelcomePage, SWT.NONE);
		label_3.setImage(SWTResourceManager.getImage(HomePage.class, "/org/eclipse/wb/swt/images/login (1).png"));
		label_3.setBounds(199, 118, 76, 89);
		 
		 Label label_2 = new Label(shlWelcomePage, SWT.NONE);
		 label_2.setImage(SWTResourceManager.getImage(HomePage.class, "/org/eclipse/wb/swt/images/icons8-checked-user-male-96.png"));
		 label_2.setBounds(29, 118, 100, 100);
		 
		 Label label_4 = new Label(shlWelcomePage, SWT.NONE);
		 label_4.setImage(SWTResourceManager.getImage(HomePage.class, "/org/eclipse/wb/swt/images/info-64.png"));
		 label_4.setBounds(350, 118, 76, 89);
			}
}
