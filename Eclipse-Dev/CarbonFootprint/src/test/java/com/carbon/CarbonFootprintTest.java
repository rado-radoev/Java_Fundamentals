package com.carbon;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CarbonFootprintTest {
	
	public ArrayList<CarbonFootprint> carbonEmittingObjects = new ArrayList<CarbonFootprint>();;

	@Before
	public void setUp() throws Exception {
		carbonEmittingObjects.add(new Building(4500, 2000));
		carbonEmittingObjects.add(new Car(10000, 400));
		carbonEmittingObjects.add(new Bycicle(50));
	}

	@Test
	public void testBuildingCO2() {
		for (CarbonFootprint currentObject : carbonEmittingObjects) {
			if (currentObject instanceof Building) {
				System.out.printf("%s %s %s%n"
						,"checking",
						currentObject.getClass().getName(),
						"emission levels");
				assertEquals(682500, currentObject.getCarbonFootprint(), 1.0);
			}
		}
	}
	
	@Test
	public void testCarCO2() {
		for (CarbonFootprint currentObject : carbonEmittingObjects) {
			if (currentObject instanceof Car) {
				System.out.printf("%s %s %s"
						,"checking",
						currentObject.getClass().getName(),
						"emission levels");
				assertEquals(1130316, currentObject.getCarbonFootprint(), 1.0);
			}
		}
	}
	
	
	@Test
	public void testBycicleCO2() {
		for (CarbonFootprint currentObject : carbonEmittingObjects) {
			if (currentObject instanceof Bycicle) {
				System.out.printf("%s %s %s%n"
						,"checking",
						currentObject.getClass().getName(),
						"emission levels");
				assertEquals(11, currentObject.getCarbonFootprint(), 1.0);
			}
		}
	}

}
