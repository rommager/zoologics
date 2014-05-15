package edu.radford.itec370.mainmethod.zoologics.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public abstract class ArrayListTableModel<T> extends AbstractTableModel {
	protected String[] columnNames; 
	protected ArrayList<T> rowData;

	protected abstract Object getValue(T item, int field);
	protected abstract void setValue(T item, Object value, int field);
	protected abstract boolean isFieldEditable(T item, int field);
	
	// constructors
	public ArrayListTableModel() {
		super();
	}

	public ArrayListTableModel(ArrayList<T> rowData) {
		super();
		this.rowData = rowData;
	}
	
	public ArrayListTableModel(String[] columnNames) {
		super();
		this.columnNames = columnNames;
	}
	
	public ArrayListTableModel(String[] columnNames, ArrayList<T> rowData) {
		super();
		this.columnNames = columnNames;
		this.rowData = rowData;
	}
	
	public void addRow(T item) {
		rowData.add(item);
		int newRow = rowData.indexOf(item);
		this.fireTableRowsInserted(newRow,  newRow);
	}
	
	@Override
	public String getColumnName(int col) { return columnNames[col]; }

	@Override
	public int getRowCount() { return rowData.size(); }

	@Override
	public int getColumnCount() { return columnNames.length; }

	@Override
	public Object getValueAt(int row, int col) { return getValue(rowData.get(row), col); }

	@Override
	public boolean isCellEditable(int row, int col) { return isFieldEditable(rowData.get(row), col); }

	@Override
	public void setValueAt(Object value, int row, int col) {
		setValue(rowData.get(row), value, col);
		fireTableCellUpdated(row, col);
	}
	
	// setters and getters
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
}
