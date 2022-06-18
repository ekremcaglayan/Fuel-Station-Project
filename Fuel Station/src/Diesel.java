public class Diesel {
	
	private String origin;
	private double pricePerLiter;
	private double totalLiters;
	
	public Diesel(String origin, double pricePerLiter, double totalLiters) {
		this.origin = origin;
		this.pricePerLiter = pricePerLiter;
		this.totalLiters = totalLiters;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public double getPricePerLiter() {
		return pricePerLiter;
	}
	
	public void setPricePerLiter(double pricePerLiter) {
		this.pricePerLiter = pricePerLiter;
	}
	
	public double getTotalLiters() {
		return totalLiters;
	}
	
	public void setTotalLiters(double totalLiters) {
		this.totalLiters = totalLiters;
	}
	
}
