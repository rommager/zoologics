package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;

import javax.print.attribute.HashPrintRequestAttributeSet;

import edu.radford.itec370.mainmethod.zoologics.gui.Filterable;

public class Animal implements Printable, Serializable, Filterable {

	// Constants and static counters
	private static final long serialVersionUID = 5761796477851733790L;
	private static int animalIDCounter = 20001;

	// Class variables
	private int animalID;
	private String name;
	private Species species;
	private char sex;
	private String father;
	private String mother;
	private boolean identificationChip;
	private String chipID;
	private String breed;
	private Date dateOfBirth;
	private String markings;
	private String notes;
	private String thumbnail;
	
	// Collections
	private ArrayList<Task> activeTasks;
	private ArrayList<Task> completedTasks;
	private ArrayList<Photo> photos;

	// constructors
	public Animal() {
		super();
		this.animalID = animalIDCounter++;
	}

	// full constructor
	public Animal(int animalID, String name, Species species, char sex, String father,
			String mother, boolean identificationChip, String chipId,
			String breed, Date dateOfBirth, String markings, String notes) {
		super();
		setAnimalID(animalID);
		this.name = name;
		this.species = species;
		this.sex = sex;
		this.father = father;
		this.mother = mother;
		this.identificationChip = identificationChip;
		this.chipID = chipId;
		this.breed = breed;
		this.dateOfBirth = dateOfBirth;
		this.markings = markings;
		this.notes = notes;
	}

	public Animal(int animalID, String name, Species species, char sex, String father,
			String mother, boolean identificationChip, String chipId,
			String breed, Date dateOfBirth, String markings, String notes,
			String thumbnail) {
		this(animalID, name, species, sex, father, mother, identificationChip, chipId,
				breed, dateOfBirth, markings, notes);

		this.thumbnail = thumbnail;
	}
	
	// IO constructor
	public Animal(String lineIO) {
		super();
		StringTokenizer st = new StringTokenizer(lineIO, Application.DELIMITER);
		setAnimalID(Integer.parseInt(st.nextToken()));
		name = st.nextToken();
		
	}


	public static void main(String[] args) {
		Animal animal = new Animal(2001, "Puja", new Species("Feline"), 'M', "Simba", "", true, "A12343212", "Orange Tiger", new Date(), "Orange with stripes", "Gentle, needs special attention","tiger.jpg");
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(animal);
		HashPrintRequestAttributeSet att = new HashPrintRequestAttributeSet();
		
	
		PrintPreview preview = new PrintPreview(animal, job.getPageFormat(att));
	
	}
	
	public String getIOLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(animalID); sb.append("|");
		sb.append(name); sb.append("|");
		sb.append(species.getSpeciesID()); sb.append("|");
		sb.append(sex); sb.append("|");
		sb.append(father); sb.append("|");
		sb.append(mother); sb.append("|");
		sb.append(identificationChip); sb.append("|");
		sb.append(breed); sb.append("|");
		sb.append(dateOfBirth); sb.append("|");
		sb.append(markings); sb.append("|");
		sb.append(notes); sb.append("|");
		
		return sb.toString();
		
// example output:		Puja|23400|M|3276|4358  (except it contains all the fields
	}

	@Override
	public int print(Graphics g, PageFormat pf, int page)
			throws PrinterException {

		// We have only one page, and 'page'
		// is zero-based
		if (page > 0) {
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D)g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());

		// Now we perform our rendering
		g.drawString(getName(), 100, 100);
		g.drawString(getSpecies().getSpeciesName(), 200, 100);


		// tell the caller that this page is part
		// of the printed document
		return PAGE_EXISTS;
	}

	@Override
	public boolean isVisibleWithFilter(String filter) {
		if (filter.isEmpty() || filter == null)
			return true;
		if (name != null) {
			if (name.toUpperCase().indexOf(filter) >= 0)
				return true;
		}
		if (species != null) {
			if (species.getSpeciesName().toUpperCase().indexOf(filter) >= 0)
				return true;
		}
		if (breed != null) {
			if (breed.toUpperCase().indexOf(filter) >= 0)
				return true;
		}
		return false;
	}

	public int getAnimalID() {
		return animalID;
	}

	public void setAnimalID(int animalID) {
		this.animalID = animalID;
		if (animalID >= animalIDCounter)
			animalIDCounter = animalID + 1;
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
			throw new IllegalArgumentException("Animal sex must be either M or F.");
	}

	public String getFather() {
		return father;
	}

	public void setFather(String sire) {
		this.father = sire;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String dam) {
		this.mother = dam;
	}

	public boolean isIdenficationChip() {
		return identificationChip;
	}

	public void setIdenficationChip(boolean identificationChip) {
		this.identificationChip = identificationChip;
	}

	public String getChipId() {
		return chipID;
	}

	public void setChipId(String chipId) {
		this.chipID = chipId;
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

	public ArrayList<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(ArrayList<Photo> photos) {
		this.photos = photos;
	}

	public ArrayList<Task> getActiveTasks() {
		return activeTasks;
	}

	public void setActiveTasks(ArrayList<Task> tasks) {
		this.activeTasks = tasks;
	}

	public ArrayList<Task> getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(ArrayList<Task> completedTasks) {
		this.completedTasks = completedTasks;
	}

}
