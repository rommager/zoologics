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
	private final Action action = new SwingAction();
	JMenuItem mntmExit;
	JMenuItem mntmVaccinePanel;

	public MainScreen() {

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
		
		table = new JTable(new DefaultTableModel(new Object[][] { }, new String[] { "Task Tpye", "Animal", "Description", "Due" }) {
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(21, 73, 504, 195);
		getContentPane().add(scrollPane);
	//	scrollPane.setColumnHeaderView(table);

		JButton btnOpenItem = new JButton("Open Item");
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

		JMenuItem mntmAdminPanel = new JMenuItem("Admin Panel");
		mntmAdminPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnFile.add(mntmAdminPanel);

		JMenuItem mntmAnimalPanel = new JMenuItem("Animal Panel");
		mntmAnimalPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		mnFile.add(mntmAnimalPanel);

		JMenuItem mntmAnimalReport = new JMenuItem("Animal Report");
		mntmAnimalReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AnimalVaccinationReportPanel report = new AnimalVaccinationReportPanel();
				report.setVisible(true);
			}
		});
		mnFile.add(mntmAnimalReport);

		JMenuItem mntmSpeciesPanel = new JMenuItem("Species Panel");
		mntmSpeciesPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
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
		mntmAboutMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
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
				
		}
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
