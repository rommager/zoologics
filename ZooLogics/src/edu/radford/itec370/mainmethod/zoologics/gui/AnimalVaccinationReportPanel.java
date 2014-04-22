package edu.radford.itec370.mainmethod.zoologics.gui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Staff;
import edu.radford.itec370.mainmethod.zoologics.Vaccination;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimalVaccinationReportPanel extends JFrame implements Navigable {

	private static final String[] HISTORY_COLUMN_NAMES = new String[] {"Vaccination Name/Dose", "Administered Date", "Administered By"};
	private static final String[] UPCOMING_COLUMN_NAMES = new String[] {"Vaccination Name/Dose", "Due Date"};
	private ArrayList <Vaccination> vaccinations;
	private Animal animal;
	private JTextField txtAnimalName;
	private JScrollPane historyScroll;
	private JTable historyTable;
	private DefaultTableModel historyModel;
	
	private JScrollPane upcomingScroll;
	private JTable upcomingTable;
	private DefaultTableModel upcomingModel;
	
	private JScrollPane pastDueScroll;
	private JTable pastDueTable;
	private DefaultTableModel pastDueModel;
	
	public AnimalVaccinationReportPanel() {
		
		setBounds(10, 10, 700, 500);
		setTitle("Animal Vaccination Reports");
		
		setIconImage(Application.getAppIcon());
		getContentPane().setLayout(new BorderLayout());
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel, BorderLayout.CENTER);
		add(new NavigatorBar(this), BorderLayout.SOUTH);
		
		txtAnimalName = new JTextField();
		txtAnimalName.setBounds(140, 33, 173, 20);
		panel.add(txtAnimalName);
		txtAnimalName.setColumns(10);
		
		JLabel lblAnimalName = new JLabel("Animal Name:");
		lblAnimalName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnimalName.setBounds(21, 34, 97, 14);
		panel.add(lblAnimalName);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(203, 48, 0, 0);
		panel.add(label);
		
		JLabel lblHistory = new JLabel("Vaccination History:");
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHistory.setBounds(21, 79, 139, 20);
		panel.add(lblHistory);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(477, 404, 75, 23);
		panel.add(btnSearch);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnClose.setBounds(605, 404, 68, 23);
		panel.add(btnClose);
		
		JLabel lblUpcoming = new JLabel("Upcoming Vaccinations:");
		lblUpcoming.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpcoming.setBounds(33, 254, 157, 23);
		panel.add(lblUpcoming);
		
		JLabel lblPastDue = new JLabel("Past Due:");
		lblPastDue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPastDue.setBounds(380, 255, 84, 20);
		panel.add(lblPastDue);
		
		// set up vaccination history table
		historyModel = new DefaultTableModel(null, HISTORY_COLUMN_NAMES);
		historyTable = new JTable(historyModel);
		historyScroll = new JScrollPane(historyTable);
		historyScroll.setBounds(21, 110, 649, 133);
		panel.add(historyScroll);
		
		// set up upcoming vaccinations table
		upcomingModel = new DefaultTableModel(null,UPCOMING_COLUMN_NAMES);
		upcomingTable = new JTable(upcomingModel);
		upcomingScroll = new JScrollPane(upcomingTable);
		upcomingScroll.setBounds(21, 286, 322, 107);
		panel.add(upcomingScroll);
		
		// set up past due vaccinations table
		pastDueModel = new DefaultTableModel(null,UPCOMING_COLUMN_NAMES);
		pastDueTable = new JTable(pastDueModel);
		pastDueScroll = new JScrollPane(pastDueTable);
		pastDueScroll.setBounds(382, 286, 291, 107);
		panel.add(pastDueScroll);
//		pack();
				
	}
	
	public String[][] getAllTableRows() {
		
		String[][] outArray;
		for (Vaccination vacc : vaccinations) {
		
		}
		return null;	
		
	}
	
	public static void main(String[] args) {
		AnimalVaccinationReportPanel tester = new AnimalVaccinationReportPanel();
		tester.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Vaccination v1 = new Vaccination();
		v1.setTaskName("Vaccine 1");
		v1.setCompletedBy(new Staff("Crazy Nick"));
		v1.setCompletedDate(Calendar.getInstance());
		
		Vaccination v2 = new Vaccination();
		v2.setTaskName("Vaccine 2");
		v2.setCompletedBy(new Staff("Chase"));
		v2.setCompletedDate(Calendar.getInstance());
		
		tester.setVisible(true);
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
