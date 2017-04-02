package inventorymgmtsystem.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inventorymgmtsystem.admin.dao.AdminDao;
import inventorymgmtsystem.admin.dao.AdminDaoImpl;
import inventorymgmtsystem.admin.model.Admin;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class invmgmt extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel adminUsernameLBL;
	private JTextField adminUsernameTXT;
	private JLabel adminPasswordLBL;
	private JPasswordField adminPasswordTXT;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//JFrame f=new JFrame();
				   // f.setTitle("Inventory Management System");
					invmgmt frame = new invmgmt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public invmgmt() {
		setTitle("Inventory Management System");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//JFrame f=new JFrame();
	  //  f.setTitle("Inventory Management System");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getAdminUsernameLBL())
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(getAdminUsernameTXT(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getAdminPasswordLBL())
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(getBtnLogin())
								.addComponent(getAdminPasswordTXT()))))
					.addContainerGap(218, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(getAdminUsernameLBL())
						.addComponent(getAdminUsernameTXT(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(getAdminPasswordLBL())
						.addComponent(getAdminPasswordTXT(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(getBtnLogin())
					.addContainerGap(148, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private JPanel getPanel() {
		JFrame f=new JFrame();
		f.setTitle("Inventory Management System");
		if (panel == null) {
			panel = new JPanel();
		}
		return panel;
	}
	private JLabel getAdminUsernameLBL() {
		if (adminUsernameLBL == null) {
			adminUsernameLBL = new JLabel("Username");
		}
		return adminUsernameLBL;
	}
	private JTextField getAdminUsernameTXT() {
		if (adminUsernameTXT == null) {
			adminUsernameTXT = new JTextField();
			adminUsernameTXT.setColumns(10);
		}
		return adminUsernameTXT;
	}
	private JLabel getAdminPasswordLBL() {
		if (adminPasswordLBL == null) {
			adminPasswordLBL = new JLabel("Password");
		}
		return adminPasswordLBL;
	}
	private JPasswordField getAdminPasswordTXT() {
		if (adminPasswordTXT == null) {
			adminPasswordTXT = new JPasswordField();
		}
		return adminPasswordTXT;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			
btnLogin.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						
						// 1. Validation
						if (adminUsernameTXT.getText().trim().equals("")) {
							adminUsernameTXT.setBackground(Color.PINK);
							adminUsernameTXT.requestFocus();
							JOptionPane.showMessageDialog(contentPane, "Please Enter Username!");
							return;
						} else {
							adminUsernameTXT.setBackground(Color.WHITE);
						}

						if (adminPasswordTXT.getText().trim().equals("")) {
							adminPasswordTXT.setBackground(Color.PINK);
							adminPasswordTXT.requestFocus();
							JOptionPane.showMessageDialog(contentPane, "Please Enter Password!");
							return;
						} else {
							adminPasswordTXT.setBackground(Color.WHITE);
						}
						
						
						saveDatatoDB();
						
						//userLogin();
						//showAllValue();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					clearForm();
				}
			});
			
		}
		return btnLogin;
	}
	
	private void clearForm(){
		adminUsernameTXT.setText("");
		adminPasswordTXT.setText("");
		
		
	}
public void saveDatatoDB() throws Exception{
		
		Admin ad = new Admin();
		
		
		ad.setUsernameAdmin(adminUsernameTXT.getText());
		ad.setPasswordAdmin(adminPasswordTXT.getText());
		
		AdminDao dao = new AdminDaoImpl();
		dao.loginAdmin(ad);
	
	}
	
}
