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
import java.text.SimpleDateFormat;
import java.util.Date;

public class NavigatorBar extends JPanel {
	private Navigable parentGUI;
	private boolean showRecordNavigator;
	private boolean showSearchBox;
	private JTextField textField;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnNew;
	private JLabel lblDateTime;
	

	private NavigatorBar() {
		super();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {120, 120};
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
		
		btnFirst = new JButton("[<");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentGUI.firstRecord();
			}
		});
		panel.add(btnFirst);
		
		btnPrevious = new JButton("<");
		panel.add(btnPrevious);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		btnNext = new JButton(">");
		panel.add(btnNext);
		
		btnLast = new JButton(">]");
		panel.add(btnLast);
		
		btnNew = new JButton(">]*");
		panel.add(btnNew);
		
		JPanel datePanel = new JPanel();
		GridBagConstraints gbc_datePanel = new GridBagConstraints();
		gbc_datePanel.insets = new Insets(0, 0, 0, 5);
		gbc_datePanel.fill = GridBagConstraints.BOTH;
		gbc_datePanel.gridx = 1;
		gbc_datePanel.gridy = 0;
		add(datePanel, gbc_datePanel);
		datePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblDateTime = new JLabel("Time");
		datePanel.add(lblDateTime);
		refresh();
	}
	
	public NavigatorBar(Navigable parentGUI){
		this();
		this.parentGUI = parentGUI;
	}
		
	public void refresh() {
		SimpleDateFormat sdb = new SimpleDateFormat("MM/dd/yyyy hh:mm");
		Date now = new Date();
		lblDateTime.setText(sdb.format(now));
	}

	public Navigable getParentGUI() {
		return parentGUI;
	}

	public void setParentGUI(Navigable parentGUI) {
		this.parentGUI = parentGUI;
	}

	public boolean isShowRecordNavigator() {
		return showRecordNavigator;
	}

	public void setShowRecordNavigator(boolean showRecordNavigator) {
		this.showRecordNavigator = showRecordNavigator;
	}

	public boolean isShowSearchBox() {
		return showSearchBox;
	}

	public void setShowSearchBox(boolean showSearchBox) {
		this.showSearchBox = showSearchBox;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

}
