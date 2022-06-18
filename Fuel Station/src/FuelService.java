
public class FuelService extends Service{

	private double litersBought;

	public FuelService(String carPlate, double litersBought) {
		super(carPlate);
		this.litersBought = litersBought;
	}
	
	
	public void displayServiceInfo() {
		System.out.println("Bought " + getLitersBought() + " liters.");
		super.displayServiceInfo();
	}
	
	public double makeTransaction(double price) {
		return super.makeTransaction(price);
		
	}
	
	public double getLitersBought() {
		return litersBought;
	}

	public void setLitersBought(double litersBought) {
		this.litersBought = litersBought;
	}
}
