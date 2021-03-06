package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;

import edu.radford.itec370.mainmethod.zoologics.gui.Filterable;

public class Animal implements Printable, Serializable, Filterable, DataIOable<Animal> {

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

	public Animal(int id) {
		super();
		this.animalID = id;
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
	public Animal(String[] str) {
		super();
		setAnimalID(Integer.parseInt(str[0]));
		name = str[1];
		try {species = Application.findSpecies(Integer.parseInt(str[2]));}
		catch (NumberFormatException e) {species = null;}
		sex = str[3].toCharArray()[0];
		father = str[4];
		mother = str[5];
		identificationChip = str[6].equals("true");
		breed = str[7];
		try {dateOfBirth = Application.parseDate(str[8]);} 
		catch (ParseException e) {dateOfBirth = null;}
		markings = str[9];
		notes = str[10];
		thumbnail = str[11];
		chipID = str[12];
	}

	@Override
	public Animal getNewInstanceFromIO(String[] ioString) {
		return new Animal(ioString);
	}

	@Override
	public String getIOLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(animalID).append(Application.DELIMITER);  // 0
		sb.append(name).append(Application.DELIMITER);  // 1
		if (species != null)
			sb.append(species.getSpeciesID()).append(Application.DELIMITER);  // 2
		else
			sb.append(Application.DELIMITER);  // 2
		sb.append(sex).append(Application.DELIMITER);  // 3
		sb.append(father).append(Application.DELIMITER);  // 4
		sb.append(mother).append(Application.DELIMITER);  // 5
		sb.append(identificationChip).append(Application.DELIMITER);  // 6
		sb.append(breed).append(Application.DELIMITER);  // 7
		sb.append(Application.formatDateToString(dateOfBirth)).append(Application.DELIMITER);  // 8
		sb.append(markings).append(Application.DELIMITER);  // 9
		sb.append(notes).append(Application.DELIMITER);  // 10
		sb.append(thumbnail).append(Application.DELIMITER);  // 11
		sb.append(chipID).append(Application.DELIMITER);  // 12
		return sb.toString();
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
