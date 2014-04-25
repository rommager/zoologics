package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Vaccine;

public class VaccinePanel extends JFrame {

	private static final long serialVersionUID = -3966249468484312613L;

	private ArrayList<Vaccine> vaccines;
	
	
	private JTextField txtVaccineID;
	private JTextField txtName;
	private JTextField txtDosage;
	private JTextField txtDueAt;
	private JLabel lblDosage;
	private JLabel lblFirstDoseAge;

	public static void main(String[] args) {
		VaccinePanel panel = new VaccinePanel();

		panel.setVisible(true);
		panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setVaccines(new ArrayList<Vaccine>());
//		panel.getVaccines().add(
//				new Vaccine("1001", "Ivomec", "50ML", true, new Date()));
//		panel.getVaccines().add(
//				new Vaccine("1002", "Rabies", "50ML", true, new Date()));
//		panel.getVaccines().add(
//				new Vaccine("1003", "Dewormer", "100ML", true, new Date()));

	}

	public VaccinePanel() {
		setIconImage(Application.getAppIcon());
		setTitle(Application.getAppName() + " Vaccination and Regiments");
		this.setSize(new Dimension(800, 480));
		getContentPane().setLayout(null);

		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setBounds(32, 32, 67, 14);
		getContentPane().add(lblIdNumber);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(32, 85, 46, 14);
		getContentPane().add(lblNewLabel);

		txtVaccineID = new JTextField();
		txtVaccineID.setBounds(109, 29, 86, 20);
		getContentPane().add(txtVaccineID);
		txtVaccineID.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(109, 82, 86, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		txtDosage = new JTextField();
		txtDosage.setBounds(109, 138, 86, 20);
		getContentPane().add(txtDosage);
		txtDosage.setColumns(10);

		txtDueAt = new JTextField();
		txtDueAt.setBounds(109, 203, 86, 20);
		getContentPane().add(txtDueAt);
		txtDueAt.setColumns(10);

		lblDosage = new JLabel("Dosage");
		lblDosage.setBounds(32, 141, 46, 14);
		getContentPane().add(lblDosage);

		lblFirstDoseAge = new JLabel("First dose");
		lblFirstDoseAge.setBounds(32, 206, 67, 14);
		getContentPane().add(lblFirstDoseAge);

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

		ButtonGroup group = new ButtonGroup();
		
	}

	private ArrayList<Vaccine> getVaccines() {
		// TODO Auto-generated method stub
		return null;
	}

	private void setVaccines(ArrayList<Vaccine> vaccines) {
		this.vaccines = vaccines;

	}


}
