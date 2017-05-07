import java.util.EnumSet;

public class TrafficLightTest {

	public static void main(String[] args) {
		for (TrafficLight trafficLight : TrafficLight.values()) {
			System.out.printf("The duration of %s is %d seconds%n", trafficLight, trafficLight.getDuration());
		}
		
		System.out.println();
		for (TrafficLight trafficLight : EnumSet.range(TrafficLight.RED, TrafficLight.YELLOW)) {
			System.out.println("Duration of " + trafficLight + "is ----- " + trafficLight.getDuration());
		}

	}

}
