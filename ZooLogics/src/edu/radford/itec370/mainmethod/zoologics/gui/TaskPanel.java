package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.util.ArrayList;

import edu.radford.itec370.mainmethod.zoologics.*;

import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TaskPanel extends JDialog implements Navigable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1052426461587559703L;
	protected ArrayList<Task> tasks;
	protected int currentIndex;
	
	protected JPanel taskPanel;
	protected JTextField txtTaskName;
	protected JTextField txtDueDate;
	protected JTextField txtNotes;
	protected JTextField txtCompletedBy;
	protected JTextField txtCompletedDate;

	protected JLabel lblTaskName;
	protected JLabel lblDueDate;
	protected JLabel lblCompletedBy;
	protected JLabel lblCompletionDate;
	protected JLabel lblNotes;

	protected JButton btnDismiss;
	protected JButton btnCancel;
	protected JButton btnCompleteTask;
	
	public TaskPanel() {
		this(new ArrayList<Task>());
	}
	
	public TaskPanel(ArrayList<Task> tasks) {
		super();
		this.tasks = tasks;
		currentIndex = 0;
		
		setIconImage(Application.getAppIcon());
		setTitle("Task");
		setBounds(100, 100, 481, 341);
		
		taskPanel = new JPanel();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(taskPanel, BorderLayout.CENTER);
		
		NavigatorBar naviBar = new NavigatorBar(this);
		getContentPane().add(naviBar, BorderLayout.SOUTH);
		
		taskPanel.setLayout(null);

		lblTaskName = new JLabel("Name");
		lblTaskName.setBounds(10, 11, 39, 22);
		taskPanel.add(lblTaskName);

		txtTaskName = new JTextField();
		txtTaskName.setBounds(90, 12, 120, 20);
		taskPanel.add(txtTaskName);
		txtTaskName.setColumns(10);

		lblDueDate = new JLabel("Due Date");
		lblDueDate.setBounds(236, 15, 73, 14);
		taskPanel.add(lblDueDate);

		txtDueDate = new JTextField();
		txtDueDate.setBounds(342, 12, 106, 20);
		taskPanel.add(txtDueDate);
		txtDueDate.setColumns(10);

		btnCompleteTask = new JButton("Complete Task");
		btnCompleteTask.setBounds(100, 245, 120, 23);
		taskPanel.add(btnCompleteTask);

		btnDismiss = new JButton("Dismiss");
		btnDismiss.setBounds(245, 245, 89, 23);
		taskPanel.add(btnDismiss);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(359, 245, 89, 23);
		taskPanel.add(btnCancel);

		lblNotes = new JLabel("Notes");
		lblNotes.setBounds(10, 44, 89, 14);
		taskPanel.add(lblNotes);

		txtNotes = new JTextField();
		txtNotes.setBounds(10, 69, 438, 101);
		taskPanel.add(txtNotes);
		txtNotes.setColumns(10);

		txtCompletedBy = new JTextField();
		txtCompletedBy.setColumns(10);
		txtCompletedBy.setBounds(90, 194, 120, 20);
		taskPanel.add(txtCompletedBy);

		lblCompletedBy = new JLabel("Completed by");
		lblCompletedBy.setBounds(10, 193, 70, 22);
		taskPanel.add(lblCompletedBy);

		lblCompletionDate = new JLabel("Completion Date");
		lblCompletionDate.setBounds(236, 197, 96, 14);
		taskPanel.add(lblCompletionDate);

		txtCompletedDate = new JTextField();
		txtCompletedDate.setColumns(10);
		txtCompletedDate.setBounds(342, 194, 106, 20);
		taskPanel.add(txtCompletedDate);
	}

	public static void main(String[] args) {
		TaskPanel taskPanel = new TaskPanel();
		taskPanel.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		Task newTask;
		newTask = new Task("Reminder to clean toilets", "11/17/2011", null);
		taskPanel.add(newTask);
		taskPanel.updateGUI();
		taskPanel.setVisible(true);
	}
	
	public void add(Task newTask) {
		tasks.add(newTask);
	}
	
	public Task getCurrentTask() {
		Task task = null;
		try {
			task = tasks.get(currentIndex);
		}
		catch(IndexOutOfBoundsException e) {
			// do nothing
		}
		return task;
	}

	
	public void updateGUI() {
		Task task = getCurrentTask();
		if (task != null) {
			this.txtTaskName.setText(task.getTaskName());
			if (task.getCompletedBy() != null)
				this.txtCompletedBy.setText(task.getCompletedBy().getDisplayName());
			if (task.getDueDate() != null)
				this.txtDueDate.setText(Application.formatDateToString(task.getDueDate()));
			if (task.getCompletedDate() != null)
				this.txtCompletedDate.setText(Application.formatDateToString(task.getCompletedDate()));
			this.txtNotes.setText(task.getNotes());
		}
		
	}
	
	public void save() {
		Task task = getCurrentTask();
		if (task != null) {
			task.setTaskName(this.txtTaskName.getText());
//			task.setStaff(this.txtCompletedBy.getText());
			task.setDueDate(Application.parseDate(this.txtDueDate.getText()));
			task.setCompletedDate(Application.parseDate(this.txtCompletedBy.getText()));
			task.setNotes(this.txtNotes.getText());
		}
	}

	@Override
	public void firstRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previousRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nextRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lastRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyFilter(String filter) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

}
