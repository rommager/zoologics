package edu.radford.itec370.mainmethod.zoologic;

import java.util.ArrayList;

import javax.swing.JPanel;

public class AnimalVaccinationReportPanel extends JPanel {

	private ArrayList <Vaccination> vaccinations;
	private Animal animal;
	
	public AnimalVaccinationReportPanel() {
		
	}
	
	public void refresh() {
		
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public ArrayList <Vaccination> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(ArrayList <Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}
	
}
