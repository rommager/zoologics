package edu.radford.itec370.mainmethod.zoologics;

import java.util.StringTokenizer;

public class Vaccine implements DataIOable<Vaccine> {

	public static int vaccineIDCounter = 92001;
	private int vaccineID;
	private String vaccineName;

	public Vaccine() {
		super();
		vaccineID = vaccineIDCounter++;
	}

	public Vaccine(int id) {
		super();
		this.vaccineID = id;
	}
	
	public Vaccine(int vaccineID, String vaccineName) {
		super();
		setVaccineID(vaccineID);
		this.vaccineName = vaccineName;
	}
	
	public Vaccine(String ioString){
		StringTokenizer st = new StringTokenizer(ioString, Application.DELIMITER);
		setVaccineID(Integer.parseInt(st.nextToken()));
		vaccineName = st.nextToken();
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

	@Override
	public Vaccine getNewInstanceFromIO(String ioString) {
		return new Vaccine(ioString);
	}

	@Override
	public String getIOLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(vaccineID); sb.append("|");
		sb.append(vaccineName); sb.append("|");
		return sb.toString(); 
	}

}
