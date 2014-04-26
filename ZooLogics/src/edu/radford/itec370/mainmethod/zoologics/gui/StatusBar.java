package edu.radford.itec370.mainmethod.zoologics.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;

public class StatusBar extends JPanel {
	private static final long serialVersionUID = -4182515365061614761L;
	
	private JLabel lblDateTime;
	private JLabel lblStatus;
	
	public StatusBar() {
		super();
		this.setPreferredSize(new Dimension(400,25));
		setLayout(new BorderLayout());
		
		JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblStatus = new JLabel("Status");
		leftPanel.add(lblStatus);
		add(leftPanel,BorderLayout.WEST);
		
		JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		lblDateTime = new JLabel("DateTime");
		lblDateTime.setHorizontalAlignment(SwingConstants.RIGHT);
		rightPanel.add(lblDateTime);
		add(rightPanel,BorderLayout.EAST);
		
		refresh();
	}
	
	public StatusBar(String statusBarText) {
		this();
		setStatusBarText(statusBarText);
	}
	
	public void refresh() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy h:mm a");
		Date now = new Date();
		lblDateTime.setText(sdf.format(now));
	}
	
	public String getStatusBarText() {
		return lblStatus.getText();
	}
	
	public void setStatusBarText(String statusBarText) {
		lblStatus.setText(statusBarText);
	}
	
}
