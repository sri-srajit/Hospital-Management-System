package org.eclipse.wb.swt;
import java.sql.*;
public class sqlconnection {
				public static Connection sqlconnect() {
					String url = "jdbc:mysql://localhost:3306/hospital";
					String uname = "username";
					String pass = "password";
					Connection con=null;;
					try {
						con = DriverManager.getConnection(url,uname,pass);
						return con;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
				}
}

