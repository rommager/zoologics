package srider4_JAAS;
import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;


public class CallBackHandlerP2 implements CallbackHandler {

	/* 
	 * Checks what authentication handlers the user has configured and calls them.
	 * @see javax.security.auth.callback.CallbackHandler#handle(javax.security.auth.callback.Callback[])
	 */
	public void handle(Callback[] arg0) throws IOException,
			UnsupportedCallbackException {
		int numCallBacks = 0; 
		for (int i=0; i < arg0.length; i++) {
			/* 
			 * A Namecallback simply requests a username from the user.
			 */
			if (arg0[i] instanceof NameCallback) {
				NameCallback user = (NameCallback) arg0[i];
				// Get username
				System.out.print(user.getPrompt() + " ");
				// read in the username from the console and set the username.
				user.setName((new Scanner(System.in).next()));
				// one call back done. 
				numCallBacks++;
				
			} else if (arg0[i] instanceof PasswordCallback) {
				PasswordCallback userpass = (PasswordCallback) arg0[i];
				//Get password from user.
				System.out.print(userpass.getPrompt() + " ");
				// setPassword requires a character array as parameter.
				// so we read in the password as a string and convert to 
				// charArray. 
				userpass.setPassword((new Scanner(System.in).next()).toCharArray());
				// another callback done.
				numCallBacks++;
			}
		}
		/* Error check - if there was an error in processing either username 
		 * or password, throw an exception.  
		 */
		if (numCallBacks < 2) {
			throw new UnsupportedCallbackException(arg0[0], 
					"Invalid or no callbacks.");
		}
	
		
	}

}
