

package srider4_JAAS;
import java.io.IOException;
import java.security.Principal;
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
	
	/*
	 * String username
	 * String password 
	 * Temporary storage for usernames and passwords (before authentication).
	 * After authentication we can clear these variables. 
	 */
	String username, password;
	
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
			password = scan.next();
		
		// Now populate username/passwords etc. from the handler
//		username = ((NameCallback) exampleCallbacks[0]).getName();
//		password = new String (
//					((PasswordCallback) exampleCallbacks[1]).getPassword());
//		
		// Now perform validation. This part, you can either read from a file or a 
		// database. You can also incorporate secure password  handling here. 
		// As an example, we are going to use hard-coded passwords. 
		System.out.println("Checking username and password: " + username +"/" + password);
		if ((username.equals("team") && password.equals("security")) ||
				(username.equals("root") && password.equals("security"))){
				successfulLogin = true; 
				return true; // successful login.			
		}
		
		return false;
	}
		
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
//	MessageDigest md = MessageDigest.getInstance("SHA");
//
//	 try {
//	     md.update(toChapter1);
//	     MessageDigest tc1 = md.clone();
//	     byte[] toChapter1Digest = tc1.digest();
//	     md.update(toChapter2);
//	     ...etc.
//	 } catch (CloneNotSupportedException cnse) {
//	     throw new DigestException("couldn't make digest of partial content");
//	 }
	 
	
/*	public class SHACheckSumExample 
	{
	    public static void main(String[] args)throws Exception
	    {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        FileInputStream fis = new FileInputStream("c:\\loging.log");
	 
	        byte[] dataBytes = new byte[1024];
	 
	        int nread = 0; 
	        while ((nread = fis.read(dataBytes)) != -1) {
	          md.update(dataBytes, 0, nread);
	        };
	        byte[] mdbytes = md.digest();
	 
	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < mdbytes.length; i++) {
	          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	 
	        System.out.println("Hex format : " + sb.toString());
	 
	       //convert the byte to hex format method 2
	        StringBuffer hexString = new StringBuffer();
	    	for (int i=0;i<mdbytes.length;i++) {
	    	  hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
	    	}
	 
	    test test
	    	
	    	System.out.println("Hex format : " + hexString.toString());
	    }
	}*/

	/*
	public void testVerifyPassword() throws Exception {
		  String password="star12345";
		  FileOutputStream outputStream=getContext().openFileOutput(FILE_NAME,Context.MODE_PRIVATE);
		  MessageDigest digest=MessageDigest.getInstance("SHA-256");
		  digest.update(password.getBytes());
		  byte[] hashPassword=digest.digest();
		  outputStream.write(hashPassword);
		  FileInputStream inputStream=getContext().openFileInput(FILE_NAME);
		  PasswordStorage storage=new PasswordStorage(inputStream);
		  assert(storage.verifyPassword(password));
		  
		}
	*/
}