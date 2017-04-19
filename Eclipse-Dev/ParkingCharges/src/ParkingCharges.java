
public class ParkingCharges {

	private final double minCharge = 2D;
	private final double maxCharge = 10D;
	private final double pricePerHour = 0.5D;
	private final double minHours = 3D;
	private final double maxHours = 24D;
	
	private double hoursParked;
	
	public ParkingCharges(double hoursParked) {
		setHoursParked(hoursParked);
	}
	
	
	public double calculateCharges() {
		double currentHours = getHoursParked();
		double charge = 0;
		
		/**
		 * if hours parked is less than min hours
		 * charge is minCharge
		 * 
		 * if hours parkes is higher than min hours
		 * calculate minCharge + 0.5 for every hour
		 * 
		 * if charge > maxCharge
		 * 	return maxCharge
		 * else
		 * 	return charge
		 */
		
		if (currentHours <= minHours)
			charge = minCharge;
		
		if (currentHours > minHours) {
			double hours = currentHours - minHours;
			charge = minCharge + (hours * pricePerHour);
		}
		
		if (charge > maxCharge) {
			return maxCharge;
		}
		else {
			return charge;
		}
			
	}
	
	public double getHoursParked() {
		return Math.ceil(hoursParked);
	}
	
	public void setHoursParked(double hoursParked) {
		if (this.hoursParked + hoursParked > maxHours) 
			this.hoursParked = maxHours;
		else
			this.hoursParked += hoursParked;
	}
	
}
