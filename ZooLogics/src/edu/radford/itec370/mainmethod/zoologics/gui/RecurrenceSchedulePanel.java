package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RecurrenceSchedulePanel extends JPanel {
	
	private static final long serialVersionUID = -8360408723630767538L;
	
	private final String[] HEADER_ROW = {"How frequently", "How many times", "From date"};
	
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;

	public RecurrenceSchedulePanel() {
		super();
		setLayout(new BorderLayout());
		JPanel upperPanel = new JPanel(new GridLayout(1,1));
		model = new DefaultTableModel(null,HEADER_ROW);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		upperPanel.add(scrollPane);
		add(upperPanel,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		GUITester.launchTestFrame(new RecurrenceSchedulePanel());
	}

}
