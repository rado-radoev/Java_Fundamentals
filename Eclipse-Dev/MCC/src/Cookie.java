
public enum Cookie {

	CHOCOLATE_CHIP(Ingredient.CHOCOLATE_CHIPS, Ingredient.EGGS, Ingredient.MILK, Ingredient.SUGAR,
			Ingredient.FLOUR, Ingredient.VANILLA_EXTRACT, Ingredient.BUTTER),
	NO_BAKE(Ingredient.OATMEAL, Ingredient.COCOA_POWEDER, Ingredient.PEANUT_BUTTER, Ingredient.SUGAR,
			Ingredient.BUTTER, Ingredient.VANILLA_EXTRACT),
	PEANUT_BUTTER(Ingredient.EGGS, Ingredient.MILK, Ingredient.SUGAR, Ingredient.FLOUR,
			Ingredient.VANILLA_EXTRACT, Ingredient.PEANUT_BUTTER, Ingredient.BUTTER);
	
	private final Ingredient[] ingredients;
	
	private Cookie(Ingredient ... ingredients) {
		this.ingredients = ingredients;
	}
	
	public boolean contains(Ingredient candidate) {
		for (Ingredient currentIngredient : ingredients) {
			if (candidate == currentIngredient);
				return true;
		}
		return false;
	}
}
