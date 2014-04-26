package edu.radford.itec370.mainmethod.zoologics;

import java.util.Calendar;
import java.util.Date;

public class RecurrenceInstance implements Cloneable {

	private static int idCounter = 8001;
	private int recurrenceInstanceID;
	private int numberOfRecurrences;
	private int numberRemaining;
	private int intervalType;
	private int intervalCount;

	private RecurrenceInstance() {
		super();
		recurrenceInstanceID = idCounter++;
	}

	public RecurrenceInstance(int numberOfRecurrences, 
			int intervalType,
			int intervalCount) {
		this();
		this.numberOfRecurrences = numberOfRecurrences;
		this.numberRemaining = numberOfRecurrences;
		this.intervalType = intervalType;
		this.intervalCount = intervalCount;
		validate();
	}

	public RecurrenceInstance(int recurrenceCount, 
			int intervalType,
			int intervalCount,
			int remainingCount) {
		this();
		this.numberOfRecurrences = recurrenceCount;
		this.intervalType = intervalType;
		this.intervalCount = intervalCount;
		this.numberRemaining = remainingCount;
		validate();
	}

	// full constructor with ID for IO
	public RecurrenceInstance(int recurrenceInstanceID,
			int numberOfRecurrences, int numberRemaining, int intervalType,
			int intervalCount) {
		super();
		setRecurrenceInstanceID(recurrenceInstanceID);
		this.numberOfRecurrences = numberOfRecurrences;
		this.numberRemaining = numberRemaining;
		this.intervalType = intervalType;
		this.intervalCount = intervalCount;
	}

	public boolean hasMoreRecurrences() {
		if (numberOfRecurrences == -1) {     // if -1 then recurrences are indefinite
			return true;
		}
		else if (numberRemaining > 0) {  // if > 0 then more recurrences remain
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
	public RecurrenceInstance clone() {
		RecurrenceInstance newInstance = new RecurrenceInstance(numberOfRecurrences, intervalType, intervalCount);
		return newInstance;
	}

	public String getDescription() {
		StringBuffer output = new StringBuffer();
		output.append("Recurrence ");
		output.append(numberRemaining);
		output.append(" of ");
		output.append(numberOfRecurrences);
		output.append(", every ");
		output.append(intervalCount);
		switch (intervalType) {
		case Task.DAY:
			output.append(" day");
		case Task.WEEK:
			output.append(" week");
		case Task.MONTH:
			output.append(" month");
		case Task.YEAR:
			output.append(" year");
		}
		if (intervalCount > 1)
			output.append("s");

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
		calendar.add(intervalType, intervalCount);
	}

	public void decrement() {
		numberRemaining--;
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

	public void setIntervalCount(int intervalAmount) {
		this.intervalCount = intervalAmount;
	}

	public int getRemainingCount() {
		return numberRemaining;
	}

	public void setRemainingCount(int remainingCount) {
		this.numberRemaining = remainingCount;
	}

	public void validate() {
		if (numberOfRecurrences < -1 || numberOfRecurrences == 0 || numberOfRecurrences == 1)
			throw new IllegalArgumentException("Number of recurrences must be greater than 2, or forever.");
		if (numberRemaining < 0 || numberRemaining > numberOfRecurrences) 
			throw new IllegalArgumentException("Number of remaining recurrences must be within the range of 0 to the number of total recurrences.");
		if (intervalCount <= 0)
			throw new IllegalArgumentException("Interval must be a positive value.");
		if (numberOfRecurrences == -1 && numberRemaining != 0)
			throw new IllegalArgumentException("Number of remaining recurrences must be zero when recurrence is set to forever.");
		if (intervalType != Task.DAY && intervalType != Task.WEEK && intervalType != Task.MONTH && intervalType != Task.YEAR)
			throw new IllegalArgumentException("Interval Type is invalid.");
	}

	public int getRecurrenceInstanceID() {
		return recurrenceInstanceID;
	}

	public void setRecurrenceInstanceID(int recurrenceInstanceID) {
		if (idCounter <= recurrenceInstanceID)
			idCounter = recurrenceInstanceID + 1;
		this.recurrenceInstanceID = recurrenceInstanceID;
	}
}
