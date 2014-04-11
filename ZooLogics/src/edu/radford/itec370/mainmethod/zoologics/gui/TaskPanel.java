package edu.radford.itec370.mainmethod.zoologics.gui;

import java.util.ArrayList;

import javax.swing.JPanel;

import edu.radford.itec370.mainmethod.zoologics.Task;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TaskPanel extends JDialog {
	
	protected JButton btnCompleteTask;
	
	public TaskPanel() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 11, 84, 22);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(54, 12, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setBounds(192, 15, 73, 14);
		getContentPane().add(lblDueDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(292, 12, 89, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnCompleteTask = new JButton("Complete Task");
		btnCompleteTask.setBounds(54, 250, 120, 23);
		getContentPane().add(btnCompleteTask);
		
		JButton btnDismiss = new JButton("Dismiss");
		btnDismiss.setBounds(189, 250, 89, 23);
		getContentPane().add(btnDismiss);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(313, 250, 89, 23);
		getContentPane().add(btnCancel);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setBounds(10, 74, 46, 14);
		getContentPane().add(lblNotes);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 99, 371, 101);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
	private ArrayList <Task> tasks;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public void refresh () {
		
	}
}
