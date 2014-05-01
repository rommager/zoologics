package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.ParseException;

import edu.radford.itec370.mainmethod.zoologics.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class TaskPanel extends JPanel {

	private static final long serialVersionUID = -1052426461587559703L;
	protected Task task;
	protected boolean editable;
	protected boolean dirty;
	protected boolean updating;
	
	protected JPanel detailPanel;
	protected JPanel buttonPanel;
	
	protected JTextField txtTaskName;
	protected JTextField txtDueDate;
	protected JTextPane txtNotes;
	protected JScrollPane scrollPane;
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

	protected TaskPanel() {
		super();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(580,250));
		setSize(getPreferredSize());
		detailPanel = new JPanel();
		detailPanel.setLayout(null);
		detailPanel.setPreferredSize(new Dimension(580, 250));
		
		lblTaskName = new JLabel("Task Name");
		lblTaskName.setBounds(10, 11, 122, 22);
		detailPanel.add(lblTaskName);

		txtTaskName = new JTextField();
		txtTaskName.setBounds(132, 11, 202, 20);
		detailPanel.add(txtTaskName);

		lblDueDate = new JLabel("Due Date");
		lblDueDate.setBounds(345, 11, 96, 22);
		detailPanel.add(lblDueDate);

		txtDueDate = new JTextField();
		txtDueDate.setBounds(451, 11, 119, 20);
		detailPanel.add(txtDueDate);

		lblNotes = new JLabel("Notes");
		lblNotes.setBounds(10, 77, 132, 22);
		detailPanel.add(lblNotes);

		txtNotes = new JTextPane();
		scrollPane = new JScrollPane(txtNotes);
		scrollPane.setBounds(10, 101, 560, 101);
		detailPanel.add(scrollPane);

		txtCompletedBy = new JTextField();
		txtCompletedBy.setBounds(132, 44, 203, 20);
		detailPanel.add(txtCompletedBy);

		lblCompletedBy = new JLabel("Completed by");
		lblCompletedBy.setBounds(10, 44, 122, 22);
		detailPanel.add(lblCompletedBy);

		lblCompletionDate = new JLabel("Completion Date");
		lblCompletionDate.setBounds(345, 44, 96, 22);
		detailPanel.add(lblCompletionDate);

		txtCompletedDate = new JTextField();
		txtCompletedDate.setBounds(451, 44, 119, 20);
		detailPanel.add(txtCompletedDate);

		buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnCompleteTask = new JButton("Complete Task");
		//btnCompleteTask.setBounds(211, 213, 120, 23);
		buttonPanel.add(btnCompleteTask);
		
		btnDismiss = new JButton("Dismiss");
		//btnDismiss.setBounds(356, 213, 89, 23);
		buttonPanel.add(btnDismiss);

		btnCancel = new JButton("Cancel");
		//btnCancel.setBounds(470, 213, 89, 23);
		buttonPanel.add(btnCancel);

		add(detailPanel,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);

	}

	public TaskPanel(Task task) {
		this();
		this.task = task;
		updateGUI();
	}

	public static void main(String[] args) {
		Task newTask = new Task("Reminder to clean toilets", "11/17/2011", null);
		TaskPanel taskPanel = new TaskPanel(newTask);
		GUITester.launchTestFrame(taskPanel);
	}

	public Task getTask() {
		return task;
	}

	public void updateGUI() {
		if (task != null) {
			updating = true;
			this.txtTaskName.setText(task.getTaskName());
			if (task.getCompletedBy() != null)
				this.txtCompletedBy.setText(task.getCompletedBy().getDisplayName());
			if (task.getDueDate() != null)
				this.txtDueDate.setText(Application.formatDateToString(task.getDueDate()));
			if (task.getCompletedDate() != null)
				this.txtCompletedDate.setText(Application.formatDateToString(task.getCompletedDate()));
			this.txtNotes.setText(task.getNotes());
			updating = false;
		}
	}

	public void save() {
		if (task != null) {
			task.setTaskName(this.txtTaskName.getText());
			//			task.setStaff(this.txtCompletedBy.getText());
			try {
				task.setDueDate(Application.parseDate(this.txtDueDate.getText()));
				task.setCompletedDate(Application.parseDate(this.txtCompletedBy.getText()));
			}
			catch (ParseException e) {

			}
			task.setNotes(this.txtNotes.getText());
		}
	}
	
	public boolean isEditable() {
		return editable;
	}
	
	public void setEditable(boolean editable) {
		this.editable = editable;
		updateEditable();
	}
	
	protected void updateEditable() {
		txtTaskName.setEditable(editable);
		txtNotes.setEditable(editable);
		txtDueDate.setEditable(editable);
	}
	
	protected void completeTask() {
		txtCompletedBy.setEditable(true);
		txtCompletedDate.setEditable(true);
	}
	
}
