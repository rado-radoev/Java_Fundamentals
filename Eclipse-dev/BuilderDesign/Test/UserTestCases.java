import static org.junit.Assert.*;

import org.junit.Test;

public class UserTestCases {


	
	@Test
	public void user1() {
		User user1 = new User.UserBuilder("Lokesh", "Gupta")
				.age(30)
				.phone("1234567")
				.address("Fake Address")
				.build();
		assertEquals(user1.getAddress(), "Fake Address");
		assertTrue("Check if age is 30 or higher", user1.getAge() >= 30);
	}

}
