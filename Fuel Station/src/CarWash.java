
public class CarWash extends Service{

	final static double basePrice = 10;
	
	public CarWash(String carPlate) {
		super(carPlate);

	}
	
	@Override
	public void displayServiceInfo() {
		System.out.println();
		System.out.println("Car Wash Service...");
		super.displayServiceInfo();
	}
	
	public double makeTransaction(double price) {
		return super.makeTransaction(price);
	}
	
	@Override
	public double calculate() {
		return getRevenue();
	}

}
