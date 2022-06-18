
public class Manager extends Person{

	private int jobYear;

	public Manager(String name, String surname, int jobYear) {
		super(name, surname);
		this.jobYear = jobYear;
	}

	@Override
	public double calculate() {
		return -(getSalary() + 200 + jobYear * 50);
	}
}
