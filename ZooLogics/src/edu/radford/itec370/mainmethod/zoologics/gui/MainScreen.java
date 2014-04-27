package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.print.*;

import edu.radford.itec370.mainmethod.zoologics.Application;

public class MainScreen extends JFrame {

	// constants
	private static final long serialVersionUID = -6514056067808688533L;
	private static final String[] COLUMN_HEADER = new String[] {"Task Tpye", "Animal", "Description", "Due"};
	private static final int PAGE_EXISTS = 0;
	private static final int NO_SUCH_PAGE = 0;
	
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

	public MainScreen(Application application) {
		super();
	}
	
	public void buildGUI() {
		// set up JFrame properties
		setTitle(Application.getAppName() + " Main Task Screen");
		setIconImage(Application.getAppIcon());
		setSize(new Dimension(650, 449));
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		// build north panel
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTasks = new JLabel("Tasks:");
		lblTasks.setFont(new Font("Tahoma", Font.BOLD, 14));
		northPanel.add(lblTasks);
		getContentPane().add(northPanel,BorderLayout.NORTH);

		// build center panel
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

		mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic(KeyEvent.VK_X);
		mntmExit.addActionListener(new MenuListener());
		mnFile.add(mntmExit);
		
		mntmPrint = new JMenuItem("Print");
		mntmPrint.setMnemonic(KeyEvent.VK_X);
		mntmPrint.addActionListener(new MenuListener());
		mnFile.add(mntmPrint); 

		JMenu mnAbout = new JMenu("About");
		mnAbout.setMnemonic(KeyEvent.VK_B);
		menuBar_1.add(mnAbout);

		mntmAboutMainMethod = new JMenuItem("About Main() Method");
		mntmAboutMainMethod.addActionListener(new MenuListener());
		mnAbout.add(mntmAboutMainMethod);
	}
	
	 public int print(Graphics g, PageFormat pf, int page)
		      throws PrinterException {

		    // We have only one page, and 'page'
		    // is zero-based
		    if (page > 0) {
		         return NO_SUCH_PAGE;
		    }

		    Graphics2D g2d = (Graphics2D)g;
		    g2d.translate(pf.getImageableX(), pf.getImageableY());

		    // Now we perform our rendering
		    g.drawString(getName(), 100, 100);
//		    g.drawString(getMainSceen(), 200, 100);
		    

		    // tell the caller that this page is part
		    // of the printed document
		    return PAGE_EXISTS;
		  }
		
	public Application getApplication() {
		return application;
	}

	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmExit)
				System.exit(0);
			else if (e.getSource() == mntmVaccinePanel) {
				VaccinePanel vaccinePanel = new VaccinePanel();
				vaccinePanel.setVisible(true);
			} else if (e.getSource() == mntmSpeciesPanel) {
				SpeciesPanel speciesPanel = new SpeciesPanel(null); // TODO Fix this
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
			} else if (e.getSource() == mntmAboutMainMethod) {
				AboutMainMethod aboutmainmethod = new AboutMainMethod();
				aboutmainmethod.setVisible(true);
			}
			 
		}
	}
}
