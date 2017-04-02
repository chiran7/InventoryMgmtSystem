package inventorymgmtsystem.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import inventorymgmtsystem.model.Expenseform;
import inventorymgmtsystem.model.Mainform;

public class ExpenseFormDaoImpl implements ExpenseFormDao {

	@Override
	public List<Expenseform> showAllValue() throws Exception {
		
		List<Expenseform> expenseformList = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studdb", "root", "");
		Statement stat = conn.createStatement();
		ResultSet rs= stat.executeQuery("SELECT*FROM expensetable ");
		
		while(rs.next()){
			//`name`, `roll_no`, `phone_no`, `gender`, `email`, `address`, `college_name`)
		Expenseform ef= new Expenseform();
	
		
		    ef.setDate(rs.getString("date"));
			ef.setDealer(rs.getString("dealer"));
			ef.setQuantity(rs.getString("qty"));
			ef.setUnit(rs.getString("unit"));
			ef.setProductcode(rs.getString("prodcode"));
			ef.setLot(rs.getString("lot"));
			ef.setDescription(rs.getString("description"));
			ef.setUnitprice(rs.getString("unitprice"));
			ef.setTotalprice(rs.getString("totalprice"));
			

			
		expenseformList.add(ef);
		/**/
		}
		
		return expenseformList;
	}

	@Override
	public void saveDetails(Expenseform ef) throws Exception {

		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studdb", "root", "");
		String sql = "INSERT INTO `expensetable` ( `date`,`dealer`, `qty`, `unit`, `prodcode`, `lot`, `description`, `unitprice`, `totalprice`) VALUES ( ?,?, ?,?,?,?,?,?,?) ";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, ef.getDate());

		stat.setString(2, ef.getDealer());
		stat.setString(3, ef.getQuantity());
		stat.setString(4, ef.getUnit());
		stat.setString(5, ef.getProductcode());
		stat.setString(6, ef.getLot());
		stat.setString(7, ef.getDescription());
		stat.setString(8, ef.getUnitprice());
		stat.setString(9, ef.getTotalprice());
		stat.executeUpdate();
		conn.close();
	
	}
	}

	
	

