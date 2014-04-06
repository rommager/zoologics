package edu.radford.itec370.mainmethod.zoologic;

import java.util.ArrayList;
import java.util.Date;


public class Animal implements Printable {

	private int id;
	private String name;
	private Species species;
	private char sex;
	private String sire;
	private String dame;
	private boolean idenficationChip;
	private String chipId;
	private String breed;
	private Date dateOfBirth;
	private StringBuffer markings;
	private StringBuffer notes;
	private String thumbnail;
	private Photos photos;
	private ArrayList<Vaccination> vaccination;

public Animal() {
	
}

public Animal(String name){
	
}

public void add(Vaccine vaccine){
	
	
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

public String getDame() {
	return dame;
}

public void setDame(String dame) {
	this.dame = dame;
}

public boolean isIdenficationChip() {
	return idenficationChip;
}

public void setIdenficationChip(boolean idenficationChip) {
	this.idenficationChip = idenficationChip;
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
	return vaccination;
}

public void setVaccination(ArrayList<Vaccination> vaccination) {
	this.vaccination = vaccination;
}



}
