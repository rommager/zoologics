package edu.radford.itec370.mainmethod.zoologics;

import java.util.ArrayList;

public class Species {
	private String speciesName;
	private ArrayList<Vaccine> vaccineIdCollection = new ArrayList<Vaccine>();

	public Species() {
		super();
	}
	
	public Species(String speciesName) {
		this();
		this.speciesName = speciesName;
	}
	public String getSpeciesName() {
		return speciesName;
	}
	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}
	public ArrayList<Vaccine> getVaccineIdCollection() {
		return vaccineIdCollection;
	}
	public void setVaccineIdCollection(ArrayList<Vaccine> vaccineIdCollection) {
		this.vaccineIdCollection = vaccineIdCollection;
	}
	
	
}
