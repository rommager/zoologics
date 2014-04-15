package edu.radford.itec370.mainmethod.zoologics;

import java.util.ArrayList;
import java.util.Calendar;

public class TaskRecurrence {

	private Calendar currentDate;
	private int recurrenceCount;
	private int intervalType;
	private int intervalCount;
	private Task parentTask;
	private ArrayList<TaskRecurrence> parentCollection;
	
	public TaskRecurrence() {
		super();
	}
	
	public TaskRecurrence(Calendar currentDate, int recurrenceCount,
			int intervalType, int intervalCount) {
		this();
		this.currentDate = currentDate;
		this.recurrenceCount = recurrenceCount;
		this.intervalType = intervalType;
		this.intervalCount = intervalCount;
	}
	
	public Task getNextRecurrence() {
		
		
		
		return null;
	}

	public Calendar getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Calendar currentDate) {
		this.currentDate = currentDate;
	}

	public int getRecurrenceCount() {
		return recurrenceCount;
	}

	public void setRecurrenceCount(int recurrenceCount) {
		if (recurrenceCount >= -1){
		this.recurrenceCount = recurrenceCount;
		}
		else {
			this.recurrenceCount = -1;
		}
	}

	public int getIntervalType() {
		return intervalType;
	}

	public void setIntervalType(int intervalType) {
		this.intervalType = intervalType;
	}

	public int getIntervalCount() {
		return intervalCount;
	}

	public void setIntervalCount(int intervalCount) {
		this.intervalCount = intervalCount;
	}

	public Task getParentTask() {
		return parentTask;
	}

	public void setParentTask(Task parentTask) {
		this.parentTask = parentTask;
	}

	public ArrayList<TaskRecurrence> getParentCollection() {
		return parentCollection;
	}

	public void setParentCollection(ArrayList<TaskRecurrence> parentCollection) {
		this.parentCollection = parentCollection;
	}

}
