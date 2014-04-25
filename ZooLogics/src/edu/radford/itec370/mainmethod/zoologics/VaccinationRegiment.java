package edu.radford.itec370.mainmethod.zoologics;


/**
 * @author Sean
 * A VaccinationRegiment is a template for creating a VaccinationTask for an individual Animal.
 * It consists of a single Vaccine and a TaskRecurrences collection.
 * To assign a vaccination regiment to an animal, 
 */
public class VaccinationRegiment {

	private String regimentName;
	private Vaccine vaccine;
	private TaskRecurrence taskRecurrences;

	public VaccinationRegiment() {
		super();
	}
	
	public VaccinationRegiment(String regimentName, Vaccine vaccine,
			TaskRecurrence taskRecurrences) {
		this();
		this.regimentName = regimentName;
		this.vaccine = vaccine;
		this.taskRecurrences = taskRecurrences;
	}
	public String getRegimentName() {
		return regimentName;
	}
	public void setRegimentName(String regimentName) {
		this.regimentName = regimentName;
	}
	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	public TaskRecurrence getTaskRecurrences() {
		return taskRecurrences;
	}
	public void setTaskRecurrences(TaskRecurrence taskRecurrences) {
		this.taskRecurrences = taskRecurrences;
	}
	
}
