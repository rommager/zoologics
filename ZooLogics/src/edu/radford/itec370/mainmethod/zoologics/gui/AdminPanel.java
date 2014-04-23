package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;









import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;










import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Staff;
import edu.radford.itec370.mainmethod.zoologics.StaffHive;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3185446536402535910L;
	private static final String[] COLUMN_NAMES = {"ID","Last Name","First Name","Position","Username"};
	
	private static int nextStaffID = 1001;
	
	private StaffHive staffHive;
	
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	
	public static void main(String args[]) {
		AdminPanel admin = new AdminPanel();
		admin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		admin.setSize(350, 200);
		admin.setVisible(true);
		
		AdminPanel admin2 = new AdminPanel();
		admin2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		admin2.setSize(350, 200);
		admin2.setVisible(true);
	}
	
	public AdminPanel() {
		setTitle(Application.getAppName() + " Staff Maintenance");
		setIconImage(Application.getAppIcon());		
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel(new GridLayout(1,1));
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(1,1,100,100);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton newButton = new JButton("Add New Staff");
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.addRow(new String[] {Integer.toString(nextStaffID), null, null, null, null});
				nextStaffID++;
			}
		});
		JButton saveButton = new JButton("Save");
		JButton closeButton = new JButton("Close");
		buttonPanel.add(newButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(closeButton);
		getContentPane().add(buttonPanel,BorderLayout.SOUTH);
		
		panel.add(scrollPane);
		getContentPane().add(panel, BorderLayout.CENTER);
//		pack();

		
	}


}
