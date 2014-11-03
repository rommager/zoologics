package srider4_JAAS;

public interface DataIOable<T> {

    public T getNewInstanceFromIOData(String[] io);
    
	public String[] getIOData();
	
}
