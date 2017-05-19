
public class OrderTest {
	
	public static void main(String[] args) {
		Order[] orders = {
				new Order(),
				new Order(Cookie.CHOCOLATE_CHIP, Cookie.CHOCOLATE_CHIP),
				new Order(Cookie.CHOCOLATE_CHIP, Cookie.PEANUT_BUTTER),
				new Order(Cookie.CHOCOLATE_CHIP, Cookie.PEANUT_BUTTER, Cookie.NO_BAKE,
						Cookie.CHOCOLATE_CHIP, Cookie.PEANUT_BUTTER)
		};
		
		for (Order currentOrder : orders) {
			currentOrder.displayIngredients();
			System.out.println();
		}
	}

}
