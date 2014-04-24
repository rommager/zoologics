package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;

import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Species;
import edu.radford.itec370.mainmethod.zoologics.Vaccine;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * @author Sean
 * The SpeciesPanel is meant as a GUI interface to manage Species instances
 */
public class SpeciesPanel extends JDialog implements Navigable {

	//ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();
	ArrayList<Species> species;
	int index = 0;
	
	private static final long serialVersionUID = 4119451221171558539L;
	private JPanel contentPanel;
	private JTextField txtSpecies;
	private JTable vaccineRegimentTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SpeciesPanel dialog = new SpeciesPanel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public SpeciesPanel(ArrayList<Species> species) {
		this();
		this.species = species;
	}
	
	private SpeciesPanel() {
		super();
		this.species = new ArrayList<Species>();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SpeciesPanel.class.getResource("/edu/radford/itec370/mainmethod/zoologics/z_icon.png")));
		setTitle(Application.getAppName() + " Species");
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
		NavigatorBar naviBar = new NavigatorBar(this);
		getContentPane().add(naviBar,BorderLayout.SOUTH);
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSpecies = new JLabel("Species:");
			lblSpecies.setBounds(10, 11, 60, 14);
			contentPanel.add(lblSpecies);
		}
		
		txtSpecies = new JTextField();
		txtSpecies.setBounds(65, 8, 133, 20);
		contentPanel.add(txtSpecies);
		txtSpecies.setColumns(10);
		{
			vaccineRegimentTable = new JTable();
			vaccineRegimentTable.setBounds(20, 36, 393, 182);
			contentPanel.add(vaccineRegimentTable);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			//getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// Put a call to a save method here
						System.out.println("Click");
						JButton sourceButton = (JButton) arg0.getSource();
						sourceButton.getParent().getParent().getParent().getParent().getParent().setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
			
	}
	
	public void save() {
		Species x = species.get(index);
		x.setSpeciesName(this.txtSpecies.getText());
	}
	
	public void refresh() {
		Species x = species.get(index);
		this.txtSpecies.setText(x.getSpeciesName());
	}


	@Override
	public void firstRecord() {
		// TODO Auto-generated method stub
		index = 0;
		refresh();
	}


	@Override
	public void previousRecord() {
		// TODO fix this to make sure we dont go out of bounds
		if (index > 0 && species.size() != 0) {
			index--;
			refresh();
		}
	}


	@Override
	public void nextRecord() {
		// TODO Auto-generated method stub
		index++;
		refresh();
	}


	@Override
	public void lastRecord() {
		// TODO Auto-generated method stub
		System.out.println("Saved");
		save();
	}


	@Override
	public void newRecord() {
		// TODO Auto-generated method stub
		Species newSpecies = new Species();
		species.add(newSpecies);
		index = species.indexOf(newSpecies);
		refresh();
	}


	@Override
	public void applyFilter(String filter) {
		// TODO Auto-generated method stub
		
	}
}
