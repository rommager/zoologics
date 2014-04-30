package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.ComponentPrinter;

public abstract class DataManagerFrame<T extends Filterable> extends JFrame implements Navigable, WindowListener  {

	private static final long serialVersionUID = 2450406106011886854L;
	protected String windowTitle;
	protected ArrayList<T> fullArrayList;
	protected ArrayList<T> filteredArrayList;
	protected int index;
	protected boolean dirty;
	protected boolean updating;

	protected NavigatorBar navPanel;
	protected JPanel dataPanel;
	protected JButton saveButton;
	
	protected DirtyDataListener dirtyListener;

	public DataManagerFrame() {
		super();
		index = 0;
		dirtyListener = new DirtyDataListener();
		
		// set up frame
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  // The WindowListener takes care of closing the window!
		addWindowListener(this);

		// add navigator bar in south window area
		navPanel = new NavigatorBar(this);
		getContentPane().add(navPanel, BorderLayout.SOUTH);

	}

	public abstract void updateGUIElements();
	public abstract boolean save();
	public abstract T getNewInstance();
	protected abstract void setComponentColorForPrinting(Color color);

	public void updateGUI() {
		updating = true;

		if (filteredArrayList.size() == 0)
			dataPanel.setVisible(false);
		else
			dataPanel.setVisible(true);

		if (dataPanel.isVisible()) {
			updateGUIElements();	
		}
		updateRecordCount();
		saveButton.setEnabled(false);
		setDirty(false);
		updating = false;
	}

	protected void setDirty(boolean dirty) {
		// if updating (refreshing GUI) then override dirty - it should always be false when updating!
		if (windowTitle == null)
			windowTitle = getTitle();
		if (updating)
			dirty = false;
		if (this.dirty != dirty) {
			this.dirty = dirty;
			saveButton.setEnabled(dirty);
			if (dirty)
				this.setTitle(" * " + windowTitle);
			else
				this.setTitle(windowTitle);

		}
	}

	public boolean validated() {
		if (dirty) {
			int n = JOptionPane.showConfirmDialog(
					this, 
					"This record has been changed.  Would you like to save?",
					"Record Changed",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (n == JOptionPane.YES_OPTION)
				return save();
			else if (n == JOptionPane.NO_OPTION)
				return true;
			else
				return false;
		}
		else
			return true;
	}

	public void closeWindow() {
		if (dirty) {
			if (validated()) 
				this.dispose();		
		}
		else
			this.dispose();
	}
	
	// print methods
	public void print() {
		Color color = dataPanel.getBackground();
		setComponentColorForPrinting(Color.WHITE);
		dataPanel.setBackground(Color.WHITE);
		ComponentPrinter.runPrintJob(dataPanel);
		dataPanel.setBackground(color);
		setComponentColorForPrinting(color);
	}
	
	// setters and getters
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		if (this.index != index) {
			this.index = index;
			updateGUI();
		}
	}
	
	public T getItem() {
		return filteredArrayList.get(index);
	}

	public void setItem(T item) {
		index = filteredArrayList.indexOf(item);
		updateGUI();
	}
	
	public ArrayList<T> getArrayList() {
		return filteredArrayList;
	}

	public void setArrayList(ArrayList<T> arrayList) {
		this.fullArrayList = arrayList;
		this.filteredArrayList = arrayList;
		index = 0;
	}

	// Navigable implementation
	@Override
	public void firstRecord() {
		if (index != 0) {
			if (validated()) {
				index = 0;
				updateGUI();
			}
		}
	}
	@Override
	public void previousRecord() {
		if (index > 0) {
			if (validated()) {
				index--;
				updateGUI();
			}
		}
	}
	@Override
	public void nextRecord() {
		if (index < filteredArrayList.size() - 1) {
			if (validated()) {
				index++;
				updateGUI();
			}
		}
	}
	@Override
	public void lastRecord() {
		if (index != filteredArrayList.size() - 1) {
			if (validated()) {
				index = filteredArrayList.size() - 1;
				updateGUI();
			}
		}
	}
	@Override
	public void newRecord() {
		if (validated()) {
			T newItem = getNewInstance();
			filteredArrayList.add(newItem);
			index = filteredArrayList.indexOf(newItem);
			updateGUI();
		}
	}
	@Override
	public void applyFilter(String filter) {
		if (validated()) {
			if (filter == null) {
				if (filteredArrayList != fullArrayList) {
					if (filteredArrayList.size() != 0)
						index = fullArrayList.indexOf(filteredArrayList.get(index));
					else
						index = 0;
					filteredArrayList = fullArrayList;
					updateGUI();
				}
			}
			else {
				index = 0;
				filteredArrayList = new ArrayList<T>();
				for (T item : fullArrayList) {
					if (item.isVisibleWithFilter(filter))
						filteredArrayList.add(item);
				}
				updateGUI();
			}
		}
	}
	@Override
	public void updateRecordCount() {
		navPanel.updateRecordCount(index + 1, filteredArrayList.size());
	}
	
	// WindowListener implementation (calls closeWindow() method when red X is clicked
	@Override public void windowClosing(WindowEvent e) {closeWindow();}
	@Override public void windowActivated(WindowEvent e) {}
	@Override public void windowClosed(WindowEvent e) {}
	@Override public void windowDeactivated(WindowEvent e) {}
	@Override public void windowDeiconified(WindowEvent e) {}
	@Override public void windowIconified(WindowEvent e) {}
	@Override public void windowOpened(WindowEvent e) {}

	protected class DirtyDataListener implements DocumentListener, ActionListener {
		// DocumentListener implementation (sets dirty for text boxes)
		@Override public void changedUpdate(DocumentEvent e) {setDirty(true);}
		@Override public void insertUpdate(DocumentEvent e) {setDirty(true);}
		@Override public void removeUpdate(DocumentEvent e) {setDirty(true);}

		// ActionListener implementation (sets dirty for radio buttons)
		@Override public void actionPerformed(ActionEvent arg0) {setDirty(true);}
	}
}
