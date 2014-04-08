package edu.radford.itec370.mainmethod.zoologic;

import java.awt.Dimension;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class LogonFrame extends JFrame {
	protected final static int WINDOW_WIDTH = 300;
	protected final static int WINDOW_HEIGHT = 180;
	protected final static String ICON_FILE = "z_icon.png";
	//private Staff staff;
	
	public LogonFrame() 
	{
		super();
		this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setLayout(new AppLayout());
		
		URL icon = Object.class.getResource(ICON_FILE);
		//this.setIconImage(new ImageIcon(icon).getImage());
		
		this.add(new JLabel("User Name:"));
		this.add(new JTextPane());
		this.add(new JLabel("Password:"));
		this.add(new JTextPane());
		this.setVisible(true);
	}
	
}
