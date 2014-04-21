package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;
import java.util.ArrayList;

public class StaffHive extends ArrayList<Staff> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5713056110616181317L;

	public Staff findUser(String username) {
		username.trim();
		for (Staff staffer : this) {
			if (username.equalsIgnoreCase(staffer.getUserName())) {
				return staffer;
			}
		}
		return null;
	}
}
