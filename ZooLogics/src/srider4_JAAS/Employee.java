package srider4_JAAS;

import java.util.ArrayList;

public class Employee implements DataIOable<Employee>{
	
	private static ArrayList<Employee> employees;
	
	private int id;
	private String name;
	private String position;
	private Employee supervisor;
	private int salary;
	
	public Employee() {
		super();
		if (employees == null)
			employees = new ArrayList<Employee>();
		employees.add(this);
	}
	
	public Employee(String[] data) {
		this();
		this.id = Integer.parseInt(data[0]);
		this.name = data[1];
		this.position = data[2];
		this.setSupervisor(Integer.parseInt(data[3]));
		this.salary = Integer.parseInt(data[4]);
	}
	
	public Employee(int id) {
		this();
		this.id = id;
	}
	
	public String toString() {
		return Integer.toString(id) + " " + name + supervisor.getName() + " (" + supervisor.getId() + ") " + salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	public void setSupervisor(int supervisorId) {
		if (supervisorId == -1) {
			supervisor = null;
			return;
		}
		Employee supervisor = null;
		for (Employee employee : employees) {
			if (supervisorId == employee.getId())
				supervisor = employee;
		}
		if (supervisor != null)
			this.supervisor = supervisor;
	}
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public Employee getNewInstanceFromIOData(String[] input) {
		Employee employee = new Employee(input);		
		return employee;
	}

	@Override
	public String[] getIOData() {
		String[] output = new String[5];
		output[0] = Integer.toString(id);
		output[1] = name;
		output[2] = position;
		output[3] = Integer.toString(supervisor.getId());
		output[4] = Integer.toString(salary);
		return output;
	}
	
}
