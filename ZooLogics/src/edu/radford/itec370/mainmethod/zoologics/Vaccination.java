package edu.radford.itec370.mainmethod.zoologics;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.gui.VaccinationPanel;

public class Vaccination extends AnimalTask {

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
