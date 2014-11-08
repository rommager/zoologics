package p2example;
import java.security.Principal;

/* 
 * We have created a custom principal class to store each principal.
 */

public class ExamplePrincipal implements Principal {
	String name;
	
	public ExamplePrincipal(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
		
	}

}
