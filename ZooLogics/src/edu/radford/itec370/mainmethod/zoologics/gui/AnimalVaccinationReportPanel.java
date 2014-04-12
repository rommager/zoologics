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
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AnimalVaccinationReportPanel extends JDialog{

	private ArrayList <Vaccination> vaccinations;
	private Animal animal;
	private JTextField textField;
	private JTable table_2;
	private JTable table;
	private JTable table_1;
	
	public AnimalVaccinationReportPanel() {
		setIconImage(Application.getAppIcon());
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(140, 33, 173, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblAnimal = new JLabel("Animal Name:");
		lblAnimal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnimal.setBounds(21, 34, 97, 14);
		panel.add(lblAnimal);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(203, 48, 0, 0);
		panel.add(label);
		
		JLabel lblAdministeredBy = new JLabel("Vaccination History:");
		lblAdministeredBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdministeredBy.setBounds(21, 79, 139, 20);
		panel.add(lblAdministeredBy);
		
		JButton btnDismiss = new JButton("Search");
		btnDismiss.setBounds(477, 404, 65, 23);
		panel.add(btnDismiss);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.setBounds(605, 404, 65, 23);
		panel.add(btnCancel);
		
		JLabel lblUpcomingVaccinations = new JLabel("Upcoming Vaccinations:");
		lblUpcomingVaccinations.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpcomingVaccinations.setBounds(33, 254, 157, 23);
		panel.add(lblUpcomingVaccinations);
		
		JLabel lblPastDue = new JLabel("Past Due:");
		lblPastDue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPastDue.setBounds(380, 255, 84, 20);
		panel.add(lblPastDue);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 110, 649, 133);
		panel.add(scrollPane);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"Vaccination Name/Dose", "Administered Date", "Administered By"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Vaccination Name/Dose", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setColumnHeaderView(table_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 286, 322, 107);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Vaccination Name/Dose", "Due Date"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"", "Due Date"
			}
		));
		scrollPane_1.setColumnHeaderView(table);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(382, 286, 291, 107);
		panel.add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Vaccination Name/Dose", "Due Date"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Vaccination Name/Dose", "Due Date"
			}
		));
		scrollPane_2.setRowHeaderView(table_1);
		
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
