package edu.radford.itec370.mainmethod.zoologics;

import java.awt.Image;
import java.io.Serializable;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.radford.itec370.mainmethod.zoologics.gui.LogonDialog;
import edu.radford.itec370.mainmethod.zoologics.gui.MainScreen;

public class Application implements Runnable {

	private static final long serialVersionUID = -4947318641942709682L;
	private final static String APPLICATION_NAME = "ZooLogics";
	private final static String ICON_FILE = "z_icon.png";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"MM/dd/yyyy");
	
	// operating Application variables
	private Staff currentUser;
	
	// set up app data variables
	private ArrayList<Animal> animals;
	private ArrayList<Task> allActiveTasks;    // used to store all active tasks
	private ArrayList<Task> inactiveTasks;     // used to store all inactive tasks (completed or dismissed tasks)
	private ArrayList<Task> outstandingTasks;  // used to store all outstanding tasks (all active tasks with an upcoming due date) 
	
	// reference data variables
	private static StaffHive staffHive;
	private ArrayList<Vaccine> vaccines;
	private ArrayList<Species> species;
	private ArrayList<RecurrenceSchedule> recurrenceScheduleTemplates;
	private ArrayList<VaccinationSchedule> vaccinationScheduleTemplates;

	public Application(Staff authenticatedUser) {
		super();
		if (authenticatedUser.isUser()) {
			this.currentUser = authenticatedUser;
			animals = new ArrayList<Animal>();
			allActiveTasks = new ArrayList<Task>();
			inactiveTasks = new ArrayList<Task>();
			outstandingTasks = new ArrayList<Task>();
			
			vaccines = new ArrayList<Vaccine>();
			species = new ArrayList<Species>();
			recurrenceScheduleTemplates = new ArrayList<RecurrenceSchedule>();
			vaccinationScheduleTemplates = new ArrayList<VaccinationSchedule>();
		} 
		else
			System.exit(0);
	}

	public static void main(String[] args) {
		new LogonDialog();
	}
	
	@Override
	public void run() {
		loadDataFromIO();
		MainScreen gui = new MainScreen(this);
		gui.setVisible(true);
	}
	
	public void loadDataFromIO() {
		//TODO implement use of DataIO class
	}

	public Staff getCurrentUser() {
		return currentUser;
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
	
	public static String formatDateToString(Date dateIn) {
		return dateFormat.format(dateIn);
	}
		
	public static Date parseDate(String stringIn) {
		try {
			return dateFormat.parse(stringIn);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "'" + stringIn + "' is not a valid date.\n\nPlease try again", "Date Entry Error", JOptionPane.ERROR_MESSAGE);
		}
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

	public ArrayList<Task> getAllActiveTasks() {
		return allActiveTasks;
	}

	public void setAllActiveTasks(ArrayList<Task> allActiveTasks) {
		this.allActiveTasks = allActiveTasks;
	}

	public ArrayList<Task> getInactiveTasks() {
		return inactiveTasks;
	}

	public void setInactiveTasks(ArrayList<Task> inactiveTasks) {
		this.inactiveTasks = inactiveTasks;
	}

	public ArrayList<Task> getOutstandingTasks() {
		return outstandingTasks;
	}

	public void setOutstandingTasks(ArrayList<Task> outstandingTasks) {
		this.outstandingTasks = outstandingTasks;
	}

	public ArrayList<RecurrenceSchedule> getRecurrenceScheduleTemplates() {
		return recurrenceScheduleTemplates;
	}

	public void setRecurrenceScheduleTemplates(
			ArrayList<RecurrenceSchedule> recurrenceScheduleTemplates) {
		this.recurrenceScheduleTemplates = recurrenceScheduleTemplates;
	}

	public ArrayList<VaccinationSchedule> getVaccinationScheduleTemplates() {
		return vaccinationScheduleTemplates;
	}

	public void setVaccinationScheduleTemplates(
			ArrayList<VaccinationSchedule> vaccinationScheduleTemplates) {
		this.vaccinationScheduleTemplates = vaccinationScheduleTemplates;
	}

	public static StaffHive getStaffHive() {
		cacheStaffHive();
		if (staffHive.size() == 0) {
			Staff defaultStaff = new Staff("ZooLogics","ZooLogics","ZooLogics","master");
			defaultStaff.setPassword("master".toCharArray());
			staffHive.add(defaultStaff);
		}
		return staffHive;
	}
	
	private static void cacheStaffHive() {
		staffHive = new StaffHive();
		//TODO Read StaffHive from disk and populate into staffHive 
	}
}
