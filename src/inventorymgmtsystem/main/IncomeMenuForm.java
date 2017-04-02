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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import inventorymgmtsystem.main.dao.IncomeFormDao;
import inventorymgmtsystem.main.dao.IncomeFormDaoImpl;
import inventorymgmtsystem.main.dao.IncomeMenuFormDao;
import inventorymgmtsystem.main.dao.IncomeMenuFormDaoImpl;
import inventorymgmtsystem.main.dao.MainFormDao;
import inventorymgmtsystem.main.dao.MainFormDaoImpl;
import inventorymgmtsystem.model.Incomemenuform;
import inventorymgmtsystem.model.Mainform;

public class IncomeMenuForm extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JPanel studentPNL;

	private JButton showInfoBTN;

	private JTable studentTBL;
	private JScrollPane scrollPane;

	private ButtonGroup btnGroup;
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
	private JComboBox comboBoxLBL;
	private JMenu mnNewMenu;
	//private JLabel lblDate;
	//private JTextField dateTXT;
	private JMenuItem mntmIncomeMenuLBL;
	private JMenuItem mntmExitLBL;
	private JComboBox comboBox;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				IncomeMenuForm frame;
				try {
					frame = new IncomeMenuForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public IncomeMenuForm() throws Exception {
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
			studentPNL.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Entry form",
					TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
			studentPNL.setBounds(10, 22, 533, 145);
			studentPNL.setLayout(null);
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
			//studentPNL.add(getLblTotalPrice());
			//studentPNL.add(getTotalpriceTXT());
			studentPNL.add(getBtnSaveDetails());
			studentPNL.add(getComboBoxLBL());
			studentPNL.add(getComboBox());
			//studentPNL.add(getLblDate());
			//studentPNL.add(getDateTXT());

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
						// saveDatatoDB();
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
		IncomeMenuFormDao dao = new IncomeMenuFormDaoImpl();
		List<Incomemenuform> mainformList = dao.showAllValues();
		// System.out.println(mainformList);
		// System.out.println();

		// for (Mainform cs : mainformList) {

		// System.out.println(cs.getUnit());
		// System.out.println(cs.getIssuedto());

		// }

		for (Incomemenuform cs : mainformList) {
			Object[] row = new Object[] { cs.getDate(),cs.getQty(), cs.getUnit(), cs.getProdcode(),cs.getDescriptions()

					,cs.getLot(), cs.getUnitprice() };

			model.addRow(row);

			// System.out.println(cs.getDate());

		}
		/**/
	}

	private JTable getStudentTBL() {
		if (studentTBL == null) {
			studentTBL = new JTable();
			studentTBL.setModel(new DefaultTableModel(
					new Object[][] { { null, null, null, null, null, null, null },
							{ null, null, null, null, null, null, null } },
					new String[] { "Date","Quantity" ,"Unit", "Product code", "Description","Lot#",
							"Unit price" }));
		//	studentTBL.getColumnModel().getColumn(0).setPreferredWidth(100);
			//studentTBL.getColumnModel().getColumn(1).setPreferredWidth(25);

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

	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel(" Quantity");
			lblQuantity.setBounds(66, 25, 78, 14);
		}
		return lblQuantity;
	}

	private JTextField getQtyTXT() {
		if (qtyTXT == null) {
			qtyTXT = new JTextField();
			qtyTXT.setColumns(10);
			qtyTXT.setBounds(129, 22, 46, 20);
		}
		return qtyTXT;
	}

	private JLabel getLblUnit() {
		if (lblUnit == null) {
			lblUnit = new JLabel("Unit");
			lblUnit.setBounds(214, 25, 46, 14);
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
/*
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
*/
	private void saveDatatoDB() {

		Incomemenuform mf = new Incomemenuform();
		

		Date dt = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String fDate=fmt.format(dt);
      //System.out.println(fDate);
	     mf.setDate(fDate);
		
		//mf.setDate(dateTXT.getText().trim());
		mf.setQty(qtyTXT.getText());
		//comboBox
		mf.setUnit(String.valueOf(comboBox.getSelectedItem()));
		mf.setProdcode(productcodeTXT.getText());
		mf.setDescriptions(descriptionsTXT.getText());

		mf.setLot(lotTXT.getText());
		//String x = String.valueOf(comboBoxLBL.getSelectedItem());
		mf.setIssuedto(String.valueOf(comboBoxLBL.getSelectedItem()));
          
		// mf.setIssuedto(issuedtoTXT.getText());
		//mf.setUnitprice(unitpriceTXT.getText());
		mf.setUnitprice(Long.parseLong(unitpriceTXT.getText()));
		//Integer.parseInt(unitpriceTXT.getText())
		//Integer.parseInt(textField.getText())

		// Save to DB
		try {
			IncomeMenuFormDao dao = new IncomeMenuFormDaoImpl();
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
		//dateTXT.setText("");
		qtyTXT.setText("");
		//unitTXT.setText("");
		productcodeTXT.setText("");
		lotTXT.setText("");
		descriptionsTXT.setText("");
		// issuedtoTXT.setText("");
		unitpriceTXT.setText("");
	//	totalpriceTXT.setText("");

	}

	private JMenuBar getMenuBar_1() throws Exception {
		if (menuBar_1 == null) {
			menuBar_1 = new JMenuBar();
			menuBar_1.setBounds(10, 0, 553, 21);
			menuBar_1.add(getMnNewMenu());
		}
		return menuBar_1;
	}

	private JComboBox getComboBoxLBL() {
		if (comboBoxLBL == null) {
			comboBoxLBL = new JComboBox();
			comboBoxLBL.setToolTipText("");
			comboBoxLBL.setModel(new DefaultComboBoxModel(new String[] { "Customer", "Consumer" }));
			comboBoxLBL.setBounds(371, 60, 68, 20);
			
			comboBoxLBL.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					

					// 4.show all Records
					try {
						//saveDatatoDB();
						System.out.println("customer and consumer");
						
						allocPriceCustCons();
						//MainForm mf= new MainForm();
						//mf.setVisible(true);
						//showAllValue();
					} catch (Exception e1) {
						e1.printStackTrace();
					}


				}
			});
		}
		return comboBoxLBL;
	}

	private void allocPriceCustCons(){
		Incomemenuform mf = new Incomemenuform();
		
	//	mf.setDate(dateTXT.getText().trim());
		mf.setQty(qtyTXT.getText());

		mf.setUnit(String.valueOf(comboBoxLBL.getSelectedItem()));
		mf.setProdcode(productcodeTXT.getText());
		mf.setDescriptions(descriptionsTXT.getText());

		mf.setLot(lotTXT.getText());
		//String x = String.valueOf(comboBoxLBL.getSelectedItem());
		mf.setIssuedto(String.valueOf(comboBoxLBL.getSelectedItem()));

		try {
			IncomeMenuFormDao dao = new IncomeMenuFormDaoImpl();
			dao.allocatePrice(mf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Income Entry Menu Details");
			mnNewMenu.add(getMntmIncomeMenuLBL());
			mnNewMenu.add(getMntmExitLBL());
			
			
		}
		return mnNewMenu;
	}
/*
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date");
			lblDate.setBounds(21, 28, 78, 14);
		}
		return lblDate;
	}

	private JTextField getDateTXT() {
		if (dateTXT == null) {
			dateTXT = new JTextField();
			dateTXT.setColumns(10);
			dateTXT.setBounds(53, 22, 78, 20);
		}
		return dateTXT;
	}
	*/
	private JMenuItem getMntmIncomeMenuLBL() {
		if (mntmIncomeMenuLBL == null) {
			mntmIncomeMenuLBL = new JMenuItem("Income Details");
			
			mntmIncomeMenuLBL.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					

					// 4.show all Records
					try {
						//saveDatatoDB();
						IncomeForm ef= new IncomeForm();
						ef.setVisible(true);
						//showAllValue();
						//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						//System.exit(0);


					} catch (Exception e1) {
						e1.printStackTrace();
					}


				}
			});
			
			
		}
		return mntmIncomeMenuLBL;
	}
	private JMenuItem getMntmExitLBL() {
		if (mntmExitLBL == null) {
			mntmExitLBL = new JMenuItem("Exit");
			
			mntmExitLBL.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					

					// 4.show all Records
					try {
						setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						//System.exit(0);


					} catch (Exception e1) {
						e1.printStackTrace();
					}


				}
			});
			
		}
		return mntmExitLBL;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kg", "gm", "packet"}));
			comboBox.setBounds(245, 22, 78, 20);
		}
		return comboBox;
	}
}
