package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.gui.Filterable;
import edu.radford.itec370.mainmethod.zoologics.gui.TaskPanel;

public class Task implements Serializable, Filterable, DataIOable<Task> {

	// public constants
	public static final int ACTIVE = 1;
	public static final int COMPLETED = 2;
	public static final int DISMISSED = 3;
	public static final int DELETED = 0;

	public static final int DAY = 5;    // Calendar.DATE;
	public static final int WEEK = 3;   // Calendar.WEEK_OF_YEAR;
	public static final int MONTH = 2;  // Calendar.MONTH;
	public static final int YEAR = 1;   // Calendar.YEAR;

	private static final long serialVersionUID = -8687090435553311509L;
	private static final String TASK_TYPE = "Task";
	protected static int taskIDCounter = 40001;

	protected int taskID;
	protected int status;
	protected String taskName;
	protected String notes;
	protected Date dueDate;
	protected Date completedDate;
	protected Staff completedBy;
	
	private RecurrenceSchedule recurrences;

	private ArrayList<Task> parentTaskList;

	public Task() {
		super();
		status = Task.ACTIVE;
		taskID = taskIDCounter++;
	}
	
	public Task(int id) {
		super();
		this.taskID = id;
	}

	// constructor for new blank task
	public Task(ArrayList<Task> parentTaskList) {
		this();
		this.parentTaskList = parentTaskList;
		this.taskID = taskIDCounter++;
	}

	// constructor for test data
	public Task(String taskName,
			ArrayList<Task> parentTaskList) {
		this();
		this.taskName = taskName;
		this.parentTaskList = parentTaskList;
		this.taskID = taskIDCounter++;
	}

	// constructor for test data
	public Task(String taskName, 
			String dueDate,
			ArrayList<Task> parentTaskList) {
		this();
		this.taskName = taskName;
		try {
		this.dueDate = Application.parseDate(dueDate);
		}
		catch (ParseException e) {
			
		}
		this.parentTaskList = parentTaskList;
	}

	// Full constructor
	public Task(int taskID,
			String taskName,
			String notes, 
			String dueDate,
			String completedDate,
			int status, 
			int completedByStaffID,
			ArrayList<Task> parentTaskList) throws ParseException {
		super();
		setTaskID(taskID);
		this.taskName = taskName;
		this.notes = notes;
		this.dueDate = Application.getDateFormat().parse(dueDate);
		this.completedDate = Application.getDateFormat().parse(dueDate);
		this.status = status;
		//TODO Resolve StaffID and put into staff variable
		this.parentTaskList = parentTaskList;
	}
	
	// IO Constructor
	public Task(String[] io) {
		super();
		taskID = Integer.parseInt(io[0]);
		taskName = io[1];
		notes = io[2];
		
		try {dueDate = Application.parseDate(io[3]);}
		catch (ParseException e) {dueDate = null;}
		
		try {completedDate = Application.parseDate(io[4]);}
		catch (ParseException e) {dueDate = null;}
		
		completedBy = Application.getRunningInstance().findStaff(Integer.parseInt(io[5]));
	}

	public static String intervalToString(int interval) {
		String output = "";
		switch (interval) {
		case Task.DAY: output = "Day";
		case Task.WEEK: output = "Week";
		case Task.MONTH: output = "Month";
		case Task.YEAR: output = "Year";
		default: output = "Invalid";
		}
		return output;
	}

	public static int stringToInterval(String interval) {
		int output = 0;
		switch (interval) {
		case "Day": output = Task.DAY;
		case "Week": output = Task.WEEK;
		case "Month": output = Task.MONTH;
		case "Year": output = Task.YEAR;
		}
		return output;
	}

	public void dismiss(){
		setStatus(DISMISSED);
	}

	public void complete() {
		if (isValid()) {
			setStatus(COMPLETED);
			spawnNextTaskRecurrence();
		}
		else {
			throw new IllegalStateException();
		}
	}

	public boolean isValid(){
		return true;
	}

	public Task spawnNextTaskRecurrence(){
		if (isRecurring()) {
			Task newTask = new Task(taskName, parentTaskList);

			// move recurrences collection from this instance to the newly spawned instance
			newTask.setRecurrences(this.getRecurrences());
			newTask.setDueDate(recurrences.getNextRecurrenceDate(dueDate));
			this.recurrences = null;
			parentTaskList.add(newTask);
			return newTask;
		}
		this.setRecurrences(null);
		return null;
	}

	public void passRecurrenceSchedule(Task newTask) {
		//		recurrences.decrement();
		newTask.setRecurrences(recurrences);
		recurrences = null;
	}


	public String[] getGridRow() {
		if (status == Task.ACTIVE)
			return new String[] {taskName, Application.getDateFormat().format(dueDate)};
		else if (status == Task.COMPLETED)
			return new String[] {taskName, Application.getDateFormat().format(completedDate), completedBy.getDisplayName()};
		else
			return null;
	}

	public boolean isRecurring() {
		return (recurrences != null);
	}

	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return "Task '" + taskName + "', " + " status=" + status + ", due=" + df.format(dueDate.getTime()) + "]";
	}

	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public ArrayList<Task> getParentTaskList() {
		return parentTaskList;
	}

	public void setParentTaskList(ArrayList<Task> parentTaskList) {
		this.parentTaskList = parentTaskList;
	}

	public RecurrenceSchedule getRecurrences() {
		return recurrences;
	}

	public void setRecurrences(RecurrenceSchedule recurrences) {
		this.recurrences = recurrences;
	}

	public String getTaskType() {
		return TASK_TYPE;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Staff getCompletedBy() {
		return completedBy;
	}

	public void setCompletedBy(Staff completedBy) {
		this.completedBy = completedBy;
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
		if (taskID >= taskIDCounter)
			taskIDCounter = taskID + 1;
	}

	public JPanel getPanel() {
		return new TaskPanel(this);
	}

	@Override
	public boolean isVisibleWithFilter(String filter) {
		// tasks are not filterable
		return false;
	}
	
	@Override
	public Task getNewInstanceFromIO(String[] io) {
		return new Task(io);
	}
	
	@Override
	public String getIOLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(taskID).append("|");
		sb.append(taskName).append("|");
		sb.append(notes).append("|");
		
		if (dueDate != null)
			sb.append(Application.formatDateToString(dueDate));
		sb.append("|");
		
		if (completedDate != null)
			sb.append(Application.formatDateToString(completedDate));
		sb.append("|");
		
		if (completedBy != null)
			sb.append(completedBy.getStaffID());
		sb.append("|");
		return sb.toString();
	}
}
