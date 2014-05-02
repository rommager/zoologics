package edu.radford.itec370.mainmethod.zoologics;

public interface DataIOable<T> {

    public T getNewInstanceFromIO(String[] io);
	public String getIOLine();
	
}
