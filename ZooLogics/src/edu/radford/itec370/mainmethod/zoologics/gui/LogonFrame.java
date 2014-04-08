package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import edu.radford.itec370.mainmethod.zoologic.Application;

public class LogonFrame extends JFrame {
	protected final static int WINDOW_WIDTH = 300;
	protected final static int WINDOW_HEIGHT = 180;
	protected final static String ICON_FILE = "z_icon.png";
	protected final static String WINDOW_TITLE = Application.APPLICATION_NAME + " Logon";
	//private Staff staff;
	
	public LogonFrame() 
	{
		super();
		this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setLayout(new GridLayout(3,2));
		this.setTitle(WINDOW_TITLE);
		
		URL icon = Object.class.getResource(ICON_FILE);
		//Image icon2 = new ImageIcon(icon).getImage();
		//this.setIconImage(icon2);
		
		JTextPane userNamePane = new JTextPane();
		userNamePane.setPreferredSize(new Dimension(100,25));
		JTextPane passwordPane = new JTextPane();
		passwordPane.setPreferredSize(new Dimension(100,25));
		
		this.add(new JLabel("User Name:"));
		this.add(userNamePane);
		this.add(new JLabel("Password:"));
		this.add(passwordPane);
		this.setVisible(true);
	}
	
}
