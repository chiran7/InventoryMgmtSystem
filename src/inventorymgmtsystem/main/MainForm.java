package inventorymgmtsystem.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import inventorymgmtsystem.main.dao.MainFormDao;
import inventorymgmtsystem.main.dao.MainFormDaoImpl;
import inventorymgmtsystem.model.Mainform;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JPanel studentPNL;


	private JButton showInfoBTN;
	
	private JTable studentTBL;
	private JScrollPane scrollPane;

	private ButtonGroup btnGroup;
	private JLabel lblDate;
	private JTextField dateTXT;
	private JLabel lblQuantity;
	private JTextField qtyTXT;
	private JLabel lblUnit;
	private JLabel lblProductCode;
	private JTextField productcodeTXT;
	private JLabel lblLot;
	private JTextField lotTXT;
	private JLabel lblDescriptions;
	private JTextField descriptionsTXT;
	private JLabel lblIssuedTo;
	private JLabel lblUnitPrice;
	private JTextField unitpriceTXT;
	private JLabel lblTotalPrice;
	private JTextField totalpriceTXT;
	private JButton btnSaveDetails;
	private JMenuBar menuBar_1;
	private JMenu mnNewMenu;
	private JMenuItem incomeMenuItem;
	private JMenuItem expenseMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem profitMenuItem;
	private JMenuItem lossMenuItem;
	private JComboBox comboBoxLBL;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MainForm frame;
				try {
					frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public MainForm() throws Exception {
		setTitle("Inventory Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getStudentPNL());
		contentPane.add(getScrollPane());
		contentPane.add(getShowInfoBTN());
		contentPane.add(getMenuBar_1());
		showAllValue();
	}

	private JPanel getStudentPNL() {
		if (studentPNL == null) {
			studentPNL = new JPanel();
			studentPNL.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Entry form", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
			studentPNL.setBounds(10, 22, 533, 145);
			studentPNL.setLayout(null);
			//studentPNL.add(getLblDate());
			//studentPNL.add(getDateTXT());
			studentPNL.add(getLblQuantity());
			studentPNL.add(getQtyTXT());
			studentPNL.add(getLblUnit());
			studentPNL.add(getLblProductCode());
			studentPNL.add(getProductcodeTXT());
			studentPNL.add(getLblLot());
			studentPNL.add(getLotTXT());
			studentPNL.add(getLblDescriptions());
			studentPNL.add(getDescriptionsTXT());
			studentPNL.add(getLblIssuedTo());
			studentPNL.add(getLblUnitPrice());
			studentPNL.add(getUnitpriceTXT());
			studentPNL.add(getLblTotalPrice());
			studentPNL.add(getTotalpriceTXT());
			studentPNL.add(getBtnSaveDetails());
			studentPNL.add(getComboBoxLBL());
			studentPNL.add(getComboBox());


		}
		return studentPNL;
	}

	private JButton getShowInfoBTN() {
		if (showInfoBTN == null) {
			showInfoBTN = new JButton("Show info");
			showInfoBTN.setBounds(20, 167, 100, 25);
			showInfoBTN.setForeground(Color.BLUE);
			showInfoBTN.setFont(new Font("Tahoma", Font.BOLD, 13));

			showInfoBTN.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					

					// 4.show all Records
					try {
						//saveDatatoDB();
						showAllValue();
					} catch (Exception e1) {
						e1.printStackTrace();
					}


				}
			});
		}
		return showInfoBTN;
	}

	private void showAllValue() throws Exception {

		// Clear table
		DefaultTableModel model = (DefaultTableModel) studentTBL.getModel();
		model.setRowCount(0);

		// Fetch from DB
		MainFormDao dao = new MainFormDaoImpl();
		List<Mainform> mainformList = dao.showAllValues();
		//System.out.println(mainformList);
		//System.out.println();
		
		//for (Mainform cs : mainformList) {
			
			//System.out.println(cs.getUnit());
			//System.out.println(cs.getIssuedto());

		//}
		
		
		for (Mainform cs : mainformList) {
			Object[] row = new Object[] { cs.getDate(),cs.getQty(), cs.getUnit(), cs.getProductcode(), 
					
			cs.getLot(),cs.getDescription(),cs.getIssuedto(),cs.getUnitprice(),cs.getTotalprice()};

			model.addRow(row);
			
			//System.out.println(cs.getDate());

		}
		/**/
	}

	private JTable getStudentTBL() {
		if (studentTBL == null) {
			studentTBL = new JTable();
			studentTBL.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
				},
				new String[] {
					"Date", "Qty", "Unit", "Product code", "Lot#", "Description", "Issued to", "Unit price", "Total price"
				}
			));
			studentTBL.getColumnModel().getColumn(0).setPreferredWidth(100);
			studentTBL.getColumnModel().getColumn(1).setPreferredWidth(25);
		
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
	/*
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date");
			lblDate.setBounds(30, 28, 46, 14);
		}
		return lblDate;
	}
	private JTextField getDateTXT() {
		if (dateTXT == null) {
			dateTXT = new JTextField();
			dateTXT.setBounds(66, 22, 86, 20);
			dateTXT.setColumns(10);
		}
		return dateTXT;
	}
	*/
	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel(" Quantity");
			lblQuantity.setBounds(41, 25, 78, 14);
		}
		return lblQuantity;
	}
	private JTextField getQtyTXT() {
		if (qtyTXT == null) {
			qtyTXT = new JTextField();
			qtyTXT.setColumns(10);
			qtyTXT.setBounds(112, 22, 46, 20);
		}
		return qtyTXT;
	}
	private JLabel getLblUnit() {
		if (lblUnit == null) {
			lblUnit = new JLabel("Unit");
			lblUnit.setBounds(201, 25, 46, 14);
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
	private JLabel getLblIssuedTo() {
		if (lblIssuedTo == null) {
			lblIssuedTo = new JLabel("  Issued to");
			lblIssuedTo.setBounds(309, 66, 63, 14);
		}
		return lblIssuedTo;
	}
	private JLabel getLblUnitPrice() {
		if (lblUnitPrice == null) {
			lblUnitPrice = new JLabel("  Unit Price");
			lblUnitPrice.setBounds(30, 91, 62, 17);
		}
		return lblUnitPrice;
	}
	private JTextField getUnitpriceTXT() {
		if (unitpriceTXT == null) {
			unitpriceTXT = new JTextField();
			unitpriceTXT.setColumns(10);
			unitpriceTXT.setBounds(112, 88, 86, 20);
		}
		return unitpriceTXT;
	}
	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("  Total Price");
			lblTotalPrice.setBounds(211, 94, 76, 14);
		}
		return lblTotalPrice;
	}
	private JTextField getTotalpriceTXT() {
		if (totalpriceTXT == null) {
			totalpriceTXT = new JTextField();
			totalpriceTXT.setColumns(10);
			totalpriceTXT.setBounds(286, 88, 86, 20);
		}
		return totalpriceTXT;
	}
	
	private void saveDatatoDB(){
		
		Mainform mf = new Mainform();
		
		Date dt = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String fDate=fmt.format(dt);
        System.out.println(fDate);
	     mf.setDate(fDate);
		
	    // mf.setDate(dateTXT.getText().trim());
		 mf.setQty(qtyTXT.getText());
		mf.setUnit(String.valueOf(comboBox.getSelectedItem()));
		mf.setProductcode(productcodeTXT.getText());
		mf.setLot(lotTXT.getText());
		mf.setDescription(descriptionsTXT.getText());
		mf.setIssuedto(String.valueOf(comboBoxLBL.getSelectedItem()));
		//mf.setIssuedto(comboBoxLBL.getSelectedItem().toString());
		//mf.setIssuedto(issuedtoTXT.getText());
		mf.setUnitprice(unitpriceTXT.getText());
		mf.setTotalprice(totalpriceTXT.getText());







		// Save to DB
		try {
			MainFormDao dao = new MainFormDaoImpl();
			dao.saveDetails(mf);
		} catch (Exception e) {
			e.printStackTrace();
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
	//	dateTXT.setText("");
		qtyTXT.setText("");
		//unitTXT.setText("");
		productcodeTXT.setText("");
		lotTXT.setText("");
		descriptionsTXT.setText("");
		//issuedtoTXT.setText("");
		unitpriceTXT.setText("");
		totalpriceTXT.setText("");






	}
	private JMenuBar getMenuBar_1() throws Exception {
		if (menuBar_1 == null) {
			menuBar_1 = new JMenuBar();
			menuBar_1.setBounds(10, 0, 553, 21);
			menuBar_1.add(getMnNewMenu());
			menuBar_1.add(getMnNewMenu_1());
		}
		return menuBar_1;
	}
	private JMenu getMnNewMenu() throws Exception {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Income and expense details");
			mnNewMenu.add(getIncomeMenuItem());
			mnNewMenu.add(getExpenseMenuItem());
		}
		return mnNewMenu;
	}
	private JMenuItem getIncomeMenuItem() throws Exception {
		if (incomeMenuItem == null) {
			incomeMenuItem = new JMenuItem("Income details");
			incomeMenuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					

					// 4.show all Records
					try {
						//saveDatatoDB();
						IncomeForm mf= new IncomeForm();
						mf.setVisible(true);
						//showAllValue();
					} catch (Exception e1) {
						e1.printStackTrace();
					}


				}
			});
		}
		return incomeMenuItem;
	}
	private JMenuItem getExpenseMenuItem() {
		if (expenseMenuItem == null) {
			expenseMenuItem = new JMenuItem("Expense Details");
			expenseMenuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					

					// 4.show all Records
					try {
						//saveDatatoDB();
						ExpenseForm ef= new ExpenseForm();
						ef.setVisible(true);
						//showAllValue();
					} catch (Exception e1) {
						e1.printStackTrace();
					}


				}
			});
			
		}
		return expenseMenuItem;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("Profit and loss details");
			mnNewMenu_1.add(getProfitMenuItem());
			mnNewMenu_1.add(getLossMenuItem());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getProfitMenuItem() {
		if (profitMenuItem == null) {
			profitMenuItem = new JMenuItem("Profit");
		}
		return profitMenuItem;
	}
	private JMenuItem getLossMenuItem() {
		if (lossMenuItem == null) {
			lossMenuItem = new JMenuItem("Loss");
		}
		return lossMenuItem;
	}
	private JComboBox getComboBoxLBL() {
		if (comboBoxLBL == null) {
			comboBoxLBL = new JComboBox();
			comboBoxLBL.setToolTipText("");
			comboBoxLBL.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Consumer"}));
			comboBoxLBL.setBounds(371, 60, 68, 20);
		}
		return comboBoxLBL;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kg", "gm", "packet"}));
			comboBox.setBounds(241, 22, 78, 20);
		}
		return comboBox;
	}
}
