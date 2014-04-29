package edu.radford.itec370.mainmethod.zoologics.gui;

import edu.radford.itec370.mainmethod.zoologics.Vaccination;

public class VaccinationPanel extends AnimalTaskPanel{

	private VaccinationPanel() {
		super();
		lblCompletionDate.setText("Administer Date");
		lblCompletedBy.setText("Administered by");
		lblTaskName.setText("Vaccination Name");		
		btnCompleteTask.setText("Administer Vaccination");
	}
	
	public VaccinationPanel(Vaccination vaccination) {
		this();
		task = vaccination;
	}
}
