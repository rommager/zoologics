package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.radford.itec370.mainmethod.zoologics.RecurrenceSchedule;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecurrenceSchedulePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -8360408723630767538L;
	private static final String[] HEADER_ROW = {"Every", "Interval", "How many times"};
	
	private RecurrenceSchedule schedule;
	
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnMoveUp;
	private JButton btnMoveDown;
	private JButton btnAdd;
	private JButton btnSave;

	private JComboBox<String> cboInterval;

	public RecurrenceSchedulePanel() {
		super();
		setLayout(new BorderLayout());
		JPanel centerPanel = new JPanel();
		model = new DefaultTableModel(null, HEADER_ROW);
		cboInterval = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"Day(s)","Week(s)","Month(s)","Year(s)"}));

		table = new JTable(model);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(cboInterval));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("valueChanged" + e.getValueIsAdjusting() + e.getFirstIndex()+ e.getLastIndex());
			}
		});
		table.setCellSelectionEnabled(true);
		scrollPane = new JScrollPane(table);
		centerPanel.add(scrollPane);
		add(centerPanel,BorderLayout.CENTER);

		JPanel southPanel = new JPanel(new FlowLayout());
		btnMoveUp = new JButton("Move Up");
		btnMoveUp.addActionListener(this);
		southPanel.add(btnMoveUp);
		btnMoveDown = new JButton("Move Down");
		btnMoveDown.addActionListener(this);
		southPanel.add(btnMoveDown);
		btnAdd = new JButton("Add New");
		btnAdd.addActionListener(this);
		southPanel.add(btnAdd);
		btnSave = new JButton("Save");
		btnSave.addActionListener(this);
		southPanel.add(btnSave);
		add(southPanel,BorderLayout.SOUTH);
	}

	public RecurrenceSchedulePanel(RecurrenceSchedule schedule) {
		this();
		this.schedule = schedule;
	}
	
	public void save() {
		schedule = new RecurrenceSchedule();
		
		int nRow = model.getRowCount();
//		int nCol = model.getColumnCount();
		for (int i = 0; i < nRow; i++) {
			
		}
	}

	public static void main(String[] args) {
		GUITester.launchTestFrame(new RecurrenceSchedulePanel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		if (command.equalsIgnoreCase("Add New")) {
			model.addRow(new String[] {null,null,"forever","8001"});
		}
		if (command.equalsIgnoreCase("Save")) {
			save();
		}
		if (command.equalsIgnoreCase("Move Up")) {
			int index = table.getSelectedRow();
			if (index > 0) {				
				model.moveRow(index, index, index - 1);
				table.setRowSelectionInterval(index - 1, index - 1);
			}
		}
		if (command.equalsIgnoreCase("Move Down")) {
			int index = table.getSelectedRow();
			if (index < table.getRowCount() - 1) {				
				model.moveRow(index, index, index + 1);
				table.setRowSelectionInterval(index + 1, index + 1);
			}
		}


	}

	public RecurrenceSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(RecurrenceSchedule schedule) {
		this.schedule = schedule;
	}

}
