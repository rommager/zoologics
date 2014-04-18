package edu.radford.itec370.mainmethod.zoologics;

public class Staff {

    private String username;
	private String name;
    private boolean isUser;
    private String passwordHash;
	
    public Staff() {
		super();
	}
	public Staff(String name, boolean isUser, String passwordHash) {
		super();
		this.name = name;
		this.isUser = isUser;
		this.passwordHash = passwordHash;
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
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

 

    


}


