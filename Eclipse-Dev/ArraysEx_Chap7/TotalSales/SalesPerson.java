
public class SalesPerson {

	private int[][] sales;
	private static int personalNumber;
	
	public SalesPerson() {
	}
	
	public int[][] getSales() {
		return sales;
	}

	public int getPersonalNumber() {
		return personalNumber;
	}

	public static void setPersonalNumber() {
		personalNumber++;
	}

	public void setSales(int[][] sales) {
		this.sales = sales;
	}

//	public static class SalesPersonBuilder {
//		private int[][] sales;
//		
//		public SalesPersonBuilder (int[][] sales) {
//			this.sales = sales;
//		}
//		
//		public SalesPerson build() {
//			SalesPerson salesPerson = new SalesPerson(this);
//			return salesPerson;
//		}
//		
//	}
}
