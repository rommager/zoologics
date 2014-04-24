package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.Application;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class MainScreen extends JFrame implements MainScreenNav {
	// TODO Auto-generated method stub

	private JTable table;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu aboutMenu;
	private JMenuItem exitItem;
	private JMenuItem mntmExit;
	private JMenuItem mntmVaccinePanel;
	private JMenuItem mntmSpeciesPanel;
	private JMenuItem mntmAnimalReport;
	private JMenuItem mntmAnimalPanel;
	private JMenuItem mntmAdminPanel;

	public MainScreen() {
		setTitle(Application.getAppName() + " Main Task Screen");
		setIconImage(Application.getAppIcon());
		this.setSize(new Dimension(650, 449));
		getContentPane().setLayout(null);

		JLabel lblTasks = new JLabel("Tasks:");
		lblTasks.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTasks.setBounds(21, 36, 65, 26);
		getContentPane().add(lblTasks);

	//	JScrollPane scrollPane = new JScrollPane();
	//	scrollPane.setBounds(21, 73, 504, 195);
	//	getContentPane().add(scrollPane);
		
	//	DefaultTableModel model = new DefaultTableModel(null, new String[] { "Task Type", "Animal", "Description", "Due"});
	//	table = new JTable(model);
	//	JScrollPane scrollPane2 = new JScrollPane(table);
		
		table = new JTable(new DefaultTableModel(new Object[][] { }, new String[] {"Task Tpye", "Animal", "Description", "Due"}) {
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(21, 73, 504, 195);
		getContentPane().add(scrollPane);
	//	scrollPane.setColumnHeaderView(table);

		JButton btnOpenItem = new JButton("Open");
		btnOpenItem.setBounds(294, 279, 89, 23);
		getContentPane().add(btnOpenItem);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(419, 279, 89, 23);
		getContentPane().add(btnSearch);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setToolTipText("");
		setJMenuBar(menuBar_1);

		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar_1.add(mnFile);

		mntmAdminPanel = new JMenuItem("Admin Panel");
		mntmAdminPanel.addActionListener(new MenuListener());
		mnFile.add(mntmAdminPanel);

		mntmAnimalPanel = new JMenuItem("Animal Panel");
		mntmAnimalPanel.addActionListener(new MenuListener());
		mnFile.add(mntmAnimalPanel);

		mntmAnimalReport = new JMenuItem("Animal Report");
		mntmAnimalReport.addActionListener(new MenuListener());
		mnFile.add(mntmAnimalReport);

		mntmSpeciesPanel = new JMenuItem("Species Panel");
		mntmSpeciesPanel.addActionListener(new MenuListener());
		mnFile.add(mntmSpeciesPanel);

		mntmVaccinePanel = new JMenuItem("Vaccine Panel");
		mntmVaccinePanel.addActionListener(new MenuListener());
		mnFile.add(mntmVaccinePanel);

		mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic(KeyEvent.VK_X);
		mntmExit.addActionListener(new MenuListener());
		mnFile.add(mntmExit);

		JMenu mnAbout = new JMenu("About");
		mnAbout.setMnemonic(KeyEvent.VK_B);
		menuBar_1.add(mnAbout);

		JMenuItem mntmAboutMain = new JMenuItem("About Main() Method");
		mntmAboutMain.addActionListener(new MenuListener()); 
		mnAbout.add(mntmAboutMain);

	}
	
	private void add(MainScreenNav mainScreenNav, String south) {
		// TODO Auto-generated method stub
		
	}

	public MainScreen(String windowTitle) {
		this();
		this.setTitle(windowTitle);
	}
	
	public static void main(String[] args) {
		MainScreen tester = new MainScreen();
		tester.setVisible(true);
	}

	@Override
	public void tasks() {
		// TODO Auto-generated method stub

	}

	@Override
	public void applyFilter(String filter) {
		// TODO Auto-generated method stub

	}

	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmExit)
				System.exit(0);
			else if (e.getSource() == mntmVaccinePanel) {
				VaccinePanel vaccinePanel = new VaccinePanel();
				vaccinePanel.setVisible(true);
				}
			else if (e.getSource() == mntmSpeciesPanel) {
				SpeciesPanel speciesPanel = new SpeciesPanel();
				speciesPanel.setVisible(true);	
			}
			else if (e.getSource() == mntmAnimalReport) {
				AnimalVaccinationReportPanel animalReport = new AnimalVaccinationReportPanel();
				animalReport.setVisible(true);	
			}
			else if (e.getSource() == mntmAnimalPanel) {
				AnimalPanel animalPanel = new AnimalPanel();
				animalPanel.setVisible(true);	
		}
			else if (e.getSource() == mntmAdminPanel) {
				AdminPanel adminPanel = new AdminPanel();
				adminPanel.setVisible(true);	
		}
		}
	}



		public void actionPerformed(ActionEvent e) {
		}

	}


