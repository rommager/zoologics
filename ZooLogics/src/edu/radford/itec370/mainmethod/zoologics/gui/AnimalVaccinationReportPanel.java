package edu.radford.itec370.mainmethod.zoologics.gui;

import java.util.ArrayList;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Vaccination;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class AnimalVaccinationReportPanel extends JDialog{

	private ArrayList <Vaccination> vaccinations;
	private Animal animal;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	
	public AnimalVaccinationReportPanel() {
		setIconImage(Application.getAppIcon());
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(141, 23, 173, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblAnimal = new JLabel("Animal Name:");
		lblAnimal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnimal.setBounds(21, 24, 97, 14);
		panel.add(lblAnimal);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(203, 48, 0, 0);
		panel.add(label);
		
		JLabel lblAdministeredBy = new JLabel("Vaccination History:");
		lblAdministeredBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdministeredBy.setBounds(21, 49, 139, 20);
		panel.add(lblAdministeredBy);
		
		JButton btnDismiss = new JButton("Search");
		btnDismiss.setBounds(451, 331, 65, 23);
		panel.add(btnDismiss);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.setBounds(540, 331, 65, 23);
		panel.add(btnCancel);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(21, 68, 379, 107);
		panel.add(formattedTextField);
		
		JLabel lblUpcomingVaccinations = new JLabel("Upcoming Vaccinations:");
		lblUpcomingVaccinations.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpcomingVaccinations.setBounds(21, 186, 157, 23);
		panel.add(lblUpcomingVaccinations);
		
		table = new JTable();
		table.setBounds(21, 209, 249, 107);
		panel.add(table);
		
		JLabel lblPastDue = new JLabel("Past Due:");
		lblPastDue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPastDue.setBounds(313, 186, 84, 20);
		panel.add(lblPastDue);
		
		table_1 = new JTable();
		table_1.setBounds(313, 209, 292, 107);
		panel.add(table_1);
		
	}
	
	public void refresh() {
		
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public ArrayList <Vaccination> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(ArrayList <Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}
}
