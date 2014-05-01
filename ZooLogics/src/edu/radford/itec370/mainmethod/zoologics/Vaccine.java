package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;

public class Vaccine implements Serializable, DataIOable<Vaccine> {

	private static final long serialVersionUID = -4084693244451360926L;
	public static int vaccineIDCounter = 92001;
	private int vaccineID;
	private String vaccineName;

	public Vaccine() {
		super();
		vaccineID = vaccineIDCounter++;
	}

	public Vaccine(int vaccineID, String vaccineName) {
		super();
		setVaccineID(vaccineID);
		this.vaccineName = vaccineName;
	}
	
	public Object[] getVaccinePanelRow() {
		return new Object[] {vaccineID, this};
	}
	
	public String toString() {
		return vaccineName;
	}

	public int getVaccineID() {
		return vaccineID;
	}

	public void setVaccineID(int vaccineID) {
		this.vaccineID = vaccineID;
		if (vaccineID >= vaccineIDCounter)
			vaccineIDCounter = vaccineID + 1;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

}
