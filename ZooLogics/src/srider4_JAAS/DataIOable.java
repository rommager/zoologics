package srider4_JAAS;

public interface DataIOable<T> {

    public T getNewInstanceFromIO(String[] io);
    
	public String getIOLine();
	
}
