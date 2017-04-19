
public class ParkingChargesTest {

	public static void main(String[] args) {
		ParkingCharges pc1 = new ParkingCharges(1);
		System.out.printf("Parking charges for 1 hour: %.2f%n", pc1.calculateCharges());
		
		ParkingCharges pc2 = new ParkingCharges(3.5);
		System.out.printf("Parking charges for 3.5 hours: %.2f%n", pc2.calculateCharges());
		

		ParkingCharges pc3 = new ParkingCharges(18);
		System.out.printf("Parking charges for 18 hours: %.2f%n", pc3.calculateCharges());
	}

}
