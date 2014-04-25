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
	private static int idCounter = 4001;
	private int id;
	private String scheduleName;
	private Vaccine vaccine;
	private String dosage;
	private RecurrenceSchedule taskRecurrences;

	public VaccinationSchedule() {
		super();
	}
	
	public VaccinationSchedule(
			int id,
			String scheduleName, 
			Vaccine vaccine,
			String dosage) {
		this();
		this.setId(id);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		if (id >= idCounter)
			idCounter = id + 1;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	
}
