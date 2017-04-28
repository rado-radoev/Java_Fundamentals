
public class TotalSales {

	public static void main(String[] args) {
		
		int[] salesPeople = new int[4];
		int[] products = {100,200,300,400,500};
		int[][] sales = new int[products.length][salesPeople.length];
		
		for (int salesPerson = 0; salesPerson < salesPeople.length; salesPerson++) {
			for (int product = 0; product < products.length; product++) {
				sales[product][salesPerson] += products[product];
			}
		}
		
		
	}

}
