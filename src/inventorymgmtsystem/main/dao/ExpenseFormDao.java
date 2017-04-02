package inventorymgmtsystem.main.dao;

import java.util.List;

import inventorymgmtsystem.model.Expenseform;
import inventorymgmtsystem.model.Mainform;

public interface ExpenseFormDao {

	void saveDetails(Expenseform ef)throws Exception;

	
	List<Expenseform> showAllValue() throws Exception;
	
	
}
