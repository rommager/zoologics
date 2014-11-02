package srider4_JAAS;

public class Employee implements DataIOable<Employee>{
	private int id;
	private String name;
	private String position;
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

	@Override
	public Employee getNewInstanceFromIO(String[] io) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIOLine() {
		return Integer.toString(id) + "|" + name + supervisor.getName() + " (" + supervisor.getId() + ") " + salary;
	}
	
}
