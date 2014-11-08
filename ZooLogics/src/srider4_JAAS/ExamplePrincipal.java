package srider4_JAAS;
import java.security.Principal;

/* 
 * We have created a custom principal class to store each principal.
 */

public class ExamplePrincipal implements Principal {
	String name;
	
	ExamplePrincipal(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
		
	}

}
