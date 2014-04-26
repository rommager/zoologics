package edu.radford.itec370.mainmethod.zoologics.gui;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Species;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

public class AnimalPanel extends JFrame implements Navigable, Serializable {
	
	private static final long serialVersionUID = 6632886394131544115L;
	public static final String WINDOW_TITLE = Application.getAppName() + " Animal Profile";
	public static final String PHOTO_FOLDER = "./photos/"; 
	public static final String DEFAULT_THUMBNAIL_FILE = "default_thumbnail.png";
	private ArrayList <Animal> animals;
	private int index;
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
	
	public static void main(String[] args) {
		AnimalPanel panel = new AnimalPanel();
		
		panel.setVisible(true);
		panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setAnimals(new ArrayList<Animal>());
		panel.getAnimals().add(new Animal(1001, "Puja", new Species("Feline"), 'M', "Simba", "", true, "A12343212", "Orange Tiger", new Date(), "white with stripes", "Gentle, needs special attention","tiger.jpg"));
		panel.getAnimals().add(new Animal(1002, "Rawr", new Species("Feline"), 'M', "Timbre", "Saber", false, "", "Leopard", new Date(), "orange with stripes", "Snappy","leopard.jpg"));
		panel.getAnimals().add(new Animal(1003, "Fran", new Species("Feline"), 'F', "Goomba", "Mush", true, "A12343201", "Ocelot", new Date(), "not many stripes", "Will eat your hand if you let her","ocelot.jpg"));
		panel.getAnimals().add(new Animal(1004, "George", new Species("Primate"), 'M', "unknown", "unknown", false, "", "golden-mantled tamarin", new Date(), "alpha male","watch for this one","tamarin.jpg"));
		panel.getAnimals().add(new Animal(1005, "Spots", new Species("Deer"), 'F', "unknown", "unknown", false, "", "White Tailed Deer", new Date(), "just another deer",""));
		panel.setAnimal(panel.getAnimals().get(0));
	}
	
	public AnimalPanel() {
		// initialize class variables;
		index = 0;
		
		// set up window
		setTitle(WINDOW_TITLE);
		setIconImage(Application.getAppIcon());
		this.setSize(new Dimension(800, 480));
		getContentPane().setLayout(new BorderLayout());
		
		// add navigator bar in south window area
		NavigatorBar navPanel = new NavigatorBar(this);
//		navPanel.setNewRecordVisible(false);
//		navPanel.setSearchBoxVisible(false);
		navPanel.setBounds(0, 415, 784, 30);
		getContentPane().add(navPanel, BorderLayout.SOUTH);
		
		// set up animal panel and add to main frame		
		JPanel animalPanel = new JPanel();
		getContentPane().add(animalPanel, BorderLayout.CENTER);
		
		// build animal panel
		animalPanel.setFont(new Font("Tahoma", Font.BOLD, 11));
		animalPanel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(121, 30, 102, 20);
		animalPanel.add(txtName);
		txtName.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(678, 315, 89, 23);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		animalPanel.add(btnSearch);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSave.setBounds(678, 349, 89, 23);
		animalPanel.add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton caller = (JButton) e.getSource();				
				JFrame caller2 = (JFrame) caller.getParent().getParent().getParent().getParent().getParent();
				caller2.dispose();
			}
		});
		btnClose.setBounds(678, 383, 89, 23);
		animalPanel.add(btnClose);
		
		pnlPhoto = new JPanel();
		pnlPhoto.setBounds(389, 227, 265, 179);
		thumbnail = new JLabel();
		thumbnail.setBounds(389, 227, 262, 179);
		thumbnail.setSize(new Dimension(265,180));
		animalPanel.add(pnlPhoto);
		pnlPhoto.add(thumbnail);
		
				
		txtSpecies = new JTextField();
		txtSpecies.setBounds(121, 62, 102, 20);
		animalPanel.add(txtSpecies);
		txtSpecies.setColumns(10);
		
		txtSex = new JTextField();
		txtSex.setBounds(121, 93, 102, 20);
		animalPanel.add(txtSex);
		txtSex.setColumns(10);
		
		txtFather = new JTextField();
		txtFather.setBounds(121, 124, 102, 20);
		animalPanel.add(txtFather);
		txtFather.setColumns(10);
		
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
		rdbtnChipYes.setBounds(121, 148, 55, 23);
		animalPanel.add(rdbtnChipYes);
		
		rdbtnChipNo = new JRadioButton("No");
		rdbtnChipNo.setMnemonic(KeyEvent.VK_N);
		rdbtnChipNo.setBounds(178, 148, 46, 23);
		animalPanel.add(rdbtnChipNo);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnChipYes);
		group.add(rdbtnChipNo);
		
		JLabel lblIdChip = new JLabel("Tattoo or Chip?");
		lblIdChip.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdChip.setBounds(27, 152, 102, 14);
		animalPanel.add(lblIdChip);
		
		txtZooID = new JTextField();
		txtZooID.setBounds(484, 30, 137, 20);
		animalPanel.add(txtZooID);
		txtZooID.setColumns(10);
		
		txtBreed = new JTextField();
		txtBreed.setBounds(484, 62, 137, 20);
		animalPanel.add(txtBreed);
		txtBreed.setColumns(10);
		
		txtDOB = new JTextField();
		txtDOB.setBounds(484, 93, 137, 20);
		animalPanel.add(txtDOB);
		txtDOB.setColumns(10);
		
		txtMother = new JTextField();
		txtMother.setBounds(484, 124, 137, 20);
		animalPanel.add(txtMother);
		txtMother.setColumns(10);
		
		txtIDNumber = new JTextField();
		txtIDNumber.setBounds(484, 155, 137, 20);
		animalPanel.add(txtIDNumber);
		txtIDNumber.setColumns(10);
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoto.setBounds(389, 202, 46, 14);
		animalPanel.add(lblPhoto);		
				
	}
	
	public Animal getAnimal() {
		return animals.get(index);
	}

	public void setAnimal(Animal animal) {
		index = animals.indexOf(animal);
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
	
	public void updateGUI() {
		this.txtName.setText(getAnimal().getName());
		this.txtSpecies.setText(getAnimal().getSpecies().getSpeciesName());
		this.txtSex.setText(Character.toString(getAnimal().getSex()));
		this.txtFather.setText(getAnimal().getSire());
		this.txtMother.setText(getAnimal().getDam());
		this.txtZooID.setText(Integer.toString(getAnimal().getId()));
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
	
	public void save() {
		Animal a = getAnimal();
		a.setName(txtName.getText());
		a.setSpecies(new Species(txtSpecies.getText()));   //TODO lookup existing species from Application
		a.setSex(txtSex.getText().toCharArray()[0]);  //TODO set txtSex to a max length of 1, and allow only m or f entries
		a.setSire(txtFather.getText());
		a.setDam(txtMother.getText());
		a.setId(Integer.parseInt(txtZooID.getText()));
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

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}
	
		public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		updateGUI();
	}

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
		if (index < animals.size()-1) {
			index++;
			updateGUI();
	}
	}

	@Override
	public void lastRecord() {
		index = animals.size()-1;
		updateGUI();
	}

	@Override
	public void newRecord() {
		Animal newAnimal = new Animal();
		animals.add(newAnimal);
		index = animals.indexOf(newAnimal);
		updateGUI();
	}

	@Override
	public void applyFilter(String filter) {
		txtDOB.setText(filter);
		
	}
}
