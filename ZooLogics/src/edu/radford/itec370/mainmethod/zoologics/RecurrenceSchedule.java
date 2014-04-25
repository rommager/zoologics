package edu.radford.itec370.mainmethod.zoologics;

import java.util.ArrayList;
import java.util.Calendar;

public class RecurrenceSchedule extends ArrayList<RecurrenceInstance> implements Cloneable {

	private static final long serialVersionUID = -578725875891715725L;
	private boolean fromCompletedDate;    // determines if next due date will be calculated from the last due date, or last completion date
	private boolean isTemplate;

	public RecurrenceSchedule() {
		super();		
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
	
	@Override
	public Object clone() {
		RecurrenceSchedule newRecurrences = new RecurrenceSchedule();
		for (RecurrenceInstance ti : this) {
			newRecurrences.add(ti.clone());
		}
		return newRecurrences;
	}


}
