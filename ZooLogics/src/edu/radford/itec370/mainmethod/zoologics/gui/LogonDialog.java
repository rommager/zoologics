package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import edu.radford.itec370.mainmethod.zoologics.*;
import edu.radford.itec370.mainmethod.zoologics.gui.components.*;
import javax.swing.JPasswordField;

public class LogonDialog extends JDialog {
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
		{
			lblUsername = new JLabel("User name: ");
			lblUsername.setBounds(32, 35, 58, 14);
			contentPanel.add(lblUsername);
		}
		{
			txtUserName = new JTextField();
			txtUserName.setBounds(120, 32, 100, 20);
			contentPanel.add(txtUserName);
			txtUserName.setColumns(10);
		}
		{
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(32, 64, 50, 14);
			contentPanel.add(lblPassword);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(120, 63, 100, 20);
			contentPanel.add(passwordField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}
}
