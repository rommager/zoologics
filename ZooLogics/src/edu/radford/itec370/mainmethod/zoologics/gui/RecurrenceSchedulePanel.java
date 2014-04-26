package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class RecurrenceSchedulePanel extends JPanel {
	
	private static final long serialVersionUID = -8360408723630767538L;
	
	private final String[] HEADER_ROW = {"Every", "Count", "Interval", "How many times"};
	
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	
	private JTextField txtCount;
	private JComboBox<String> cboInterval;
	private JComboBox<String> cboFrom;
	private JButton btnEdit;
	private JButton btnSave;

	public RecurrenceSchedulePanel() {
		super();
		setLayout(new BorderLayout());
		JPanel centerPanel = new JPanel();
		model = new DefaultTableModel(new String[][] {{"a","b","c"}}, HEADER_ROW);
		cboInterval = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"Day","Week","Month","Year"}));
		table = new JTable(model);
		//table.getColumnModel().getColumn(0).getCellEditor().cancelCellEditing();
		table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(cboInterval));
		scrollPane = new JScrollPane(table);
		centerPanel.add(scrollPane);
		add(centerPanel,BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel(new FlowLayout());
		btnEdit = new JButton("Edit");
		southPanel.add(btnEdit);
		btnSave = new JButton("Save");
		southPanel.add(btnSave);

		
		
		southPanel.add(new JLabel("Every"));
		txtCount = new JTextField();
		southPanel.add(txtCount);
		
		
		southPanel.add(cboInterval);
		add(southPanel,BorderLayout.SOUTH);
		System.out.println(cboInterval.getSize().height);
	}
	
	public static void main(String[] args) {
		GUITester.launchTestFrame(new RecurrenceSchedulePanel());
	}

}
