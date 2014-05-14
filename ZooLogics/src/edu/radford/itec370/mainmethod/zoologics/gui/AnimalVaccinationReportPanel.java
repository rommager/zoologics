package edu.radford.itec370.mainmethod.zoologics.gui;

import java.util.ArrayList;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Task;
import edu.radford.itec370.mainmethod.zoologics.Vaccination;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.*;

public class AnimalVaccinationReportPanel extends JFrame {

	// constants
	private static final long serialVersionUID = 511782685113323967L;
	private static final Object[] HISTORY_COLUMN_NAMES = new String[] {"Vaccination Name/Dose", "Administered Date", "Administered By"};
	private static final Object[] UPCOMING_COLUMN_NAMES = new String[] {"Vaccination Name/Dose", "Due Date"};
	
	// class variables
	private ArrayList<Vaccination> upcomingVaccinations;
	private ArrayList<Vaccination> overdueVaccinations;
	private ArrayList<Vaccination> historyVaccinations;
	private Animal animal;
	
	// GUI Elements
	private JTextField txtAnimalName;
	private ReadOnlyTableModel historyModel;
	private JTable historyTable;
	private ReadOnlyTableModel upcomingModel;
	private JTable upcomingTable;
	private ReadOnlyTableModel pastDueModel;
	private JTable pastDueTable;

	// constructors
	private AnimalVaccinationReportPanel() {
		super();
		setBounds(10, 10, 700, 500);
		setTitle(Application.getAppName() + " - Animal Vaccination Report");

		setIconImage(Application.getAppImage());
		getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel, BorderLayout.CENTER);

		txtAnimalName = new JTextField();
		txtAnimalName.setBounds(140, 33, 173, 20);
		txtAnimalName.setBackground(Color.WHITE);
		txtAnimalName.setEditable(false);
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
		historyModel = new ReadOnlyTableModel();
		historyModel.setColumnIdentifiers(HISTORY_COLUMN_NAMES);
		historyTable = new JTable(historyModel);
		JScrollPane historyScroll = new JScrollPane(historyTable);
		historyScroll.setBounds(21, 110, 649, 133);
		panel.add(historyScroll);
		historyModel.addRow(new String[] {null,null,null});

		// set up upcoming vaccinations table
		upcomingModel = new ReadOnlyTableModel();
		upcomingModel.setColumnIdentifiers(UPCOMING_COLUMN_NAMES);
		upcomingTable = new JTable(upcomingModel);
		JScrollPane upcomingScroll = new JScrollPane(upcomingTable);
		upcomingScroll.setBounds(21, 286, 322, 107);
		panel.add(upcomingScroll);

		// set up past due vaccinations table
		pastDueModel = new ReadOnlyTableModel();
		pastDueModel.setColumnIdentifiers(UPCOMING_COLUMN_NAMES);
		historyModel.setColumnIdentifiers(HISTORY_COLUMN_NAMES);
		pastDueTable = new JTable(pastDueModel);
		JScrollPane pastDueScroll = new JScrollPane(pastDueTable);
		pastDueScroll.setBounds(382, 286, 291, 107);
		panel.add(pastDueScroll);
	}

	public AnimalVaccinationReportPanel(ArrayList<Animal> animals, ArrayList<Task> activeTasks, ArrayList<Task> inactiveTasks) {
		this();
	}

	/*	public String[][] getAllTableRows() {
		//TODO
		String[][] outArray;
		for (Vaccination vacc : vaccinations) {

		}
		return null;	

	}
	 */
	public static void main(String[] args) {
		AnimalVaccinationReportPanel tester = new AnimalVaccinationReportPanel();
		tester.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//		Vaccination v1 = new Vaccination();
//		v1.setTaskName("Vaccine 1");
		//		v1.setCompletedBy(new Staff("Crazy Nick"));
//		v1.setCompletedDate(new Date());

//		Vaccination v2 = new Vaccination();
//		v2.setTaskName("Vaccine 2");
		//		v2.setCompletedBy(new Staff("Chase"));
//		v2.setCompletedDate(new Date());

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

	@SuppressWarnings("serial")
	class ReadOnlyTableModel extends DefaultTableModel {
		@Override
		public boolean isCellEditable(int row, int column) {
			//all cells false
			return false;
		}
	}
	
	public int print(Graphics g, PageFormat pf, int page)
			throws PrinterException {

		// We have only one page, and 'page'
		// is zero-based
		if (page > 0) {
			return Printable.NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());

		// Now we perform our rendering
		g.drawString(getName(), 100, 100);
//		g.drawString(getVaccine(), 200, 100);


		// tell the caller that this page is part
		// of the printed document
		return Printable.PAGE_EXISTS;
	}

}

