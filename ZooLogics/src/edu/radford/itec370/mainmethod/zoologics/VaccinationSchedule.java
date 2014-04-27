package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;

/**
 * @author Sean
 * A VaccinationSchedule is a template for creating a VaccinationTask for an individual Animal.
 * It consists of a single Vaccine and a TaskRecurrences collection.
 * To assign a vaccination schedule to an animal 
 */
public class VaccinationSchedule implements Serializable {

	private static final long serialVersionUID = -3195843828057553503L;
	private static int vaccinationScheduleIDCounter = 93001;
	private int vaccinationScheduleID;
	private String scheduleName;
	private Vaccine vaccine;
	private String dosage;
	private RecurrenceSchedule taskRecurrences;

	// constructors
	public VaccinationSchedule() {
		super();
		vaccinationScheduleID = vaccinationScheduleIDCounter++;
	}
	
	public VaccinationSchedule(
			int id,
			String scheduleName, 
			Vaccine vaccine,
			String dosage) {
		super();
		this.setVaccinationScheduleID(id);
		this.scheduleName = scheduleName;
		this.vaccine = vaccine;
		this.dosage = dosage;
	}
	
	public VaccinationSchedule(
			int id,
			String scheduleName, 
			Vaccine vaccine,
			String dosage,
			RecurrenceSchedule taskRecurrences) {
		this(id, scheduleName, vaccine, dosage);
		this.taskRecurrences = taskRecurrences;
	}

	// setters and getters
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	public RecurrenceSchedule getTaskRecurrences() {
		return taskRecurrences;
	}
	public void setTaskRecurrences(RecurrenceSchedule taskRecurrences) {
		this.taskRecurrences = taskRecurrences;
	}

	public int getVaccinationScheduleID() {
		return vaccinationScheduleID;
	}

	public void setVaccinationScheduleID(int vaccinationScheduleID) {
		this.vaccinationScheduleID = vaccinationScheduleID;
		if (vaccinationScheduleID >= vaccinationScheduleIDCounter)
			vaccinationScheduleIDCounter = vaccinationScheduleID + 1;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	
}
