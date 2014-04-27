package edu.radford.itec370.mainmethod.zoologics;

public class Vaccination extends Task {

	private static final long serialVersionUID = -3208824316987913037L;
	private static final String TASK_TYPE = "Vaccination";
	private Animal animal;
	
	public Vaccination() {
		super();
	}
	
	public Vaccination(Animal animal, String vaccineName,
			String dateAdministered, Staff administeredBy) {
		this();
		this.animal = animal;
		this.taskName = vaccineName;
		this.completedDate = Application.parseDate(dateAdministered);
		this.completedBy = administeredBy;
	}

	@Override
	public String getTaskType() {
		return TASK_TYPE;
	}
	

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}
