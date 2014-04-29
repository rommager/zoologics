package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Task;

public class TaskFrame extends JFrame implements Navigable, WindowListener, DocumentListener, ActionListener {

	private static final long serialVersionUID = 6640903267745319370L;

	protected ArrayList<Task> tasks;
	protected int index;
	protected boolean dirty;
	protected boolean updating;

	protected NavigatorBar naviBar;
	
	private TaskFrame () {
		super();
		setIconImage(Application.getAppImage());
		setTitle("Task");
		setBounds(100, 100, 580, 283);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		naviBar = new NavigatorBar(this);
		naviBar.setNewButtonVisible(false);
		naviBar.setSearchBoxVisible(false);
		getContentPane().add(naviBar, BorderLayout.SOUTH);
		this.addWindowListener(this);

	}

	public TaskFrame(ArrayList<Task> tasks) {
		this();
		this.tasks = tasks;
	}

	public void closeWindow() {
		dispose();
	}
	
	public void updateGUI() {
		
	}
	
	public void save() {
		
	}
	
	public void setDirty(boolean dirty) {
		
	}
	
	public boolean validated() {
		return false;
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
		if (index < tasks.size() - 1) {
			if (validated()) {
				index++;
				updateGUI();
			}
		}
	}
	@Override
	public void lastRecord() {
		if (index != tasks.size() - 1) {
			if (validated()) {
				index = tasks.size() - 1;
				updateGUI();
			}
		}
	}
	@Override
	public void newRecord() {}
	@Override
	public void applyFilter(String filter) {}
	@Override
	public void updateRecordCount() {
		naviBar.updateRecordCount(index + 1, tasks.size());
	}

	// DocumentListener implementation (sets dirty for text boxes)
	@Override public void changedUpdate(DocumentEvent e) {setDirty(true);}
	@Override public void insertUpdate(DocumentEvent e) {setDirty(true);}
	@Override public void removeUpdate(DocumentEvent e) {setDirty(true);}

	// ActionListener implementation (sets dirty for radio buttons)
	@Override public void actionPerformed(ActionEvent arg0) {setDirty(true);}

	@Override public void windowClosing(WindowEvent e) {closeWindow();}
	@Override public void windowActivated(WindowEvent e) {}
	@Override public void windowClosed(WindowEvent e) {}
	@Override public void windowDeactivated(WindowEvent e) {}
	@Override public void windowDeiconified(WindowEvent e) {}
	@Override public void windowIconified(WindowEvent e) {}
	@Override public void windowOpened(WindowEvent e) {}

	// tester method
	public static void main(String[] args) {
		ArrayList<Task> tasks = new ArrayList<Task>();
		TaskFrame frame = new TaskFrame(tasks);
		frame.setVisible(true);
	}
}

