
public class Service implements Profitable, Comparable<Service>{
	private String carPlate;
	private double revenue;


	@Override
	public int compareTo(Service o) {

		return (int) (this.revenue - o.revenue);
	}

	
	public Service(String carPlate) {
			this.carPlate = carPlate;
	} 

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	
	public void displayServiceInfo() {
		System.out.println("Car Plate is " + getCarPlate() + ".");
		System.out.println("The revenue from this service is " + getRevenue() + ".");
	}
	
	public double makeTransaction(double price) {	
		setRevenue(price);	
		return price;
	}
	
	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public double getRevenue() {
		return revenue;
	}

	
	@Override
	public double calculate() {
		return revenue;
		
	}

}
