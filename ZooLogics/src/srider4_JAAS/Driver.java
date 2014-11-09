package srider4_JAAS;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class Driver {

	private Employee user;
	//	private static String[] positions =  {"CEO","VP","Manager","Associate","Junior Associate"};
	private ArrayList<Employee> employees;
	private DataIO<Employee> io;
	private Scanner scan;
	private LoginContext lc;
	private String username;

	public static void main(String[] args) {

		Driver program = new Driver();
		program.login();
	}

	private void login() {
		loadEmployees();
		//LoginModuleP2 lm = new LoginModuleP2(employees);
		CallBackHandlerP2 cbe = new CallBackHandlerP2(); 

		/* Create a new login context. 
		 * @param Policy Name : We defined a policy in the file JAASPolicy.txt 
		 *                      and it is called "JAASExample"
		 * @param Call Back Handler
		 */
		try {
			lc = new LoginContext("JAASPolicyP2", cbe);
		}
		catch (LoginException e) {
			System.err.println("Login exception."); 
		}

		try {
			lc.login();
		}
		catch (LoginException e) {
			System.out.println("Username/password incorrect!  Application terminated.");
			return;
		}


		Iterator<Principal> i = lc.getSubject().getPrincipals().iterator();
		while (i.hasNext()) {
			PrincipalP2 principal = (PrincipalP2) i.next();
			user = getEmployeeById(principal.getUserid());
			username = principal.getName();
		}
		run();

		try {
			lc.logout();
		} catch (LoginException e) {
			System.out.println("Something went wrong when logging out.");
			return;
		}
		System.out.println("You have logged out successfully.");
	}

	private void run() {
		System.out.println("\nWelcome to the Employee Database");
		scan = new Scanner(System.in);

		do {
			int selection = getMenuSelection();
			switch (selection) {
			case 1: 
				printInfo(user);
				break;
			case 2:
				// TODO add call to list employees under this employee
				editEmployee();
				break;
			case 3:
				System.out.println("\nThank you!");
				return;
			}
		} while(true);

	}

	private void loadEmployees() {
		String filename = "src/srider4_JAAS/employees.txt";
		employees = new ArrayList<Employee>();
		io = new DataIO<Employee>(filename);
		employees = io.loadData(new Employee());
	}

	private void printInfo(Employee employee) {
		System.out.println("\nEmployee Information:\n");
		System.out.println("Name:               " + employee.getName());
		System.out.println("Employee ID Number: " + employee.getId());
		System.out.println("Position:           " + employee.getPosition());
		Employee supervisor = getEmployeeById(employee.getSupervisorId());
		System.out.println("Your Supervisor:    " + supervisor.getName() + " (" + supervisor.getPosition() + ")"); 
		System.out.println("Your Salary:        " + employee.getSalary());
		System.out.println("Your Username:      " + employee + "\n");
	}

	private Employee getEmployeeById(int id) {

		for (Employee emp : employees) {
			if (id == emp.getId())
				return emp;
		}
		return null;
	}

	private void editEmployee() {
		Employee emp;
		emp = selectEmployee();
		if (emp != null) {
			System.out.println(emp.toString());
		}
		
	}

	// recursive function to get all employees that have an employee as their supervisor
	// returns all employees in the chain of command below the current supervisor
	private void getEmployees(ArrayList<Employee> employeeList, int supervisorId) {
		for (Employee emp : employees) {			
			if (emp.getSupervisorId() == supervisorId && !employeeList.contains(emp)) {
				employeeList.add(emp);
				// recursively call method to add any employees that have the current employee as their supervisor 
				getEmployees(employeeList, emp.getId());
			}
		}
	}
	
	private Employee selectEmployee() {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		getEmployees(employeeList, user.getId());
		int selection = 0;
		System.out.println("\nYour Employees:\n");
		int c = 1;
		for (Employee emp : employeeList) {
			System.out.println(c++ + ") " + emp.toString());			
		}
		if (c == 1) {
			System.out.println("\nYou have no employees who report to you.\n");
			return null;
		}
		System.out.println(c + ") Cancel\n\nPlease select an employee to edit:");
		if (scan.hasNextInt())
			selection = scan.nextInt();		
		if (selection < 1 || selection > employeeList.size()) {
			System.out.println("\nNo employee selected.  Returning without editing.\n");
			return null;
		}
		return employeeList.get(--selection);
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
				if (scan.hasNext())
					scan.next();
				selection = -1;
			}
			if (selection == -1)
				System.out.println("Invalid selection.  Please try again.");

		} while (selection == -1);
		return selection;
	}

}
