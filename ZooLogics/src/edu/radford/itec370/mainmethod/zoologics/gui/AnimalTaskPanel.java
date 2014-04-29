package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.AnimalTask;

public class AnimalTaskPanel extends TaskPanel {

	private static final long serialVersionUID = -3909857959125438949L;

	protected JTextField txtAnimalName;
	protected JLabel lblAnimalName;
	private Animal animal;
	
	public AnimalTaskPanel() {
		super();
		lblTaskName.setSize(122, 22);
		setPreferredSize(new Dimension(580,283));
		setSize(getPreferredSize());
		
		scrollPane.setLocation(10, 134);
		txtNotes.setLocation(12, 140);
		lblNotes.setLocation(10, 110);
		txtCompletedDate.setLocation(451, 77);
		lblCompletionDate.setLocation(345, 77);
		txtDueDate.setLocation(451, 44);
		lblDueDate.setLocation(345, 44);
		txtCompletedBy.setLocation(132, 77);
		lblCompletedBy.setLocation(10, 77);
		txtTaskName.setLocation(132, 44);
		lblTaskName.setLocation(10, 44);
		
		lblAnimalName = new JLabel("Animal Name");
		lblAnimalName.setBounds(10, 11, 122, 22);
		detailPanel.add(lblAnimalName);
		
		txtAnimalName = new JTextField();
		txtAnimalName.setBounds(132, 11, 202, 20);
		detailPanel.add(txtAnimalName);
	}
	
	public AnimalTaskPanel(AnimalTask animalTask) {
		this();
		this.task = animalTask;
	}
	
	public static void main(String[] args) {
		AnimalTaskPanel panel = new AnimalTaskPanel();
		GUITester.launchTestFrame(panel);
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public AnimalTask getAnimalTask() {
		return (AnimalTask) task;
	}
	
	@Override
	public void updateGUI() {
		txtAnimalName.setText(animal.getName());
		super.updateGUI();
	}
	
	@Override
	public void save() {
//		animal = txtAnimalName.getText();  //TODO Fix this
		super.save();
	}
}
