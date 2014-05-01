package edu.radford.itec370.mainmethod.zoologics;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Species implements DataIOable<Species> {
	private static int speciesIDCounter = 91001;
	private int speciesID;
	private String speciesName;
	private ArrayList<VaccinationSchedule> vaccinationSchedules = new ArrayList<VaccinationSchedule>();
	private ArrayList<Species> parentList;

	// constructors
	public Species() {
		super();
		this.speciesID = speciesIDCounter++;
	}
	
	public Species(int id) {
		super();
		this.speciesID = id;
	}

	public Species(int speciesID, String speciesName) {
		super();
		setSpeciesID(speciesID);
		this.speciesName = speciesName;
	}
	
	public Species(String ioString) {
		super();
		
		StringTokenizer st = new StringTokenizer(ioString,Application.DELIMITER);
		setSpeciesID(Integer.parseInt(st.nextToken()));
		speciesName = st.nextToken();
	}
	
	public Species getNewInstanceFromIO(String ioString) {
		return new Species(ioString);
	}
	
	@Override
	public String getIOLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(speciesID); sb.append("|");
		sb.append(speciesName); sb.append("|");
		//sb.append(vaccinationSchedules.getVaccinationScheduleID()); sb.append("|");
		return sb.toString();
	}
	// methods
	
		
	// setters and getters
	public String getSpeciesName() {
		return speciesName;
	}
	
	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}
	
	public ArrayList<VaccinationSchedule> getVaccinationSchedule() {
		return vaccinationSchedules;
	}

	public void setVaccinationSchedule(ArrayList<VaccinationSchedule> vaccinationSchedule) {
		this.vaccinationSchedules = vaccinationSchedule;
	}

	public int getSpeciesID() {
		return speciesID;
	}

	public void setSpeciesID(int speciesID) {
		this.speciesID = speciesID;
		if (speciesID >= speciesIDCounter)
			speciesIDCounter = speciesID + 1;
	}

	public ArrayList<Species> getParentList() {
		return parentList;
	}

	public void setParentList(ArrayList<Species> parentList) {
		this.parentList = parentList;
	}
	
}
