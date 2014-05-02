package edu.radford.itec370.mainmethod.zoologics;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import edu.radford.itec370.mainmethod.zoologics.gui.MainScreen;

public class Application implements Runnable {

	private final static String APPLICATION_NAME = "ZooLogics";
	private final static String ICON_FILE = "z_icon.png";
	private final static String VERSION = "0.4 alpha";
	public static final String DELIMITER = "|";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	private static Application application;

	// operating Application variables
	private Staff currentUser;

	// set up app data variables
	private ArrayList<Animal> animals;
	private ArrayList<Task> allActiveTasks;    // used to store all active tasks
	private ArrayList<Task> inactiveTasks;     // used to store all inactive tasks (completed or dismissed tasks)
	private ArrayList<Task> activeTasks;  // used to store all outstanding tasks (all active tasks with an upcoming due date) 

	// reference data variables
	private static StaffHive staffHive; 
	private ArrayList<Vaccine> vaccines;
	private ArrayList<Species> allSpecies;
	private ArrayList<RecurrenceSchedule> recurrenceScheduleTemplates;
	private ArrayList<VaccinationSchedule> vaccinationScheduleTemplates;

	public Application(Staff authenticatedUser) {
		super();
		if (authenticatedUser.isUser()) {
			this.currentUser = authenticatedUser;
			animals = new ArrayList<Animal>();
			allActiveTasks = new ArrayList<Task>();
			inactiveTasks = new ArrayList<Task>();
			activeTasks = new ArrayList<Task>();

			vaccines = new ArrayList<Vaccine>();
			allSpecies = new ArrayList<Species>();
			recurrenceScheduleTemplates = new ArrayList<RecurrenceSchedule>();
			vaccinationScheduleTemplates = new ArrayList<VaccinationSchedule>();
		} 
		else
			System.exit(0);
	}

	public static void main(String[] args) {
		//new LogonDialog();

		Staff authStaff = getStaffHive().findUser("master");
		Application app = new Application(authStaff);
		app.run();
	}

	@Override
	public void run() {
		Application.application = this;
		loadDataFromIO();
		MainScreen gui = new MainScreen(this);
		gui.setVisible(true);
	}

	public void loadDataFromIO() {
		//TODO implement use of DataIO class
		allSpecies = new DataIO<Species>("Species.dta").loadData(new Species(-1));
		vaccines = new DataIO<Vaccine>("Vaccines.dta").loadData(new Vaccine(-1));
		animals = new DataIO<Animal>("Animals.dta").loadData(new Animal(-1));
		activeTasks = new DataIO<Task>("ActiveTasks.dta").loadData(new Task(-1));
		activeTasks = new DataIO<Task>("InactiveTasks.dta").loadData(new Task(-1));
	}

	public void saveDataToIO() {
		// TODO add more of each DataIOable element
		new DataIO<Species>("Species.dta").saveData(allSpecies);
		new DataIO<Vaccine>("Vaccines.dta").saveData(vaccines);
		new DataIO<Animal>("Animals.dta").saveData(animals);
		new DataIO<Task>("Tasks.dta").saveData(activeTasks);
	}

	public Staff getCurrentUser() {
		return currentUser;
	}

	public static Image getAppImage() {
		return getAppIcon().getImage();
	}

	public static ImageIcon getAppIcon() {
		URL iconURL = Application.class.getResource(ICON_FILE);
		ImageIcon icon = new ImageIcon(iconURL);
		return icon;
	}

	public static String getAppName() {
		return APPLICATION_NAME;
	}

	//	public static Application generateTestData() {
	//		// Generate an Application class with user "master" as the app user
	//		Application newApp = new Application(new Staff(0, "master", "master", "master"));
	//
	//		Species s1 = new Species("Tiger");
	//
	//		Species s2 = new Species("Monkey");
	//		Species s3 = new Species("Zebra");
	//
	//		newApp.animals.add(new Animal(1001, "Puja", s1, 'M', "Simba", "", true,
	//				"A12343212", "", new Date(), "stripes",
	//				"Gentle, needs special attention"));
	//		newApp.animals.add(new Animal(1002, "Sir Rawr", s1, 'M', "Simba",
	//				"Puma", true, "A43212", "", new Date(), "spots", "Alpha"));
	//
	//		return newApp;
	//
	//	}

	public static String formatDateToString(Date dateIn) {
		return dateFormat.format(dateIn);
	}

	public static Date parseDate(String stringIn) throws ParseException {
		try {
			return dateFormat.parse(stringIn);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "'" + stringIn + "' is not a valid date.\n\nPlease try again", "Date Entry Error", JOptionPane.ERROR_MESSAGE);
			throw e;
		}		
	}

	public static Animal findAnimal(int id) {
		for(Animal animal : application.animals) {
			if (animal.getAnimalID() == id)
				return animal;
		}
		return null;
	}

	public static Task findActiveTask(int id) {
		for (Task task : application.allActiveTasks) {
			if (task.getTaskID() == id)
				return task;
		}
		return null;
	}

	public static Task findInactiveTask(int id) {
		for (Task task : application.inactiveTasks) {
			if (task.getTaskID() == id)
				return task;
		}
		return null;
	}

	public static Species findSpecies(int id) {
		if (application == null)
			System.out.println("App is null");
		if (application.getSpecies() == null)
			System.out.println("species is null");
		if (application.allSpecies.size() != 0) {
			for (Species species : application.allSpecies) {
				if (species.getSpeciesID() == id)
					return species;
			}
		}
		return null;
	}

	public static Species findSpeciesByName(String name) {
		for (Species species : application.allSpecies) {
			if (species.getSpeciesName().equalsIgnoreCase(name))
				return species;
		}
		Species species = new Species();
		species.setSpeciesName(name);
		application.allSpecies.add(species);
		return species;
	}
	
	public String[] getVaccineOptions() {
		String[] out = new String[vaccines.size()];
		int index = 0;
		for (Vaccine vacc : vaccines) {
			out[index] = vacc.getVaccineName();
			index++;
		}
		return out;
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
		return allSpecies;
	}

	public void setSpecies(ArrayList<Species> species) {
		this.allSpecies = species;
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
		return activeTasks;
	}

	public void setOutstandingTasks(ArrayList<Task> outstandingTasks) {
		this.activeTasks = outstandingTasks;
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

	public static String getVersion() {
		return VERSION;
	}

	public static Application getRunningInstance() {
		return application;
	}

	public static URL getLocalFilePath(String path, String filename) {
		URL jarLocation = Application.class.getProtectionDomain().getCodeSource().getLocation();
		URL outputURL = null;
		try {
			outputURL = new URL(jarLocation, path + filename);
		} catch (MalformedURLException e) {
			// do nothing
		}
		return outputURL;
	}

	public static File getFile(String path, String filename) {
		URL url = getLocalFilePath(path, filename);

		return(getFile(url));
	}

	public static File getFile(URL url) {
		File newFile;
		String decoded = "";

		try {
			decoded = URLDecoder.decode(url.getPath(), "UTF-8");
		} catch (UnsupportedEncodingException e) { }

		newFile = new File(decoded);
		return newFile;
	}

	public static boolean copyFile(File source, File dest) {
		try {
			if(!dest.exists()) {
				dest.createNewFile();
			}
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new FileInputStream(source);
				out = new FileOutputStream(dest);

				// Transfer bytes from in to out
				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
			}
			finally {
				if(in != null) {
					in.close();
				}
				if(out != null) {
					out.close();
				}
			}
		}
		catch (IOException e) {
			return false;
		}
		return true;
	}
}
