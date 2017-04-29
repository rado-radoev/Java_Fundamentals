
public class TotalSales {

	public static void main(String[] args) {

		SalesPerson[] salesPeople1 = {new SalesPerson(), new SalesPerson(), new SalesPerson(), new SalesPerson()};
		int[] products1 = {100,200,300,400,500};
		int[][]sales = new int[products1.length][1];
		
		int count = 0;

		for (SalesPerson sp : salesPeople1) {
			sp.setSales(sales);
			sp.setPersonalNumber();
			while (count < 30) {
				for (int product = 0; product < products1.length;product++){
					sales[product][0] += products1[product]; 
					sp.setSales(sales);
				}
				count++;
			}

			System.out.println("Sales rep N: " + sp.getPersonalNumber());
			System.out.printf("%s%8s%n", "Product Number", "Product total");
			for (int row = 0; row < sp.getSales().length; row++) {
				System.out.printf("%d%8d%n", row + 1, sp.getSales()[row][0]);
			}
			
			for (int i = 0; i < sales.length; i++) {
				sales[i][0] = 0;
			}
			count = 0;
		}		
	}

}
