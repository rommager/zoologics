package srider4_JAAS;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
		loadEmployees();
		LoginModuleP2 lm = new LoginModuleP2();
		try {
			lm.login();
		}
		catch (LoginException e) {
			System.out.println("Username/password incorrect!");
			return;
		}
		run();
		try {
			lm.logout();
		} catch (LoginException e) {
			System.out.println("Something went wrong.");
		}
	}

	/*	private void dummyLogin() {
		loadEmployees();
		scan = new Scanner(System.in);
		do {
			System.out.println("Login ID: ");			
			int id = scan.nextInt();		
			user = getEmployee(id); 
			if (user == null)
				System.out.println("Invalid ID!"); }
		while (user == null);
		scan.close();
		run();
	}*/


	private void run() {
		System.out.println("Welcome to the Employee Database");
		scan = new Scanner(System.in);
/*		for (Employee emp : employees) {
			System.out.println(emp.toString());
		}*/
		do {
			int selection = getMenuSelection();
			switch (selection) {
			case 1:  viewMyInfo();
				break;
			case 2:  
				break;
			case 3:
				System.out.println("Thank you!");
				return;
			}
		} while(true);

	}

	private void editEmployee(Employee employee) {

	}

	private void loadEmployees() {
		String filename = "src/srider4_JAAS/employees.txt";
		employees = new ArrayList<Employee>();
		io = new DataIO<Employee>(filename);
		employees = io.loadData(new Employee());
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

	private void viewMyInfo() {
		System.out.println(user.toString());
	}

	private int getMenuSelection() {

		System.out.println("Select Option From Menu:");
		System.out.println(" 1) View my information");
		System.out.println(" 2) Edit an employee's information");
		System.out.println(" 3) Log out\n");
		System.out.println("Enter Option:");

		int selection = -1;
		do {
			if (scan.hasNextInt()) {
				selection = scan.nextInt();
				if (selection < 1 || selection > 3)
					selection = -1;
			}
			else {
				scan.next();
				selection = -1;
			}
			if (selection == -1)
				System.out.println("Invalid selection.  Please try again.");

		} while (selection == -1);
		return selection;
	}

}
