package edu.radford.itec370.mainmethod.zoologics;

import java.util.StringTokenizer;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.gui.VaccinationPanel;

//TODO figure out the best way to save all 3 task types

public class Vaccination extends AnimalTask implements DataIOable<Vaccination> {

	private static final long serialVersionUID = -5452735200526026986L;
	private static final String TASK_TYPE = "Vaccination";
	
	public Vaccination(String ioString){
		StringTokenizer st = new StringTokenizer(ioString, Application.DELIMITER);
		setTaskID(Integer.parseInt(st.nextToken()));
		taskName = st.nextToken();
		status = Integer.parseInt(st.nextToken());
		notes = st.nextToken();
		animal = Application.findAnimal(Integer.parseInt(st.nextToken()));
	}
	
	@Override
	public String getTaskType() {
		return TASK_TYPE;
	}
	
	public JPanel getPanel() {
		return new VaccinationPanel(this);
	}
	
	@Override
	public Vaccination getNewInstanceFromIO(String ioString) {
		return new Vaccination(ioString);
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
