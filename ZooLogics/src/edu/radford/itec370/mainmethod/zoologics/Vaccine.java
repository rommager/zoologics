package edu.radford.itec370.mainmethod.zoologics;

import java.util.Queue;

public class Vaccine {
	private int vaccineID;
	private String vaccineName;
	private String dosage;
	private boolean recurring;
	private Queue<TaskRecurrence> frequencyDays;
	private int dueAtAnimalAge;
}
