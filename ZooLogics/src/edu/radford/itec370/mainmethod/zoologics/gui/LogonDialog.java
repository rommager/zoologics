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

public class LogonDialog extends JDialog {
	protected final static String WINDOW_TITLE = Application.getAppName() + " Logon";
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
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
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		{
			lblUsername = new JLabel("User name: ");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblUsername, 30, SpringLayout.NORTH, contentPanel);
			contentPanel.add(lblUsername);
		}
		{
			txtUserName = new JTextField();
			sl_contentPanel.putConstraint(SpringLayout.NORTH, txtUserName, -3, SpringLayout.NORTH, lblUsername);
			sl_contentPanel.putConstraint(SpringLayout.WEST, txtUserName, 30, SpringLayout.EAST, lblUsername);
			sl_contentPanel.putConstraint(SpringLayout.EAST, txtUserName, -15, SpringLayout.EAST, contentPanel);
			contentPanel.add(txtUserName);
			txtUserName.setColumns(10);
		}
		{
			lblPassword = new JLabel("Password:");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblPassword, 15, SpringLayout.SOUTH, lblUsername);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblPassword, 27, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblUsername, 0, SpringLayout.WEST, lblPassword);
			contentPanel.add(lblPassword);
		}
		{
			txtPassword = new JTextField();
			sl_contentPanel.putConstraint(SpringLayout.EAST, txtPassword, 0, SpringLayout.EAST, txtUserName);
			sl_contentPanel.putConstraint(SpringLayout.WEST, txtPassword, 38, SpringLayout.EAST, lblPassword);
			sl_contentPanel.putConstraint(SpringLayout.NORTH, txtPassword, -3, SpringLayout.NORTH, lblPassword);
			contentPanel.add(txtPassword);
			txtPassword.setColumns(10);
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
