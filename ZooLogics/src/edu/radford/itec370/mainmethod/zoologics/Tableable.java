package edu.radford.itec370.mainmethod.zoologics;

public interface Tableable {
	public Object getValue(int col, int rowConfig);
	public void setValue(Object value, int col, int rowConfig);
	public boolean isFieldEditable(int col); 
}
