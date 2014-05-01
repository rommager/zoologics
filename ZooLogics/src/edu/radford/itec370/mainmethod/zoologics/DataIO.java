package edu.radford.itec370.mainmethod.zoologics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataIO<T extends Savable> {
	public static final String DATA_FOLDER = "./data/";
	private ArrayList<T> items;

	public static void main (String[] args) {
		System.out.println(DataIO.class.getSimpleName());
		
	}
	
	public DataIO(ArrayList<T> items) {
		super();
		this.items = items;
	}

	public void saveData(String filename) {
		File file = Application.getFile(DATA_FOLDER, filename);
		System.out.println(file.getPath());
		BufferedWriter writer = null;
		try {
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
			for (T item : items) {
				writer.write(item.getIOLine());
				System.out.println(item.getIOLine());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {e.printStackTrace();} 
		finally { }
	}
	
	public ArrayList<T> loadData(String filename) {
		BufferedReader read = null;
		File file = Application.getFile(DATA_FOLDER, filename);
		String inLine;
		ArrayList<T> items = new ArrayList<T>();
		try {
			read = new BufferedReader(new FileReader(file));
			inLine = read.readLine();
			while (inLine != null) {
//				T item = new T();
//				items.add(new Animal(inLine));
				inLine = read.readLine();
			}
			read.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();			
		}
		finally{ }

		return items;

	}



	public static void saveAnimals(ArrayList<Animal> animals) {
		File file = Application.getFile(DATA_FOLDER, "Animals.dta");
		System.out.println(file.getPath());
		BufferedWriter writer = null;

		try {

			file.createNewFile();

			writer = new BufferedWriter(new FileWriter(file));
			for (Animal animal : animals) {

				writer.write(animal.getIOLine());
				System.out.println(animal.getIOLine());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// file.close();
		}
	}

	public static void saveTasks(ArrayList<Task> tasks) {
		File file = Application.getFile(DATA_FOLDER, "Tasks.dat");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (Task task : tasks) {
				// writer.write(task.getIOLine());

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<Animal> loadAnimals() {
		BufferedReader read = null;
		File file = Application.getFile(DATA_FOLDER, "Animals.dta");
		String inLine;
		ArrayList<Animal> animals = new ArrayList<Animal>();
		try {
			read = new BufferedReader(new FileReader(file));
			inLine = read.readLine();
			while (inLine != null) {
				animals.add(new Animal(inLine));
				inLine = read.readLine();
			}
			read.close();
		}
		catch (FileNotFoundException e) {
			
		}
		catch (IOException e) {
			e.printStackTrace();			
		}
		finally{

		}

		return animals;

	}

	public static ArrayList<Task> loadTask() {

		return null;
	}

	public static void loadReferenceData(ArrayList<Vaccine> vaccine,
			ArrayList<Species> species) {

	}

	public static void createBackup() {

	}

}
