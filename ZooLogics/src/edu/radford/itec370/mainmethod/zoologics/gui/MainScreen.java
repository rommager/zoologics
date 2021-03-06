package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Task;

public class MainScreen extends JFrame implements WindowListener {

	// constants
	private static final long serialVersionUID = -6514056067808688533L;
	private static final String[] COLUMN_HEADER = new String[] {"Task Type", "Animal", "Description", "Due"};

	// class variables
	private Application application;

	// class GUI elements
	private JTable table;
	private JMenuItem mntmExit;
	private JMenuItem mntmVaccinePanel;
	private JMenuItem mntmSpeciesPanel;
	private JMenuItem mntmAnimalReport;
	private JMenuItem mntmAnimalPanel;
	private JMenuItem mntmAdminPanel;
	private JMenuItem mntmPrint;
	private JMenuItem mntmAboutMainMethod;
	private StatusBar statusBar;

	private MainScreen() {
		super();
		// set up JFrame properties
		setTitle(Application.getAppName() + " Main Task Screen");
		setIconImage(Application.getAppImage());
		setSize(new Dimension(650, 449));
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		addWindowListener(this);

		// build north panel
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTasks = new JLabel("Tasks:");
		lblTasks.setFont(new Font("Tahoma", Font.BOLD, 14));
		northPanel.add(lblTasks);
		getContentPane().add(northPanel,BorderLayout.NORTH);

		// build center panel
		
/*		String[][] demoData = new String[][] {
				{"Vaccination","Muthosh","Ivomec, 40ml","04/28/2014"},
				{"Vaccination","Puja","Dewormer","05/02/2014"},
				{"Vaccination","George","Ivomec, 20ml","05/04/2014"},
				{"Vaccination","Muthosh","Rabies","05/07/2014"},
				{"Vaccination","Muthosh","Dewormer","05/13/2014"}};*/
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		table = new JTable(new DefaultTableModel(null,COLUMN_HEADER));
		JScrollPane scrollPane = new JScrollPane(table);
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(centerPanel);

		// build button panel for center panel - this is an embedded south panel for the center panel
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		JButton btnOpenItem = new JButton("Open");
		buttonPanel.add(btnOpenItem);

		JButton btnSearch = new JButton("Search");
		buttonPanel.add(btnSearch);
		centerPanel.add(buttonPanel,BorderLayout.SOUTH);

		// build status bar as south panel
		statusBar = new StatusBar();
		getContentPane().add(statusBar,BorderLayout.SOUTH);

		// build menu bar
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setToolTipText("");
		setJMenuBar(menuBar_1);

		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar_1.add(mnFile);

		mntmAnimalPanel = new JMenuItem("Animal Profiles");
		mntmAnimalPanel.addActionListener(new MenuListener());
		mnFile.add(mntmAnimalPanel);

		mntmAnimalReport = new JMenuItem("Animal Vaccination Report");
		mntmAnimalReport.addActionListener(new MenuListener());
		mnFile.add(mntmAnimalReport);

		mntmSpeciesPanel = new JMenuItem("Species Panel");
		mntmSpeciesPanel.addActionListener(new MenuListener());
		mnFile.add(mntmSpeciesPanel);

		mntmVaccinePanel = new JMenuItem("Vaccine Panel");
		mntmVaccinePanel.addActionListener(new MenuListener());
		mnFile.add(mntmVaccinePanel);

		mntmAdminPanel = new JMenuItem("Admin Panel");
		mntmAdminPanel.addActionListener(new MenuListener());
		mnFile.add(mntmAdminPanel);

		mntmPrint = new JMenuItem("Print");
		mntmPrint.setMnemonic(KeyEvent.VK_X);
		mntmPrint.addActionListener(new MenuListener());
		mnFile.add(mntmPrint); 
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic(KeyEvent.VK_X);
		mntmExit.addActionListener(new MenuListener());
		mnFile.add(mntmExit);


		JMenu mnAbout = new JMenu("About");
		mnAbout.setMnemonic(KeyEvent.VK_B);
		menuBar_1.add(mnAbout);

		mntmAboutMainMethod = new JMenuItem("About Main() Method");
		mntmAboutMainMethod.addActionListener(new MenuListener());
		mnAbout.add(mntmAboutMainMethod);
	}

	public MainScreen(Application application) {
		this();
		this.application = application;
	}

	public Application getApplication() {
		return application;
	}

	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmExit)
				System.exit(0);
			else if (e.getSource() == mntmVaccinePanel) {
				VaccinePanel vaccinePanel = new VaccinePanel(application.getVaccines());
				vaccinePanel.setVisible(true);
			} else if (e.getSource() == mntmSpeciesPanel) {
				SpeciesPanel speciesPanel = new SpeciesPanel(application.getSpecies());
				speciesPanel.setVisible(true);
			} else if (e.getSource() == mntmAnimalReport) {
				AnimalVaccinationReportPanel animalReport = new AnimalVaccinationReportPanel(application.getAnimals(), application.getAllActiveTasks(), application.getInactiveTasks());
				animalReport.setVisible(true);
			} else if (e.getSource() == mntmAnimalPanel) {
				AnimalPanel animalPanel = new AnimalPanel(application.getAnimals());
				animalPanel.setVisible(true);
			} else if (e.getSource() == mntmAdminPanel) {
				StaffPanel adminPanel = new StaffPanel(Application.getStaffHive());
				adminPanel.setVisible(true);
			} else if (e.getSource() == mntmAboutMainMethod) {
				JOptionPane.showMessageDialog(null, 
						Application.getAppName() + " version " + Application.getVersion() + 
						"\n created by team main() Method", 
						Application.getAppName(), 
						JOptionPane.INFORMATION_MESSAGE,
						Application.getAppIcon());
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		application.saveDataToIO();
		System.exit(0);
	}
	
	@Override public void windowActivated(WindowEvent arg0) { }
	@Override public void windowClosed(WindowEvent arg0) { }
	@Override public void windowDeactivated(WindowEvent arg0) { }
	@Override public void windowDeiconified(WindowEvent arg0) { }
	@Override public void windowIconified(WindowEvent arg0) { }
	@Override public void windowOpened(WindowEvent arg0) { }
	
	@SuppressWarnings("serial")
	class TaskTableModel extends AbstractTableModel {
		private final String[] COLUMN_NAMES = new String[] {"Task Type","Animal","Description","Due"}; 
		private ArrayList<Task> rowData;

		public TaskTableModel() {
			super();
		}
		
		public TaskTableModel(ArrayList<Task> rowData) {
			super();
			this.rowData = rowData;
		}

		public String getColumnName(int col) {
			return COLUMN_NAMES[col];
		}

		public int getRowCount() { return rowData.size(); }

		public int getColumnCount() { return COLUMN_NAMES.length; }

		public Object getValueAt(int row, int col) {
			Task item = rowData.get(row);
			switch (col) {
			case 0:
				//return task type
			case 1:
				//return animal
			default:
				return null;
			}
		}

		public void addRow(Task task) {
			rowData.add(task);
			int newRow = rowData.indexOf(task);
			this.fireTableRowsInserted(newRow,  newRow);
		}

		public boolean isCellEditable(int row, int col) {
			if (col == 0)
				return false;
			return true;
		}

		public void setValueAt(Object value, int row, int col) {
			Task item = rowData.get(row);
			switch (col) {
			case 1:
				//item.setVaccineName((String) value);
			}
			fireTableCellUpdated(row, col);
		}
		public ArrayList<Task> getRowData() {
			return rowData;
		}
		public void setRowData(ArrayList<Task> rowData) {
			this.rowData = rowData;
		}
	}

}
