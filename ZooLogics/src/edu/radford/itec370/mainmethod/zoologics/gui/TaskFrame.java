package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Task;

@SuppressWarnings("serial")
public class TaskFrame extends NavigableFrame<Task> {

	private static final String WINDOW_TITLE = Application.getAppName() + "Task";
	
	private Task task;
	private Animal animal;
	private boolean editable;
	
	private JPanel detailPanel;
	private JPanel buttonPanel;
	
	private JTextField txtTaskName;
	private JTextField txtDueDate;
	private JTextPane txtNotes;
	private JScrollPane scrollPane;
	private JTextField txtCompletedBy;
	private JTextField txtCompletedDate;
	private JTextField txtAnimalName;
	
	private JLabel lblTaskName;
	private JLabel lblDueDate;
	private JLabel lblCompletedBy;
	private JLabel lblCompletionDate;
	private JLabel lblNotes;
	private JLabel lblAnimalName;
	
	private JButton btnDismiss;
	private JButton btnClose;
	private JButton btnCompleteTask;
	private JButton btnSave;

	
	private TaskFrame () {
		super();
		setIconImage(Application.getAppImage());
		setTitle(WINDOW_TITLE);
		setBounds(100, 100, 597, 334);
		navPanel.setNewButtonVisible(false);  // no new button
		navPanel.setSearchBoxVisible(false);  // no filter box
		
		JPanel centerPanel = new JPanel();
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setPreferredSize(new Dimension(581, 405));
		centerPanel.setSize(getPreferredSize());
		detailPanel = new JPanel();
		detailPanel.setLayout(null);
		detailPanel.setPreferredSize(new Dimension(580, 250));
		
		lblTaskName = new JLabel("Task Name");
		lblTaskName.setBounds(11, 11, 70, 22);
		detailPanel.add(lblTaskName);

		txtTaskName = new JTextField();
		txtTaskName.setBounds(91, 12, 479, 20);
		detailPanel.add(txtTaskName);

		lblDueDate = new JLabel("Due Date");
		lblDueDate.setBounds(11, 44, 70, 22);
		detailPanel.add(lblDueDate);
		
		txtDueDate = new JTextField();
		txtDueDate.setBounds(91, 43, 168, 20);
		detailPanel.add(txtDueDate);

		lblAnimalName = new JLabel("Animal Name");
		lblAnimalName.setBounds(312, 44, 80, 22);
		detailPanel.add(lblAnimalName);
		
		txtAnimalName = new JTextField();
		txtAnimalName.setBounds(402, 41, 168, 20);
		detailPanel.add(txtAnimalName);

		lblNotes = new JLabel("Task Notes");
		lblNotes.setBounds(11, 77, 132, 22);
		detailPanel.add(lblNotes);

		txtNotes = new JTextPane();
		scrollPane = new JScrollPane(txtNotes);
		scrollPane.setBounds(10, 134, 560, 101);
		detailPanel.add(scrollPane);

		txtCompletedBy = new JTextField();
		txtCompletedBy.setEnabled(false);
		txtCompletedBy.setBounds(132, 339, 203, 20);
		detailPanel.add(txtCompletedBy);

		lblCompletedBy = new JLabel("Completed by");
		lblCompletedBy.setEnabled(false);
		lblCompletedBy.setBounds(10, 339, 122, 22);
		detailPanel.add(lblCompletedBy);

		lblCompletionDate = new JLabel("Completion Date");
		lblCompletionDate.setBounds(345, 339, 96, 22);
		lblCompletionDate.setEnabled(false);
		detailPanel.add(lblCompletionDate);

		// location, location, size, size
		txtCompletedDate = new JTextField();
		txtCompletedDate.setBounds(451, 339, 119, 20);
		txtCompletedDate.setEnabled(false);
		detailPanel.add(txtCompletedDate);

		// construct button panel
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnCompleteTask = new JButton("Complete Task");
		buttonPanel.add(btnCompleteTask);
		
		btnDismiss = new JButton("Dismiss");
		buttonPanel.add(btnDismiss);

		btnSave = new JButton("Save");
		buttonPanel.add(btnSave);
		
		btnClose = new JButton("Close");
		buttonPanel.add(btnClose);

		centerPanel.add(detailPanel,BorderLayout.CENTER);
		centerPanel.add(buttonPanel,BorderLayout.SOUTH);

		
	}

	public TaskFrame(ArrayList<Task> tasks) {
		this();
		setArrayList(tasks);
	}
	
	public TaskFrame(Task task) {
		this();
		this.task = task;
		updateGUI();
	}

	
//	public TaskFrame(Vaccination task) {
//		this();
//		VaccinationPanel vPanel = new VaccinationPanel(task);
//		vPanel.setAnimal(task.getAnimal());
//		super.dataPanel = vPanel;
//		getContentPane().add(vPanel,BorderLayout.CENTER);
//		
//	}
	
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
	public Task getNewInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setComponentColorForPrinting(Color color) {
		// TODO Auto-generated method stub
		
	}
	
	
	public Task getTask() {
		return task;
	}

	public void updateGUI() {
		if (task != null) {
			this.txtTaskName.setText(task.getTaskName());
			if (task.getCompletedBy() != null)
				this.txtCompletedBy.setText(task.getCompletedBy().getDisplayName());
			if (task.getDueDate() != null)
				this.txtDueDate.setText(Application.formatDateToString(task.getDueDate()));
			if (task.getCompletedDate() != null)
				this.txtCompletedDate.setText(Application.formatDateToString(task.getCompletedDate()));
			this.txtNotes.setText(task.getNotes());
			txtAnimalName.setText(animal.getName());
		}
	}

	@Override
	public boolean save() {
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
		//TODO complete this
		return false;
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
	
	public void setTask(Task task) {
		//TODO need to complete this for all types of tasks
		lblCompletionDate.setText("Administer Date");
		lblCompletedBy.setText("Administered by");
		lblTaskName.setText("Vaccination Name");		
		btnCompleteTask.setText("Administer Vaccination");
		
		JComboBox<String> cboVaccines = new JComboBox<String>(new DefaultComboBoxModel<String>(Application.getRunningInstance().getVaccineOptions()));
		
		cboVaccines.setBounds(txtTaskName.getX(), txtTaskName.getY(), txtTaskName.getSize().width, txtTaskName.getSize().height);
		detailPanel.add(cboVaccines);
		txtTaskName.setVisible(false);

	}

	
}

