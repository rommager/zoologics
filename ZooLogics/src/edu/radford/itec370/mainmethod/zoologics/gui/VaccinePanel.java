package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
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

public class VaccinePanel extends JFrame implements Navigable{

	private static final long serialVersionUID = -3966249468484312613L; 
	private ArrayList<Vaccine> vaccines;
	private int index = 0;
	
	private JTextField txtVaccineID;
	private JTextField txtName;
	private JTextField txtDosage;
	private JTextField txtDueAt;
	
    
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
		setIconImage(Application.getAppImage());
		setTitle(Application.getAppName() + " Vaccination and Regiments");
		this.setSize(new Dimension(800, 480));
		getContentPane().setLayout(null);
		// add navigator bar in south window area
		NavigatorBar navPanel = new NavigatorBar(this);
//		navPanel.setNewRecordVisible(false);
//		navPanel.setSearchBoxVisible(false);
		navPanel.setBounds(0, 415, 784, 30);
		getContentPane().add(navPanel, BorderLayout.SOUTH);

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
	public Vaccine getVaccine() {
		return vaccines.get(index);
	}
	
	public ArrayList<Vaccine> getVaccines() {
		return vaccines;
	}

	public void setVaccines(ArrayList<Vaccine> vaccines) {
		this.vaccines = vaccines;

	}

	@Override
	public void firstRecord() {

		
	}

	@Override
	public void previousRecord() {

		
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
