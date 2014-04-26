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

public class LogonDialog extends JDialog implements Navigable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8997686514405988648L;

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
		// add navigator bar in south window area
		NavigatorBar navPanel = new NavigatorBar(this);
//		navPanel.setNewRecordVisible(false);
//		navPanel.setSearchBoxVisible(false);
		navPanel.setBounds(0, 415, 784, 30);
		getContentPane().add(navPanel, BorderLayout.SOUTH);
		{
			lblUsername = new JLabel("User name: ");
			lblUsername.setBounds(10, 24, 84, 14);
			contentPanel.add(lblUsername);
		}
		{
			txtUserName = new JTextField();
			txtUserName.setBounds(115, 21, 100, 20);
			contentPanel.add(txtUserName);
			txtUserName.setColumns(10);
		}
		{
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(10, 65, 84, 14);
			contentPanel.add(lblPassword);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(115, 62, 100, 20);
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

	@Override
	public void firstRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previousRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nextRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lastRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyFilter(String filter) {
		// TODO Auto-generated method stub
		
	}
}
