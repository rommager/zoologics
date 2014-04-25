package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Queue;

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
	
	private TaskRecurrences recurrences;
	
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
			TaskRecurrences newRecurrences = new TaskRecurrences();
			newTask.setRecurrences(newRecurrences);
			newRecurrences.add(new TaskRecurrenceInstance(3,WEEK,2));
			newRecurrences.add(new TaskRecurrenceInstance(2,MONTH,1));
			newRecurrences.add(new TaskRecurrenceInstance(-1,YEAR,1));
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

	public void dismiss(){
		setStatus(DISMISSED);
	}
	
	public void complete() throws InvalidTaskCompletionException{
		if (isValid()) {
			setStatus(COMPLETED);
			spawnNextTaskRecurrence();
		}
		else {
			throw new InvalidTaskCompletionException();
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
		recurrences.decrement();
		newTask.setRecurrences(recurrences);
		recurrences = null;
	}
	
	
	public String[] getGridRow() {
		if (status == Task.ACTIVE)
			return new String[] {taskName, Application.getDateFormat().format(dueDate)};
		else if (status == Task.COMPLETED)
			return new String[] {taskName, Application.getDateFormat().format(completedDate), completedBy.getName()};
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

	public TaskRecurrences getRecurrences() {
		return recurrences;
	}

	public void setRecurrences(TaskRecurrences recurrences) {
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
