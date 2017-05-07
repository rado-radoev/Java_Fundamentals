
public enum TrafficLight {

	// declare constants of enum type
	RED(3),
	YELLOW(1),
	GREEN(2);
	
	// instance field
	private int duration;
	
	TrafficLight(int duration) {
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
}
