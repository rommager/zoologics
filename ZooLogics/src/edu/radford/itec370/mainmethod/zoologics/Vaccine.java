package edu.radford.itec370.mainmethod.zoologics;

public class Vaccine {

	private String vaccineID;
	private String vaccineName;
	private String dosage;

	public String getVaccineID() {
		return vaccineID;
	}

	public Vaccine() {
		super();
	}

	public Vaccine(String vaccineID, String vaccineName, String dosage) {
		super();
		this.vaccineID = vaccineID;
		this.vaccineName = vaccineName;
		this.dosage = dosage;
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

}
