package edu.radford.itec370.mainmethod.zoologics;

import java.util.ArrayList;
import java.util.Calendar;

public class RecurrenceSchedule extends ArrayList<RecurrenceInstance> implements Cloneable {

	private static final long serialVersionUID = -578725875891715725L;
	
	private static int idCounter = 9001;
	private int scheduleID;
	private boolean fromCompletedDate;    // determines if next due date will be calculated from the last due date, or last completion date
	private boolean isTemplate;

	public RecurrenceSchedule() {
		super();
		this.scheduleID = idCounter++;
	}
	
	public Calendar getNextRecurrenceDate(Calendar inDate) {
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

	public int getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}

	public boolean isFromCompletedDate() {
		return fromCompletedDate;
	}

	public void setFromCompletedDate(boolean fromCompletedDate) {
		this.fromCompletedDate = fromCompletedDate;
	}

	public boolean isTemplate() {
		return isTemplate;
	}

	public void setTemplate(boolean isTemplate) {
		this.isTemplate = isTemplate;
	}


}
