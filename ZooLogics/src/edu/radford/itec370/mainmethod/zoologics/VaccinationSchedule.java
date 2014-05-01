package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;


public class VaccinationSchedule implements Serializable, DataIOable<VaccinationSchedule> {

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

	@Override
	public VaccinationSchedule getNewInstanceFromIO(String ioString) {
		return new VaccinationSchedule(vaccinationScheduleID, ioString, vaccine, ioString);
	}

	@Override
	public String getIOLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(vaccinationScheduleID); sb.append("|");
		sb.append(scheduleName); sb.append("|");
		sb.append(vaccine.getVaccineID()); sb.append("|");
		sb.append(dosage); sb.append("|");
		sb.append(taskRecurrences.getRecurrenceScheduleID()); sb.append("|");
		return sb.toString(); 
		// TODO Auto-generated method stub
	}
	
}
