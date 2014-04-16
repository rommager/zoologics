package edu.radford.itec370.mainmethod.zoologics;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Queue;

public abstract class Task {

	private StringBuffer description;
	private Calendar dueDate;
	private boolean recurring;
	private TaskStatus status;
	private TaskList parentTaskList;
	private Queue<TaskRecurrence> recurrences;
	
	public Task() {
		super();
	}
	
	public Task(String description, TaskStatus status, 
			TaskList parentTaskList) {
		this();
		this.description = new StringBuffer(description);
		this.status = status;
		this.parentTaskList = parentTaskList;
	
	}
	
	public Task(String description, TaskStatus status, 
			TaskList parentTaskList, boolean recurring) {
		this(description, status, parentTaskList);
		this.recurring = recurring;
	}
	
		
	public Task(String description, TaskStatus status, 
			TaskList parentTaskList, boolean recurring, Calendar dueDate) {
		this(description, status, parentTaskList, recurring);
		this.dueDate = dueDate;
	}

	public Task(String description, TaskStatus status, 
			TaskList parentTaskList, boolean recurring,
			String dueDate) throws ParseException {
		this(description, status, parentTaskList, recurring);
		Calendar dueCalendar = Calendar.getInstance();
		dueCalendar.setTime(Application.getDateFormat().parse(dueDate));
		setDueDate(dueCalendar);
	}

	public void dismiss(){
		setStatus(TaskStatus.DISMISSED);
	}
	
	public void complete() throws InvalidTaskCompletionException{
		if (isValid()) {
			setStatus(TaskStatus.COMPLETED);
			generateNextRecurrence();
		}
		else {
			throw new InvalidTaskCompletionException();
		}
	}

	public boolean isValid(){
		return true;
	}
	
/*	private void generateNextRecurrence(){
		if (recurring) {
			Calendar newDate = (Calendar) dueDate.clone();
			newDate.dueDate
		}
	}
*/
	
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
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public boolean isRecurring() {
		return recurring;
	}

	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	public TaskList getParentTaskList() {
		return parentTaskList;
	}

	public void setParentTaskList(TaskList parentTaskList) {
		this.parentTaskList = parentTaskList;
	}

	public Queue<TaskRecurrence> getRecurrences() {
		return recurrences;
	}

	public void setRecurrences(Queue<TaskRecurrence> recurrences) {
		this.recurrences = recurrences;
	}
			
}
