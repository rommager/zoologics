package edu.radford.itec370.mainmethod.zoologics.gui;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;

public class MainScreenNavBar extends JPanel {
	private Navigable parentGUI;
	private boolean showRecordNavigator;
	private boolean showSearchBox;
	private JLabel lblDateTime;
	private JLabel lblNeedToAdd;
	

	MainScreenNavBar() {
		super();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {345, 160};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		lblNeedToAdd = new JLabel("Need to add TaskRecurrence");
		panel.add(lblNeedToAdd);
		
		JPanel datePanel = new JPanel();
		GridBagConstraints gbc_datePanel = new GridBagConstraints();
		gbc_datePanel.insets = new Insets(0, 0, 0, 5);
		gbc_datePanel.fill = GridBagConstraints.BOTH;
		gbc_datePanel.gridx = 1;
		gbc_datePanel.gridy = 0;
		add(datePanel, gbc_datePanel);
		datePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblDateTime = new JLabel("Time");
		lblDateTime.setHorizontalAlignment(SwingConstants.RIGHT);
		datePanel.add(lblDateTime);
		refresh();
	}
	
	public MainScreenNavBar(Navigable parentGUI){
		this();
		this.parentGUI = parentGUI;
	}
		
	public void refresh() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy h:mm a");
		Date now = new Date();
		lblDateTime.setText(sdf.format(now));
	}

	public Navigable getParentGUI() {
		return parentGUI;
	}

	public void setParentGUI(Navigable parentGUI) {
		this.parentGUI = parentGUI;
	}

}
