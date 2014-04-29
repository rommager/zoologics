package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.util.ArrayList;

import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Species;

public class SpeciesPanel extends JDialog implements Navigable {

	ArrayList<Species> species;
	int index = 0;

	private static final long serialVersionUID = 4119451221171558539L;
	private static final String[] SPECIES_COLUMN_NAMES = new String[] {"Vaccine Name", "Schedule"};
	private static final String WINDOW_TITLE = Application.getAppName() + " - Species";
	
	private JPanel contentPanel;
	private JTextField txtSpecies;
	private JScrollPane speciesScroll;
	private JTable speciesTable;
	private DefaultTableModel speciesModel;
	private JComboBox<String> dropdown; 

	
	private SpeciesPanel() {
		super();

		setIconImage(Application.getAppImage());
		setTitle(WINDOW_TITLE);


		setBounds(100, 100, 540, 300);
		getContentPane().setLayout(new BorderLayout());

		NavigatorBar naviBar = new NavigatorBar(this);
		getContentPane().add(naviBar,BorderLayout.SOUTH);

		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSpecies = new JLabel("Species:");
			lblSpecies.setBounds(10, 11, 60, 14);
			contentPanel.add(lblSpecies);
		}

		txtSpecies = new JTextField();
		txtSpecies.setBounds(65, 8, 133, 20);
		contentPanel.add(txtSpecies);
		txtSpecies.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JButton sourceButton = (JButton) arg0.getSource();
				sourceButton.getParent().getParent().getParent().getParent().getParent().setVisible(false);
			}
		});
		btnCancel.setBounds(423, 195, 89, 23);
		contentPanel.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
				JButton sourceButton = (JButton) arg0.getSource();
				sourceButton.getParent().getParent().getParent().getParent().getParent().setVisible(false);
			}
		});
		btnOk.setBounds(423, 161, 89, 23);
		contentPanel.add(btnOk);

		dropdown = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"Day(s)","Week(s)","Month(s)","Year(s)"}));

		speciesModel = new DefaultTableModel(null, SPECIES_COLUMN_NAMES);
		speciesTable = new JTable(speciesModel);
		speciesScroll = new JScrollPane(speciesTable);
		speciesScroll.setBounds(20, 36, 393, 195);
		contentPanel.add(speciesScroll);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});
		btnSave.setBounds(423, 127, 89, 23);
		contentPanel.add(btnSave);
		speciesTable.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(dropdown));
		speciesModel.addRow(new String[] {null,null,null});

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// add navigator bar in south window area
		NavigatorBar navPanel = new NavigatorBar(this);
		//			navPanel.setNewRecordVisible(false);
		//			navPanel.setSearchBoxVisible(false);
		navPanel.setBounds(0, 415, 784, 30);
		getContentPane().add(navPanel, BorderLayout.SOUTH);
		//getContentPane().add(buttonPane, BorderLayout.SOUTH);
		//JButton okButton = new JButton("OK");
		//okButton.addActionListener(new ActionListener() {
		//public void actionPerformed(ActionEvent arg0) {
		// Put a call to a save method here
		//System.out.println("Click");
		//JButton sourceButton = (JButton) arg0.getSource();
		//sourceButton.getParent().getParent().getParent().getParent().getParent().setVisible(false);
		//okButton.setActionCommand("OK");
		//buttonPane.add(okButton);
		//getRootPane().setDefaultButton(okButton);
	}

	JButton cancelButton = new JButton("Cancel");
	//buttonPane.add(cancelButton);


	public SpeciesPanel(ArrayList<Species> species) {
		this();
		this.species = species;
	}

	// updateGUI and save methods
	public void updateGUI() {
		Species x = species.get(index);
		this.txtSpecies.setText(x.getSpeciesName());
	}

	public void save() {
		Species spe = species.get(index);
		spe.setSpeciesName(this.txtSpecies.getText());

//		for (int row = 0; row > speciesModel.getRowCount(); row++) {
			//			vaccines.add((Vaccine)speciesModel.getValueAt(row, 0));
//		}
//		for (int col = 0; col > speciesModel.getColumnCount(); col++) {
//			vaccinationSchedules.add((VaccinationSchedule)speciesModel.getValueAt(col, 1));
//		}
		//		spe.setVaccineIdCollection(this.vaccines);
		//		spe.setVaccineSchedule(this.vaccinationSchedules);
	}

	// Navigable implementation
	@Override
	public void firstRecord() {
		index = 0;
		updateGUI();
	}
	@Override
	public void previousRecord() {
		if (index > 0 && species.size() != 0) {
			index--;
			updateGUI();
		}
	}
	@Override
	public void nextRecord() {
		if (index < species.size() && species.size() != 0) {
			index++;
			updateGUI();
		}
	}
	@Override
	public void lastRecord() {
		index = species.size();
		updateGUI();
	}
	@Override
	public void newRecord() {
		Species newSpecies = new Species();
		species.add(newSpecies);
		index = species.indexOf(newSpecies);
		updateGUI();
	}
	@Override
	public void applyFilter(String filter) {
		// TODO Auto-generated method stub

	}
	@Override
	public void updateRecordCount() {
		// TODO Auto-generated method stub

	}

	// testing method
	public static void main(String[] args) {
		try {
			SpeciesPanel dialog = new SpeciesPanel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
