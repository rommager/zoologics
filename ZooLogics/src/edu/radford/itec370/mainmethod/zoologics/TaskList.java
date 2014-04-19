package edu.radford.itec370.mainmethod.zoologics;

import java.util.ArrayList;

public class TaskList extends ArrayList<Task> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6836842020646843571L;

	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (Task task : this) {
			sb.append(task.toString());
			sb.append("\n");	
		}
		return sb.toString();
	}
	
	
}
