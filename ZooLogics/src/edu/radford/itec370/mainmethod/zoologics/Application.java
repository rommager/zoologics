package edu.radford.itec370.mainmethod.zoologics;

import java.awt.Image;
import java.io.Serializable;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import edu.radford.itec370.mainmethod.zoologics.gui.LogonDialog;
import edu.radford.itec370.mainmethod.zoologics.gui.MainScreen;

public class Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4947318641942709682L;
	private final static String APPLICATION_NAME = "ZooLogics";
	private final static String ICON_FILE = "z_icon.png";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	private static StaffHive staffHive;
	private ArrayList<Animal> animals;
	private TaskList taskList;
	private TaskList inactiveTasks;
	private ArrayList<Vaccine> vaccines;
	private ArrayList<Species> species;
	private Staff currentUser;
	
	public Application(Staff user)
	{
		super();
		if (user.isUser()) {
			animals = new ArrayList<Animal>();
			taskList = new TaskList();
			vaccines = new ArrayList<Vaccine>();
			species = new ArrayList<Species>();
			this.currentUser = user;
		}
		else
			System.exit(0);
	}
	
	public static void main(String[] args) 
	{
		MainScreen appFrame = new MainScreen(APPLICATION_NAME);
		
		appFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );  // Set behavior to close program when GUI closed
		appFrame.setSize( 800, 600 );                               // set frame size
		appFrame.setIconImage(getAppIcon());
		appFrame.setVisible(true);
		displayLogon();
	}

	public static Application displayLogon() 
	{
		LogonDialog logon = new LogonDialog();
		return null;
	}
	
	
	public static Staff getCurrentUser() 
	{
		return null;
	}
	
	public static Image getAppIcon()
	{
		URL iconURL = Application.class.getResource(ICON_FILE);
		Image icon = new ImageIcon(iconURL).getImage();
		return icon;
	}
	
	public static String getAppName()
	{
		return APPLICATION_NAME;
	}
	
	public static Application generateTestData()
	{
		Application newApp = new Application(new Staff("master","master"));
		
		Species s1 = new Species("Tiger");
		Species s2 = new Species("Monkey");
		Species s3 = new Species("Zebra");
		
		newApp.animals.add(new Animal(1001, "Puja", s1, 'M', "Simba", "", true, "A12343212", "", new Date(), "stripes", "Gentle, needs special attention"));
		newApp.animals.add(new Animal(1002, "Sir Rawr", s1, 'M', "Simba", "Puma", true, "A43212", "", new Date(), "spots", "Alpha"));
		
		
		
		return newApp;
		
	}
	
	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}

	public TaskList getTaskList() {
		return taskList;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
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
