package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

import edu.radford.itec370.mainmethod.zoologics.*;
import edu.radford.itec370.mainmethod.zoologics.gui.components.*;

public class LogonDialog extends JDialog {
	protected final static int WINDOW_WIDTH = 300;
	protected final static int WINDOW_HEIGHT = 180;
	protected final static String WINDOW_TITLE = Application.getAppName() + " Logon";
	//private Staff staff;
	
	public LogonDialog() 
	{
		super();
		this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setLayout(new GridBagLayout());
		this.setTitle(WINDOW_TITLE);
		this.setIconImage(Application.getAppIcon());
		this.setLocation(50, 50);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		
		
		
		AppTextBox userNamePane = new AppTextBox();
		AppTextBox passwordPane = new AppTextBox();
		
		
		this.add(new JLabel("User Name:"));
		this.add(userNamePane);
		this.add(new JLabel("Password:"));
		this.add(passwordPane);
		this.setVisible(true);
	}
	
}
