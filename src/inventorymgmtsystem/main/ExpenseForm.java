package inventorymgmtsystem.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import inventorymgmtsystem.main.dao.ExpenseFormDao;
import inventorymgmtsystem.main.dao.ExpenseFormDaoImpl;
import inventorymgmtsystem.main.dao.MainFormDao;
import inventorymgmtsystem.main.dao.MainFormDaoImpl;
import inventorymgmtsystem.model.Expenseform;
import inventorymgmtsystem.model.Mainform;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ExpenseForm extends JFrame{

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JPanel studentPNL;


	private JButton showInfoBTN;
	
	private JTable studentTBL;
	private JScrollPane scrollPane;

	private ButtonGroup btnGroup;
	private JLabel lblDate;
	private JLabel lblQuantity;
	private JTextField qtyTXT;
	private JLabel lblUnit;
	private JLabel lblProductCode;
	private JTextField productcodeTXT;
	private JLabel lblLot;
	private JTextField lotTXT;
	private JLabel lblDescriptions;
	private JTextField descriptionsTXT;
	private JButton btnSaveDetails;
	private JMenuBar menuBar_1;
	private JMenu mnNewMenu;
	private JMenuItem incomeMenuItem;
	private JMenuItem expenseMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem profitMenuItem;
	private JMenuItem lossMenuItem;
	private JLabel unitpriceLBL;
	private JTextField unitpriceTXT;
	private JLabel totalpriceLBL;
	private JTextField totalpriceTXT;
	private JComboBox comboBox;
	private JLabel label_2;
	private JMenuBar menuBar_2;
	private JMenu mainExpnsPageLBL;
	private JMenuItem mntmHomeLBL;
	private JMenuItem mntmExitLBL;
	private JMenuItem mntmFoodLBL;
	private JMenuItem waterMenuItemLBL;
	private JMenuItem mntmStaffsalaryLBL;
	private JMenuItem ProductMenuItemLBL;
	private JMenuItem taxMenuItemLBL;
	private JMenuItem dealerMenuItemLBL;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ExpenseForm frame;
				try {
					frame = new ExpenseForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public ExpenseForm() throws Exception {
		setTitle("Inventory Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getStudentPNL());
		contentPane.add(getScrollPane());
		contentPane.add(getMenuBar_2());
		//contentPane.add(getShowInfoBTN());
		//contentPane.add(getMenuBar_1());
		showAllValue();
		
	}
	
	private JPanel getStudentPNL() {
		if (studentPNL == null) {
			studentPNL = new JPanel();
			studentPNL.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Entry expense details - DEALER", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
			studentPNL.setBounds(10, 22, 533, 145);
			studentPNL.setLayout(null);
			studentPNL.add(getLblDate());
			studentPNL.add(getLblQuantity());
			studentPNL.add(getQtyTXT());
			studentPNL.add(getLblUnit());
			studentPNL.add(getLblProductCode());
			studentPNL.add(getProductcodeTXT());
			studentPNL.add(getLblLot());
			studentPNL.add(getLotTXT());
			studentPNL.add(getLblDescriptions());
			studentPNL.add(getDescriptionsTXT());
			studentPNL.add(getBtnSaveDetails());
			studentPNL.add(getUnitpriceLBL());
			studentPNL.add(getUnitpriceTXT());
			studentPNL.add(getTotalpriceLBL());
			studentPNL.add(getTotalpriceTXT());
			studentPNL.add(getComboBox_1());
			studentPNL.add(getLabel_2());
			studentPNL.add(getComboBox_1_1());
			studentPNL.add(getComboBox_2());


		}
		return studentPNL;
	}
	
	private JTable getStudentTBL() {
		if (studentTBL == null) {
			studentTBL = new JTable();
			studentTBL.setModel(new DefaultTableModel(
					new Object[][] { { null,null,null, null, null, null, null, null, null, null }, 
							{ null,null,null, null, null, null, null, null, null, null },
							{ null,null,null, null, null, null, null, null, null, null },
							{null, null,null, null, null, null, null, null, null, null },
							{null, null,null, null, null, null, null, null, null, null }},
					new String[] {"Date","Dealer","Qty","Unit", "Product code", "Lot#","Description"
							,"Unit price","Total price" }));
		
		}

		return studentTBL;

	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 194, 533, 100);
			scrollPane.setViewportView(getStudentTBL());
		}
		return scrollPane;
	}
	
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Dealer");
			lblDate.setBounds(30, 28, 46, 14);
		}
		return lblDate;
	}
	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel(" Quantity");
			lblQuantity.setBounds(154, 28, 78, 14);
		}
		return lblQuantity;
	}
	private JTextField getQtyTXT() {
		if (qtyTXT == null) {
			qtyTXT = new JTextField();
			qtyTXT.setColumns(10);
			qtyTXT.setBounds(207, 25, 46, 20);
		}
		return qtyTXT;
	}
	private JLabel getLblUnit() {
		if (lblUnit == null) {
			lblUnit = new JLabel("Unit");
			lblUnit.setBounds(261, 28, 46, 14);
		}
		return lblUnit;
	}
	private JLabel getLblProductCode() {
		if (lblProductCode == null) {
			lblProductCode = new JLabel("Product code");
			lblProductCode.setBounds(361, 28, 78, 14);
		}
		return lblProductCode;
	}
	private JTextField getProductcodeTXT() {
		if (productcodeTXT == null) {
			productcodeTXT = new JTextField();
			productcodeTXT.setColumns(10);
			productcodeTXT.setBounds(437, 22, 86, 20);
		}
		return productcodeTXT;
	}
	private JLabel getLblLot() {
		if (lblLot == null) {
			lblLot = new JLabel("Lot");
			lblLot.setBounds(30, 66, 46, 14);
		}
		return lblLot;
	}
	private JTextField getLotTXT() {
		if (lotTXT == null) {
			lotTXT = new JTextField();
			lotTXT.setColumns(10);
			lotTXT.setBounds(66, 60, 46, 20);
		}
		return lotTXT;
	}
	private JLabel getLblDescriptions() {
		if (lblDescriptions == null) {
			lblDescriptions = new JLabel("Description");
			lblDescriptions.setBounds(133, 66, 75, 14);
		}
		return lblDescriptions;
	}
	private JTextField getDescriptionsTXT() {
		if (descriptionsTXT == null) {
			descriptionsTXT = new JTextField();
			descriptionsTXT.setColumns(10);
			descriptionsTXT.setBounds(201, 60, 86, 20);
		}
		return descriptionsTXT;
	}
	
private void saveDatatoDB(){
		
		Expenseform ef = new Expenseform();
		
		Date dt = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String fDate=fmt.format(dt);
       // System.out.println(fDate);
	     ef.setDate(fDate);
		
		
	     ef.setDealer(String.valueOf(comboBox_2.getSelectedItem()));
		 ef.setQuantity(qtyTXT.getText());
		ef.setUnit(String.valueOf(comboBox_1.getSelectedItem()));
		ef.setProductcode(productcodeTXT.getText());
		ef.setLot(lotTXT.getText());
		ef.setDescription(descriptionsTXT.getText());
		//mf.setIssuedto(issuedtoTXT.getText());
		ef.setUnitprice(unitpriceTXT.getText());
		ef.setTotalprice(totalpriceTXT.getText());







		// Save to DB
		try {
			ExpenseFormDao dao1 = new ExpenseFormDaoImpl();
			dao1.saveDetails(ef);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
		
private void showAllValue() throws Exception {

	// Clear table
	
	DefaultTableModel model = (DefaultTableModel) studentTBL.getModel();
	model.setRowCount(0);

	ExpenseFormDao dao = new ExpenseFormDaoImpl();
	List<Expenseform> expenseformList = dao.showAllValue();

	for (Expenseform ef : expenseformList) {
		Object[] row = new Object[] { ef.getDate(),ef.getDealer(),ef.getQuantity(), ef.getUnit(), ef.getProductcode(), 
				
		ef.getLot(),ef.getDescription(),ef.getUnitprice(),ef.getTotalprice()};

		model.addRow(row);
		
	//	System.out.println(ef.getDate());

	}
	
}
	
	
	
	private JButton getBtnSaveDetails() {
		if (btnSaveDetails == null) {
			btnSaveDetails = new JButton("Save details");
			btnSaveDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnSaveDetails.setForeground(Color.RED);
			btnSaveDetails.setBounds(378, 116, 121, 23);
			
			btnSaveDetails.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					

					// 4.show all Records
					try {
						saveDatatoDB();
						showAllValue();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
                    clearForm();

				}
			});
			
		}
		return btnSaveDetails;
	}
	
	private void clearForm() {
		//dealerTXT.setText("");
		qtyTXT.setText("");
		//unitTXT.setText("");
		productcodeTXT.setText("");
		lotTXT.setText("");
		descriptionsTXT.setText("");
		//issuedtoTXT.setText("");
		unitpriceTXT.setText("");
		totalpriceTXT.setText("");


	}
	private JLabel getUnitpriceLBL() {
		if (unitpriceLBL == null) {
			unitpriceLBL = new JLabel("  Unit Price");
			unitpriceLBL.setBounds(309, 63, 62, 17);
		}
		return unitpriceLBL;
	}
	private JTextField getUnitpriceTXT() {
		if (unitpriceTXT == null) {
			unitpriceTXT = new JTextField();
			unitpriceTXT.setColumns(10);
			unitpriceTXT.setBounds(391, 60, 86, 20);
		}
		return unitpriceTXT;
	}
	private JLabel getTotalpriceLBL() {
		if (totalpriceLBL == null) {
			totalpriceLBL = new JLabel("  Total Price");
			totalpriceLBL.setBounds(30, 109, 76, 14);
		}
		return totalpriceLBL;
	}
	private JTextField getTotalpriceTXT() {
		if (totalpriceTXT == null) {
			totalpriceTXT = new JTextField();
			totalpriceTXT.setColumns(10);
			totalpriceTXT.setBounds(105, 103, 86, 20);
		}
		return totalpriceTXT;
	}
	private JComboBox getComboBox_1() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Advance Salary", "Regular Salary"}));
			comboBox.setToolTipText("");
			comboBox.setBounds(269, 103, 102, 20);
		}
		return comboBox;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Salary");
			label_2.setBounds(218, 109, 46, 14);
		}
		return label_2;
	}
	private JMenuBar getMenuBar_2() {
		if (menuBar_2 == null) {
			menuBar_2 = new JMenuBar();
			menuBar_2.setBounds(42, 0, 233, 21);
			menuBar_2.add(getMainExpnsPageLBL());
		}
		return menuBar_2;
	}
	private JMenu getMainExpnsPageLBL() {
		if (mainExpnsPageLBL == null) {
			mainExpnsPageLBL = new JMenu("Expense Details Main Page");
			mainExpnsPageLBL.add(getMntmHomeLBL());
			mainExpnsPageLBL.add(getDealerMenuItemLBL());
			mainExpnsPageLBL.add(getMntmFoodLBL());
			mainExpnsPageLBL.add(getWaterMenuItemLBL());
			mainExpnsPageLBL.add(getMntmStaffsalaryLBL());
			mainExpnsPageLBL.add(getProductMenuItemLBL());
			mainExpnsPageLBL.add(getTaxMenuItemLBL());
			mainExpnsPageLBL.add(getMntmExitLBL());
		}
		return mainExpnsPageLBL;
	}
	private JMenuItem getMntmHomeLBL() {
		if (mntmHomeLBL == null) {
			mntmHomeLBL = new JMenuItem("Home Page");
			mntmHomeLBL.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					

					// 4.show all Records
					try {
						//saveDatatoDB();
						MainForm mf= new MainForm();
						mf.setVisible(true);
						//showAllValue();
					} catch (Exception e1) {
						e1.printStackTrace();
					}


				}
			});
			
		}
		return mntmHomeLBL;
	}
	private JMenuItem getMntmExitLBL() {
		if (mntmExitLBL == null) {
			mntmExitLBL = new JMenuItem("Exit");
			
			mntmExitLBL.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

					//System.exit(0);
				}
			});
		}
		return mntmExitLBL;
	}
	private JMenuItem getMntmFoodLBL() {
		if (mntmFoodLBL == null) {
			mntmFoodLBL = new JMenuItem("Food");
		}
		return mntmFoodLBL;
	}
	private JMenuItem getWaterMenuItemLBL() {
		if (waterMenuItemLBL == null) {
			waterMenuItemLBL = new JMenuItem("Water");
		}
		return waterMenuItemLBL;
	}
	private JMenuItem getMntmStaffsalaryLBL() {
		if (mntmStaffsalaryLBL == null) {
			mntmStaffsalaryLBL = new JMenuItem("Staff-Salary");
		}
		return mntmStaffsalaryLBL;
	}
	private JMenuItem getProductMenuItemLBL() {
		if (ProductMenuItemLBL == null) {
			ProductMenuItemLBL = new JMenuItem("Product");
		}
		return ProductMenuItemLBL;
	}
	private JMenuItem getTaxMenuItemLBL() {
		if (taxMenuItemLBL == null) {
			taxMenuItemLBL = new JMenuItem("Tax");
		}
		return taxMenuItemLBL;
	}
	private JMenuItem getDealerMenuItemLBL() {
		if (dealerMenuItemLBL == null) {
			dealerMenuItemLBL = new JMenuItem("Dealer");
		}
		return dealerMenuItemLBL;
	}
	private JComboBox getComboBox_1_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Kg", "gm", "packet"}));
			comboBox_1.setBounds(289, 25, 62, 20);
		}
		return comboBox_1;
	}
	private JComboBox getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox();
			comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Hundai", "CG", "Samsung"}));
			comboBox_2.setBounds(66, 25, 78, 20);
		}
		return comboBox_2;
	}
}
