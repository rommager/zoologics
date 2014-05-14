package edu.radford.itec370.mainmethod.zoologics.gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import edu.radford.itec370.mainmethod.zoologics.Tableable;

@SuppressWarnings("serial")
public class ArrayListTableModel<T extends Tableable> extends AbstractTableModel {
	private String[] columnNames; 
	private ArrayList<T> rowData;
	private int rowConfig;

	public ArrayListTableModel() {
		super();
	}

	public ArrayListTableModel(ArrayList<T> rowData) {
		super();
		this.rowData = rowData;
	}
	
	public ArrayListTableModel(ArrayList<T> rowData, int rowConfig) {
		super();
		this.rowData = rowData;
		this.rowConfig = rowConfig;
	}
	
	public ArrayListTableModel(String[] columnNames) {
		super();
		this.columnNames = columnNames;
	}
	
	public ArrayListTableModel(String[] columnNames, int rowConfig) {
		super();
		this.columnNames = columnNames;
		this.rowConfig = rowConfig;
	}
	
	public ArrayListTableModel(String[] columnNames, ArrayList<T> rowData) {
		super();
		this.columnNames = columnNames;
		this.rowData = rowData;
	}
	
	public ArrayListTableModel(String[] columnNames, ArrayList<T> rowData, int rowConfig) {
		super();
		this.columnNames = columnNames;
		this.rowData = rowData;
		this.rowConfig = rowConfig;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public int getRowCount() { return rowData.size(); }

	public int getColumnCount() { return columnNames.length; }

	public Object getValueAt(int row, int col) {
		T item = rowData.get(row);
		return item.getValue(col, rowConfig);
	}

	public void addRow(T item) {
		rowData.add(item);
		int newRow = rowData.indexOf(item);
		this.fireTableRowsInserted(newRow,  newRow);
	}

	public boolean isCellEditable(int row, int col) {
		T item = rowData.get(row);
		return item.isFieldEditable(col);
	}

	public void setValueAt(Object value, int row, int col) {
		T item = rowData.get(row);
		item.setValue(value, col, rowConfig);
		fireTableCellUpdated(row, col);
	}
	public ArrayList<T> getRowData() {
		return rowData;
	}
	public void setRowData(ArrayList<T> rowData) {
		this.rowData = rowData;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public int getRowConfig() {
		return rowConfig;
	}

	public void setRowConfig(int rowConfig) {
		this.rowConfig = rowConfig;
	}
}
