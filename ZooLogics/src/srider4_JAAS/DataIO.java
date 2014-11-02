package srider4_JAAS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

import edu.radford.itec370.mainmethod.zoologics.Application;

public class DataIO<T extends DataIOable<T>> {
	private static final String DATA_FOLDER = "./";
	private String filename;
	private File file;

	private DataIO() {
		super();
	}
	
	public DataIO(String filename) {
		this();
		this.filename = filename;
		file = getFile(DATA_FOLDER, filename);
	}
	
	public void saveData(ArrayList<T> arrayList) {
//		createBackup(filename);
//		File file = Application.getFile(DATA_FOLDER, filename);
		if (!file.getParentFile().exists()) 
			file.getParentFile().mkdirs();   // creates the folder if it doesn't exist
		BufferedWriter writer = null;
		try {
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
			for (T item : arrayList) {
				String ioLine = item.getIOLine().replaceAll("\n", "\\\\n");  // converts returns to '\n' for storage
				writer.write(ioLine);
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) { System.out.println("Error: IO Exception!"); } 
		finally { }  //TODO - I'm pretty sure we need to close something here, but writer.close throws IOExceptions too, so it can't go in finally block...?
	}
	
	public ArrayList<T> loadData(T template) {
		BufferedReader reader = null;
//		File file = Application.getFile(DATA_FOLDER, filename);
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
		catch (FileNotFoundException e) { System.out.println("Error: File not found!"); }
		catch (IOException e) { System.out.println("Error: IO Exception!"); }
		finally{ }  //TODO - I'm pretty sure we need to close something here, but writer.close throws IOExceptions too, so it can't go in finally block...?
		return arrayList;
	}
	
	private static URL getLocalFilePath(String path, String filename) {
		URL jarLocation = Application.class.getProtectionDomain().getCodeSource().getLocation();
		URL outputURL = null;
		try {
			outputURL = new URL(jarLocation, path + filename);
		} catch (MalformedURLException e) {
			// do nothing
		}
		return outputURL;
	}
	
	private static File getFile(String path, String filename) {
		URL url = getLocalFilePath(path, filename);

		return(getFile(url));
	}
	
	private static File getFile(URL url) {
		File newFile;
		String decoded = "";

		try {
			decoded = URLDecoder.decode(url.getPath(), "UTF-8");
		} catch (UnsupportedEncodingException e) { }

		newFile = new File(decoded);
		return newFile;
	}

	public static void createBackup(String filename) {
		File source = getFile(DATA_FOLDER, filename);
		File dest = getFile(DATA_FOLDER, filename + ".backup");
		Application.copyFile(source, dest);
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
