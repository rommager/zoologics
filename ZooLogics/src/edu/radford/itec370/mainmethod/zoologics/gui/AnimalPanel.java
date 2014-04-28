package edu.radford.itec370.mainmethod.zoologics.gui;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Species;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.Font;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AnimalPanel extends JFrame implements Navigable {

	// constants
	private static final long serialVersionUID = 6632886394131544115L;
	public static final String WINDOW_TITLE = Application.getAppName() + " Animal Profile";
	public static final String PHOTO_FOLDER = "./photos/"; 
	public static final String DEFAULT_THUMBNAIL_FILE = "default_thumbnail.png";

	// class variables
	private ArrayList <Animal> allAnimals;
	private ArrayList <Animal> filteredAnimals;
	private int index;

	// gui elements
	private JPanel animalPanel;
	private JTextField txtName;
	private JTextField txtSpecies;
	private JTextField txtSex;
	private JTextField txtFather;
	private JTextField txtZooID;
	private JTextField txtBreed;
	private JTextField txtDOB;
	private JTextField txtMother;
	private JTextField txtIDNumber;
	private JRadioButton rdbtnChipYes;
	private JRadioButton rdbtnChipNo;
	private JTextPane txtMarkings;
	private JTextPane txtNotes;
	private JPanel pnlPhoto;
	private JLabel thumbnail;
	NavigatorBar navPanel;

	// constructors
	private AnimalPanel() {
		super();
		// initialize class variables;
		index = 0;

		// set up window
		setTitle(WINDOW_TITLE);
		setIconImage(Application.getAppImage());
		this.setSize(new Dimension(836, 480));
		getContentPane().setLayout(new BorderLayout());

		// add navigator bar in south window area
		navPanel = new NavigatorBar(this);

		getContentPane().add(navPanel, BorderLayout.SOUTH);

		// build animal panel		
		animalPanel = new JPanel();
		animalPanel.setLayout(null);

		txtName = new JTextField();
		txtName.setBounds(121, 30, 210, 20);
		animalPanel.add(txtName);

		pnlPhoto = new JPanel();
		pnlPhoto.setBounds(389, 227, 265, 179);
		thumbnail = new JLabel();
		thumbnail.setBounds(389, 227, 262, 179);
		thumbnail.setSize(new Dimension(265,180));
		animalPanel.add(pnlPhoto);
		pnlPhoto.add(thumbnail);


		txtSpecies = new JTextField();
		txtSpecies.setBounds(121, 62, 210, 20);
		animalPanel.add(txtSpecies);

		txtSex = new JTextField();
		txtSex.setBounds(121, 93, 210, 20);
		animalPanel.add(txtSex);

		txtFather = new JTextField();
		txtFather.setBounds(121, 124, 210, 20);
		animalPanel.add(txtFather);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(28, 33, 46, 14);
		animalPanel.add(lblName);

		JLabel lblSpecies = new JLabel("Species");
		lblSpecies.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSpecies.setBounds(28, 65, 46, 14);
		animalPanel.add(lblSpecies);

		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex.setBounds(28, 96, 46, 14);
		animalPanel.add(lblSex);

		JLabel lblNewLabel = new JLabel("Father");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(28, 127, 46, 14);
		animalPanel.add(lblNewLabel);

		txtMarkings = new JTextPane();
		JScrollPane scrollPane1 = new JScrollPane(txtMarkings);
		scrollPane1.setBounds(28, 202, 303, 63);
		animalPanel.add(scrollPane1);

		txtNotes = new JTextPane();
		JScrollPane scrollPane2 = new JScrollPane(txtNotes);
		scrollPane2.setBounds(28, 283, 303, 123);
		animalPanel.add(scrollPane2);

		JLabel lblDescriptiveMarkings = new JLabel("Descriptive Markings");
		lblDescriptiveMarkings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescriptiveMarkings.setBounds(10, 187, 152, 14);
		animalPanel.add(lblDescriptiveMarkings);

		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotes.setBounds(10, 266, 46, 14);
		animalPanel.add(lblNotes);

		JLabel lblNewLabel_1 = new JLabel("Zoo ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(389, 33, 46, 14);
		animalPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Breed");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(389, 65, 46, 14);
		animalPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Date of Birth");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(389, 96, 85, 14);
		animalPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Mother");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(389, 127, 46, 14);
		animalPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("ID Number");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(389, 158, 61, 14);
		animalPanel.add(lblNewLabel_5);

		rdbtnChipYes = new JRadioButton("Yes");
		rdbtnChipYes.setMnemonic(KeyEvent.VK_Y);
		rdbtnChipYes.setBounds(122, 151, 55, 23);
		animalPanel.add(rdbtnChipYes);

		rdbtnChipNo = new JRadioButton("No");
		rdbtnChipNo.setMnemonic(KeyEvent.VK_N);
		rdbtnChipNo.setBounds(179, 151, 46, 23);
		animalPanel.add(rdbtnChipNo);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnChipYes);
		group.add(rdbtnChipNo);

		JLabel lblIdChip = new JLabel("Tattoo or Chip?");
		lblIdChip.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdChip.setBounds(28, 155, 102, 14);
		animalPanel.add(lblIdChip);

		txtZooID = new JTextField();
		txtZooID.setBounds(484, 30, 170, 20);
		animalPanel.add(txtZooID);
		txtZooID.setColumns(10);

		txtBreed = new JTextField();
		txtBreed.setBounds(484, 62, 170, 20);
		animalPanel.add(txtBreed);
		txtBreed.setColumns(10);

		txtDOB = new JTextField();
		txtDOB.setBounds(484, 93, 170, 20);
		animalPanel.add(txtDOB);
		txtDOB.setColumns(10);

		txtMother = new JTextField();
		txtMother.setBounds(484, 124, 170, 20);
		animalPanel.add(txtMother);
		txtMother.setColumns(10);

		txtIDNumber = new JTextField();
		txtIDNumber.setBounds(484, 155, 170, 20);
		animalPanel.add(txtIDNumber);
		txtIDNumber.setColumns(10);

		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoto.setBounds(389, 202, 46, 14);
		animalPanel.add(lblPhoto);

		getContentPane().add(animalPanel, BorderLayout.CENTER);

		// Set up button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(160,-1));
		buttonPanel.setLayout(null);

		/*		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(678, 315, 89, 23);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		animalPanel.add(btnSearch);
		 */

		JButton btnHistory = new JButton("Vaccination History");
		//btnHistory.setBounds(664, 315, 146, 23);
		btnHistory.setBounds(5, 315, 146, 23);
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				print();
			}
		});
		buttonPanel.add(btnHistory);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSave.setBounds(5, 349, 146, 23);
		buttonPanel.add(btnSave);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton caller = (JButton) e.getSource();				
				JFrame caller2 = (JFrame) caller.getParent().getParent().getParent().getParent().getParent();
				caller2.dispose();
			}
		});
		btnClose.setBounds(5, 383, 146, 23);
		buttonPanel.add(btnClose);

		getContentPane().add(buttonPanel, BorderLayout.EAST);

	}

	public AnimalPanel(ArrayList<Animal> animals) {
		this();
		this.allAnimals = animals;
		this.filteredAnimals = animals;
		index = 0;
		updateGUI();
	}

	public void setColor(Color color) {
		animalPanel.setBackground(color);
		rdbtnChipYes.setBackground(color);
		rdbtnChipNo.setBackground(color);
		pnlPhoto.setBackground(color);
	}

	public void updateGUI() {
		if (filteredAnimals.size() == 0)
			animalPanel.setVisible(false);
		else
			animalPanel.setVisible(true);

		if (animalPanel.isVisible()) {
			this.txtName.setText(getAnimal().getName());
			if (getAnimal().getSpecies() != null)
				this.txtSpecies.setText(getAnimal().getSpecies().getSpeciesName());
			else
				this.txtSpecies.setText("");
			if (Character.getNumericValue(getAnimal().getSex()) != -1)
				this.txtSex.setText(Character.toString(getAnimal().getSex()));
			else
				this.txtSex.setText("");
			this.txtFather.setText(getAnimal().getFather());
			this.txtMother.setText(getAnimal().getMother());
			this.txtZooID.setText(Integer.toString(getAnimal().getAnimalID()));
			this.txtBreed.setText(getAnimal().getBreed());
			this.txtIDNumber.setText(getAnimal().getChipId());
			this.txtMarkings.setText(getAnimal().getMarkings());
			this.txtNotes.setText(getAnimal().getNotes());
			// TODO Add Date of birth
			if(getAnimal().isIdenficationChip()){
				this.rdbtnChipYes.setSelected(true);
			}
			else {
				this.rdbtnChipNo.setSelected(true);
			}
			this.setThumbnail(getAnimal().getThumbnail());
		}
		updateRecordCount();
	}

	public void save() {
		try {
			Animal a = getAnimal();
			a.setName(txtName.getText());
			a.setSpecies(new Species(txtSpecies.getText()));   //TODO lookup existing species from Application
			if (!txtSex.getText().isEmpty())
				a.setSex(txtSex.getText().toCharArray()[0]);   //TODO set txtSex to a max length of 1, and allow only m or f entries
			else
				a.setSex(' ');
			a.setFather(txtFather.getText());
			a.setMother(txtMother.getText());
			a.setAnimalID(Integer.parseInt(txtZooID.getText()));
			a.setBreed(txtBreed.getText());
			a.setChipId(txtIDNumber.getText());
			a.setMarkings(txtMarkings.getText());
			a.setNotes(txtNotes.getText());
			if(this.rdbtnChipYes.isSelected())
				a.setIdenficationChip(true);
			else
				a.setIdenficationChip(false);
			updateGUI();
		}
		catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
		}
	}


	// setters and getters 
	public Animal getAnimal() {
		return filteredAnimals.get(index);
	}

	public void setAnimal(Animal animal) {
		index = filteredAnimals.indexOf(animal);
		updateGUI();
	}

	public void setThumbnail(String fileName)  {
		URL jarLocation = AnimalPanel.class.getProtectionDomain().getCodeSource().getLocation();
		URL imageURL = null;
		try {
			imageURL = new URL(jarLocation, PHOTO_FOLDER + fileName);
		} catch (MalformedURLException e) {
			// do nothing
		}

		File newFile = new File(imageURL.getPath());
		if (!newFile.exists())
			imageURL = AnimalPanel.class.getResource(DEFAULT_THUMBNAIL_FILE);

		Image image = new ImageIcon(imageURL).getImage();
		thumbnail.setIcon(new ImageIcon(image.getScaledInstance(265, 180, Image.SCALE_SMOOTH)));

	}

	public ArrayList<Animal> getAnimals() {
		return filteredAnimals;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.allAnimals = animals;
		this.filteredAnimals = animals;
		index = 0;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		updateGUI();
	}

	// interface implementations
	@Override
	public void firstRecord() {
		index = 0;
		updateGUI();
	}

	@Override
	public void previousRecord() {
		if (index > 0) {
			index--;
			updateGUI();
		}
	}

	@Override
	public void nextRecord() {
		if (index < filteredAnimals.size()-1) {
			index++;
			updateGUI();
		}
	}

	@Override
	public void lastRecord() {
		index = filteredAnimals.size()-1;
		updateGUI();
	}

	@Override
	public void newRecord() {
		Animal newAnimal = new Animal();
		filteredAnimals.add(newAnimal);
		index = filteredAnimals.indexOf(newAnimal);
		updateGUI();
	}

	@Override
	public void applyFilter(String filter) {
		if (filter == null) {
			if (filteredAnimals != allAnimals) {
				if (filteredAnimals.size() != 0)
					index = allAnimals.indexOf(filteredAnimals.get(index));
				else
					index = 0;
				filteredAnimals = allAnimals;
				updateGUI();
			}
		}
		else {
			index = 0;
			filteredAnimals = new ArrayList<Animal>();
			for (Animal animal : allAnimals) {
				if (animal.isVisibleWithFilter(filter))
					filteredAnimals.add(animal);
			}
			updateGUI();
		}
	}

	public void print() {
		Color color = animalPanel.getBackground();
		setColor(Color.WHITE);
		Application.runPrintJob(animalPanel);
		setColor(color);
	}

	private void updateRecordCount() {
		navPanel.updateRecordCount(index + 1, filteredAnimals.size());
	}

	// testing methods
	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal(2001, "Puja", new Species("Feline"), 'M', "Simba", "", true, "A12343212", "Orange Tiger", new Date(), "Orange with stripes", "Gentle, needs special attention","tiger.jpg"));
		animals.add(new Animal(2002, "Rawr", new Species("Feline"), 'M', "Timbre", "Saber", false, "", "Leopard", new Date(), "golden with ring spots", "Snappy","leopard.jpg"));
		animals.add(new Animal(2003, "Fran", new Species("Feline"), 'F', "Goomba", "Mush", true, "A12343201", "Ocelot", new Date(), "Cute, but dangerous", "Will eat your hand if you let her","ocelot.jpg"));
		animals.add(new Animal(2004, "George", new Species("Primate"), 'M', "unknown", "unknown", false, "", "golden-mantled tamarin", new Date(), "Has white cheeks","alpha male - watch for this one","tamarin.jpg"));
		animals.add(new Animal(2005, "Spots", new Species("Deer"), 'F', "unknown", "unknown", false, "", "White Tailed Deer", new Date(), "just another deer",""));

		AnimalPanel panel = new AnimalPanel(animals);
		panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setVisible(true);

	}
}
