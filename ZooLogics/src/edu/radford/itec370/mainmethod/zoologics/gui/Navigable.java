package edu.radford.itec370.mainmethod.zoologics.gui;

public interface Navigable {
	public void firstRecord();
	public void previousRecord();
	public void nextRecord();
	public void lastRecord();
	public void newRecord();
	public void applyFilter(String filter);
}
