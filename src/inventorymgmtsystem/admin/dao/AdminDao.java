package inventorymgmtsystem.admin.dao;

import java.sql.SQLException;

import inventorymgmtsystem.admin.model.Admin;

public interface AdminDao {

	void loginAdmin(Admin ad) throws Exception;
	
}
