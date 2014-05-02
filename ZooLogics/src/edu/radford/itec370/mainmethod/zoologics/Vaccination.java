package edu.radford.itec370.mainmethod.zoologics;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.gui.VaccinationPanel;

//TODO figure out the best way to save all 3 task types

public class Vaccination extends AnimalTask implements DataIOable<Task> {

	private static final long serialVersionUID = -5452735200526026986L;
	private static final String TASK_TYPE = "Vaccination";
	
	public Vaccination() {
		super();
	}
	
	public Vaccination(int id) {
		super();
		this.taskID = id;
	}
	
	public Vaccination(String[] io){
		setTaskID(Integer.parseInt(io[0]));
		taskName = io[1];
		status = Integer.parseInt(io[2]);
		notes = io[3];
		animal = Application.findAnimal(Integer.parseInt(io[4]));
	}
	
	@Override
	public String getTaskType() {
		return TASK_TYPE;
	}
	
	public JPanel getPanel() {
		return new VaccinationPanel(this);
	}
	
	@Override
	public Vaccination getNewInstanceFromIO(String[] io) {
		return new Vaccination(io);
	}

	@Override
	public String getIOLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.taskID); sb.append("|");
		sb.append(this.taskName); sb.append("|");
		sb.append(this.status); sb.append("|");
	    sb.append(this.notes); sb.append("|");
		sb.append(this.animal.getAnimalID()); sb.append("|");
		return sb.toString();
	}

}
