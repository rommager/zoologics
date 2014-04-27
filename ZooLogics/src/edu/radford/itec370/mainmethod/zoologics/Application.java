package edu.radford.itec370.mainmethod.zoologics;

import java.awt.Image;
import java.io.Serializable;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.radford.itec370.mainmethod.zoologics.gui.LogonDialog;
import edu.radford.itec370.mainmethod.zoologics.gui.MainScreen;

public class Application implements Serializable {

	private static final long serialVersionUID = -4947318641942709682L;
	private final static String APPLICATION_NAME = "ZooLogics";
	private final static String ICON_FILE = "z_icon.png";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"MM/dd/yyyy");
	
	// set up app data variables
	private ArrayList<Animal> animals;
	private ArrayList<Task> allActiveTasks;
	private ArrayList<Task> inactiveTasks;
	private ArrayList<Task> outstandingTasks;
	
	// reference data variables
	private static StaffHive staffHive;
	private ArrayList<Vaccine> vaccines;
	private ArrayList<RecurrenceSchedule> schedules;
	private ArrayList<Species> species;
	private ArrayList<VaccinationSchedule> vaccinationSchedule;
	
	private Staff currentUser;

	public Application(Staff user) {
		super();
		if (user.isUser()) {
			animals = new ArrayList<Animal>();
			allActiveTasks = new ArrayList<Task>();
			inactiveTasks = new ArrayList<Task>();
			outstandingTasks = new ArrayList<Task>();
			
			vaccines = new ArrayList<Vaccine>();
			schedules = new ArrayList<RecurrenceSchedule>();
			species = new ArrayList<Species>();
			
			this.currentUser = user;
		} else
			System.exit(0);
	}

	public static void main(String[] args) {
		MainScreen appFrame = new MainScreen(APPLICATION_NAME);

		// Set behavior to close program when GUI closed
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		appFrame.setSize(800, 600); // set frame size
		appFrame.setIconImage(getAppIcon());
		appFrame.setVisible(true);
		displayLogon();
	}

	public static Application displayLogon() {
		LogonDialog logon = new LogonDialog();
		return null;
	}

	public static Staff getCurrentUser() {
		return null;
	}

	public static Image getAppIcon() {
		URL iconURL = Application.class.getResource(ICON_FILE);
		Image icon = new ImageIcon(iconURL).getImage();
		return icon;
	}

	public static String getAppName() {
		return APPLICATION_NAME;
	}

	public static Application generateTestData() {
		// Generate an Application class with user "master" as the app user
		Application newApp = new Application(new Staff(0, "master", "master", "master"));

		Species s1 = new Species("Tiger");
		Species s2 = new Species("Monkey");
		Species s3 = new Species("Zebra");

		newApp.animals.add(new Animal(1001, "Puja", s1, 'M', "Simba", "", true,
				"A12343212", "", new Date(), "stripes",
				"Gentle, needs special attention"));
		newApp.animals.add(new Animal(1002, "Sir Rawr", s1, 'M', "Simba",
				"Puma", true, "A43212", "", new Date(), "spots", "Alpha"));

		return newApp;

	}
	
	public static String formatDate(Date dateIn) {
		return dateFormat.format(dateIn);
	}
	
	public static String formatDate(Calendar dateIn) {
		return formatDate(dateIn.getTime());
	}
	
	public static Date parseDate(String stringIn) {
		try {
			return dateFormat.parse(stringIn);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "'" + stringIn + "' is not a valid date.\n\nPlease try again", "Date Entry Error", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public static Calendar parseCalendar(String stringIn) {
		Date date = parseDate(stringIn);
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		}
		else
			return null;
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}

	public ArrayList<Vaccine> getVaccines() {
		return vaccines;
	}

	public void setVaccines(ArrayList<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}

	public ArrayList<Species> getSpecies() {
		return species;
	}

	public void setSpecies(ArrayList<Species> species) {
		this.species = species;
	}

	public void setCurrentUser(Staff currentUser) {
		this.currentUser = currentUser;
	}

	public static SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public static void setDateFormat(SimpleDateFormat inDateFormat) {
		dateFormat = inDateFormat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
