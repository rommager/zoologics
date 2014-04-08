package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import edu.radford.itec370.mainmethod.zoologics.*;
import edu.radford.itec370.mainmethod.zoologics.gui.components.*;

public class LogonFrame extends JFrame {
	protected final static int WINDOW_WIDTH = 300;
	protected final static int WINDOW_HEIGHT = 180;
	protected final static String WINDOW_TITLE = Application.getAppName() + " Logon";
	//private Staff staff;
	
	public LogonFrame() 
	{
		super();
		this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setLayout(new GridBagLayout());
		this.setTitle(WINDOW_TITLE);
		this.setIconImage(Application.getAppIcon());
		this.setLocation(50, 50);
		
		
		JTextPane userNamePane = new AppTextBox();
		userNamePane.setPreferredSize(new Dimension(100,25));
		JTextPane passwordPane = new AppTextBox();
		passwordPane.setPreferredSize(new Dimension(100,25));
		
		this.add(new JLabel("User Name:"));
		this.add(userNamePane);
		this.add(new JLabel("Password:"));
		this.add(passwordPane);
		this.setVisible(true);
	}
	
}
