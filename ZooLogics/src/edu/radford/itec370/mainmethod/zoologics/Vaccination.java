package edu.radford.itec370.mainmethod.zoologics;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.gui.VaccinationPanel;

//TODO figure out the best way to save all 3 task types

public class Vaccination extends AnimalTask implements DataIOable<Vaccination> {

	private static final long serialVersionUID = -5452735200526026986L;
	private static final String TASK_TYPE = "Vaccination";
	
	@Override
	public String getTaskType() {
		return TASK_TYPE;
	}
	
	public JPanel getPanel() {
		return new VaccinationPanel(this);
	}

}
