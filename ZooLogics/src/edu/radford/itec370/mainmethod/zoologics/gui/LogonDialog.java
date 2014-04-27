package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.radford.itec370.mainmethod.zoologics.*;

import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LogonDialog extends JDialog implements ActionListener {

	protected final static String WINDOW_TITLE = Application.getAppName() + " Logon";

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUserName;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	//private Staff staff;

	public LogonDialog() 
	{
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle(WINDOW_TITLE);
		setIconImage(Application.getAppIcon());
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 246, 168);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblUsername = new JLabel("User name: ");
		lblUsername.setBounds(10, 24, 84, 14);
		contentPanel.add(lblUsername);

		txtUserName = new JTextField();
		txtUserName.setBounds(115, 21, 100, 20);
		contentPanel.add(txtUserName);
		txtUserName.setColumns(10);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 65, 84, 14);
		contentPanel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(115, 62, 100, 20);
		contentPanel.add(passwordField);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(this);
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		buttonPane.add(cancelButton);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if (command.equals("Ok")) {
			Staff user = getAuthenticatedUser(txtUserName.getText(),passwordField.getPassword());
			Application newAppInstance = new Application(user);
			newAppInstance.run();
		}
		else if (command.equals("Cancel"))
			System.exit(0);
	}
	
	private Staff getAuthenticatedUser(String username, char[] password) {
		Staff staff = Application.getStaffHive().findUser(username);
		staff.validatePassword(password);
		return staff;
	}
	
}

