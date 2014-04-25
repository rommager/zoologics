package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;

public class Vaccine implements Serializable {

	private static final long serialVersionUID = -4084693244451360926L;
	public static int idGenerator = 3001;
	private int vaccineID;
	private String vaccineName;

	public Vaccine() {
		super();
	}

	public Vaccine(int vaccineID, String vaccineName) {
		this();
		this.vaccineID = vaccineID;
		this.vaccineName = vaccineName;
	}
	
	public String toString() {
		return vaccineName;
	}

	public int getVaccineID() {
		return vaccineID;
	}

	public void setVaccineID(int vaccineID) {
		this.vaccineID = vaccineID;
		if (vaccineID >= idGenerator)
			idGenerator = vaccineID + 1;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

}
