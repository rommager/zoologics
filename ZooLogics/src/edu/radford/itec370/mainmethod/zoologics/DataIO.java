package edu.radford.itec370.mainmethod.zoologics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataIO<T extends DataIOable<T>> {
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
		if (!file.getParentFile().exists()) 
			file.getParentFile().mkdirs();   // creates the folder if it doesn't exist
//		System.out.println(file.getPath());
		BufferedWriter writer = null;
		try {
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
			for (T item : arrayList) {
				String ioLine = item.getIOLine().replaceAll("\n", "\\\\n");  // converts returns to '\n' for storage
				writer.write(ioLine);
//				System.out.println(item.getIOLine());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) { e.printStackTrace(); } 
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
				
				arrayList.add(template.getNewInstanceFromIO(inLine.replaceAll("\\\\n", "\n").split("\\|",-1)));
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
		File source = Application.getFile(DATA_FOLDER, filename);
		File dest = Application.getFile(DATA_FOLDER, filename + ".backup");
		Application.copyFile(source, dest);
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
