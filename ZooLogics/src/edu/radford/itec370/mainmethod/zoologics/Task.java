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
	private StringBuffer description;
	private Calendar dueDate;
	private int status;
	
	private TaskRecurrences recurrences;
	
	private TaskList parentTaskList;
	
	public Task() {
		super();
	}
	
	public Task(StringBuffer description,
			int status,
			TaskList parentTaskList) {
		this();
		this.description = new StringBuffer(description);
		this.status = status;
		this.parentTaskList = parentTaskList;
	}
	
	public Task(StringBuffer description, 
			int status,
			TaskList parentTaskList,
			Calendar dueDate) {
		this(description, status, parentTaskList);
		this.dueDate = dueDate;
	}
	
	// Constructor that accepts strings for description and due date, for IO
	public Task(String description, 
			int status, 
			TaskList parentTaskList,
			String dueDate) throws ParseException {
		this(new StringBuffer(description), status, parentTaskList);
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
			// TODO Auto-generated catch block
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
			Task newTask = new Task(description, status, parentTaskList);
			
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
	
	public boolean isRecurring() {
		return (recurrences != null);
	}
	
	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return "Task '" + description + "', " + " status=" + status + ", due=" + df.format(dueDate.getTime()) + "]";
	}

	public StringBuffer getDescription() {
		return description;
	}
	public void setDescription(StringBuffer description) {
		this.description = description;
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
}
