package srider4_JAAS;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	private Employee user;
	private static String[] positions =  {"CEO","VP","Manager","Associate","Junior Associate"};
	private ArrayList<Employee> employees;
	private DataIO<Employee> io;
	
	public static void main(String[] args) {
	
		Driver program = new Driver();
		program.run();
	}
	
	private void run() {
		String filename = "src/srider4_JAAS/employees.txt";
		employees = new ArrayList<Employee>();
		
		io = new DataIO<Employee>(filename);		
		employees = io.loadData(new Employee());
		
		for (Employee emp : employees) {
			System.out.println(emp.toString());
		}
		
		System.out.println("Login ID: ");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		user = getEmployee(id);
		
		System.out.println(user.toString());
		
		scanner.close();
		
	}
	
	private void showMenu() {
		
	}
	
	private Employee getEmployee(int id) {
		for (Employee emp : employees) {
			if (id == emp.getId())
				return emp;
		}
		return null;
	}
	
	

}
