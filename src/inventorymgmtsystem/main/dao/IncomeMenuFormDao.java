package inventorymgmtsystem.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import inventorymgmtsystem.model.Incomemenuform;
import inventorymgmtsystem.model.Mainform;

public interface IncomeMenuFormDao {

	void allocatePrice(Incomemenuform mf);

	
 void saveDetails(Incomemenuform mf) throws Exception;
 
 List<Incomemenuform>	showAllValues() throws Exception;
 
 

	
}
