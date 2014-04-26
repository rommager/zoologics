package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Staff implements Serializable {

	private static final long serialVersionUID = 4632391733615291271L;
	private static final String SALT = Application.getAppName() + Application.getSerialversionuid();
	private static int nextStaffID = 1001;
	private int id;
	private String lastName;
	private String firstName;
	private String position;
	private String userName;
    private byte[] passwordHash;
	
    private Staff() {
		super();
	}
    public Staff(String lastName, String firstName, String position) {
		this();
		this.lastName = lastName;
		this.firstName = firstName;
		this.position = position;
	}
	
    public Staff(String lastName, String firstName, String position, String userName) {
		this();
		this.lastName = lastName;
		this.firstName = firstName;
		this.position = position;
		this.userName = userName;
	}
	
	public Staff(int id, String lastName, String firstName, String position, String userName, byte[] passwordHash) {
		this();
		this.id = id;
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
	
	public String[] getRow() {
		String[] output = new String[5];
		output[0] = Integer.toString(id);
		output[1] = null;
		output[2] = null;
		output[3] = null;
		output[4] = null;
		return output;
	}

	public boolean isUser() {
		return (userName != null);
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
	}
}
