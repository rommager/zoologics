package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Task implements Serializable {

	public static final int ACTIVE = 1;
	public static final int COMPLETED = 2;
	public static final int DISMISSED = 3;
	public static final int DELETED = 0;
	
	public static final int DAY = Calendar.DATE;
	public static final int WEEK = Calendar.WEEK_OF_YEAR;
	public static final int MONTH = Calendar.MONTH;
	public static final int YEAR = Calendar.YEAR;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8687090435553311509L;
	private static final String TASK_TYPE = "Task";
	protected String taskName;
	protected String notes;
	protected Calendar dueDate;
	protected Calendar completedDate;
	protected int status;
	protected Staff completedBy;
	
	private RecurrenceSchedule recurrences;
	
	private TaskList parentTaskList;
	
	public Task() {
		super();
	}
	
	public Task(String notes,
			int status,
			TaskList parentTaskList) {
		this();
		this.notes = notes;
		this.status = status;
		this.parentTaskList = parentTaskList;
	}
	
	public Task(String notes, 
			int status,
			TaskList parentTaskList,
			Calendar dueDate) {
		this(notes, status, parentTaskList);
		this.dueDate = dueDate;
	}
	
	// Constructor that accepts strings for description and due date, for IO
	public Task(String notes, 
			int status, 
			TaskList parentTaskList,
			String dueDate) throws ParseException {
		this(new String(notes), status, parentTaskList);
		Calendar dueCalendar = Calendar.getInstance();
		dueCalendar.setTime(Application.getDateFormat().parse(dueDate));
		setDueDate(dueCalendar);
	}

	public static void main(String[] args) {
		TaskList list = new TaskList();
		try {
			Task newTask = new Task("Reminder to clean toilets", Task.ACTIVE, list, "11/17/2011");
			RecurrenceSchedule newRecurrences = new RecurrenceSchedule();
			newTask.setRecurrences(newRecurrences);
			newRecurrences.add(new RecurrenceInstance(3,WEEK,2));
			newRecurrences.add(new RecurrenceInstance(2,MONTH,1));
			newRecurrences.add(new RecurrenceInstance(-1,YEAR,1));
			list.add(newTask);
			list.add(new Task("Vet Visit for Puja", Task.ACTIVE, list, "05/17/2014"));
			newTask =  newTask.spawnNextTaskRecurrence();
			System.out.println("SPAWNED: " + newTask);
			newTask =  newTask.spawnNextTaskRecurrence();
			System.out.println("SPAWNED: " + newTask);
			newTask =  newTask.spawnNextTaskRecurrence();
			System.out.println("SPAWNED: " + newTask);
			newTask =  newTask.spawnNextTaskRecurrence();
			System.out.println("SPAWNED: " + newTask);
			newTask =  newTask.spawnNextTaskRecurrence();
			System.out.println("SPAWNED: " + newTask);
			newTask =  newTask.spawnNextTaskRecurrence();
			System.out.println("SPAWNED: " + newTask);
			newTask =  newTask.spawnNextTaskRecurrence();
			System.out.println("SPAWNED: " + newTask);
			newTask =  newTask.spawnNextTaskRecurrence();
			System.out.println("SPAWNED: " + newTask);


			System.out.println(list.toString());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
			Task newTask = new Task(notes, status, parentTaskList);
			
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
	public Calendar getDueDate() {
		return dueDate;
	}
	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public TaskList getParentTaskList() {
		return parentTaskList;
	}

	public void setParentTaskList(TaskList parentTaskList) {
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
	
	public Calendar getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Calendar completedDate) {
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
}
