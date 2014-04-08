package edu.radford.itec370.mainmethod.zoologics.gui.components;

import java.awt.Dimension;

import javax.swing.JTextPane;

public class AppTextBox extends JTextPane 
{
	public AppTextBox()
	{
		super();
		this.setPreferredSize(new Dimension(100,20));
		this.setMinimumSize(new Dimension(50,20));
		this.setMaximumSize(new Dimension(200,20));
		
	}
	
	public AppTextBox(String defaultText)
	{
		this();
		this.setText(defaultText);
	}
}
