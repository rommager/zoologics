package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.GridLayout;


import javax.swing.JCheckBox;


import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



import edu.radford.itec370.mainmethod.zoologics.Staff;

public class AdminPanel extends JDialog {
	Staff staff;
	JTabbedPane tabbedPane;
	JLabel label;
	JTextField textfield;
	JPasswordField txtpassword;
	JPanel panel1;
	JPanel panel2;
	JButton button;
	JTextField txtUserID;
	JTextField txtUserName;
	JButton Submit;
	JCheckBox User;
	
	
	
	public static void main(String args[]) {
		AdminPanel admin = new AdminPanel();
		admin.setDefaultCloseOperation(HIDE_ON_CLOSE);
		admin.setSize(350, 200);
		admin.setVisible(true);
	}
	
	public AdminPanel() {

		tabbedPane = new JTabbedPane();
		this.addUser();
		getContentPane().add(tabbedPane);
		
	}

	void addUser() {
		
		JLabel lblUserID = new JLabel("User ID", SwingConstants.CENTER);
		txtUserID = new JTextField();

		JLabel lblUserName = new JLabel("User Name", SwingConstants.CENTER);
		txtUserName = new JTextField();

		JLabel lblPassword = new JLabel("Password", SwingConstants.CENTER);
		txtpassword = new JPasswordField();

		JButton btnSubmit = new JButton("Submit");
		
		 boolean User = true;

		/**
		 Are you a user?
		 */
		final Checkbox User1;

		/* ... */

		User1 = new Checkbox("user");

		User1.addItemListener ( new ItemListener()
		   {

		   public void itemStateChanged( ItemEvent e )
		      {
		       boolean User;
			User = User1.getState(); 
			 
		      /* ... */
		      }
		   });
		/* ... */
		




		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4, 2, 2, 2));

		panel1.add(lblUserID);
		panel1.add(txtUserID);
		panel1.add(lblUserName);
		panel1.add(txtUserName);
		panel1.add(lblPassword);
		panel1.add(txtpassword);
		panel1.add(btnSubmit);
		panel1.add(User1);

		tabbedPane.addTab("Add User", null, panel1, "First Panel");

	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
		this.txtpassword.setText("");
	}

}
