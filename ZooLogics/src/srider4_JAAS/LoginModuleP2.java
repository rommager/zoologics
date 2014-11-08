

package srider4_JAAS;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.ArrayList;
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

	/*
	 * Subject keeps track of who is currently logged in.
	 */
	Subject subject;
	
	private static final char[] SALT = "employeeDB".toCharArray();

	private ArrayList<Employee> employees;

	/*
	 * String username
	 * String password 
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
		for (Employee emp : employees) {
			if (username.equalsIgnoreCase(emp.getName())) { // TODO make this work - gen setters & getters for new fields
				byte[] hashCheck = generateHash(username,password);
				// TODO compare hash to the passhash in the employee record - might need to google example for comparing byte arrays
				byte[] storedHash = 
				/*     
		  		byte[] array = new BigInteger("1111000011110001", 2).toByteArray();
				byte[] secondArray = new BigInteger("1111000011110001", 2).toByteArray();
				if (Arrays.equals(array, secondArray))
				{
				    System.out.println("Yup, they're the same!");
				}  
				*/
				
				{
					successfulLogin = true; 
					return true; // successful login.	
				}
			}


		}

		System.out.println("Invalid login.");
		return false;
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

	private byte[] generateHash(String username, byte[] password) {
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

	private byte[] addSalt(String username, byte[] password) {
		StringBuilder sb = new StringBuilder();
		sb.append(SALT);
		sb.append(username);
		sb.append(password);
		return sb.toString().getBytes();
	}


	

}