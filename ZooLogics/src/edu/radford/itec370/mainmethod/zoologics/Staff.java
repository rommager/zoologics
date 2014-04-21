package edu.radford.itec370.mainmethod.zoologics;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Staff implements Serializable {

	private static final String SALT = Application.getAppName() + Application.getSerialversionuid();
    private String userName;
	private String name;
    private boolean isUser;
    private byte[] passwordHash;
	
    private Staff() {
		super();
	}
    public Staff(String name) {
		this();
		this.name = name;
		this.isUser = false;
	}
	
    public Staff(String name, String userName) {
		this();
		this.name = name;
		this.userName = userName;
		this.isUser = true;
	}
	
	public Staff(String name, String userName, byte[] passwordHash) {
		this();
		this.name = name;
		this.userName = userName;
		this.isUser = true;
		this.passwordHash = passwordHash;
	}
	
	public void setPassword(String password) {
		if (isUser)
		passwordHash = generateHash(password);
	}
	
	public boolean validatePassword(String password) {
		if (isUser) {
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isUser() {
		return isUser;
	}
	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}


