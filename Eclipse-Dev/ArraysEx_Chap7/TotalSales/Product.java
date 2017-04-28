
public class Product {

	private int value;
	
	private Product(ProductBuilder builder) {
		this.value = builder.value;
	}
	
	public static class ProductBuilder {
		private int value;
		
		public Product build() {
			Product product = new Product(this);
			return product;
		}
		
		public ProductBuilder value(int value) {
			this.value = value;
			return this;
		}
	}
}
