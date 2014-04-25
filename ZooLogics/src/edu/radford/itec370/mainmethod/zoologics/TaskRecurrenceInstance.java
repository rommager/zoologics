package edu.radford.itec370.mainmethod.zoologics;

import java.util.Calendar;
import java.util.Date;

/**
 * @author srid3
 *
 */
/**
 * @author srid3
 *
 */
/**
 * @author srid3
 *
 */
public class TaskRecurrenceInstance implements Cloneable {

	private String recurrenceName;
	private int numberOfRecurrences;
	private int intervalType;
	private int intervalAmount;
	private int remainingCount;
	
	private TaskRecurrenceInstance() {
		super();
	}

	public TaskRecurrenceInstance(int numberOfRecurrences, 
			int intervalType,
			int intervalAmount) {
		this();
		this.numberOfRecurrences = numberOfRecurrences;
		this.remainingCount = numberOfRecurrences;
		this.intervalType = intervalType;
		this.intervalAmount = intervalAmount;
		validate();
	}
	
	public TaskRecurrenceInstance(int recurrenceCount, 
			int intervalType,
			int intervalAmount,
			int remainingCount) {
		this();
		this.numberOfRecurrences = recurrenceCount;
		this.intervalType = intervalType;
		this.intervalAmount = intervalAmount;
		this.remainingCount = remainingCount;
		validate();
	}

	public boolean hasMoreRecurrences() {
		if (numberOfRecurrences == -1) {     // if -1 then recurrences are indefinite
			return true;
		}
		else if (remainingCount > 0) {  // if > 0 then more recurrences remain
			return true;
		}
		return false;					 // return false because no more of this recurrence instance remains
	}
	
	public int getNumberOfRecurrences() {
		return numberOfRecurrences;
	}

	public void setNumberOfRecurrences(int recurrenceCount) {
		if (recurrenceCount >= -1){
		this.numberOfRecurrences = recurrenceCount;
		}
		else {
			this.numberOfRecurrences = -1;   // -1 means indefinitely
		}

	}
	
	@Override
	public TaskRecurrenceInstance clone() {
		TaskRecurrenceInstance newInstance = new TaskRecurrenceInstance(numberOfRecurrences, intervalType, intervalAmount);
		return newInstance;
	}
	
	public String getDescription() {
		StringBuffer output = new StringBuffer();
		//TODO finish this
		return output.toString();
	}
	
    
	/**
	 * @param inCalendar
	 * @return clone of Calendar object with the interval added
	 * returns a copy of Calendar as not to change date on original passed in Calendar object
	 */
	public Calendar getNextRecurrenceDate(Calendar inCalendar) {
		Calendar outCalendar = (Calendar) inCalendar.clone();
		addInterval(outCalendar);
		return outCalendar;
	}
	
	/**
	 * @param inDate
	 * @return Calendar object with interval added to the date
	 */
	public Calendar getNextRecurrenceDate(Date inDate) {
		Calendar outCalendar = Calendar.getInstance();
		addInterval(outCalendar);
		return outCalendar;
	}
	
	/**
	 * @param calendar
	 * adds interval to the passed in Calendar object
	 */
	private void addInterval(Calendar calendar) {
		calendar.add(intervalType, intervalAmount);
	}
	
	public void decrement() {
		remainingCount--;
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

	public void setIntervalAmount(int intervalAmount) {
		this.intervalAmount = intervalAmount;
	}
	
	public int getRemainingCount() {
		return remainingCount;
	}

	public void setRemainingCount(int remainingCount) {
		this.remainingCount = remainingCount;
	}

	private void validate() {
		if (numberOfRecurrences < -1 || numberOfRecurrences == 0 || numberOfRecurrences == 1 || remainingCount < 0 || remainingCount > numberOfRecurrences || intervalAmount <= 0)
			throw new IllegalArgumentException();
		if (numberOfRecurrences == -1 && remainingCount != 0)
			throw new IllegalArgumentException();
		if (intervalType != Task.DAY && intervalType != Task.WEEK && intervalType != Task.MONTH && intervalType != Task.YEAR)
			throw new IllegalArgumentException();
		
		
	}
}
