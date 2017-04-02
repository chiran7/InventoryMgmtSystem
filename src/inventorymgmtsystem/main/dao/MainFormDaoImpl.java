package inventorymgmtsystem.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import inventorymgmtsystem.model.Mainform;



public class MainFormDaoImpl implements MainFormDao{

	@Override
	public List<Mainform> showAllValues() throws Exception {
		
List<Mainform> mainformList = new ArrayList<>();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studdb", "root", "");
		Statement stat = conn.createStatement();
		ResultSet rs= stat.executeQuery("SELECT*FROM inventable ");
		
		while(rs.next()){
			//`name`, `roll_no`, `phone_no`, `gender`, `email`, `address`, `college_name`)
			Mainform mf= new Mainform();
			mf.setDate(rs.getString("date"));
			mf.setQty(rs.getString("qty"));
			mf.setUnit(rs.getString("unit"));
			mf.setProductcode(rs.getString("prodcode"));
			mf.setLot(rs.getString("lot"));
			mf.setDescription(rs.getString("description"));
			mf.setIssuedto(rs.getString("issued_to"));
			mf.setUnitprice(rs.getString("unit_price"));
			mf.setTotalprice(rs.getString("total_price"));
			

			
		mainformList.add(mf);
			
		}
		//System.out.println(mainformList);
		return mainformList;
	}

	@Override
	public void saveDetails(Mainform mf) throws Exception {

		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studdb", "root", "");
		String sql = "INSERT INTO `inventable` ( `date`, `qty`, `unit`, `prodcode`, `lot`, `description`, `issued_to`, `unit_price`, `total_price`) VALUES ( ?, ?,?,?,?,?,?,?,?) ";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, mf.getDate());
		stat.setString(2, mf.getQty());
		stat.setString(3, mf.getUnit());
		stat.setString(4, mf.getProductcode());
		stat.setString(5, mf.getLot());
		stat.setString(6, mf.getDescription());
		stat.setString(7, mf.getIssuedto());
		stat.setString(8, mf.getUnitprice());
		stat.setString(9, mf.getTotalprice());
		stat.executeUpdate();
		conn.close();
	
	}


	
}
