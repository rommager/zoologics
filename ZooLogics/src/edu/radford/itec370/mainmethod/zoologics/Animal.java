package edu.radford.itec370.mainmethod.zoologics;

import java.util.ArrayList;
import java.util.Date;

public class Animal implements Printable {

	private int id;
	private String name;
	private Species species;
	private char sex;
	private String sire;
	private String dam;
	private boolean identificationChip;
	private String chipId;
	private String breed;
	private Date dateOfBirth;
	private StringBuffer markings;
	private StringBuffer notes;
	private String thumbnail;
	private Photos photos;
	private ArrayList<Vaccination> vaccinations;

	public Animal() {
		super();
	}

	public Animal(int id, String name, Species species, char sex, String sire,
			String dam, boolean identificationChip, String chipId,
			String breed, Date dateOfBirth, String markings, String notes) {
		this();
		this.id = id;
		this.name = name;
		this.species = species;
		this.sex = sex;
		this.sire = sire;
		this.dam = dam;
		this.identificationChip = identificationChip;
		this.chipId = chipId;
		this.breed = breed;
		this.dateOfBirth = dateOfBirth;
		this.markings = new StringBuffer(markings);
		this.notes = new StringBuffer(notes);
	}

	public Animal(int id, String name, Species species, char sex, String sire,
			String dam, boolean identificationChip, String chipId,
			String breed, Date dateOfBirth, String markings, String notes,
			String thumbnail, Photos photos, ArrayList<Vaccination> vaccinations) {
		this(id, name, species, sex, sire, dam, identificationChip, chipId,
				breed, dateOfBirth, markings, notes);

		this.thumbnail = thumbnail;
		this.photos = photos;
		this.vaccinations = vaccinations;
	}

	public Animal(String name) {

	}

	public void add(Vaccine vaccine) {

	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getSire() {
		return sire;
	}

	public void setSire(String sire) {
		this.sire = sire;
	}

	public String getDam() {
		return dam;
	}

	public void setDam(String dam) {
		this.dam = dam;
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

	public StringBuffer getMarkings() {
		return markings;
	}

	public void setMarkings(StringBuffer markings) {
		this.markings = markings;
	}

	public StringBuffer getNotes() {
		return notes;
	}

	public void setNotes(StringBuffer notes) {
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
