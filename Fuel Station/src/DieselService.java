
public class DieselService extends FuelService {

	private boolean discountedAntiFreeze;
	private int discountedAntiFreezeCount;
	private double discountedAntiFreezePrice;

	public DieselService(String carPlate, double litersBought, 
			boolean discountedAntiFreeze, int discountedAntiFreezeCount,
			double discountedAntiFreezePrice) {
		
		super(carPlate,litersBought);
		this.discountedAntiFreeze = discountedAntiFreeze;
		this.discountedAntiFreezeCount = discountedAntiFreezeCount;
		this.discountedAntiFreezePrice = discountedAntiFreezePrice;
	}
	
	public void displayServiceInfo() {
		System.out.println();
		System.out.println("Diesel Service...");
		super.displayServiceInfo();
		if(discountedAntiFreeze == true) {
			System.out.println("Bought " + discountedAntiFreezeCount + " discounted anti-freeze.");
		}
	}
	
	public double makeTransaction(double price) {
		if(discountedAntiFreeze == true) {
			 price = price + discountedAntiFreezePrice * discountedAntiFreezeCount; 
		}
		return super.makeTransaction(price);	
	} 

	
	@Override
	public double calculate() {
		return getRevenue();
	}
	
	public boolean isDiscountedAntiFreeze() {
		return discountedAntiFreeze;
	}

	public void setDiscountedAntiFreeze(boolean discountedAntiFreeze) {
		this.discountedAntiFreeze = discountedAntiFreeze;
	}

	public int getDiscountedAntiFreezeCount() {
		return discountedAntiFreezeCount;
	}

	public void setDiscountedAntiFreezeCount(int discountedAntiFreezeCount) {
		this.discountedAntiFreezeCount = discountedAntiFreezeCount;
	}

	public double getDiscountedAntiFreezePrice() {
		return discountedAntiFreezePrice;
	}

	public void setDiscountedAntiFreezePrice(double discountedAntiFreezePrice) {
		this.discountedAntiFreezePrice = discountedAntiFreezePrice;
	}
}
