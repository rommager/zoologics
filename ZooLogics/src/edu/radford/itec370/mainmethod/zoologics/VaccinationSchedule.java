package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;

public class VaccinationSchedule implements Serializable, DataIOable<VaccinationSchedule> {

	private static final long serialVersionUID = -3195843828057553503L;
	private static int vaccinationScheduleIDCounter = 93001;
	private int vaccinationScheduleID;
	private String scheduleName;
	private Vaccine vaccine;
	private String dosage;
	private RecurrenceSchedule recurrenceSchedule;

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
		this.recurrenceSchedule = taskRecurrences;
	}
	
	public VaccinationSchedule(String[] io) {
		vaccinationScheduleID = Integer.parseInt(io[0]);
		scheduleName = io[1];
		vaccine = Application.getRunningInstance().findVaccine(Integer.parseInt(io[2]));
		dosage = io[3];
		recurrenceSchedule = Application.getRunningInstance().findRecurrenceSchedule(Integer.parseInt(io[4]));		
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
		return recurrenceSchedule;
	}
	public void setTaskRecurrences(RecurrenceSchedule taskRecurrences) {
		this.recurrenceSchedule = taskRecurrences;
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
	public VaccinationSchedule getNewInstanceFromIO(String[] io) {
		return new VaccinationSchedule(io);
	}

	@Override
	public String getIOLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(vaccinationScheduleID).append("|");
		sb.append(scheduleName).append("|");
		sb.append(vaccine.getVaccineID()).append("|");
		sb.append(dosage).append("|");
		sb.append(recurrenceSchedule.getRecurrenceScheduleID()).append("|");
		return sb.toString(); 
	}
	
}
