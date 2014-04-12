package edu.radford.itec370.mainmethod.zoologics;



import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.sql.SQLException;


public class AdminPanel extends User
{
	JTabbedPane tabbedPane;
	JLabel label[];
	JTextField textfield[];
	JPasswordField password;
	JPanel panel1;
	JPanel panel2;
	JButton button[];

	public AdminPanel()
	{

		tabbedPane = new JTabbedPane();
		this.addUser();
		add( tabbedPane );
	}

	void addUser()
	{

		label = new JLabel[4];
		textfield = new JTextField[4];

                label[0] = new JLabel( "User ID", SwingConstants.CENTER );
                textfield[0] = new JTextField();

                label[1] = new JLabel( "User Name", SwingConstants.CENTER );
                textfield[1] = new JTextField();

                label[2] = new JLabel( "Password", SwingConstants.CENTER );
                password = new JPasswordField();

		button = new JButton[2];
		button[0] = new JButton( "Submit" );

		panel1 = new JPanel();
		panel1.setLayout( new GridLayout(4,2,2,2) );

		panel1.add( label[0] );
                panel1.add( textfield[0] );
                panel1.add( label[1] );
                panel1.add( textfield[1] );
                panel1.add( label[2] );
                panel1.add( password );
		panel1.add( button[0] );

                tabbedPane.addTab( "Add User", null, panel1, "First Panel" );

		AdminHandler adminHandler = new AdminHandler();

		button[0].addActionListener( adminHandler );
	}

	private class AdminHandler implements ActionListener
        {
                public void actionPerformed( ActionEvent event )
                {
                        String userString = "";
                        String passwordString = "";
                        UserConnection userconnection = new UserConnection();

                        if ( event.getSource() == button[0] ) {

				int UserId = Integer.parseInt( textfield[0].getText() ); 
                                userString = textfield[1].getText();
                                passwordString = new String( password.getPassword() ) ;

                                try {
					userconnection.addUser( UserId, userString, passwordString );
					JOptionPane.showMessageDialog( null, "User Created Successfully" );
                                }
                                catch ( SQLException sqlException )
                                {
                                        JOptionPane.showMessageDialog( null, sqlException.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE );
                                }
                        }
                }
        }

	public static void main( String args[] )
	{
		Admin admin = new Admin();

                admin.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                admin.setSize( 350, 200 );
                admin.setVisible( true );
	}

}



