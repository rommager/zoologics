package edu.radford.itec370.mainmethod.zoologics;

import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import edu.radford.itec370.mainmethod.zoologics.gui.LogonFrame;

public class Application {
	private final static String APPLICATION_NAME = "ZooLogics";
	private final static String ICON_FILE = "z_icon.png";
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	private ArrayList<TaskList> taskList = new ArrayList<TaskList>();
	private ArrayList<Vaccine> vaccines = new ArrayList<Vaccine>();
	private ArrayList<Species> species = new ArrayList<Species>();
	private Staff currentUser;
	
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
		LogonFrame logon = new LogonFrame();
		return null;
	}
	
	
	public static Staff getCurrentUser() 
	{
		return null;
	}
	
	public static Image getAppIcon()
	{
		URL icon = Application.class.getResource(ICON_FILE);
		Image icon2 = new ImageIcon(icon).getImage();
		return icon2;
	}
	
	public static String getAppName()
	{
		return APPLICATION_NAME;
	}
}
