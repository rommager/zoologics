package srider4_JAAS;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import javax.xml.bind.DatatypeConverter;

public class LoginModuleP2 implements LoginModule {

	// Flag to keep track of successful login.
	Boolean successfulLogin = false;

	// Variable that keeps track of the principal.
	Principal userPrincipal;

	// Subject keeps track of who is currently logged in.
	Subject subject;

	// Salt app constant part for password hash 
	private static final byte[] SALT = "employeeDB".getBytes();

	/*
	 * String username
	 * byte[] password 
	 * Temporary storage for usernames and passwords (before authentication).
	 * After authentication we can clear these variables. 
	 */
	String username;
	byte[] password;
	int userId;

	/*
	 * Other variables that are initialized by the login context.
	 */

	CallbackHandler cbh;
	Map sharedState;
	Map options;

	/*
	 * This method is called by the login context automatically.
	 * @see javax.security.auth.spi.LoginModule#initialize(javax.security.auth.Subject, 
	 *         javax.security.auth.callback.CallbackHandler, java.util.Map, java.util.Map)
	 */
	public void initialize(Subject subject, 
			CallbackHandler cbh,
			Map sharedState,
			Map options) {

		this.subject = subject;
		this.cbh = cbh;
		this.sharedState = sharedState;
		this.options = options;
	}

	/*
	 * If a user tries to abort a login then the state is reset. 
	 * @see javax.security.auth.spi.LoginModule#abort()
	 */
	public boolean abort() throws LoginException {
		if (!successfulLogin) {

			username = null;
			password = null;
			return false; 
		} else {
			logout(); 
			return true; 
		}

	}

	/*
	 * If login is valid, then the commit method is called by the LoginContext object. Here
	 * the logged in user is associated with a "principle". Think of this as a token
	 * that can from now on be used for authorization. 
	 * @see javax.security.auth.spi.LoginModule#commit()
	 */
	public boolean commit() throws LoginException {

		if (successfulLogin) {
			// Example Principal object stores the logged in user name.
			userPrincipal = new PrincipalP2(username, userId);
			// subject stores the current logged in user.
			subject.getPrincipals().add(userPrincipal);
			return true; 
		}

		return false;
	}

	/*
	 * The actual login method that performs the authentication
	 * @see javax.security.auth.spi.LoginModule#login()
	 */
	public boolean login() throws LoginException {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter username");
		username = scan.next();

		System.out.println("Enter password");
		password = scan.next().getBytes();

		//		scan.close();   // We realize we should close the scanner, but it causes the main app not to work correctly, because it also uses a Scanner.

		String[] data = findUser(username);
		if (data != null) {
			byte[] hashCheck = generateHash(username.getBytes(), password);
			byte[] storedHash = DatatypeConverter.parseHexBinary(data[2]);
			if (Arrays.equals(hashCheck, storedHash))
			{								
				username = data[0];
				try {
					userId = Integer.parseInt(data[1]);
				}
				catch (NumberFormatException e) {
					System.out.println("Login failed - account is not connected to a valid employee.  Please contact support.");
					return false;
				}
				successfulLogin = true;
				return true; // successful login.	
			}				
		}
		return false;
	}

	private String[] findUser(String username) {
		BufferedReader reader = null;
		String[] user = null;
		File file = new File("src/srider4_JAAS/logins.txt");
		String inLine;

		try {
			reader = new BufferedReader(new FileReader(file));
			inLine = reader.readLine();
			while (inLine != null) {

				String[] fields = inLine.split("\\|",-1);
				if (fields[0].equalsIgnoreCase(username))
					user = fields;
				inLine = reader.readLine();
			}
			reader.close();
		}
		catch (FileNotFoundException e) { System.out.println("Error: File not found!"); }
		catch (IOException e) { System.out.println("Error: IO Exception!"); }
		catch (Exception e) { e.printStackTrace(); }
		return user;
	}

	/*
	 * @see javax.security.auth.spi.LoginModule#logout()
	 */
	public boolean logout() throws LoginException {
		username = null;
		password = null;		
		subject.getPrincipals().remove(userPrincipal);
		return true;
	}

	private byte[] generateHash(byte[] username, byte[] password) {
		byte[] returnHash;
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA1");
			returnHash = md.digest(addSalt(username, password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			returnHash = new String().getBytes();
		}
		return returnHash;
	}

	private byte[] addSalt(byte[] username, byte[] password) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
		try {
			outputStream.write(SALT);
			outputStream.write(username);
			outputStream.write(password);
		}
		catch (IOException e) { }
		byte c[] = outputStream.toByteArray( );
		return c;

		//		final Random r = new SecureRandom();
		//		byte[] salt = new byte[32];
		//		r.nextBytes(salt);
	}

}