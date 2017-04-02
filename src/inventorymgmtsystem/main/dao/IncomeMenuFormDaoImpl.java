package inventorymgmtsystem.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import inventorymgmtsystem.model.Incomemenuform;
import inventorymgmtsystem.model.Mainform;

public class IncomeMenuFormDaoImpl implements IncomeMenuFormDao  {

	@Override
	public void saveDetails(Incomemenuform mf) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studdb", "root", "");
		String sql = "INSERT INTO `incomeformtable` ( `date`, `quantity` ,`unit`, `product_code`,`description` ,`issued_to`, `lot`, `unit_price`) VALUES ( ?,?,?,?,?,?,?,?) ";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, mf.getDate());
		stat.setString(2, mf.getQty());
		stat.setString(3, mf.getUnit());
		stat.setString(4, mf.getProdcode());
		stat.setString(5, mf.getDescriptions());
		stat.setString(6, mf.getIssuedto());

		stat.setString(7, mf.getLot());
		//long prc1=(long) ((mf.getUnitprice())*0.90);
		//stat.setLong(8, prc1);
		//stat.setLong(8, mf.getUnitprice());

	//	long prc=(long) ((mf.getUnitprice())*0.90);
		//stat.setLong(8, prc);
//System.out.println(mf.getIssuedto());
		if(mf.getIssuedto().equals("Consumer")){
			long prc=(long) ((mf.getUnitprice())*0.90);
			stat.setLong(8, prc);
			//stat.setLong(8, mf.getUnitprice());

			//System.out.println(prc);
			//stat.setLong(8, prc);
		//stat.setLong(8, mf.getUnitprice());
		
		}
		else 
		if (mf.getIssuedto().equals("Customer")){
			//long prc=(long) ((mf.getUnitprice())*0.90);
			stat.setLong(8, mf.getUnitprice());

		}/**//*{
			 if (mf.getIssuedto().equals("consumer")){
					long prc=(long) ((mf.getUnitprice())*0.90);
					System.out.println(prc);
					stat.setLong(8, prc);
                     
				}*/
		//}
		stat.executeUpdate();
		conn.close();
	
	}

		
	

	@Override
	public List<Incomemenuform> showAllValues() throws Exception {
		List<Incomemenuform> incomeList = new ArrayList<>();

		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studdb", "root", "");
		Statement stat = conn.createStatement();
		ResultSet rs= stat.executeQuery("SELECT*FROM incomeformtable ");
		
		while(rs.next()){
			//`name`, `roll_no`, `phone_no`, `gender`, `email`, `address`, `college_name`)
			Incomemenuform mf= new Incomemenuform();
			mf.setDate(rs.getString("date"));
			mf.setUnit(rs.getString("unit"));
			mf.setQty(rs.getString("quantity"));

			mf.setProdcode(rs.getString("product_code"));
			mf.setLot(rs.getString("lot"));
			mf.setDescriptions(rs.getString("description"));

			mf.setUnitprice(rs.getLong("unit_price"));
			

			
		incomeList.add(mf);
			
		}
		return incomeList;
	}




	@Override
	public void allocatePrice(Incomemenuform mf) {

		
		
	}

}
