package edu.radford.itec370.mainmethod.zoologics;

import java.util.ArrayList;

public interface DataIOable<T> {

    public T getNewInstanceFromIO(String ioString);
	public String getIOLine();
	
}