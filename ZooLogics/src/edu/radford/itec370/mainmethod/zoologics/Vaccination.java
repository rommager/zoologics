package edu.radford.itec370.mainmethod.zoologics;

import java.util.Date;

public class Vaccination {

	private String vaccineName;
	private String dosage;
	private Date dateAdministered;
	private Staff administeredBy;
	
	public Vaccination() {
		super();
	}
	
	public Vaccination(String vaccineName, String dosage,
			Date dateAdministered, Staff administeredBy) {
		this();
		this.vaccineName = vaccineName;
		this.dosage = dosage;
		this.dateAdministered = dateAdministered;
		this.administeredBy = administeredBy;
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

	public Date getDateAdministered() {
		return dateAdministered;
	}

	public void setDateAdministered(Date dateAdministered) {
		this.dateAdministered = dateAdministered;
	}

	public Staff getAdministeredBy() {
		return administeredBy;
	}

	public void setAdministeredBy(Staff administeredBy) {
		this.administeredBy = administeredBy;
	}
	
}
