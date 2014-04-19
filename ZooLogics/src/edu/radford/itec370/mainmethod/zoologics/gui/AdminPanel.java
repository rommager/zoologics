package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class AdminPanel extends JDialog {
	JTabbedPane tabbedPane;
	JLabel label;
	JTextField textfield;
	JPasswordField password;
	JPanel panel1;
	JPanel panel2;
	JButton button;

	public static void main(String args[]) {
		AdminPanel admin = new AdminPanel();
		admin.setDefaultCloseOperation(HIDE_ON_CLOSE);
		admin.setSize(350, 200);
		admin.setVisible(true);
	}
	
	public AdminPanel() {

		tabbedPane = new JTabbedPane();
		this.addUser();
		add(tabbedPane);
		
	}

	void addUser() {

		JLabel label0 = new JLabel("User ID", SwingConstants.CENTER);
		JTextField textfield0 = new JTextField();

		JLabel label1 = new JLabel("User Name", SwingConstants.CENTER);
		JTextField textfield1 = new JTextField();

		JLabel label2 = new JLabel("Password", SwingConstants.CENTER);
		password = new JPasswordField();

		JButton button0 = new JButton("Submit");

		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4, 2, 2, 2));

		panel1.add(label0);
		panel1.add(textfield0);
		panel1.add(label1);
		panel1.add(textfield1);
		panel1.add(label2);
		panel1.add(password);
		panel1.add(button0);

		tabbedPane.addTab("Add User", null, panel1, "First Panel");

	}

}
