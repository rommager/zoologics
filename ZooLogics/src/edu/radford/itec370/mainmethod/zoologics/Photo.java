package edu.radford.itec370.mainmethod.zoologics;

import edu.radford.itec370.mainmethod.zoologics.Animal;


public class Photo {

	private static int photoIDCounter = 22001;
	private int photoID;
	private Animal animal;
	private String path;
	private boolean thumbnail;
	
	public Photo() {
		super();
		photoID = photoIDCounter++;
	}
	
	public Photo(Animal animal, String path) {
		this();
		this.animal = animal;
		this.path = path;
	}
	
	public Photo(int photoID, Animal animal, String path, boolean thumbnail) {
		super();
		setPhotoID(photoID);
		this.animal = animal;
		this.path = path;
		this.thumbnail = thumbnail;
	}

	public int getPhotoID() {
		return photoID;
	}

	public void setPhotoID(int photoID) {
		this.photoID = photoID;
		if (photoID >= photoIDCounter)
			photoIDCounter = photoID + 1;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public boolean isThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(boolean thumbnail) {
		this.thumbnail = thumbnail;
	}
	
}
