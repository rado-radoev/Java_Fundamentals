
public class Items {

	private int productNumber;
	private int quantitySold;
	private double productPrice;
	
	public Items(int proudctNumber, int quantitySold) {
		this(proudctNumber, quantitySold, -1);
	}
	
	public Items(int productNumber, int quantitySold, double productPrice) {
		setProductNumber(productNumber);
		setQuantitySold(quantitySold);
		setProductPrice(productPrice);
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public int getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(int quantitySold) {
		this.quantitySold += quantitySold;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
}
