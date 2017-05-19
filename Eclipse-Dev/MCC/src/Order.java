
public class Order {

	Cookie[] batches;
	final int orderNumber;
	
	static int orderNumberTracker = 0;
	
	public Order(Cookie... batches) {
		this.batches = batches;
		this.orderNumber = orderNumberTracker++;
	}
	
	public void displayIngredients() {
		System.out.println("Order #" + orderNumber + "'s Ingredients:");
		
		for (Ingredient currentIngredient : Ingredient.values()) {
			for (Cookie currentCookie : batches) {
				if (currentCookie.contains(currentIngredient)) {
					System.out.println(currentIngredient);
					break;
				}
			}
		}
	}
}
