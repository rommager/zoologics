package srider4_JAAS;

import java.util.ArrayList;

public class Driver {

	Employee user;
	ArrayList<Employee> Employees;
	DataIO<Employee> io;
	
	public static void main(String[] args) {
	
		Driver program = new Driver();
		program.run();
	}
	
	public void run() {
		io = new DataIO<Employee>("employees.txt");
		io.loadData(new Employee());
		
	}
	

}
