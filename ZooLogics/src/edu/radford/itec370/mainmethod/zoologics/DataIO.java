package edu.radford.itec370.mainmethod.zoologics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataIO {
	public static final String DATA_FOLDER = "./data/";

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

	public static ArrayList<Animal> loadAnimals() throws IOException {
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

		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}
		read.close();
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
