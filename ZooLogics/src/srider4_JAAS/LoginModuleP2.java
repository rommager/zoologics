

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import javax.xml.bind.DatatypeConverter;

import p2example.ExamplePrincipal;


public class LoginModuleP2 implements LoginModule {

	// Flag to keep track of successful login.
	Boolean successfulLogin = false;

	// Variable that keeps track of the principal.
	Principal examplePrincipal;

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
			examplePrincipal = new ExamplePrincipal(username);
			// subject stores the current logged in user.
			subject.getPrincipals().add(examplePrincipal);
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
		// We will use two call backs - one for username and the other
		// for password. 
		//		Callback exampleCallbacks[] = new Callback[2];
		//		exampleCallbacks[0] = new NameCallback("username: ");
		//		exampleCallbacks[1] = new PasswordCallback("password: ", false);
		// pass the callbacks to the handler. 
		//		try {
		//			cbh.handle(exampleCallbacks);
		//		} catch (IOException e) {
		//			 e.printStackTrace();
		//		} catch (UnsupportedCallbackException e) {
		//			e.printStackTrace();
		//		}
		//		
		System.out.println("Enter username");
		username = scan.next();

		System.out.println("Enter password");
		password = scan.next().getBytes();

//		scan.close();
		// Now populate username/passwords etc. from the handler
		//		username = ((NameCallback) exampleCallbacks[0]).getName();
		//		password = new String (
		//					((PasswordCallback) exampleCallbacks[1]).getPassword());
		//		
		// Now perform validation. This part, you can either read from a file or a 
		// database. You can also incorporate secure password  handling here. 
		// As an example, we are going to use hard-coded passwords. 

		/*		System.out.println("Checking username and password: " + username +"/" + password);
		if ((username.equals("team") && password.equals("security")) ||
				(username.equals("root") && password.equals("security"))){
				successfulLogin = true; 
				return true; // successful login.			
		}*/
		String[] data = findUser(username);
		if (data != null) {
			byte[] hashCheck = generateHash(username.getBytes(), password);
			byte[] storedHash = DatatypeConverter.parseHexBinary(data[2]);
			if (Arrays.equals(hashCheck, storedHash))
			{
				successfulLogin = true; 
				return true; // successful login.	
			}				
			/*     
		  		byte[] array = new BigInteger("1111000011110001", 2).toByteArray();
				byte[] secondArray = new BigInteger("1111000011110001", 2).toByteArray();
				if (Arrays.equals(array, secondArray))
				{
				    System.out.println("Yup, they're the same!");
				}  
			 */				
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

	/*  public boolean authenticate(Connection con, String login, String password)
	           throws SQLException, NoSuchAlgorithmException{
	       boolean authenticated=false;
	       PreparedStatement ps = null;
	       ResultSet rs = null;
	       try {
	           boolean userExist = true;
	           // INPUT VALIDATION
	           if (login==null||password==null){
	               // TIME RESISTANT ATTACK
	               // Computation time is equal to the time needed by a legitimate user
	               userExist = false;
	               login="";
	               password="";
	           }

	           ps = con.prepareStatement("SELECT PASSWORD, SALT FROM CREDENTIAL WHERE LOGIN = ?");
	           ps.setString(1, login);
	           rs = ps.executeQuery();
	           String digest, salt;
	           if (rs.next()) {
	               digest = rs.getString("PASSWORD");
	               salt = rs.getString("SALT");
	               // DATABASE VALIDATION
	               if (digest == null || salt == null) {
	                   throw new SQLException("Database inconsistant Salt or Digested Password altered");
	               }
	               if (rs.next()) { // Should not append, because login is the primary key
	                   throw new SQLException("Database inconsistent two CREDENTIALS with the same LOGIN");
	               }
	           } else { // TIME RESISTANT ATTACK (Even if the user does not exist the
	               // Computation time is equal to the time needed for a legitimate user
	               digest = "000000000000000000000000000=";
	               salt = "00000000000=";
	               userExist = false;
	           } */
	/*
	 * 
	 * @see javax.security.auth.spi.LoginModule#logout()
	 */
	public boolean logout() throws LoginException {
		username = null;
		password = null;		
		subject.getPrincipals().remove(examplePrincipal);
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