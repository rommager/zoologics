package edu.radford.itec370.mainmethod.zoologics.gui;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
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

public class MainScreen extends JFrame implements MainScreenNav {
		// TODO Auto-generated method stub

	
			private JTable table;
			private JMenuBar menuBar;
			private JMenu fileMenu;
			private JMenu aboutMenu;
			private JMenuItem exitItem;

			public MainScreen() {
				
			
				setIconImage(Application.getAppIcon());
				this.setSize(new Dimension(800, 480));
				getContentPane().setLayout(null);
				
				JLabel lblTasks = new JLabel("Tasks:");
				lblTasks.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTasks.setBounds(21, 36, 65, 26);
				getContentPane().add(lblTasks);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(21, 73, 504, 195);
				getContentPane().add(scrollPane);
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{"Task Type", "Animal", "Description", "Due"},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
					},
					new String[] {
						"Task Tpye", "Animal", "Description", "Due"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				scrollPane.setColumnHeaderView(table);
				
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
				
				JMenuItem mntmVaccinePanel = new JMenuItem("Vaccine Panel");
				mntmVaccinePanel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});
				mnFile.add(mntmVaccinePanel);
				
				JMenu mnAbout = new JMenu("About");
				menuBar_1.add(mnAbout);
				
				JMenuItem mntmAboutMain = new JMenuItem("About Main() Method");
				mntmAboutMain.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});
				mnAbout.add(mntmAboutMain);
			
				
				}
			
			@Override
			public void tasks() {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void applyFilter(String filter) {
				// TODO Auto-generated method stub
				
			
			
	}
}
