package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class TaskFrame extends DataManagerFrame<Task> {

	private static final long serialVersionUID = 6640903267745319370L;
	private static final String WINDOW_TITLE = Application.getAppName() + "Task";
	
	protected int index;
	protected boolean dirty;
	protected boolean updating;
	
	private TaskFrame () {
		super();
		setIconImage(Application.getAppImage());
		setTitle(WINDOW_TITLE);
		setBounds(100, 100, 580, 283);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		navPanel.setNewButtonVisible(false);  // no new button
		navPanel.setSearchBoxVisible(false);  // no filter box
	}

	public TaskFrame(ArrayList<Task> tasks) {
		this();
		setArrayList(tasks);
		
	}

	@Override
	public boolean save() {
		// TODO write save method and return a boolean whether save was successful
		return false;
	}

	@Override
	public void updateGUIElements() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task getNewInstance() {
		// This window does not implement a new button
		return new Task();
	}

	@Override
	protected void setComponentColorForPrinting(Color color) {
		// Do nothing because there are no weird components on this form
	}

	// tester method
	public static void main(String[] args) {
		ArrayList<Task> tasks = new ArrayList<Task>();
		TaskFrame frame = new TaskFrame(tasks);
		frame.setVisible(true);
	}
}

