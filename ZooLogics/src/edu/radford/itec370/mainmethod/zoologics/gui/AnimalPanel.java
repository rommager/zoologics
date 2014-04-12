package edu.radford.itec370.mainmethod.zoologics.gui;


import java.util.ArrayList;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.Application;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class AnimalPanel extends JDialog {
	
	private Animal animal;
	private ArrayList <Animal> animals;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	
	public AnimalPanel() {
		
		setIconImage(Application.getAppIcon());
		
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(121, 30, 102, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(678, 331, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(678, 365, 89, 23);
		add(btnNewButton_1);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(678, 399, 89, 23);
		add(btnClose);
		
		JPanel panel = new JPanel();
		panel.setBounds(447, 260, 204, 179);
		add(panel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 62, 102, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(121, 93, 102, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(121, 124, 102, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(28, 33, 46, 14);
		add(lblName);
		
		JLabel lblSpecies = new JLabel("Species");
		lblSpecies.setBounds(28, 65, 46, 14);
		add(lblSpecies);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(28, 96, 46, 14);
		add(lblSex);
		
		JLabel lblNewLabel = new JLabel("Father");
		lblNewLabel.setBounds(28, 127, 46, 14);
		add(lblNewLabel);
		
		textField_5 = new JTextField();
		textField_5.setBounds(28, 211, 303, 63);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(28, 315, 303, 123);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblDescriptiveMarkings = new JLabel("Descriptive Markings");
		lblDescriptiveMarkings.setBounds(10, 186, 114, 14);
		add(lblDescriptiveMarkings);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setBounds(10, 290, 46, 14);
		add(lblNotes);
		
		JLabel lblNewLabel_1 = new JLabel("Zoo ID");
		lblNewLabel_1.setBounds(389, 33, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Breed");
		lblNewLabel_2.setBounds(389, 65, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date of Birth");
		lblNewLabel_3.setBounds(389, 96, 61, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mother");
		lblNewLabel_4.setBounds(389, 127, 46, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ID Number");
		lblNewLabel_5.setBounds(389, 158, 61, 14);
		add(lblNewLabel_5);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBounds(121, 148, 55, 23);
		add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(178, 148, 46, 23);
		add(rdbtnNo);
		
		JLabel lblIdChip = new JLabel("Tattoo or Chip?");
		lblIdChip.setBounds(27, 152, 76, 14);
		add(lblIdChip);
		
		textField_4 = new JTextField();
		textField_4.setBounds(484, 30, 137, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(484, 62, 137, 20);
		add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(484, 93, 137, 20);
		add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(484, 124, 137, 20);
		add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(484, 155, 137, 20);
		add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setBounds(437, 235, 46, 14);
		add(lblPhoto);
	}
	
	
	public void refresh() {
		
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
		this.textField.setText(animal.getName());
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}
}
