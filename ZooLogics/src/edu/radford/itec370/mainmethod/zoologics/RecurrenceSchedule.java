package edu.radford.itec370.mainmethod.zoologics;

import java.util.ArrayList;
import java.util.Date;

public class RecurrenceSchedule extends ArrayList<RecurrenceInstance> implements Cloneable, DataIOable<RecurrenceSchedule> {

	private static final long serialVersionUID = -578725875891715725L;
	
	private static int recurrenceScheduleIDCounter = 41001;
	private int recurrenceScheduleID;
	private boolean fromDateCompleted;    // determines if next due date will be calculated from the last due date, or last completion date
	private boolean isTemplate;

	public RecurrenceSchedule() {
		super();
		this.recurrenceScheduleID = recurrenceScheduleIDCounter++;
	}
	
	// DataIOable template constructor
	public RecurrenceSchedule(int id) {
		super();
		this.recurrenceScheduleID = id;
	}
	
	public RecurrenceSchedule(String[] io) {
		super();
		setRecurrenceScheduleID(Integer.parseInt(io[0]));
		fromDateCompleted = io[1].equals("true");
		isTemplate = io[2].equals("true");
	}
	
	public Date getNextRecurrenceDate(Date inDate) {
		int index = 0;
		while (this.size() > index) {
						
			if (get(index).hasMoreRecurrences()) {
				return get(index).getNextRecurrenceDate(inDate);
			}
			index++;
		}
		 return null;	
	}
	
	public void executeCurrentTask() {
		if (!isTemplate) {
			if (this.size() != 0) {
				get(0).decrement();
				if (get(0).getRemainingCount() == 0)
					popElement();
			}
		}
		else
			throw new IllegalStateException("Cannot use executeCurrentTask() method on template");
	}
	
	private void popElement() {
		this.remove(0);
	}
	
	public void validate() {
		for (int index = 0; index < size(); index++) {
			if (get(index).getRemainingCount() == -1 && index == size() - 1)
				throw new IllegalStateException("Only the last instance in the task schedule can be forever.");
			get(index).validate();
		}
	}
	
	@Override
	public Object clone() {
		RecurrenceSchedule newRecurrences = new RecurrenceSchedule();
		for (RecurrenceInstance ti : this) {
			newRecurrences.add(ti.clone());
		}
		return newRecurrences;
	}
	
	@Override
	public RecurrenceSchedule getNewInstanceFromIO(String[] io) {
		return new RecurrenceSchedule(io);
	}
	
	@Override
	public String getIOLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(recurrenceScheduleID).append(Application.DELIMITER);
		sb.append(fromDateCompleted).append(Application.DELIMITER);
		sb.append(isTemplate).append(Application.DELIMITER);
		return sb.toString();
	}
	
	// setters and getters
	public int getRecurrenceScheduleID() {
		return recurrenceScheduleID;
	}

	public void setRecurrenceScheduleID(int recurrenceScheduleID) {
		this.recurrenceScheduleID = recurrenceScheduleID;
		if (recurrenceScheduleID >= recurrenceScheduleIDCounter)
			recurrenceScheduleIDCounter = recurrenceScheduleID + 1;
	}

	public boolean isFromCompletedDate() {
		return fromDateCompleted;
	}

	public void setFromCompletedDate(boolean fromCompletedDate) {
		this.fromDateCompleted = fromCompletedDate;
	}

	public boolean isTemplate() {
		return isTemplate;
	}

	public void setTemplate(boolean isTemplate) {
		this.isTemplate = isTemplate;
	}

}
