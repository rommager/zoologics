package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Staff implements Serializable {

	private static final long serialVersionUID = 4632391733615291271L;
	private static final String SALT = Application.getAppName() + Application.getSerialversionuid();
	private static int nextStaffID = 1001;
	private int staffID;
	private String lastName;
	private String firstName;
	private String position;
	private String userName;
    private byte[] passwordHash;
	
    public Staff() {
		super();
		staffID = nextStaffID++;
	}
    
    public Staff(String lastName, String firstName, String position) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.position = position;
		staffID = nextStaffID++;
	}
	
    public Staff(String lastName, String firstName, String position, String userName) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.position = position;
		this.userName = userName;
		staffID = nextStaffID++;
	}

    // constructor for IO
	public Staff(int staffID, String lastName, String firstName, String position) {
		super();
		setStaffID(staffID);
		this.lastName = lastName;
		this.firstName = firstName;
		this.position = position;
		this.userName = null;
		this.passwordHash = null;
	}
    
    // full constructor for IO
	public Staff(int staffID, String lastName, String firstName, String position, String userName, byte[] passwordHash) {
		super();
		setStaffID(staffID);
		this.lastName = lastName;
		this.firstName = firstName;
		this.position = position;
		this.userName = userName;
		this.passwordHash = passwordHash;
	}
	
	public void setPassword(String password) {
		if (isUser())
		passwordHash = generateHash(password);
	}
	
	public boolean validatePassword(String password) {
		if (isUser()) {
			byte[] compareHash = generateHash(password);		
			if (Arrays.equals(compareHash, passwordHash)) {
				return true;
			}
		}	
		return false;
	}
	
	private byte[] generateHash(String password) {
		byte[] returnHash;
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			returnHash = md.digest(addSalt(password));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnHash = new String().getBytes();
		}
		return returnHash;
	}
	
	private byte[] addSalt(String password) {
		
		String newString = SALT + userName + password;
		return newString.getBytes();
	}
	
	public Object[] getRow() {
		Object[] output = new Object[6];
		output[0] = staffID;
		output[1] = lastName;  // last name
		output[2] = firstName;  // first name
		output[3] = position;  // position
		output[4] = userName;  // user name
		output[5] = this;
		return output;
	}

	public boolean isUser() {
		return (userName != null);
	}
	
	public String getDisplayName() {
		return firstName + " " + lastName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		if (userName.equals(""))
			this.userName = null;
		else
			this.userName = userName;
		
		// if this staff is not a program user, then also clear out the passwordHash
		if (this.userName == null)
			passwordHash = null;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
		if (nextStaffID <= staffID)
			nextStaffID = staffID + 1;
	}
}
