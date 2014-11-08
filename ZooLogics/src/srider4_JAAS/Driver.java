package srider4_JAAS;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

public class Driver {

	private Employee user;
	private static String[] positions =  {"CEO","VP","Manager","Associate","Junior Associate"};
	private ArrayList<Employee> employees;
	private DataIO<Employee> io;
	private Scanner scan;
	
	public static void main(String[] args) {
	
		Driver program = new Driver();
		program.login();
	}
	
	private void login() {
		LoginModuleP2 lm = new LoginModuleP2();
		try {
			lm.login();
		}
		catch (LoginException e) {
			System.out.println("Username/password incorrect!");
			return;
		}
		run();
	}
	
	
	private void run() {
		System.out.println("We're in");
		
		String filename = "src/srider4_JAAS/employees.txt";
		employees = new ArrayList<Employee>();		
		io = new DataIO<Employee>(filename);		
		employees = io.loadData(new Employee());
		scan = new Scanner(System.in);
		
		
/*		for (Employee emp : employees) {
			System.out.println(emp.toString());
		}*/
		
		
		do {
			System.out.println("Login ID: ");
			
			int id = scan.nextInt();		
			user = getEmployee(id); 
			if (user == null)
				System.out.println("Invalid ID!"); }
		while (user == null);
		
		
		
		System.out.println(user.toString());
		
		int selection = getMenuSelection();
		
		scan.close();
		
	}
	
	private void editEmployee(Employee employee) {
		
	}
	
	private Employee getEmployee(int id) {
		
		for (Employee emp : employees) {
			if (id == emp.getId())
				return emp;
		}
		return null;
	}
	
	private void listEmployees() {
		
	}
	
	private int getMenuSelection() {
		System.out.println("Select Option From Menu:");
		System.out.println(" 1) View my information");
		System.out.println(" 2) Edit an employee's information\n");
		System.out.println(" 3) Log out");
		System.out.println("Enter Option:");
//		try {
			int selection = scan.nextInt();
//		}
//		catch Exception e { }
		return selection;
	}
	
	
	
	

}
