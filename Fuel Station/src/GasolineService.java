
public class GasolineService extends FuelService{

	private boolean hasCoupon;

	public GasolineService(String carPlate, double litersBought, boolean hasCoupon) {
		super(carPlate,litersBought);
		this.hasCoupon = hasCoupon;
	}
	
	public void displayServiceInfo() {
		System.out.println();
		System.out.println("Gasoline Service...");
		super.displayServiceInfo();
		if(hasCoupon == true) {
			System.out.println("Has 10% discount coupon");
		}
	}
	
	public double makeTransaction(double price) {
		if(hasCoupon == true) {
			price = price * 0.9;
		}
		return super.makeTransaction(price);
	}

	
	@Override
	public double calculate() {
		return getRevenue();
	}
		
	public boolean isHasCoupon() {
		return hasCoupon;
	}

	public void setHasCoupon(boolean hasCoupon) {
		this.hasCoupon = hasCoupon;
	}
}
