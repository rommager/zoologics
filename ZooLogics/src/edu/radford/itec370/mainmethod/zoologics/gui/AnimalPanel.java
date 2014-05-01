package edu.radford.itec370.mainmethod.zoologics.gui;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.net.URL;

import edu.radford.itec370.mainmethod.zoologics.Animal;
import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Species;
import edu.radford.itec370.mainmethod.zoologics.Vaccination;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;

public class AnimalPanel extends DataManagerFrame<Animal> {

	// constants
	private static final long serialVersionUID = 6632886394131544115L;
	public static final String WINDOW_TITLE = Application.getAppName() + " Animal Profile";
	public static final String PHOTO_FOLDER = "./photos/";
	public static final String DEFAULT_THUMBNAIL_FILE = "default_thumbnail.png";
	// gui elements
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

	// constructors
	private AnimalPanel() {
		// call super constructor, because its awesome
		super();

		// set up window
		setTitle(WINDOW_TITLE);
		setIconImage(Application.getAppImage());
		this.setSize(new Dimension(836, 480));

		// build data panel		
		dataPanel = new JPanel();
		dataPanel.setLayout(null);

		txtAnimalID = new JTextField();
		txtAnimalID.setBounds(484, 30, 170, 20);
		txtAnimalID.setEditable(false);
		txtAnimalID.setBackground(Color.WHITE);
		dataPanel.add(txtAnimalID);

		try {
			txtDOB = new JFormattedTextField(Application.getDateFormat());
			txtDOB.setBounds(484, 93, 170, 20);
			MaskFormatter dateMask = new MaskFormatter("##/##/####");
			dateMask.install(txtDOB);
			txtDOB.getDocument().addDocumentListener(dirtyListener);
			dataPanel.add(txtDOB);

			txtSex = new JFormattedTextField();
			txtSex.setBounds(121, 93, 210, 20);
			MaskFormatter sexMask = new MaskFormatter("U");
			sexMask.setValidCharacters("FM");
			sexMask.install(txtSex);
			txtSex.getDocument().addDocumentListener(dirtyListener);
			dataPanel.add(txtSex);
		}
		catch (ParseException e) {

		}

		txtName = new JTextField();
		txtName.setBounds(121, 30, 210, 20);
		txtName.getDocument().addDocumentListener(dirtyListener);
		dataPanel.add(txtName);

		txtSpecies = new JTextField();
		txtSpecies.setBounds(121, 62, 210, 20);
		txtSpecies.getDocument().addDocumentListener(dirtyListener);
		dataPanel.add(txtSpecies);

		txtFather = new JTextField();
		txtFather.setBounds(121, 124, 210, 20);
		txtFather.getDocument().addDocumentListener(dirtyListener);
		dataPanel.add(txtFather);

		txtMarkings = new JTextPane();
		JScrollPane scrollPane1 = new JScrollPane(txtMarkings);
		scrollPane1.setBounds(28, 202, 303, 63);
		txtMarkings.getDocument().addDocumentListener(dirtyListener);
		dataPanel.add(scrollPane1);

		txtNotes = new JTextPane();
		JScrollPane scrollPane2 = new JScrollPane(txtNotes);
		scrollPane2.setBounds(28, 283, 303, 123);
		txtNotes.getDocument().addDocumentListener(dirtyListener);
		dataPanel.add(scrollPane2);

		txtBreed = new JTextField();
		txtBreed.setBounds(484, 62, 170, 20);
		txtBreed.getDocument().addDocumentListener(dirtyListener);
		dataPanel.add(txtBreed);

		txtMother = new JTextField();
		txtMother.setBounds(484, 124, 170, 20);
		txtMother.getDocument().addDocumentListener(dirtyListener);
		dataPanel.add(txtMother);

		txtIDNumber = new JTextField();
		txtIDNumber.setBounds(484, 155, 170, 20);
		txtIDNumber.getDocument().addDocumentListener(dirtyListener);
		dataPanel.add(txtIDNumber);

		rdbtnChipYes = new JRadioButton("Yes");
		rdbtnChipYes.setMnemonic(KeyEvent.VK_Y);
		rdbtnChipYes.setBounds(122, 151, 55, 23);
		rdbtnChipYes.addActionListener(dirtyListener);
		dataPanel.add(rdbtnChipYes);

		rdbtnChipNo = new JRadioButton("No");
		rdbtnChipNo.setMnemonic(KeyEvent.VK_N);
		rdbtnChipNo.setBounds(179, 151, 46, 23);
		rdbtnChipNo.addActionListener(dirtyListener);
		dataPanel.add(rdbtnChipNo);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnChipYes);
		group.add(rdbtnChipNo);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(28, 33, 46, 14);
		dataPanel.add(lblName);

		JLabel lblSpecies = new JLabel("Species");
		lblSpecies.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSpecies.setBounds(28, 65, 46, 14);
		dataPanel.add(lblSpecies);

		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex.setBounds(28, 96, 46, 14);
		dataPanel.add(lblSex);

		JLabel lblNewLabel = new JLabel("Father");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(28, 127, 46, 14);
		dataPanel.add(lblNewLabel);

		JLabel lblDescriptiveMarkings = new JLabel("Descriptive Markings");
		lblDescriptiveMarkings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescriptiveMarkings.setBounds(10, 187, 152, 14);
		dataPanel.add(lblDescriptiveMarkings);

		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotes.setBounds(10, 266, 46, 14);
		dataPanel.add(lblNotes);

		JLabel lblNewLabel_1 = new JLabel("Zoo ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(389, 33, 46, 14);
		dataPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Breed");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(389, 65, 46, 14);
		dataPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Date of Birth");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(389, 96, 85, 14);
		dataPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Mother");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(389, 127, 46, 14);
		dataPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("ID Number");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(389, 158, 61, 14);
		dataPanel.add(lblNewLabel_5);

		JLabel lblIdChip = new JLabel("Tattoo or Chip?");
		lblIdChip.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdChip.setBounds(28, 155, 102, 14);
		dataPanel.add(lblIdChip);

		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoto.setBounds(389, 202, 46, 14);
		dataPanel.add(lblPhoto);

		pnlPhoto = new JPanel();
		pnlPhoto.setBounds(389, 227, 265, 180);
		thumbnail = new JLabel();
		thumbnail.setSize(new Dimension(265,180));
		dataPanel.add(pnlPhoto);
		pnlPhoto.add(thumbnail);

		getContentPane().add(dataPanel, BorderLayout.CENTER);

		// Set up button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(160,-1));
		buttonPanel.setLayout(null);

//		JButton btnHistory = new JButton("Vaccination History");
		JButton btnHistory = new JButton("Print");
		btnHistory.setBounds(5, 315, 146, 23);
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				print();
			}
		});
		buttonPanel.add(btnHistory);

		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		saveButton.setBounds(5, 349, 146, 23);
		buttonPanel.add(saveButton);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnClose.setBounds(5, 383, 146, 23);
		buttonPanel.add(btnClose);

		getContentPane().add(buttonPanel, BorderLayout.EAST);

		final JButton btnPhotos = new JButton("Photos");
		btnPhotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(btnPhotos);	
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File sourceFile = fc.getSelectedFile();
					File destinationFile = Application.getFile(PHOTO_FOLDER, sourceFile.getName());
					boolean success = Application.copyFile(sourceFile, destinationFile);
					if (success) {
						getItem().setThumbnail(sourceFile.getName());
						updatePhoto();}
					else {
						//TODO show file error dialog
					}
				}
			}
		});
		btnPhotos.setBounds(5, 281, 145, 23);
		buttonPanel.add(btnPhotos);
		
		JButton btnNewVaccination = new JButton("New Vaccination");
		btnNewVaccination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vaccination vacc = new Vaccination();
				TaskFrame frame = new TaskFrame(vacc);
				Application.getRunningInstance().getAllActiveTasks().add(vacc);
				frame.setVisible(true);
				frame.updateGUIElements();
				frame.pack();
			}
		});
		btnNewVaccination.setBounds(5, 247, 145, 23);
		buttonPanel.add(btnNewVaccination);

	}

	public AnimalPanel(ArrayList<Animal> animals) {
		this();
		this.fullArrayList = animals;
		this.filteredArrayList = animals;
		index = 0;
		updateGUI();
	}

	// methods
	@Override
	public void updateGUIElements() {
		this.txtName.setText(getItem().getName());
		if (getItem().getSpecies() != null)
			this.txtSpecies.setText(getItem().getSpecies().getSpeciesName());
		else
			this.txtSpecies.setText("");
		if (Character.getNumericValue(getItem().getSex()) != -1)
			this.txtSex.setText(Character.toString(getItem().getSex()));
		else
			this.txtSex.setText("");
		this.txtFather.setText(getItem().getFather());
		this.txtMother.setText(getItem().getMother());
		this.txtAnimalID.setText(Integer.toString(getItem().getAnimalID()));
		this.txtBreed.setText(getItem().getBreed());
		this.txtIDNumber.setText(getItem().getChipId());
		this.txtMarkings.setText(getItem().getMarkings());
		this.txtNotes.setText(getItem().getNotes());
		if (getItem().getDateOfBirth() != null)
			this.txtDOB.setText(Application.formatDateToString(getItem().getDateOfBirth()));
		if(getItem().isIdenficationChip()){
			this.rdbtnChipYes.setSelected(true);
		}
		else {
			this.rdbtnChipNo.setSelected(true);
		}
		this.updatePhoto();
	}

	@Override
	public boolean save() {
		try {
			Animal a = getItem();
			a.setName(txtName.getText());
			a.setSpecies(Application.findSpeciesByName(txtSpecies.getText()));
			if (!txtSex.getText().isEmpty())
				a.setSex(txtSex.getText().toCharArray()[0]);
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

	@Override
	protected void setComponentColorForPrinting(Color color) {
		rdbtnChipYes.setBackground(color);
		rdbtnChipNo.setBackground(color);
		pnlPhoto.setBackground(color);
	}

	public void updatePhoto()  {
		String filename = getItem().getThumbnail();
		URL imageURL = Application.getLocalFilePath(PHOTO_FOLDER, filename);

		if (!Application.getFile(imageURL).exists())
			imageURL = AnimalPanel.class.getResource(DEFAULT_THUMBNAIL_FILE);

		Image image = new ImageIcon(imageURL).getImage();
		thumbnail.setIcon(new ImageIcon(image.getScaledInstance(265, 180, Image.SCALE_SMOOTH)));
		setDirty(true);
	}

	@Override
	public Animal getNewInstance() {
		return new Animal();
	}

	/*
	// testing method
	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal(2001, "Puja", new Species("Feline"), 'M', "Simba", "", true, "A12343212", "Orange Tiger", new Date(), "Orange with stripes", "Gentle, needs special attention","tiger.jpg"));
		animals.add(new Animal(2002, "Rawr", new Species("Feline"), 'M', "Timbre", "Saber", false, "", "Leopard", new Date(), "golden with ring spots", "Snappy","leopard.jpg"));
		animals.add(new Animal(2003, "Fran", new Species("Feline"), 'F', "Goomba", "Mush", true, "A12343201", "Ocelot", new Date(), "Cute, but dangerous", "Will eat your hand if you let her","ocelot.jpg"));
		animals.add(new Animal(2004, "George", new Species("Primate"), 'M', "unknown", "unknown", false, "", "golden-mantled tamarin", new Date(), "Has white cheeks","alpha male - watch for this one","tamarin.jpg"));
		animals.add(new Animal(2005, "Spots", new Species("Deer"), 'F', "unknown", "unknown", false, "", "White Tailed Deer", new Date(), "just another deer",""));

		AnimalPanel panel = new AnimalPanel(animals);
		panel.setVisible(true);
	}
	*/	
}
