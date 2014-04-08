package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.Dimension;

import javax.swing.JTextPane;

public class zTextBox extends JTextPane 
{
	public zTextBox()
	{
		super();
		this.setPreferredSize(new Dimension(100,20));
		this.setMinimumSize(new Dimension(50,20));
		this.setMaximumSize(new Dimension(200,20));
		
	}
	
	public zTextBox(String defaultText)
	{
		this();
		this.setText(defaultText);
	}
}
