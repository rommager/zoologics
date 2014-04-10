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

public class AnimalVaccinationReportPanel extends JDialog{

	private ArrayList <Vaccination> vaccinations;
	private Animal animal;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public AnimalVaccinationReportPanel() {
		setIconImage(Application.getAppIcon());
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(70, 23, 97, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(315, 23, 105, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnimal.setBounds(21, 24, 74, 14);
		panel.add(lblAnimal);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(203, 48, 0, 0);
		panel.add(label);
		
		JLabel lblAdministerDate = new JLabel("Administer Date");
		lblAdministerDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdministerDate.setBounds(203, 21, 105, 20);
		panel.add(lblAdministerDate);
		
		JLabel lblAdministeredBy = new JLabel("Administered By:");
		lblAdministeredBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdministeredBy.setBounds(21, 69, 112, 20);
		panel.add(lblAdministeredBy);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 71, 148, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNotes.setBounds(21, 111, 61, 29);
		panel.add(lblNotes);
		
		textField_3 = new JTextField();
		textField_3.setBounds(92, 102, 330, 96);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCompleteItem = new JButton("Complete Item");
		btnCompleteItem.setBounds(92, 209, 111, 23);
		panel.add(btnCompleteItem);
		
		JButton btnDismiss = new JButton("Dismiss");
		btnDismiss.setBounds(225, 209, 89, 23);
		panel.add(btnDismiss);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(331, 209, 89, 23);
		panel.add(btnCancel);
		
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
