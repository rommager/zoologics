package edu.radford.itec370.mainmethod.zoologics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataIO<T extends Savable<T>> {
	public static final String DATA_FOLDER = "./data/";
	private String filename;

	private DataIO() {
		super();
	}
	
	public DataIO(String filename) {
		this();
		this.filename = filename;
	}
	
	public void saveData(ArrayList<T> arrayList) {
		createBackup(filename);
		File file = Application.getFile(DATA_FOLDER, filename);
		System.out.println(file.getPath());
		BufferedWriter writer = null;
		try {
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
			for (T item : arrayList) {
				writer.write(item.getIOLine());
				System.out.println(item.getIOLine());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) { } 
		finally { }
	}
	
	public ArrayList<T> loadData(T template) {
		BufferedReader reader = null;
		File file = Application.getFile(DATA_FOLDER, filename);
		String inLine;
		ArrayList<T> arrayList = new ArrayList<T>();

		try {
			reader = new BufferedReader(new FileReader(file));
			inLine = reader.readLine();
			while (inLine != null) {
				arrayList.add(template.getNewInstanceFromIO(inLine));
				inLine = reader.readLine();
			}
			reader.close();
		}
		catch (FileNotFoundException e) { }
		catch (IOException e) {	}
		finally{ }
		return arrayList;
	}

	public static void createBackup(String filename) {
		//TODO This happens on save
		
		String backupName = filename + ".backup";
		
	// delete backupName
	// rename the existing something backupName
		
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	// tester method
	public static void main (String[] args) {
		System.out.println(DataIO.class.getSimpleName());
		
	}

}
