/*
 * Item.java
 */

/**
 * 
 * @author Radoslav Radoev
 *
 */
public class Item {

	/**
	 * @param price 	Item price
	 */
	private double price;
	
	/**
	 * Item constructor
	 * @param price		Item price
	 */
	public Item(double price) {
		setPrice(price);
	}

	/**
	 * Item price getter
	 * @return	Item price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Item price setter
	 * @param price		Item price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
