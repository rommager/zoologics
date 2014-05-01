package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Task;
import edu.radford.itec370.mainmethod.zoologics.Vaccination;

@SuppressWarnings("serial")
public class TaskFrame extends DataManagerFrame<Task> {

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
	
	public TaskFrame(Vaccination task) {
		this();
		VaccinationPanel vPanel = new VaccinationPanel(task);
		super.dataPanel = vPanel;
		getContentPane().add(vPanel,BorderLayout.CENTER);
		
	}
	
	// tester method
	public static void main(String[] args) {
		ArrayList<Task> tasks = new ArrayList<Task>();
		TaskFrame frame = new TaskFrame(tasks);
		frame.setVisible(true);
	}

	@Override
	public void updateGUIElements() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Task getNewInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setComponentColorForPrinting(Color color) {
		// TODO Auto-generated method stub
		
	}
}

