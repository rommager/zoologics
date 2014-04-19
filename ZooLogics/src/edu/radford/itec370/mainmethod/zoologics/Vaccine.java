package edu.radford.itec370.mainmethod.zoologics;

import java.util.Date;
import java.util.Queue;

public class Vaccine {

	private String vaccineID;
	private String vaccineName;
	private String dosage;
	private boolean recurring;
	private TaskRecurrences defaultRecurrency;
	private Date dueAtAnimalAge;

	public String getVaccineID() {
		return vaccineID;
	}

	public Vaccine() {
		super();
	}

	public Vaccine(String vaccineID, String vaccineName, String dosage,
			boolean recurring, 
			Date dueAtAnimalAge) {
		super();
		this.vaccineID = vaccineID;
		this.vaccineName = vaccineName;
		this.dosage = dosage;
		this.recurring = recurring;
		//this.frequencyDays = frequencyDays;
		this.dueAtAnimalAge = dueAtAnimalAge;
	}

	public void setVaccineID(String vaccineID) {
		this.vaccineID = vaccineID;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public boolean isRecurring() {
		return recurring;
	}

	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

//	public Queue<TaskRecurrence> getFrequencyDays() {
//		return frequencyDays;
//	}
//
//	public void setFrequencyDays(Queue<TaskRecurrence> frequencyDays) {
//		this.frequencyDays = frequencyDays;
//	}

	//public int getDueAtAnimalAge() {
		//return dueAtAnimalAge;
	//}

//	public void setDueAtAnimalAge(int dueAtAnimalAge) {
//		this.dueAtAnimalAge = dueAtAnimalAge;
//	}

}
