package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.CellEditor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Vaccine;

public class VaccinePanel extends JFrame implements ActionListener, WindowListener {

	private static final long serialVersionUID = -3966249468484312613L; 
	private ArrayList<Vaccine> vaccines;
	private int index = 0;

	VaccineTableModel model;
	JTable table;

	private VaccinePanel() {
		super();
		// set up JFrame
		setIconImage(Application.getAppImage());
		setTitle(Application.getAppName() + " - Vaccines");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		setSize(new Dimension(640, 480));
		getContentPane().setLayout(new BorderLayout());

		// create center panel
		model = new VaccineTableModel();
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane,BorderLayout.CENTER);

		// create button panel
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnAdd = new JButton("Add New Vaccine");
		btnAdd.addActionListener(this);
		buttonPanel.add(btnAdd);
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(this);
		buttonPanel.add(btnClose);
		getContentPane().add(buttonPanel,BorderLayout.SOUTH);
	}

	public VaccinePanel(ArrayList<Vaccine> vaccines) {
		this();
		this.vaccines = vaccines;
		model.setRowData(vaccines);
	}

	public Vaccine getVaccine() {
		return vaccines.get(index);
	}

	public ArrayList<Vaccine> getVaccines() {
		return vaccines;
	}

	public Vaccine findVaccine(int id) {
		for (Vaccine vaccine : vaccines) {
			if (vaccine.getVaccineID() == id)
				return vaccine;
		}
		return null;
	}

	public void closeWindow() {
		CellEditor editor = table.getCellEditor();
		if (editor != null)
			editor.stopCellEditing();   // this forces any in progress edit to complete (which saves the cell value!)
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals("Add New Vaccine")) {
			Vaccine newVaccine = new Vaccine();
			model.addRow(newVaccine);
		}
		else if (command.equals("Close")) {
			closeWindow();
		}

	}

	// tester method
	public static void main(String[] args) {
		ArrayList<Vaccine> vaccines = new ArrayList<Vaccine>();
		vaccines.add(new Vaccine(92001, "Ivomec"));
		vaccines.add(new Vaccine(92002, "Rabies"));
		vaccines.add(new Vaccine(92003, "Dewormer"));

		VaccinePanel panel = new VaccinePanel(vaccines);
		panel.setVisible(true);
		panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@SuppressWarnings("serial")
	class VaccineTableModel extends ArrayListTableModel<Vaccine> {

		public VaccineTableModel() {
			super();
			setColumnNames(new String[] {"VaccineID","Vaccine Name"});
		}
		
		@Override
		public Object getValue(Vaccine item, int field) {
			switch (field) {
			case 0:
				return item.getVaccineID();
			case 1:
				return item.getVaccineName();
			default:
				return null;
			}
		}

		@Override
		public void setValue(Vaccine item, Object value, int field) {
			switch (field) {
			case 1:
				item.setVaccineName((String) value);
			}

		}

		@Override
		public boolean isFieldEditable(Vaccine item, int field) {
			if (field == 0)
			return false;
		return true;
		}

	}

	// WindowListener implementation (calls closeWindow() method when red X is clicked
	@Override public void windowClosing(WindowEvent e) { closeWindow(); }
	@Override public void windowActivated(WindowEvent e) {}
	@Override public void windowClosed(WindowEvent e) {}
	@Override public void windowDeactivated(WindowEvent e) {}
	@Override public void windowDeiconified(WindowEvent e) {}
	@Override public void windowIconified(WindowEvent e) {}
	@Override public void windowOpened(WindowEvent e) {}
}
