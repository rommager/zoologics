package edu.radford.itec370.mainmethod.zoologics.gui;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.Vaccination;

	


public class AnimalTaskPanel extends TaskPanel {

	private static final long serialVersionUID = -3909857959125438949L;

	protected JTextField txtAnimalName;
	protected JLabel lblAnimalName;
	private Animal animal;
	
	public AnimalTaskPanel() {
		super();
		lblNotes.setLocation(10, 75);
		lblDueDate.setLocation(236, 46);
		txtTaskName.setLocation(90, 43);
		txtDueDate.setLocation(342, 43);
		txtNotes.setLocation(10, 100);
		txtCompletedDate.setLocation(342, 225);
		txtCompletedBy.setLocation(90, 225);
		btnDismiss.setLocation(245, 276);
		btnCancel.setLocation(359, 276);
		btnCompleteTask.setBounds(90, 276, 130, 23);
		btnCompleteTask.setText("Administer Vaccine");
		lblCompletionDate.setBounds(236, 228, 106, 14);
		lblCompletedBy.setBounds(10, 224, 89, 22);
		lblTaskName.setLocation(10, 42);

		lblCompletionDate.setText("Administer Date");
		lblCompletedBy.setText("Administered by");
		lblTaskName.setText("Vaccine");				
		
		lblAnimalName = new JLabel("Animal Name");
		lblAnimalName.setBounds(10, 17, 70, 14);
		add(lblAnimalName);
		
		txtAnimalName = new JTextField();
		txtAnimalName.setBounds(90, 12, 244, 20);
		add(txtAnimalName);
	}
	
	public AnimalTaskPanel(Vaccination vaccination) {
		this();
		this.task = vaccination;
		
	}
	
	public static void main(String[] args) {
		AnimalTaskPanel vacTaskPanel = new AnimalTaskPanel();
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public void updateGUI() {
		super.updateGUI();
	}
	
	public void save() {
		super.save();
	}
}
