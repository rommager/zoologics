package edu.radford.itec370.mainmethod.zoologics;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

public class TaskRecurrence {

	private Calendar currentDate;
	private int recurrenceCount;
	private int intervalType;
	private int intervalCount;
	private Task parentTask;
	private Queue<TaskRecurrence> parentQueue;
	
	public TaskRecurrence() {
		super();
		parentQueue = new LinkedList<TaskRecurrence>();
		parentQueue.add(this);
		
	}
	
	public TaskRecurrence(Calendar currentDate, int recurrenceCount,
			int intervalType, int intervalCount) {
		this();
		this.currentDate = currentDate;
		this.recurrenceCount = recurrenceCount;
		this.intervalType = intervalType;
		this.intervalCount = intervalCount;
	}
	
	public Calendar getNextRecurrenceDate() {
		if (recurrenceCount > 0) {
			Calendar newDate = (Calendar) currentDate.clone();
			newDate.add(intervalType, intervalCount);
			recurrenceCount--;
			return newDate;
		}
		else {
			parentQueue.poll();  // pop this expired recurrence off of the queue
			return parentQueue;
		}
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

	public Queue<TaskRecurrence> getParentQueue() {
		return parentQueue;
	}

	public void setParentQueue(Queue<TaskRecurrence> parentCollection) {
		this.parentQueue = parentQueue;
	}

}
