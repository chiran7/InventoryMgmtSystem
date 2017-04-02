package inventorymgmtsystem.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import inventorymgmtsystem.admin.model.Admin;
import inventorymgmtsystem.main.MainForm;

public class AdminDaoImpl implements AdminDao {

	@Override
	public void loginAdmin(Admin ad) throws Exception {
		String usrnm= ad.getUsernameAdmin();
		String pswd=ad.getPasswordAdmin();

		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studdb","root","");
		Statement stat = conn.createStatement();

		ResultSet rs= stat.executeQuery ("SELECT*FROM admin where username='" +usrnm+ " 'and "+ "password='"+pswd+"'");

if(rs.next()==true){
			
			if ((usrnm.equals(rs.getString("username")))&&(pswd.equals(rs.getString("password")))){
			System.out.println("Login success");	
			
			MainForm mf = new MainForm();
			mf.setVisible(true);
			//CourseForm sf = new CourseForm();
			//sf.setVisible(true);
			}
			}
			else{
			//	System.out.println("Error");
				JOptionPane.showMessageDialog(null, "Enter again. Username/Password mismatch!");
				
			}
			
		
		
	}

}
