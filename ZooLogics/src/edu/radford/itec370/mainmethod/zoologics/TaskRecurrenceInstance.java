package edu.radford.itec370.mainmethod.zoologics;

public class TaskRecurrenceInstance {

	private int recurrenceCount;
	private int intervalType;
	private int intervalAmount;
	
	private TaskRecurrenceInstance() {
		super();
	}

	public TaskRecurrenceInstance(int recurrenceCount, 
			int intervalType,
			int intervalAmount) {
		this();
		this.setRecurrenceCount(recurrenceCount);
		this.intervalType = intervalType;
		this.intervalAmount = intervalAmount;
	}

	public boolean hasMoreRecurrences() {
		if (recurrenceCount == -1) {     // if -1 then recurrences are indefinite
			return true;
		}
		else if (recurrenceCount > 0) {  // if > 0 then more recurrences remain
			recurrenceCount--;           // decrease recurrence count to count down remaining recurrences
			return true;
		}
		return false;					 // return false because no more of this recurrence instance remains
	}
	
	public int getRecurrenceCount() {
		return recurrenceCount;
	}

	public void setRecurrenceCount(int recurrenceCount) {
		if (recurrenceCount >= -1){
		this.recurrenceCount = recurrenceCount;
		}
		else {
			this.recurrenceCount = -1;   // -1 means indefinitely
		}

	}

	public int getIntervalType() {
		return intervalType;
	}

	public void setIntervalType(int intervalType) {
		this.intervalType = intervalType;
	}

	public int getIntervalAmount() {
		return intervalAmount;
	}

	public void setIntervalCount(int intervalAmount) {
		this.intervalAmount = intervalAmount;
	}
	
}
