package edu.radford.itec370.mainmethod.zoologics.gui;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.ComponentPrinter;
import edu.radford.itec370.mainmethod.zoologics.Species;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

import java.awt.Font;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AnimalPanel extends JFrame implements Navigable, DocumentListener, ActionListener  {

	// constants
	private static final long serialVersionUID = 6632886394131544115L;
	public static final String WINDOW_TITLE = Application.getAppName() + " Animal Profile";
	public static final String PHOTO_FOLDER = "./photos/"; 
	public static final String DEFAULT_THUMBNAIL_FILE = "default_thumbnail.png";


	// class variables
	private ArrayList <Animal> allAnimals;
	private ArrayList <Animal> filteredAnimals;
	private int index;
	private boolean dirty;	
	private boolean changing;

	// gui elements
	private JPanel animalPanel;
	private JTextField txtName;
	private JTextField txtSpecies;
	private JFormattedTextField txtSex;
	private JTextField txtFather;
	private JTextField txtAnimalID;
	private JTextField txtBreed;
	private JFormattedTextField txtDOB;
	private JTextField txtMother;
	private JTextField txtIDNumber;
	private JRadioButton rdbtnChipYes;
	private JRadioButton rdbtnChipNo;
	private JTextPane txtMarkings;
	private JTextPane txtNotes;
	private JPanel pnlPhoto;
	private JLabel thumbnail;
	private JButton btnSave;
	private NavigatorBar navPanel;

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
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new MyWindowListener());

		// add navigator bar in south window area
		navPanel = new NavigatorBar(this);

		getContentPane().add(navPanel, BorderLayout.SOUTH);

		// build animal panel		
		animalPanel = new JPanel();
		animalPanel.setLayout(null);

		txtAnimalID = new JTextField();
		txtAnimalID.setBounds(484, 30, 170, 20);
		txtAnimalID.setEditable(false);
		txtAnimalID.setBackground(Color.WHITE);
		animalPanel.add(txtAnimalID);

		try {
			txtDOB = new JFormattedTextField(Application.getDateFormat());
			txtDOB.setBounds(484, 93, 170, 20);
			MaskFormatter dateMask = new MaskFormatter("##/##/####");
			dateMask.install(txtDOB);
			txtDOB.getDocument().addDocumentListener(this);
			animalPanel.add(txtDOB);

			txtSex = new JFormattedTextField();
			txtSex.setBounds(121, 93, 210, 20);
			MaskFormatter sexMask = new MaskFormatter("U");
			sexMask.setValidCharacters("FM");
			sexMask.install(txtSex);
			txtSex.getDocument().addDocumentListener(this);
			animalPanel.add(txtSex);
		}
		catch (ParseException e) {

		}

		txtName = new JTextField();
		txtName.setBounds(121, 30, 210, 20);
		txtName.getDocument().addDocumentListener(this);
		animalPanel.add(txtName);

		txtSpecies = new JTextField();
		txtSpecies.setBounds(121, 62, 210, 20);
		txtSpecies.getDocument().addDocumentListener(this);
		animalPanel.add(txtSpecies);

		txtFather = new JTextField();
		txtFather.setBounds(121, 124, 210, 20);
		txtFather.getDocument().addDocumentListener(this);
		animalPanel.add(txtFather);

		txtMarkings = new JTextPane();
		JScrollPane scrollPane1 = new JScrollPane(txtMarkings);
		scrollPane1.setBounds(28, 202, 303, 63);
		txtMarkings.getDocument().addDocumentListener(this);
		animalPanel.add(scrollPane1);

		txtNotes = new JTextPane();
		JScrollPane scrollPane2 = new JScrollPane(txtNotes);
		scrollPane2.setBounds(28, 283, 303, 123);
		txtNotes.getDocument().addDocumentListener(this);
		animalPanel.add(scrollPane2);

		txtBreed = new JTextField();
		txtBreed.setBounds(484, 62, 170, 20);
		txtBreed.getDocument().addDocumentListener(this);
		animalPanel.add(txtBreed);

		txtMother = new JTextField();
		txtMother.setBounds(484, 124, 170, 20);
		txtMother.getDocument().addDocumentListener(this);
		animalPanel.add(txtMother);

		txtIDNumber = new JTextField();
		txtIDNumber.setBounds(484, 155, 170, 20);
		txtIDNumber.getDocument().addDocumentListener(this);
		animalPanel.add(txtIDNumber);

		rdbtnChipYes = new JRadioButton("Yes");
		rdbtnChipYes.setMnemonic(KeyEvent.VK_Y);
		rdbtnChipYes.setBounds(122, 151, 55, 23);
		rdbtnChipYes.addActionListener(this);
		animalPanel.add(rdbtnChipYes);

		rdbtnChipNo = new JRadioButton("No");
		rdbtnChipNo.setMnemonic(KeyEvent.VK_N);
		rdbtnChipNo.setBounds(179, 151, 46, 23);
		rdbtnChipNo.addActionListener(this);
		animalPanel.add(rdbtnChipNo);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnChipYes);
		group.add(rdbtnChipNo);

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

		JLabel lblIdChip = new JLabel("Tattoo or Chip?");
		lblIdChip.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdChip.setBounds(28, 155, 102, 14);
		animalPanel.add(lblIdChip);

		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoto.setBounds(389, 202, 46, 14);
		animalPanel.add(lblPhoto);

		pnlPhoto = new JPanel();
		pnlPhoto.setBounds(389, 227, 265, 179);
		thumbnail = new JLabel();
		thumbnail.setBounds(389, 227, 262, 179);
		thumbnail.setSize(new Dimension(265,180));
		animalPanel.add(pnlPhoto);
		pnlPhoto.add(thumbnail);

		getContentPane().add(animalPanel, BorderLayout.CENTER);

		// Set up button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(160,-1));
		buttonPanel.setLayout(null);

		JButton btnHistory = new JButton("Vaccination History");
		btnHistory.setBounds(5, 315, 146, 23);
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				print();
			}
		});
		buttonPanel.add(btnHistory);

		btnSave = new JButton("Save");
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
				closeWindow();
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
		changing = true;
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
			this.txtAnimalID.setText(Integer.toString(getAnimal().getAnimalID()));
			this.txtBreed.setText(getAnimal().getBreed());
			this.txtIDNumber.setText(getAnimal().getChipId());
			this.txtMarkings.setText(getAnimal().getMarkings());
			this.txtNotes.setText(getAnimal().getNotes());
			if (getAnimal().getDateOfBirth() != null)
				this.txtDOB.setText(Application.formatDateToString(getAnimal().getDateOfBirth()));
			if(getAnimal().isIdenficationChip()){
				this.rdbtnChipYes.setSelected(true);
			}
			else {
				this.rdbtnChipNo.setSelected(true);
			}
			this.setThumbnail(getAnimal().getThumbnail());
		}
		updateRecordCount();
		setDirty(false);
		changing = false;
	}

	public boolean save() {
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
			a.setAnimalID(Integer.parseInt(txtAnimalID.getText()));
			a.setBreed(txtBreed.getText());
			a.setChipId(txtIDNumber.getText());
			a.setMarkings(txtMarkings.getText());
			a.setNotes(txtNotes.getText());
			if(this.rdbtnChipYes.isSelected())
				a.setIdenficationChip(true);
			else
				a.setIdenficationChip(false);
			a.setDateOfBirth(Application.parseDate(txtDOB.getText()));
			updateGUI();
			return true;
		}
		catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		catch (ParseException e) {
			return false;
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

	private void setDirty(boolean dirty) {
		// if changing (refreshing GUI) then override dirty - it should always be false when changing!
		if (changing)
			dirty = false;
		if (this.dirty != dirty) {
			this.dirty = dirty;
			btnSave.setEnabled(dirty);
			if (dirty)
				this.setTitle(" * " + WINDOW_TITLE);
			else
				this.setTitle(WINDOW_TITLE);

		}
	}

	private boolean validated() {
		if (dirty) {
			int n = JOptionPane.showConfirmDialog(
					this, 
					"This record has been changed.  Would you like to save?",
					"Record Changed",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (n == JOptionPane.YES_OPTION)
				return save();
			else if (n == JOptionPane.NO_OPTION)
				return true;
			else
				return false;
		}
		else
			return true;
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
		if (index != 0) {
			if (validated()) {
				index = 0;
				updateGUI();
			}
		}
	}

	@Override
	public void previousRecord() {
		if (index > 0) {
			if (validated()) {
				index--;
				updateGUI();
			}
		}
	}

	@Override
	public void nextRecord() {
		if (index < filteredAnimals.size() - 1) {
			if (validated()) {
				index++;
				updateGUI();
			}
		}
	}

	@Override
	public void lastRecord() {
		if (index != filteredAnimals.size() - 1) {
			if (validated()) {
				index = filteredAnimals.size() - 1;
				updateGUI();
			}
		}
	}

	@Override
	public void newRecord() {
		if (validated()) {
			Animal newAnimal = new Animal();
			filteredAnimals.add(newAnimal);
			index = filteredAnimals.indexOf(newAnimal);
			updateGUI();
		}
	}

	@Override
	public void applyFilter(String filter) {
		if (validated()) {
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
	}

	public void print() {
		Color color = animalPanel.getBackground();
		setColor(Color.WHITE);
		ComponentPrinter.runPrintJob(animalPanel);
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
		//panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setVisible(true);

	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		setDirty(true);
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		setDirty(true);
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		setDirty(true);
	}

	public void closeWindow() {
		if (dirty) {
			if (validated()) 
				this.dispose();		
		}
		else
			this.dispose();

	}

	class MyWindowListener implements WindowListener {
		@Override
		public void windowClosing(WindowEvent e) {
			closeWindow();
		}
		@Override public void windowActivated(WindowEvent e) {}
		@Override public void windowClosed(WindowEvent e) {}
		@Override public void windowDeactivated(WindowEvent e) {}
		@Override public void windowDeiconified(WindowEvent e) {}
		@Override public void windowIconified(WindowEvent e) {}
		@Override public void windowOpened(WindowEvent e) {}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setDirty(true);
	}	
}
