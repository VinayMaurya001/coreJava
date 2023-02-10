package _2OOPs._7Annotation;

public class Employee implements Cloneable {

	String name;
	String databaseConnection;

	Employee() {

		// dtaabse calls
	}

	public Employee(String name, String databaseConnection) {
		super();
		this.name = name;
		this.databaseConnection = databaseConnection;
	}

	public String getName() {
		System.out.println("getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}

	public String getDatabaseConnection() {
		return databaseConnection;
	}

	public void setDatabaseConnection(String databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	@Deprecated
	public void m1() {
		System.out.println("Employee: m1()");
	}

	public void m2() {
		System.out.println("Employee: m2()");
	}

	@Override
	public Employee clone() {
		return null;

	}

}
