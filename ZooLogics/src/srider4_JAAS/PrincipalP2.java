package srider4_JAAS;
import java.security.Principal;

/* 
 * We have created a custom principal class to store each principal.
 */

public class PrincipalP2 implements Principal {
	private String name;
	private int userid;
	
	PrincipalP2(String name, int userid) {
		super();
		this.name = name;
		this.userid = userid;
	}
	
	public String getName() {
		return name;		
	}
	
	public int getUserid() {
		return userid;
	}

}
