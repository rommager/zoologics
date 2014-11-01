package srider4_JAAS;

public class Employee {
	private int id;
	private String name;
	private Employee supervisor;
	private int salary;
	
	public Employee() {
		
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

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
