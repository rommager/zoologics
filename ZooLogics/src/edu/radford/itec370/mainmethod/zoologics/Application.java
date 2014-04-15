package edu.radford.itec370.mainmethod.zoologics;

import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import edu.radford.itec370.mainmethod.zoologics.gui.LogonDialog;

public class Application {
	private final static String APPLICATION_NAME = "ZooLogics";
	private final static String ICON_FILE = "z_icon.png";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	private ArrayList<Animal> animals;
	private TaskList taskList;
	private ArrayList<Vaccine> vaccines;
	private ArrayList<Species> species;
	private Staff currentUser;
	
	public Application()
	{
		super();
		animals = new ArrayList<Animal>();
		taskList = new TaskList();
		vaccines = new ArrayList<Vaccine>();
		species = new ArrayList<Species>();
		//currentUser = new Staff();
	}
	
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame(APPLICATION_NAME);
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );  // Set behavior to close program when GUI closed
		frame.setSize( 800, 600 );                               // set frame size
		frame.setLayout(new GridLayout(1, 1));                   // Use GridLayout with 2 rows and 2 columns
		frame.setIconImage(getAppIcon());
		frame.setVisible(true);
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
		Application newApp = new Application();
		
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
	
}
