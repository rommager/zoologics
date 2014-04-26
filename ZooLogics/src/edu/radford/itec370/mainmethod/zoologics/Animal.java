package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Graphics;
import java.awt.print.*;

public class Animal implements Printable, Serializable {

	private static final long serialVersionUID = 5761796477851733790L;
	private static int animalIDCounter = 2001;
	private int id;
	private String name;
	private Species species;
	private char sex;
	private String father;
	private String mother;
	private boolean identificationChip;
	private String chipId;
	private String breed;
	private Date dateOfBirth;
	private String markings;
	private String notes;
	private String thumbnail;
	private Photos photos;
	private ArrayList<Vaccination> vaccinations;

	public Animal() {
		super();
	}

	public Animal(int id, String name, Species species, char sex, String father,
			String mother, boolean identificationChip, String chipId,
			String breed, Date dateOfBirth, String markings, String notes) {
		this();
		this.id = id;
		this.name = name;
		this.species = species;
		this.sex = sex;
		this.father = father;
		this.mother = mother;
		this.identificationChip = identificationChip;
		this.chipId = chipId;
		this.breed = breed;
		this.dateOfBirth = dateOfBirth;
		this.markings = markings;
		this.notes = notes;
	}

	public Animal(int id, String name, Species species, char sex, String father,
			String mother, boolean identificationChip, String chipId,
			String breed, Date dateOfBirth, String markings, String notes,
			String thumbnail) {
		this(id, name, species, sex, father, mother, identificationChip, chipId,
				breed, dateOfBirth, markings, notes);

		this.thumbnail = thumbnail;
	}


	public Animal(String name) {

	}

	public void add(Vaccine vaccine) {

	}

	@Override
	public int print(Graphics arg0, PageFormat arg1, int arg2)
			throws PrinterException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNewIDNumber() {
		return animalIDCounter++;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		if (id >= animalIDCounter)
			animalIDCounter = id + 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public char getSex() {
		return sex;
	}
	
	public void Printable() {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable (this);
	}

	public void setSex(char sex) {
		sex = Character.toUpperCase(sex);
		if (sex == 'M' || sex == 'F')
			this.sex = sex;
		else
			throw new IllegalArgumentException();
	}

	public String getSire() {
		return father;
	}

	public void setSire(String sire) {
		this.father = sire;
	}

	public String getDam() {
		return mother;
	}

	public void setDam(String dam) {
		this.mother = dam;
	}

	public boolean isIdenficationChip() {
		return identificationChip;
	}

	public void setIdenficationChip(boolean identificationChip) {
		this.identificationChip = identificationChip;
	}

	public String getChipId() {
		return chipId;
	}

	public void setChipId(String chipId) {
		this.chipId = chipId;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMarkings() {
		return markings;
	}

	public void setMarkings(String markings) {
		this.markings = markings;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Photos getPhotos() {
		return photos;
	}

	public void setPhotos(Photos photos) {
		this.photos = photos;
	}

	public ArrayList<Vaccination> getVaccination() {
		return vaccinations;
	}

	public void setVaccination(ArrayList<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}

}
