package edu.radford.itec370.mainmethod.zoologics.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import edu.radford.itec370.mainmethod.zoologics.Vaccination;

@SuppressWarnings("serial")
public class VaccinationPanel extends AnimalTaskPanel{

	private VaccinationPanel() {
		super();
		lblCompletionDate.setText("Administer Date");
		lblCompletedBy.setText("Administered by");
		lblTaskName.setText("Vaccination Name");		
		btnCompleteTask.setText("Administer Vaccination");
		
		JComboBox cboVaccines = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"Ivomec","Rabies","Dewormer"}));
		
		cboVaccines.setBounds(txtTaskName.getX(), txtTaskName.getY(), txtTaskName.getSize().width, txtTaskName.getSize().height);
		detailPanel.add(cboVaccines);
		txtTaskName.setVisible(false);
	}
	
	public VaccinationPanel(Vaccination vaccination) {
		this();
		task = vaccination;
	}
	
	/*
	@Override
	public void updateGUI() {
		super.updateGUI();
	}
	
	@Override
	public void save() {
		super.save();
	}
	*/
	
}
