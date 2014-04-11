package edu.radford.itec370.mainmethod.zoologics.gui;
import javax.swing.JLabel;
import javax.swing.JTextField;

	


public class VaccinationTaskPanel extends TaskPanel{
	private JTextField textField;
	private JTextField textField_1;
	public VaccinationTaskPanel() {
		super();
		btnCompleteTask.setSize(135, 23);
		btnCompleteTask.setText("Complete Vaccination");
		btnCompleteTask.setLocation(31, 250);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setBounds(10, 46, 46, 14);
		getContentPane().add(lblAnimal);
		
		textField = new JTextField();
		textField.setBounds(55, 43, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAdministeredBy = new JLabel("Administered By");
		lblAdministeredBy.setBounds(174, 46, 99, 14);
		getContentPane().add(lblAdministeredBy);
		
		textField_1 = new JTextField();
		textField_1.setBounds(294, 43, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
	}
	
	public static void main(String[] args) {
		
	}

}
