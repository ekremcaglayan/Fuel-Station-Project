import java.util.Comparator;

public class CarPlateComparator implements Comparator<Service> {

	@Override
	public int compare(Service s1, Service s2) {

		return s1.getCarPlate().compareTo(s2.getCarPlate());
	}

}
