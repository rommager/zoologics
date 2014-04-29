package edu.radford.itec370.mainmethod.zoologics;

import java.util.Date;

public class AnimalTask extends Task {

	private static final long serialVersionUID = 2033805125227771447L;

	private static final String TASK_TYPE = "Animal Task";
	private Animal animal;

	public AnimalTask() {
		super();
	}

	public AnimalTask(Animal animal, String vaccineName,
			Date dateAdministered, Staff administeredBy) {
		this();
		this.animal = animal;
		this.taskName = vaccineName;
		this.completedDate = dateAdministered;
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
