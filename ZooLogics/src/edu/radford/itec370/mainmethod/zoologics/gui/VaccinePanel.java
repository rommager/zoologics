package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Vaccine;

public class VaccinePanel extends JFrame implements ActionListener {

	private static final long serialVersionUID = -3966249468484312613L; 
	private static final String[] COLUMN_NAMES = new String[] {"VaccineID","Vaccine Name"};
	private ArrayList<Vaccine> vaccines;
	private int index = 0;
	
	DefaultTableModel model;
	JTable table;
	
	public static void main(String[] args) {
		ArrayList<Vaccine> vaccines = new ArrayList<Vaccine>();
		vaccines.add(new Vaccine(92001, "Ivomec"));
		vaccines.add(new Vaccine(92002, "Rabies"));
		vaccines.add(new Vaccine(92003, "Dewormer"));

		VaccinePanel panel = new VaccinePanel(vaccines);
		panel.setVisible(true);
		panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private VaccinePanel() {
		super();
	}
	
	public VaccinePanel(ArrayList<Vaccine> vaccines) {
		this();
		this.vaccines = vaccines;
		buildGUI();
		refreshGUI();
	}
	
	public void buildGUI() {
		// set up JFrame
		setIconImage(Application.getAppImage());
		setTitle(Application.getAppName() + " - Vaccines");
		this.setSize(new Dimension(640, 480));
		getContentPane().setLayout(new BorderLayout());

		// create center panel
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		
		// create button panel
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnAdd = new JButton("Add New Vaccine");
		btnAdd.addActionListener(this);
		buttonPanel.add(btnAdd);
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(this);
		buttonPanel.add(btnSave);
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(this);
		buttonPanel.add(btnClose);
		getContentPane().add(buttonPanel,BorderLayout.SOUTH);
		
	}
	public Vaccine getVaccine() {
		return vaccines.get(index);
	}
	
	public ArrayList<Vaccine> getVaccines() {
		return vaccines;
	}

	public void setVaccines(ArrayList<Vaccine> vaccines) {
		this.vaccines = vaccines;
		refreshGUI();
	}
	
	public void refreshGUI() {
		model.setDataVector(null, COLUMN_NAMES);
		for (Vaccine vaccine : vaccines) {
			model.addRow(vaccine.getVaccinePanelRow());
		}
	}
	
	public void save() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equals("Add New Vaccine")) {
			Vaccine newVaccine = new Vaccine();
			vaccines.add(newVaccine);
			refreshGUI();
		}
		else if (command.equals("Save")) {
			
		}
		else if (command.equals("Close")) {
			
		}
		
	}


}
