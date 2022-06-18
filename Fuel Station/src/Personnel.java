
public class Personnel extends Person{

	private int jobCount = 0;

	public Personnel(String name, String surname) {
		super(name, surname);
	}
	
	public void setJobCount(int jobCount) {
		this.jobCount = jobCount;
	}
	
	
	void incJobCount() {
		jobCount++;
	}
	
	
	@Override
	public double calculate() {
		return -(getSalary() + jobCount * 1.5);
	}
}
