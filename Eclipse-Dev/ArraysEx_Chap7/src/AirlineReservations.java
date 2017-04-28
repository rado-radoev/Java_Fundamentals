import java.util.Scanner;

public class AirlineReservations {
	
	static int seatNumber;
	static boolean[] totalSeats = new boolean[11];

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);

		
		while (true){
			System.out.printf("Please type 1 for first class%n");
			System.out.printf("Please type 2 for second class%n");
			int clase = input.nextInt();
			if (clase == 1) {
				if (checkSeatAvailability(totalSeats, 0, 5)) {
					System.out.printf("You will be travelling in %d class on seat %d", clase, seatNumber + 1);
				}
				else {
					System.out.printf("All seats in %d class are taken, do you want to travel in %d class", 1, 2);
					input.nextLine();
					String choice = input.nextLine();
					if (choice.toLowerCase().equals("yes")) {
						if (checkSeatAvailability(totalSeats, 6, 11)) {
							System.out.printf("You will be travelling in %d class on seat %d", clase +1, seatNumber + 1);
						}
						else {
							System.out.println("Sorry all seats are taken. Next flight is in 3 hours");
						}
					}
					else {
						System.out.println("Next flight is in 3 hours");
					}
				}
			}
			else if (clase == 2) {
				if (checkSeatAvailability(totalSeats, 6, 10)) {
					System.out.printf("You will be travelling in %d class on seat %d", clase, seatNumber + 1);
				}
				else {
					System.out.printf("All seats in %d class are taken, do you want to travel in %d class", 2, 1);
					input.nextLine();
					String choice = input.nextLine();
					if (choice.toLowerCase() == "yes") {
						if (checkSeatAvailability(totalSeats, 1, 5)) {
							System.out.printf("You will be travelling in %d class on seat %d", clase-1, seatNumber + 1);
						}
						else {
							System.out.println("Sorry all seats are taken. Next flight is in 3 hours");
						}
					}
					else {
						System.out.println("Next flight is in 3 hours");
					}
				}
			}
			System.out.println();
		}
		
		
	}
	
	public static boolean checkSeatAvailability(boolean[] seats, int from, int to) {
		for (int seat = from; seat < to; seat++) {
			if (!seats[seat]) {
				totalSeats[seat] = true;
				seatNumber= seat;
				return true;
			}
		}
		return false;
	}

}
