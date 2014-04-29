package edu.radford.itec370.mainmethod.zoologics;

public class Vaccination extends AnimalTask {

	private static final long serialVersionUID = -5452735200526026986L;
	private static final String TASK_TYPE = "Vaccination";
	
	@Override
	public String getTaskType() {
		return TASK_TYPE;
	}
}
