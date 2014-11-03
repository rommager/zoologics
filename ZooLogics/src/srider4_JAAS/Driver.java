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
	
	private void run() {
		String filename = "c:/proj2/employees.txt";
		ArrayList<Employee> employees = new ArrayList<Employee>();
		io = new DataIO<Employee>(filename);		
		employees = io.loadData(new Employee());
		
		for (Employee emp : employees) {
			System.out.println(emp.toString());
		}
		
	}
	

}
