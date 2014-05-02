package edu.radford.itec370.mainmethod.zoologics;


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
	
	public Vaccine(String[] io){
		setVaccineID(Integer.parseInt(io[0]));
		vaccineName = io[1];
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
	public Vaccine getNewInstanceFromIO(String[] io) {
		return new Vaccine(io);
	}

	@Override
	public String getIOLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(vaccineID); sb.append("|");
		sb.append(vaccineName); sb.append("|");
		return sb.toString(); 
	}

}
