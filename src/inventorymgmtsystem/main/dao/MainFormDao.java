package inventorymgmtsystem.main.dao;

import java.util.List;

import inventorymgmtsystem.model.Mainform;


public interface MainFormDao {

	
	void saveDetails(Mainform mf)throws Exception;

	List<Mainform> showAllValues() throws Exception;

	
}
