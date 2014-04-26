package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.radford.itec370.mainmethod.zoologics.Application;


public class AboutMainMethod extends JFrame {
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
	private StatusBar statusBar;
	public AboutMainMethod() {
		setTitle(Application.getAppName() + " About Main() Method");
		setIconImage(Application.getAppIcon());
		setSize(new Dimension(650, 449));
		getContentPane().setLayout(new BorderLayout());
		statusBar = new StatusBar();
		getContentPane().add(statusBar,BorderLayout.SOUTH);
		
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
	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmExit)
				System.exit(0);
			else if (e.getSource() == mntmVaccinePanel) {
				VaccinePanel vaccinePanel = new VaccinePanel();
				vaccinePanel.setVisible(true);
			} else if (e.getSource() == mntmSpeciesPanel) {
				SpeciesPanel speciesPanel = new SpeciesPanel(null); // TODO Fix
																	// this
				speciesPanel.setVisible(true);
			} else if (e.getSource() == mntmAnimalReport) {
				AnimalVaccinationReportPanel animalReport = new AnimalVaccinationReportPanel();
				animalReport.setVisible(true);
			} else if (e.getSource() == mntmAnimalPanel) {
				AnimalPanel animalPanel = new AnimalPanel();
				animalPanel.setVisible(true);
			} else if (e.getSource() == mntmAdminPanel) {
				StaffPanel adminPanel = new StaffPanel();
				adminPanel.setVisible(true);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
	}

}
