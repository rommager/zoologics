package edu.radford.itec370.mainmethod.zoologics;

import java.util.ArrayList;
import java.util.Calendar;

public class TaskRecurrences extends ArrayList<TaskRecurrenceInstance> implements Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -578725875891715725L;

	public TaskRecurrences() {
		super();		
	}
	
	public Calendar getNextRecurrenceDate(Calendar dueDate) {
		while (this.size() != 0) {
			TaskRecurrenceInstance ti = this.get(0);
			
			if (ti.hasMoreRecurrences()) {
				Calendar newDate = (Calendar) dueDate.clone();
				newDate.add(ti.getIntervalType(), ti.getIntervalAmount());
				return newDate;
			}
			else {
				// if no recurrences are left, remove this item from the arraylist as it is now expired.
				this.remove(ti);				
			}
		}
		 return null;	
	}
	
	public void decrement() {
		if (this.size() != 0) {
			get(0).decrement();
			if (get(0).getRemainingCount() == 0)
				popElement();
		}
	}
	
	private void popElement() {
		this.remove(0);
	}
	
	@Override
	public Object clone() {
		return null;
	}


}
