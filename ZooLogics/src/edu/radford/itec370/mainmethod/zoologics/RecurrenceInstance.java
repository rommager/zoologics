package edu.radford.itec370.mainmethod.zoologics;

import java.util.Calendar;
import java.util.Date;

public class RecurrenceInstance implements Cloneable, DataIOable<RecurrenceInstance> {

	private static int recurrenceInstanceIDCounter = 42001;
	private int recurrenceInstanceID;
	private int numberOfRecurrences;
	private int numberRemaining;
	private int intervalType;
	private int intervalCount;

	private RecurrenceInstance() {
		super();
		recurrenceInstanceID = recurrenceInstanceIDCounter++;
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
	public RecurrenceInstance getNewInstanceFromIO(String ioString) {
		return new RecurrenceInstance();
	}
	
	@Override
	public String getIOLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(recurrenceInstanceIDCounter); sb.append("|");
		sb.append(intervalCount); sb.append("|");
		sb.append(intervalType); sb.append("|");
		sb.append(numberOfRecurrences); sb.append("|");
		sb.append(numberRemaining); sb.append("|");
		sb.append(recurrenceInstanceID); sb.append("|");

		return sb.toString();
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

	public Date getNextRecurrenceDate(Date inDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(inDate);
		calendar.add(intervalType, intervalCount);
		return calendar.getTime();
	}

	public void decrement() {
		numberRemaining--;
	}
	
	public String[] getRow() {
		String[] outArray = new String[4];
		outArray[0] = Integer.toString(intervalCount);
		outArray[1] = Task.intervalToString(intervalType);
		outArray[2] = Integer.toString(intervalCount);
		outArray[3] = Integer.toString(intervalCount);
		return outArray;
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
		this.recurrenceInstanceID = recurrenceInstanceID;
		if (recurrenceInstanceID >= recurrenceInstanceIDCounter)
			recurrenceInstanceIDCounter = recurrenceInstanceID + 1;
	}
}
