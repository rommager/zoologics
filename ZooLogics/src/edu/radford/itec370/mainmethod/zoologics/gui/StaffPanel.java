package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Staff;
import edu.radford.itec370.mainmethod.zoologics.StaffHive;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffPanel extends JDialog implements ActionListener {

	private static final long serialVersionUID = 3185446536402535910L;
	private static final String[] COLUMN_NAMES = {"ID","Last Name","First Name","Position","Username"};
	
	private StaffHive staffHive;
	
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	
	private StaffPanel() {
		super();
		setTitle(Application.getAppName() + " Staff Maintenance");
		setIconImage(Application.getAppImage());		
		getContentPane().setLayout(new BorderLayout());
		
		//JPanel panel = new JPanel(new GridLayout(1,1));
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table = new JTable(model);
		table.setRowSelectionAllowed(false);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(1,1,100,100);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton newButton = new JButton("Add New Staff");
		newButton.addActionListener(this);
		buttonPanel.add(newButton);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		buttonPanel.add(saveButton);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(this);
		buttonPanel.add(closeButton);
		
		getContentPane().add(buttonPanel,BorderLayout.SOUTH);
		
		//panel.add(scrollPane);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		pack();
	}
	
	public StaffPanel(StaffHive staffHive) {
		this();
		this.setStaffHive(staffHive);
		load();
	}
	
	public static void main(String args[]) {
		StaffPanel admin = new StaffPanel();
		admin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		admin.setSize(500, 200);
		admin.setVisible(true);		
	}

	public StaffHive getStaffHive() {
		return staffHive;
	}

	public void setStaffHive(StaffHive staffHive) {
		this.staffHive = staffHive;
	}
	
	private void load() {
		for (Staff staff : staffHive) {
			model.addRow(staff.getRow());
		}
	}
	
	public void save() {
		
	}
	
	public void close() {
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Add New Staff")) {
			Staff newStaff = new Staff();
			model.addRow(newStaff.getRow());
		}
		else if (command.equals("Save")) {
			save();
		}
		else if (command.equals("Close")) {
			close();
		}
		
	}


}
