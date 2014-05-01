package edu.radford.itec370.mainmethod.zoologics;

import java.util.ArrayList;

/**
 * @author Sean
 * The Species class is used as an object to describe the species of the animal.
 * It consists of a collection of Vaccines, and 
 */
public class Species implements DataIOable<Species> {
	private static int speciesIDCounter = 91001;
	private int speciesID;
	private String speciesName;
	private ArrayList<VaccinationSchedule> vaccinationSchedule = new ArrayList<VaccinationSchedule>();
	private ArrayList<Species> parentList;

	// constructors
	public Species() {
		super();
		speciesID = speciesIDCounter++;
	}

	public Species(String speciesName) {
		this();
		this.speciesName = speciesName;
	}
	
	public Species(int speciesID, String speciesName) {
		super();
		setSpeciesID(speciesID);
		this.speciesName = speciesName;
	}
	public Species getNewInstanceFromIO(String ioString) {
		return new Species(ioString);
	}
	
	@Override
	public String getIOLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(speciesIDCounter); sb.append("|");
		sb.append(parentList); sb.append("|");
		sb.append(speciesID); sb.append("|");
		sb.append(speciesName); sb.append("|");
		sb.append(vaccinationSchedule); sb.append("|");

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
		return vaccinationSchedule;
	}

	public void setVaccinationSchedule(ArrayList<VaccinationSchedule> vaccinationSchedule) {
		this.vaccinationSchedule = vaccinationSchedule;
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
