package edu.radford.itec370.mainmethod.zoologics.gui;


import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Species;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;

public class AnimalPanel extends JFrame implements Navigable {
	
	private Animal animal;
	private ArrayList <Animal> animals;
	private JTextField txtName;
	private JTextField txtSpecies;
	private JTextField txtSex;
	private JTextField txtFather;
	private JTextField txtMarkings;
	private JTextField txtNotes;
	private JTextField txtZooID;
	private JTextField txtBreed;
	private JTextField txtDOB;
	private JTextField txtMother;
	private JTextField txtIDNumber;
	
	public static void main(String[] args) {
		AnimalPanel panel = new AnimalPanel();
		
		panel.setVisible(true);
		panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Animal a1 = new Animal(1001, "Puja", new Species("Tiger"), 'M', "Simba", "", true, "A12343212", "breed", new Date(), "stripes", "Gentle, needs special attention");
		panel.setAnimal(a1);
		//System.exit(0);
	}
	
	public AnimalPanel() {
		setTitle("Animal Profile");
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		
		setIconImage(Application.getAppIcon());
		this.setSize(new Dimension(800, 512));
		
		getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(121, 30, 102, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(678, 315, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(678, 349, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(678, 383, 89, 23);
		getContentPane().add(btnClose);
		
		JPanel panel = new JPanel();
		panel.setBounds(447, 227, 204, 179);
		getContentPane().add(panel);
		
		txtSpecies = new JTextField();
		txtSpecies.setBounds(121, 62, 102, 20);
		getContentPane().add(txtSpecies);
		txtSpecies.setColumns(10);
		
		txtSex = new JTextField();
		txtSex.setBounds(121, 93, 102, 20);
		getContentPane().add(txtSex);
		txtSex.setColumns(10);
		
		txtFather = new JTextField();
		txtFather.setBounds(121, 124, 102, 20);
		getContentPane().add(txtFather);
		txtFather.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(28, 33, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblSpecies = new JLabel("Species");
		lblSpecies.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSpecies.setBounds(28, 65, 46, 14);
		getContentPane().add(lblSpecies);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex.setBounds(28, 96, 46, 14);
		getContentPane().add(lblSex);
		
		JLabel lblNewLabel = new JLabel("Father");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(28, 127, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtMarkings = new JTextField();
		txtMarkings.setBounds(28, 202, 303, 63);
		getContentPane().add(txtMarkings);
		txtMarkings.setColumns(10);
		
		txtNotes = new JTextField();
		txtNotes.setBounds(28, 283, 303, 123);
		getContentPane().add(txtNotes);
		txtNotes.setColumns(10);
		
		JLabel lblDescriptiveMarkings = new JLabel("Descriptive Markings");
		lblDescriptiveMarkings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescriptiveMarkings.setBounds(10, 187, 152, 14);
		getContentPane().add(lblDescriptiveMarkings);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotes.setBounds(10, 266, 46, 14);
		getContentPane().add(lblNotes);
		
		JLabel lblNewLabel_1 = new JLabel("Zoo ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(389, 33, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Breed");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(389, 65, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date of Birth");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(389, 96, 85, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mother");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(389, 127, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ID Number");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(389, 158, 61, 14);
		getContentPane().add(lblNewLabel_5);
		
		JRadioButton rdbtnChipYes = new JRadioButton("Yes");
		rdbtnChipYes.setMnemonic(KeyEvent.VK_Y);
		rdbtnChipYes.setBounds(121, 148, 55, 23);
		getContentPane().add(rdbtnChipYes);
		
		JRadioButton rdbtnChipNo = new JRadioButton("No");
		rdbtnChipNo.setMnemonic(KeyEvent.VK_N);
		rdbtnChipNo.setBounds(178, 148, 46, 23);
		getContentPane().add(rdbtnChipNo);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnChipYes);
		group.add(rdbtnChipNo);
		
		JLabel lblIdChip = new JLabel("Tattoo or Chip?");
		lblIdChip.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdChip.setBounds(27, 152, 102, 14);
		getContentPane().add(lblIdChip);
		
		txtZooID = new JTextField();
		txtZooID.setBounds(484, 30, 137, 20);
		getContentPane().add(txtZooID);
		txtZooID.setColumns(10);
		
		txtBreed = new JTextField();
		txtBreed.setBounds(484, 62, 137, 20);
		getContentPane().add(txtBreed);
		txtBreed.setColumns(10);
		
		txtDOB = new JTextField();
		txtDOB.setBounds(484, 93, 137, 20);
		getContentPane().add(txtDOB);
		txtDOB.setColumns(10);
		
		txtMother = new JTextField();
		txtMother.setBounds(484, 124, 137, 20);
		getContentPane().add(txtMother);
		txtMother.setColumns(10);
		
		txtIDNumber = new JTextField();
		txtIDNumber.setBounds(484, 155, 137, 20);
		getContentPane().add(txtIDNumber);
		txtIDNumber.setColumns(10);
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoto.setBounds(427, 202, 46, 14);
		getContentPane().add(lblPhoto);
		
		NavigatorBar navPanel = new NavigatorBar(this);
		navPanel.setBounds(0, 415, 500, 30);
		getContentPane().add(navPanel);
	}
	
	
	public void refresh() {
		
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
		this.txtName.setText(animal.getName());
		this.txtBreed.setText(animal.getBreed());
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}

	@Override
	public void firstRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previousRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nextRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lastRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyFilter(String filter) {
		// TODO Auto-generated method stub
		
	}
}
